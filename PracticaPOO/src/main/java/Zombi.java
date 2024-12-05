public class Zombi extends Entidad {
    private int aguante;
    private int activaciones;
    private String tipo;
    private String subtipo;

    public Zombi(String nombre, int aguante, int activaciones, String tipo, String subtipo) {
        super(nombre);
        this.aguante = aguante;
        this.activaciones = activaciones;
        this.tipo = tipo;
        this.subtipo = subtipo;
    }

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public int getActivaciones() {
        return activaciones;
    }

    public void setActivaciones(int activaciones) {
        this.activaciones = activaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    @Override
    public String toString() {
        return "Zombi{" + "aguante=" + aguante + ", activaciones=" + activaciones + ", tipo=" + tipo + ", subtipo=" + subtipo + '}';
    }
    
    
    
    

    

}

