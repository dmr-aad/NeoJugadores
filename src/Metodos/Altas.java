
package Metodos;

import Objetos.Jugador;
import Objetos.Pais;
import java.io.BufferedReader;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.*;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a18danielmr
 */
public class Altas {
    
    public static void main(BufferedReader lee) throws IOException {
        int op;
        do {
            op = Menu.altas(lee);
            switch (op) {
                case 1:
                    jugador(lee);
                    break;
                case 2:
                    pais(lee);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    break;
            }
        } while (op != 0);
    }
    
    public static void jugador(BufferedReader lee) throws IOException {
        //Abrir sin modo cliente servidor
        ODB odb = ODBFactory.open("jugadores.db");
        
        Jugador j = null;
        Pais p = null;
        IQuery query = null;
        
        System.out.println("Nombre");
        String nombre = lee.readLine();
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        
        System.out.println("Deporte");
        String deporte = lee.readLine();
        
        System.out.println("Ciudad");
        String ciudad = lee.readLine();
        
        System.out.println("Edad");
        int edad = Integer.parseInt(lee.readLine());
        
        System.out.println("Pais");
        String npais = lee.readLine();
        
        query = new CriteriaQuery(Pais.class, Where.equal("nombrepais", npais));
        Objects<Pais> objects = odb.getObjects(query);
        
        if (objects.isEmpty()) {
            System.out.println("No existe el pais seleccionado");
            
            System.out.println("ID");
            int id = Integer.parseInt(lee.readLine());
            
            p = new Pais(id, npais);
            
            odb.store(p);
        } else {
            p = objects.getFirst();
        }
        
        j = new Jugador(nombre, deporte, ciudad, edad, p);
        
        odb.store(j);
        
        odb.close();
    }
    
    public static void pais(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("jugadores.db");
        
        Pais p = null;
        
        System.out.println("ID");
        int id = Integer.parseInt(lee.readLine());
        
        System.out.println("Nombre");
        String nombre = lee.readLine();
        
        p = new Pais(id, nombre);
        
        odb.store(p);
        odb.close();
    }
}
