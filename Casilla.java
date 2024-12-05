
public class Casilla {
    
    private int x;
    private int y;
    private Entidad entidad;   
    private Equipo equipo;
    
    
    public Casilla(int x, int y, Entidad entidad, Equipo equipo){
    
        this.x = x;
        this.y = y;
        this.entidad = entidad;
        this.equipo = equipo;
    }
    
    public Equipo getEquipo(){
        return this.equipo;
    }
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }

    public Entidad getEntidad(){
        return entidad;
    }
    
    public void setEntidad(Entidad entidad){
        this.entidad = entidad;
    }
    
    public boolean isVacia(){
        if(this.entidad ==null &&this.equipo ==null){
            return true;
        }
        return false;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void mostrarOcupado(){
        
           if(this.entidad.isSuperviviente(entidad) ==true){
               if(entidad.getNombre().charAt(0) == 'Z'){
                 System.out.println("[" + entidad.getNombre().charAt(0) + entidad.getNombre().charAt(1) + "]");
               }
              System.out.println("[" + entidad.getNombre().charAt(0) + "]");
          }
           
           if(this.entidad.isZombi(entidad)==true){
               System.out.println("[Z]");
           }
           if(this.entidad == null || this.equipo ==null){
              System.out.println("[ ]");
                
           }
           if(this.equipo !=null){
             System.out.println("[Eq]");

           }
    }
    
    
}
