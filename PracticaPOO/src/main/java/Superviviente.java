import java.util.Scanner;

public class Superviviente extends Entidad{
        
    private String estado;
    private int AccionesPorTurno;  
    private Inventario inventario;
    private Arma[] armasActivas;
    private int kills;
    private int heridas;

    public Superviviente(String nombre1, String estado, int AccionesPorTurno, Inventario inventario1, Arma[] armasActivas, int kills, int heridas) {
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
    

}       
