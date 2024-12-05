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

    
}
