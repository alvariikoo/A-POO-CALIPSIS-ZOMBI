/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOLMO
 */
public class main {

    public static void main(String[] args) {
        
        // Crear el tablero
        Tablero tablero = new Tablero();
        
        // Crear un objeto para manejar el juego
        Jugar juego = new Jugar(tablero);
        
        // Iniciar el juego
        juego.jugar();
        
    }
}

