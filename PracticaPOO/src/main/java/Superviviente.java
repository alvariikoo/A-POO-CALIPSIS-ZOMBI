import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;

public class Superviviente extends Entidad{
    
    private JLabel image;
   
    private int AccionesPorTurno;  
    private Inventario inventario;
    private Arma[] armasActivas;
    private int kills;
    private int heridas;
    

    public Superviviente(String nombre1, String estado, int AccionesPorTurno, Inventario inventario1, Arma[] armasActivas, int kills,int heridas){
        super(nombre1,estado);
        this.AccionesPorTurno = AccionesPorTurno;
        this.inventario = inventario1;
        this.armasActivas = new Arma[2];
        this.kills = kills;
        this.heridas = heridas;
        
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
    
    public void buscar(Casilla casilla){
        
        inventario.mostrarInventario();
        
        inventario.añadirEquipo( casilla.getEquipo());
            
        
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
    
    
    public int atacarZombi(Tablero tablero){
        
        
        ArrayList<Zombi> zombisDisponibles = new ArrayList<>();

        Casilla casilla = tablero.getSupervivientes(this);
        Arma arma = this.elegirArma();
        int acciones = ataqueDados(arma);
        int alcance = arma.getAlcance();
        int potencia = arma.getPotencia();
        boolean cuerpoAcuerpo = arma.isCuerpoACuerpo(arma);
        
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
        
        for(int i=0;i<acciones;i++){
        
            Scanner scanner = new Scanner(System.in);
            
            Casilla escogida = new Casilla(x,y);
            
            for(int j=0;j<zombisDisponibles.size();j++){
                
                Zombi zombi = zombisDisponibles.get(j);
                

                
                //zombi está en la posicion que elige
                if( zombi.getPosicionZ().equals(escogida)){
                    
                    
                    //si la posicion del super es la misma que la del zombi
                   if(tablero.getSupervivientes(this).equals(zombi.getPosicionZ()) ){
                    
                       if(zombi.getSubtipo().equals("Tóxico") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia >= zombi.getAguante()){
                       
                           zombi.setAguante(0);
                           zombi.setEstado("Muerto");
                        return 0; //mato a un toxico en mi casilla
                   }
                        if(zombi.getSubtipo().equals("Tóxico") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia < zombi.getAguante()){
                       
                       return 1; //no mato a un toxico en mi casilla
                   }

                   if(zombi.getSubtipo().equals("Normal") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia < zombi.getAguante()){
                       
                       return 2;// no mato a un normal en mi casilla
                   }
                   if(zombi.getSubtipo().equals("Berserker") && cuerpoAcuerpo != true && potencia >= zombi.getAguante()){
                      
                       return 3;//no mato a un berserker en mi casilla por no tener arma cuerpo a cuerpo
                }
                   if(zombi.getSubtipo().equals("Berserker") && cuerpoAcuerpo == true && potencia < zombi.getAguante()){
                      
                       return 4;//no mato a un berserker en mi casilla por potecia aunque tenga arma cuerpo a cuerpo
                }
                   
                   if(zombi.getSubtipo().equals("Berserker") && cuerpoAcuerpo == true && potencia >= zombi.getAguante()){
                       
                       zombi.setAguante(0);
                           zombi.setEstado("Muerto");
                       return 5; //mato a berserker en mi casilla por tener arma cuerpo a cuerpo con suficiente potencia.
                   }
                   if(zombi.getSubtipo().equals("Normal") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia >= zombi.getAguante()){
                       zombi.setAguante(0);
                           zombi.setEstado("Muerto");
                       return 6; //mato a zombi normal en mi casilla
                   }
                   if(zombi.getSubtipo().equals("Tóxico") && zombi.getTipo().equals("Corredor") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia < zombi.getAguante()){
                       
                       return 7; //no mato a un toxico corredor en mi casilla
                   }

                   if(zombi.getSubtipo().equals("Normal") && zombi.getTipo().equals("Corredor") && (cuerpoAcuerpo == true || cuerpoAcuerpo == false) && potencia < zombi.getAguante()){
                       
                       return 8;// no mato a un normal corredor en mi casilla
                   }
                   if(zombi.getSubtipo().equals("Berserker") && zombi.getTipo().equals("Corredor") && cuerpoAcuerpo != true && potencia >= zombi.getAguante()){
                      
                       return 9;//no mato a un corredor berserker en mi casilla por no tener arma cuerpo a cuerpo
                }
                   if(zombi.getSubtipo().equals("Berserker") &&   zombi.getTipo().equals("Corredor") && cuerpoAcuerpo == true && potencia < zombi.getAguante()){
                      
                       return 10;//no mato a un berserker en mi casilla por potecia aunque tenga arma cuerpo a cuerpo
                }
                   
                
            }
                   
                   if(!zombi.getSubtipo().equals("Berserker") && cuerpoAcuerpo == false && potencia >= zombi.getAguante()){
                       zombi.setAguante(0);
                           zombi.setEstado("Muerto");
                       return 11; //mato a cualquier zombi que no sea berserker a distancia.
                   }else{
                       return 12; // no he podido matar a distancia
                   }
                   
                   
                   
                   
                       
                       
                        
                   }
                
                
               
        
            }              
                
                   
    }
        return -1; //no puedo atacar por fuera de rango
    }
    
    
    public void reaccionarAtaque( Tablero tablero){
        
        
        int resultadoAtaque = atacarZombi(tablero);
        //mato zombi Tóxico en mi casilla, me da con acido y me suma una herida
        if(resultadoAtaque == 0){
            
            this.heridas +=1;
            
        }
        
        // no mato zombi cualquier tipo me muerde
        if(resultadoAtaque == 1 ||resultadoAtaque == 2 || resultadoAtaque == 3 || resultadoAtaque== 4 ){
            this.heridas +=1;
        }
        
        //no mato a un zombi corredor que me puede atacar dos veces
        if(resultadoAtaque== 7 || resultadoAtaque == 8 || resultadoAtaque == 9 || resultadoAtaque == 10){
            this.heridas +=2;
        }
        
        this.setHeridas(heridas);
        
        if(heridas >= 2){
            setEstado("Muerto");
        }

    }
    
    
    public boolean tieneProvision(){
        
        for (int i = 0; i < inventario.getInventario().length; i++) {
        Equipo equipo = inventario.getInventario()[i];

        if (equipo != null && equipo instanceof Provision) {
            return true;
        }
    }
        return false;
    }

}
