
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author JOLMO
 */
public class Jugar {
    
    private Tablero tablero;
    
    public Jugar(Tablero tablero){
        
        this.tablero = tablero;
    }
    
    
    private void inicializarJuego(){
        tablero.crearTablero();
        tablero.arrayEntidades();
    }
    public void realizarAccionSuperviviente(Superviviente superviviente){
        
        System.out.println("1. Moverse\n");
        System.out.println("2. Buscar\n");
        System.out.println("3. Atacar\n");
        System.out.println("4. No hacer nada \n");
        
        
        Scanner scanner = new Scanner(System.in);
        int seleccion = scanner.nextInt();
        
        switch(seleccion){
            case 0:
                superviviente.moverEntidad(tablero, tablero.getSupervivientes(superviviente));
                break;
            case 1:
                superviviente.buscar(tablero.getSupervivientes(superviviente));
                break;
            case 2:
                superviviente.atacarZombi(tablero);
                superviviente.reaccionarAtaque(tablero);
                break;
            case 3:   //no hace nada
                break;
            default:// si pulsa una opcion no correcta pierde turno
        }
    }
    
    public void realizarAccionZombi(Zombi zombi){
        
        System.out.println("1. Moverse\n");
        System.out.println("2. No hacer nada\n");
        
        
       
        zombi.moverZombi(tablero);
            
    }
    
    
    private void iniciarJuego(){
        
        inicializarJuego();
        boolean juegoCurso = true;
        
        while(juegoCurso == true){
        ArrayList<Entidad> entidades = tablero.arrayEntidades();
        
        
        for(Entidad entidad : entidades){
            
            
            if(entidad.getEstado().equals("Vivo")){
                
                if(entidad instanceof Superviviente){
                    realizarAccionSuperviviente((Superviviente)entidad);
                }
                if(entidad instanceof Zombi){
                    realizarAccionZombi((Zombi)entidad);
                }
            }
            
        }
        tablero.generarZombiRonda();
        limpiarEntidadesMuertas();
        juegoCurso = !finalDelJuego();
        }
    }
    
    private void limpiarEntidadesMuertas(){
        
       ArrayList<Entidad> entidades = tablero.arrayEntidades();
        
        ArrayList<Entidad> entidadesEliminar = new ArrayList<>();
        
        for(Entidad entidad : entidades){
            
            if(entidad.getEstado().equals("Muerto")){
                entidadesEliminar.add(entidad);
            }
        }
        
        for(Entidad entidad : entidadesEliminar){
            
           if(entidad instanceof Zombi){
               Zombi zombi = (Zombi)entidad;
               
              Casilla casilla = zombi.getPosicionZ();
               casilla.getEntidad().remove(entidad);
           }
           if(entidad instanceof Superviviente){
               Superviviente superviviente = (Superviviente)entidad;
               
               Casilla casilla = tablero.getSupervivientes(superviviente);
               casilla.getEntidad().remove(entidad);
           }
        }
        
    }
    
    
    public boolean finalDelJuego(){
    
        ArrayList<Entidad> entidades = tablero.arrayEntidades();
        boolean finJuego = false;
        
        int contadorSupervivientesMuertos = 0;
        for(Entidad entidad : entidades){
            
            if(entidad instanceof Superviviente){
                
                Superviviente superviviente = (Superviviente)entidad;
                if(superviviente.getEstado().equals("Muerto")){
                    contadorSupervivientesMuertos++;
                }
            }
            
        }
        
        if(contadorSupervivientesMuertos == 4){
            finJuego = true;
        }
        
        if(!finJuego){
            Casilla casilla = tablero.getCasilla(9, 9);
            
            for(Entidad entidad : casilla.getEntidad()){
                
                if(entidad instanceof Superviviente){
                    Superviviente superviviente = (Superviviente)entidad;
                    if(superviviente.tieneProvision() == true){
                        finJuego = true;
                    }
                }
                
                
            }
            
        }
        
        if(finJuego == true){
            System.out.println("¡Fin del juego!");
        }
        return finJuego;
        
        
        
    
}
    
    public void jugar(){
        iniciarJuego();
    }
    
    
    
}
