
package neojugadores;

import Metodos.Altas;
import Metodos.Bajas;
import Metodos.Consultar;
import Metodos.Menu;
import Metodos.Modificar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18danielmr
 */
public class NeoJugadores {

    
    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int op;
        do {            
            op = Menu.main(lee);
            switch (op) {
                case 1:
                    Altas.main(lee);
                    break;
                case 2:
                    Bajas.main(lee);
                    break;
                case 3:
                    Modificar.main(lee);
                    break;
                case 4:
                    Consultar.main(lee);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    break;
            }
        } while (op != 0);
    }
    
}
