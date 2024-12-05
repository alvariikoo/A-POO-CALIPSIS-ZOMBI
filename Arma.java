
public class Arma extends Equipo{
    
    
    private int potencia;
    private int arcangel;
    private int numDados;
    private int valorExito;
    
    
    public Arma(String nombre1, int potencia1, int alcance1,int numDados1, int valorExito1){
        
        super(nombre1);
        this.potencia = potencia1;
        this.arcangel = alcance1;
        this.numDados = numDados1;
        this.valorExito = valorExito1;
        
    }
     
    public int getPotencia(){
        return this.potencia;
    }
    
    public int getAlcance(){
        return this.arcangel;
    }
    
    public int getNumDados(){
        return this.numDados;
    }
    
    public int getValorExito(){
        return this.valorExito;
    }
     
    public void setPotencia(int potencia1){
        this.potencia = potencia1;
    }
    public void setAlcance(int alcance1){
        this.arcangel = alcance1;
    }
    public void setNumDados(int dados){
        this.numDados = dados;
    }
    public void setValorExito(int valorEx){
        this.valorExito = valorEx;
    }
    
    public boolean isCuerpoACuerpo(Arma arma){
        
        if(arma.arcangel == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if( getClass() != o.getClass()) return false;
        
        
        
        Arma arma = (Arma) o;
         return nombre.equals(arma.nombre);
    }
    
     @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", potencia=" + potencia +
                ", alcance=" + arcangel +
                ", numeroDeDados=" + numDados +
                ", valorDeExito=" + valorExito +
                '}';
    }
}   
    
