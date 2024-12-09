import java.util.ArrayList;
import java.util.Scanner;

public class Superviviente extends Entidad{
        
    private String estado;
    private int AccionesPorTurno;  
    private Inventario inventario;
    private Arma[] armasActivas;
    private int kills;
    private int heridas;

    public Superviviente(String nombre1, String estado, int AccionesPorTurno, Inventario inventario1, Arma[] armasActivas, int kills,int heridas) {
        super(nombre1);
        this.estado = estado;
        this.AccionesPorTurno = AccionesPorTurno;
        this.inventario = inventario1;
        this.armasActivas = new Arma[2];
        this.kills = kills;
        this.heridas = heridas;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAccionesPorTurno() {
        return AccionesPorTurno;
    }

    public void setAccionesPorTurno(int AccionesPorTurno) {
        this.AccionesPorTurno = AccionesPorTurno;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getHeridas() {
        return heridas;
    }

    public void setHeridas(int heridas) {
        this.heridas = heridas;
    }
    
    public Inventario getInvent(){
        return this.inventario;
    }
    public void setInvent(Inventario inventario1){
        this.inventario = inventario1;
    }
    
    public Arma[] getArmasActivas(){
        return this.armasActivas;
    }
    public void setArmasActivas(Arma[] armas){
        this.armasActivas = armas;
    }
    
    
    public Arma elegirArma(){
        
    Scanner scanner = new Scanner(System.in);

    Arma[] arrayArmas = new Arma[5];
    int contadorArmas = 0;

    System.out.println("Buscando armas disponibles en el inventario...\n");

    for (int i = 0; i < inventario.getInventario().length; i++) {
        Equipo equipo = inventario.getInventario()[i];

        if (equipo != null && equipo instanceof Arma) {
            arrayArmas[contadorArmas] = (Arma)equipo;
            contadorArmas++;
        }
    }

    if (contadorArmas == 0) {
        System.out.println("No hay armas disponibles en el inventario.\n");
        
    }

    System.out.println("Armas disponibles:\n");

    for (int i = 0; i < contadorArmas; i++) {
        System.out.println("- Arma " + (i + 1) + ": " + arrayArmas[i].toString());
    }

    System.out.println("\n¿Que arma quieres seleccionar?\n");
    int seleccion = scanner.nextInt();

    if (seleccion < 1 || seleccion > contadorArmas) {
        System.out.println("Selección no válida. No hay arma en esa posición.\n");
    } else {
        System.out.println("Has seleccionado el arma: " + arrayArmas[seleccion - 1].getNombre());
        
     }
            return arrayArmas[seleccion-1];
  
   }
    
    public Arma[] armasActivas() {
   
    int contador = 0;

    while (contador < 2) {
        System.out.println("Selecciona un arma para el juego:");

        Arma armaSeleccionada = elegirArma();
        armasActivas[contador] = armaSeleccionada; 
        
        contador++;
              
    }

    System.out.println("Has seleccionado las siguientes armas:");
    for (int i = 0; i < armasActivas.length; i++) {
        
         System.out.println(armasActivas[i].toString());
    }
    return armasActivas;
}
    
    public void buscar(int x,int y,Tablero tablero){
        
        inventario.mostrarInventario();
        
        inventario.añadirEquipo( tablero.getCasilla(x, y).getEquipo());
            
        
        System.out.println("Inventario actualizado:\n");
        inventario.mostrarInventario();
            
    }
    
    public int ataqueDados(Arma arma){
        
        int accion=0;
        for(int i=0;i<arma.getNumDados();i++){
            
           int dado= (int) (Math.random() * 5)+1;
           
           System.out.println("Lanzando el dado"+(i+1)+"->"+dado);
           
           if(dado >= arma.getValorExito()){
               
               System.out.println("¡Éxito!");
               accion++;
           }
        }
        return accion;
        
    }
    
    
    public void atacarZombi( Tablero tablero){
        
        
        ArrayList<Zombi> zombisDisponibles = new ArrayList<>();

        Casilla casilla = tablero.getSupervivientes(this);
        Arma arma = this.elegirArma();
        int acciones = ataqueDados(arma);
        int alcance = arma.getAlcance();
        int potencia = arma.getPotencia();
        
        int x = casilla.getX();
        int y = casilla.getY();
        
        for(int i = x-alcance;i<x +alcance;i++){
            for(int j = y -alcance ; j< y + alcance;j++){
                                    
                ArrayList<Entidad> entidades = tablero.getCasilla(i, j).getEntidad();

                if(entidades != null){
                        for(int p=0;p<entidades.size();p++){
                            
                            Entidad entidad = entidades.get(p);
                            
                            if(entidad instanceof Zombi){
                             Zombi zombi1 = (Zombi) entidad;
                             
                             zombisDisponibles.add(zombi1);
                            }
                        }
                        
                    }
            }
        }
        
        
        
            Scanner scanner = new Scanner(System.in);
            
            for( int i=0;i<zombisDisponibles.size();i++){
                
                Zombi zombi = zombisDisponibles.get(i);
                System.out.println("Zombi"+i+zombi.toString()+"\n");
            }
            
            
            for(int i = 0; i < acciones;i++){
                
            
            
            
            
            
            
            
            }
        
        
       
        
        
        
        
    } 
    
    
    public void reaccionarAtaque(Superviviente superviviente, Zombi zombi, Casilla casilla){
        
        
        
        if(zombi.getSubtipo().equals("Tóxico") && casilla.getEntidad().contains(superviviente) && casilla.getEntidad().contains(zombi) ){
            
           int heridas= superviviente.getHeridas();
           
           heridas +=1;
           System.out.println(nombre+" ha sufrido una herida al matar un zombi tóxico.\n");
                       
        }
        
        if(zombi.getEstado().equals("Vivo")&& casilla.getEntidad().contains(superviviente) && casilla.getEntidad().contains(zombi) ){
            heridas +=1;
            System.out.println(nombre+" ha sufrido una herida por un zombi.\n");
        }
        
        if(heridas == 2){
            
            System.out.println(nombre+" ha sido eliminado.\n");
            
            superviviente.setEstado("Muerto");
            
        }
        
    }

}
