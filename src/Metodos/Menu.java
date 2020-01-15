
package Metodos;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18danielmr
 */
public class Menu {
    public static int main(BufferedReader lee) throws IOException {
        int opcion;
        System.out.println("***MENU JUGADORES***");
        System.out.println("* 1. Altas");
        System.out.println("* 2. Bajas");
        System.out.println("* 3. Modificar");
        System.out.println("* 4. Consultar");
        System.out.println("* 0. Salir");
        opcion = Integer.parseInt(lee.readLine());
        return opcion;
    }
    
    public static int altas(BufferedReader lee) throws IOException {
        int opcion;
        System.out.println("***ALTAS***");
        System.out.println("* 1. Jugadores");
        System.out.println("* 2. Paises");
        System.out.println("* 0. Salir");
        opcion = Integer.parseInt(lee.readLine());
        return opcion;
    }
    
    public static int bajas(BufferedReader lee) throws IOException {
        int opcion;
        System.out.println("***BAJAS***");
        System.out.println("* 1. Jugadores");
        System.out.println("* 2. Paises");
        System.out.println("* 0. Salir");
        opcion = Integer.parseInt(lee.readLine());
        return opcion;
    }
    
    public static int modificar(BufferedReader lee) throws IOException {
        int opcion;
        System.out.println("***MODIFICAR***");
        System.out.println("* 1. Deporte de un jugador");
        System.out.println("* 0. Salir");
        opcion = Integer.parseInt(lee.readLine());
        return opcion;
    }
    
    public static int consultar(BufferedReader lee) throws IOException {
        int opcion;
        System.out.println("***CONSULTAR***");
        System.out.println("* 1. Jugador");
        System.out.println("* 2. Jugadores de un pais");
        System.out.println("* 3. Suma edades");
        System.out.println("* 4. Total jugadores");
        System.out.println("* 5. Media edad jugadores");
        System.out.println("* 6. Jugadores de cada ciudad");
        System.out.println("* 0. Salir");
        opcion = Integer.parseInt(lee.readLine());
        return opcion;
    }
}
