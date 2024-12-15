import java.util.ArrayList;
import java.util.Arrays;


public class Tablero{

    private Casilla[][] tablero;
    private static int contadorZombis=1;
    
    public Tablero(){
        this.tablero = new Casilla[10][10];
    }
    
    public Tablero getTablero(){
        return this;
    }
    
    public void setTablero(){
          crearTablero();
    }
    
    public void crearTablero(){
        
        for(int i= 0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                
                tablero[i][j] = new Casilla(i,j,new ArrayList<>(),null);
            }
            
            for(i=0;i<5;i++){
                int x = (int) (Math.random()*9);
                int y = (int) (Math.random()*9);
           
            tablero[x][y].setEquipo(generarProvision());
            
            }
            
            for(i = 0;i<tablero.length;i++){
                for(int p=0;p<tablero[i].length;p++){
                    
                    if(tablero[i][p].getEquipo() == null){
                        tablero[i][p].setEquipo(generarArma());
                    }
                        
                }
            }
        }
        
        tablero[0][0].setEntidad(new ArrayList<>(Arrays.asList(generarSuperviviente())));
        
        for(int q =0;q<3;q++){
                int x = (int) (Math.random()*9);
                int y = (int) (Math.random()*9);
                
                Zombi zombi = generarZombiAleatorio();
                
                Casilla casilla = tablero[x][y];
                ArrayList<Entidad> entidades = casilla.getEntidad();
                entidades.add(zombi);
                casilla.setEntidad(entidades);
            
                zombi.setPosicionZ(casilla);
                
            }
       

    }
    
    public Casilla getSupervivientes(Superviviente superviviente){
 
        for(int i = 0;i<tablero.length;i++){
                for(int p=0;p<tablero[i].length;p++){
                    
                    ArrayList<Entidad> entidades = this.getCasilla(i, p).getEntidad();
                    if(entidades != null){
                        for(int j=0;j<entidades.size();j++){
                            
                            Entidad entidad = entidades.get(j);
                            
                            if(entidad instanceof Superviviente){
                             Superviviente superviviente1 = (Superviviente) entidad;
                             
                             if(superviviente1.getNombre().equals(superviviente.getNombre())){
                                 return this.getCasilla(i,p);
                             }
                            }
                        }
                        
                    }
                        
                }
            }
        return null;


  }
            
    
    
    public Casilla getCasilla(int x, int y){
        if (x >= 0 && x < tablero.length && y >= 0 && y < tablero[0].length) {
            return tablero[x][y];
        }else {
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
        
        int random = (int) (Math.random()*2);
        
        if(random ==0){
            return null;
        }
        if(random ==1){
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
               armas[9] = new Arma("Apoticon (COD Zombis",3, 2, 1, 5);
               
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
           
       
        }
        
        return null;
    }
    
    
    private Equipo generarProvision(){
        
            Provision[] provi = new Provision[6];
               
            provi[0] = new Provision("Cerveza",23,"12/12/2028");
            provi[1] = new Provision("Manzana De Oro",33,"2/1/2018");
            provi[2] = new Provision("Bebida Energética",3,"31/8/2020");
            provi[3] = new Provision("¿Setas?",111,"1/2/2011");
            provi[4] = new Provision("Fabada",2300,"2/7/2078");
            provi[5] = new Provision("Sopita",500,"5/2/2048");
            
           for(int i=0;i<5;i++){
               return provi[i];
           }
        
           return null;
   }
    
    
    private Entidad[] generarSuperviviente() {
        Entidad[] supers = new Entidad[4];

            Inventario inventTakeo = new Inventario();
            Arma[] armasTakeo = new Arma[2];
            supers[0] = new Superviviente("Takeo", "Vivo", 3, inventTakeo, armasTakeo, 0, 0);

           Inventario inventDempsey = new Inventario();
            Arma[] armasDempsey = new Arma[2];
            supers[1] = new Superviviente("Dempsey", "Vivo", 3, inventDempsey, armasDempsey, 0, 0);

            Inventario inventNikolai = new Inventario();
            Arma[] armasNikolai = new Arma[2];
            supers[2] = new Superviviente("Nikolai", "Vivo", 3, inventNikolai, armasNikolai, 0, 0);

            Inventario inventRichtofen = new Inventario();
             Arma[] armasRichtofen = new Arma[2];
            supers[3] = new Superviviente("Richtofen", "Vivo", 3, inventRichtofen, armasRichtofen, 0, 0);

    return supers;
}
    
    
    public String generarNombreZombi(){
        
         StringBuilder nombre = new StringBuilder("Zombi");

        
            nombre.append(contadorZombis);
        contadorZombis++;
        return nombre.toString();
    }
    
    
    public Zombi generarZombiAleatorio() {
    int rand = (int) (Math.random() * 100);
    Zombi zombi;

    if (rand < 60) {
        int rand1 = (int) (Math.random() * 3);
        if (rand1 == 0) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 1, "Caminante", "Normal");
        } else if (rand1 == 1) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 1, "Caminante", "Berserker");
        } else {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 1, "Caminante", "Normal");
        }
    } else if (rand < 90) {
        int rand2 = (int) (Math.random() * 3);
        if (rand2 == 0) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 2, "Corredor", "Normal");
        } else if (rand2 == 1) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 2, "Corredor", "Berserker");
        } else {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 1, 2, "Corredor", "Tóxico");
        }
    } else {
        int rand3 = (int) (Math.random() * 3);
        if (rand3 == 0) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 3, 1, "Abominacion", "Normal");
        } else if (rand3 == 1) {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 3, 1, "Abominacion", "Berserker");
        } else {
            zombi = new Zombi(this.generarNombreZombi(),"Vivo", 3, 1, "Abominacion", "Tóxico");
        }
    }

    return zombi;
}
    
    public void generarZombiRonda(){
        
        Zombi zombi = generarZombiAleatorio();
        
        int x = (int) (Math.random()*9);
        int y = (int) (Math.random()*9);

         
         Casilla casilla = tablero[x][y];
           ArrayList<Entidad> entidades = casilla.getEntidad();
            entidades.add(zombi);
             casilla.setEntidad(entidades);
            
                zombi.setPosicionZ(casilla);        
        
    }
    
    public ArrayList<Entidad> arrayEntidades(){
        
        ArrayList<Entidad> entidades = new ArrayList<>();
                
        for(int i = 0;i<tablero.length;i++){
                for(int p=0;p<tablero[i].length;p++){
                    
                    ArrayList<Entidad> entidadesCasilla = this.getCasilla(i, p).getEntidad();
                   
                    if(entidadesCasilla != null){
                        entidades.addAll(entidadesCasilla);
                       
                       
                   }
                    
                        
                }
            }
        return entidades;
        
        
    }

    
    
}
