
public class Provision extends Equipo{
   
    private int valorEnergetico;
    private String fechaCaducidad;
    
   public Provision(String nombre1,int valorEnergetico1, String fechaCaducidad1){
        
        super(nombre1);
        this.valorEnergetico = valorEnergetico1;
        this.fechaCaducidad= fechaCaducidad1;
  
    }
    
    public int getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if( getClass() != o.getClass()) return false;
        
        
        
        Provision provi = (Provision) o;
         return nombre.equals(provi.nombre);
    }

    @Override
    public String toString() {
        return "Provisiones{" + "nombre=" + nombre + ", valorEnergetico=" + valorEnergetico + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
    
    
    
}
