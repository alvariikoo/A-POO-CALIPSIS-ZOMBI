
import java.util.Scanner;


public class Inventario {
    
        private Equipo[] equipos;
        private int contador;

    public Inventario() {
        this.equipos = new Equipo[5];
        this.contador = 0;
    }
    
    public Equipo[] getInventario(){
        return this.equipos;
    }
    
    public boolean añadirEquipo(Equipo equipo){
        
            Scanner scanner = new Scanner(System.in);
            
            if(equipo == null){
            System.out.println("No se pueden añadir equipos que no existen.\n");
            
            return false;
        }
            

        if(contador>5 ){
            
            System.out.println("Selecciona la posición del inventario que quieres cambiar:\n");
            int posicion = scanner.nextInt();
            cambiarObjetos(equipo,posicion);
        }
        
        
        equipos[contador] = equipo;
        contador++;
        
        return true;
        
    }
    
    public boolean cambiarObjetos(Equipo equipoCambiar, int posicion){
        
        if(posicion < 0 || posicion > 5) return false;
       
        equipos[posicion] = equipoCambiar;
        return true;
       
    }    
    
    public void mostrarInventario() {
        
    System.out.println("Contenido del inventario:");
    
    for (int i = 0; i < equipos.length; i++) {
        
        System.out.print("Slot " + (i + 1) + ": "); 
        
        if (equipos[i] == null) { 
            System.out.println( "Vacio.");       
        }
        else{
            equipos[i].mostrarEquipo(equipos[i]);
        }
        
    }
}


        
        
        
}
