import java.util.ArrayList;

public class Casilla {
    
    private int x;
    private int y;
    private ArrayList<Entidad> entidades;
    private Equipo equipo;
    
    
    public Casilla(int x, int y, ArrayList<Entidad> entidades, Equipo equipo){
    
        this.x = x;
        this.y = y;
        this.entidades = new ArrayList<>();
        this.equipo = equipo;
    }
    
    public Casilla(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Equipo getEquipo(){
        return this.equipo;
    }
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }

    public ArrayList<Entidad> getEntidad(){
        return entidades;
    }
    
    public void setEntidad(ArrayList<Entidad>entidad){
        this.entidades = entidad;
    }
    
    public boolean isVacia(){
       for(int i=0;i<entidades.size();i++){
           if(entidades.get(i) != null){
               return false; 
           }
       }
       
         return entidades.isEmpty();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    public void mostrarOcupado(){
        
        StringBuilder mostrar = new StringBuilder("[");

        for(int i=0;i<entidades.size();i++){
            
            if(isVacia() != false){
                System.out.println("[ ]");
                return;
            }
            
            
            mostrar.append(entidades.get(i).getNombre().charAt(0));
            
            if(i<entidades.size()-1){
                mostrar.append("-");
            }
        }
        
        
        mostrar.append("]");
        System.out.println(mostrar.toString());
        
                   
    }
       
}
