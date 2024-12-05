import java.util.Random;


public class Zombi extends Entidad {
    private int aguante;
    private int activaciones;
    private String tipo;
    private String subtipo;

    public Zombi(String nombre, int x, int y, int aguante, int activaciones, String tipo, String subtipo) {
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


    public static Zombi generarZombiAleatorio(int x, int y) {
        Random rand = new Random();
        String[] tipos = {"Normal", "Berserker", "Tóxico"};
        String[] subtipos = {"Caminante", "Corredor", "Abominación"};

        int prob = rand.nextInt(100);
        String subtipo;
        if (prob < 60) {
            subtipo = "Caminante";
        } else if (prob < 90) {
            subtipo = "Corredor";
        } else {
            subtipo = "Abominación";
        }

        String tipo = tipos[rand.nextInt(tipos.length)];

        int aguante = 1;
        int activaciones = 1;
        if ("Corredor".equals(subtipo)) {
            activaciones = 2;
        } else if ("Abominación".equals(subtipo)) {
            aguante = 3;
        }

        String nombre = "Zombi " + subtipo + " " + tipo;
        return new Zombi(nombre, x, y, aguante, activaciones, tipo, subtipo);
    }
}