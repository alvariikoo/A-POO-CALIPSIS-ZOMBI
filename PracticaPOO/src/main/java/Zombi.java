
import java.util.ArrayList;

public class Zombi extends Entidad {
    
    private int aguante;
    private int activaciones;
    private String tipo;
    private String subtipo;
    private Casilla posicion;

    public Zombi(String nombre,String estado, int aguante, int activaciones, String tipo, String subtipo) {
        super(nombre,estado);
        this.aguante = aguante;
        this.activaciones = activaciones;
        this.tipo = tipo;
        this.subtipo = subtipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        
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
    
    public Casilla getPosicionZ() {
        return posicion;
    }

    public void setPosicionZ(Casilla posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Zombi{" + "aguante=" + aguante + ", activaciones=" + activaciones + ", tipo=" + tipo + ", subtipo=" + subtipo + '}';
    }
    
    public double calcularDistancia(int x1, int y1, int x2, int y2){
        
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }
    
    public void moverZombi(Tablero tablero){
        
        ArrayList<Entidad> entidades = tablero.arrayEntidades();
        double distanciaMinima = 13; //distancia maxima que hay en un tablero 10x10
        Superviviente supervivienteCercano = null; //aqui guardaremos el superviviente mas cercano que encontremos
              
        
        for(Entidad entidad : entidades){
            
            if(entidad instanceof Superviviente && entidad.getEstado().equals("Vivo")){
                
                 Superviviente superviviente = (Superviviente)entidad;
                 
                 
                 int zombiX = this.getPosicionZ().getX();
                 int zombiY = this.getPosicionZ().getY();
                 
                 int superX = tablero.getSupervivientes(superviviente).getX();
                 int superY = tablero.getSupervivientes(superviviente).getY();
                 
                 double distancia = calcularDistancia(zombiX,zombiY,superX,superY);
                 
                 if(distancia < distanciaMinima){
                     distanciaMinima = distancia;
                     supervivienteCercano = superviviente;
                 }
                 
                 if(supervivienteCercano !=null){
                     
                     if(zombiX < superX){
                         zombiX++; //muevo derecha
                     }else if(zombiX > superX){
                         zombiX--; //muevo izquierda
                     }
                     if(zombiY < superY){
                         zombiY++;  //mover arriba
                     }else if(zombiY < superY){
                         zombiY--;
                     }
                     
                     this.getPosicionZ().setX(zombiX);
                     this.getPosicionZ().setY(zombiY);
                 }
            }
        }
       
        
        
        
        
        
        
    }
    
 
}

