/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Objetos.Jugador;
import java.io.BufferedReader;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a18danielmr
 */
public class Modificar {
    public static void main(BufferedReader lee) throws IOException {
        int op;
        do {
            op = Menu.modificar(lee);
            switch(op) {
                case 1:
                    deporte(lee);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    break;
            }
        }while(op != 0);
    }
    
    public static void deporte(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("jugadores.db");
        
        System.out.println("Introduzca el nombre de jugador");
        String nombre = lee.readLine();
        
        IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombrejug", nombre));
        Objects<Jugador> objects = odb.getObjects(query);
        
        if(objects.isEmpty()) {
            System.out.println("No se ha encontrado ningún jugador con ese nombre");
        } else {
            Jugador j = (Jugador)odb.getObjects(query).getFirst();
            System.out.println("Escriba un nuevo deporte");
            String deporte = lee.readLine();
            j.setDeporte(deporte);
            odb.store(j);
        }
        
        odb.close();
    }
}
