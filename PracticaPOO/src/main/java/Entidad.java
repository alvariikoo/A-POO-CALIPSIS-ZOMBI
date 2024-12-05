import java.util.Scanner;

public class Entidad {
    
    protected String nombre;
    

   public Entidad(String nombre){
       
       this.nombre = nombre;
       
   }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public boolean isSuperviviente(Entidad entidad){
        
        if(entidad instanceof Superviviente){
            return true;
        }
        return false;
    }
    public boolean isZombi(Entidad entidad){
        
        if(entidad instanceof Zombi){
            return true;
        }
        return false;
    }
    
    public void activarEntidad(Tablero tablero){
        
        
        
    }
    
    
    public void moverEntidad(Tablero tablero, Casilla actual){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿A donde te quieres mover?\n");
        
        int seleccion = scanner.nextInt();
        int x = actual.getX();
        int y = actual.getY();
        
        System.out.println("1.Arriba.\n");
        System.out.println("2.Abajo.\n");
        System.out.println("3.Derecha.\n");
        System.out.println("4.Izquierda.\n");

        do{
            
        
        switch(seleccion){
            
            case 1:
                y++;
                break;
            case 2:
                y--;
                break;    
            case 3:
                x++;
                break;   
            case 4:
                x--;
                break;    
        }  
            
        }while(seleccion<0 && seleccion>3);
        
        Casilla nuevaPosicion = new Casilla(x,y);
        
        if(nuevaPosicion == null){
            System.out.println("No se puede mover fuera del tablero.\n");
        }
        
        actual.getEntidad().remove(this);
        nuevaPosicion.getEntidad().add(this);
        
        System.out.println(this.nombre + "se ha movido a: ["+x+","+y+"]");
        
        
        
    }
    
    
    
}
