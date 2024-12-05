
public class Tablero {

    private Casilla[][] tablero;
    
    public Tablero(){
        this.tablero = new Casilla[10][10];
    }
    
    private void crearTablero(){
        
        for(int i= 0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                
                tablero[i][j] = new Casilla(i,j,null,null);
                
            }
        }
    }
    
    
    public Casilla getCasilla(int x, int y){
      if (x >= 0 && x < tablero.length && y >= 0 && y < tablero[0].length) {
          return tablero[x][y];
      }else{
          return null;
      }
    }
    
    public void mostrarTablero() {
        
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Casilla casilla = tablero[i][j];
                casilla.mostrarOcupado(); 
            }
            System.out.println("\n"); 
        }
    }
    
    private Equipo generarArma(){
       
        
           int random1 = (int) (Math.random()*2);
           
           if(random1 == 0){
               Arma[] armas = new Arma[10];
               
               armas[0] = new Arma("Sable Laser(Star wars)", 1, 0, 2, 1);
               armas[1] = new Arma("Motosierra(DOOM)", 2, 0, 3, 3);
               armas[2] = new Arma("Recortada(DOOM)", 2, 1, 2, 3);
               armas[3] = new Arma("M9 (Metal Gear Solid",1, 1, 2, 1);
               armas[4] = new Arma("P90(Fortnite)", 1, 1, 2, 4);
               armas[5] = new Arma("AK-47(Battlefield 4)",2, 1, 2, 4);
               armas[6] = new Arma("Glock 17(R6)", 1, 1, 3, 1);
               armas[7] = new Arma("1911(Resident Evil)", 1, 1, 3, 1);
               armas[8] = new Arma("AWP (CS:GO)",3, 2, 3, 4);
               armas[9] = new Arma("Apoticon (COD Zombis)",3, 2, 1, 5);
               
               int random2 = (int) (Math.random() * 100) + 1;
               
               if(random2 <= 50){
                   int randomPistola = (int) (Math.random()*4);
                   if(randomPistola == 0){
                       return armas[3];
                   }
                   if(randomPistola == 1){
                       return armas[4];
                   }
                   if(randomPistola ==2){
                       return armas[6];
                   }
                   if(randomPistola ==3){
                       return armas[7];
                   }
               }
               if(random2>50 && random2<=70){
                   int randomCaC = (int) Math.random()*3;
                   if(randomCaC ==2){
                       return armas[1];
                   }else{
                       return armas[0];
                   }
               }
               
               if(random2>70 && random2<=80){
                   return armas[2];
               }
               
               if(random2>80 && random2<=88){
                   return armas[5];
               }
               
               if(random2>88 && random2<=95){
                   return armas[8];
               }
               if(random2>95){
                   return armas[9];
               }
               
           }
        return null;
    }
    
    private void generarProvisiones(){
        
        Provision[] provi = new Provision[0];
        
               provi[0] = new Provision("Sable Laser(Star wars)", 1, "1");
               provi[1] = new Provision("Motosierra(DOOM)", 2, "1");
               provi[2] = new Provision("Recortada(DOOM)", 2, "1");
               provi[3] = new Provision("M9 (Metal Gear Solid",1, "1");
               provi[4] = new Provision("P90(Fortnite)", 1, "1");
               provi[5] = new Provision("AK-47(Battlefield 4)",2, "1");
    }
    
}