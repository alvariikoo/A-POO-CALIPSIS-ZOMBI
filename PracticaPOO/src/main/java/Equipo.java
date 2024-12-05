
public class Equipo {
    
    protected String nombre;
    
    public Equipo(String nombre1){
        
        this.nombre = nombre1;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    
    public void mostrarEquipo(Equipo equipo){
        
        if(equipo instanceof Arma){
            
            System.out.println(((Arma) equipo).toString());
        }
        
        if(equipo instanceof Provision){
            System.out.println(((Provision) equipo).toString());
        }
        
        else{
            System.out.println("No se puede mostrar el equipo.\n");
        }
    }
    
       

}