/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Objetos.Jugador;
import Objetos.Pais;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a18danielmr
 */
public class Consultar {
    public static void main(BufferedReader lee) throws IOException {
        int op;
        do{
            op = Menu.consultar(lee);
            switch(op) {
                case 1:
                    jugadores(lee);
                    break;
                case 2:
                    jugadorPais(lee);
                    break;
                case 3:
                    sumaEdad(lee);
                    break;
                case 4:
                    totalJugadores(lee);
                    break;
                case 5:
                    media(lee);
                    break;
                case 6:
                    jugadoresCiudad(lee);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    break;
            }
        }while(op != 0);
    }
    public static void jugadores(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("jugadores.db");
        String nombre;
        
        do {            
            System.out.println("¿Que jugador quieres consultar? (0 para salir)");
            nombre = lee.readLine();
            nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
            
            if (!nombre.equals("0")) {
                ICriterion crit = Where.like("nombrejug", nombre + "%");
                CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
                
                Objects<Jugador> jugadores = odb.getObjects(query);
                
                if (!jugadores.isEmpty()) {
                    while (jugadores.hasNext()) {
                        Jugador j = jugadores.next();
                        System.out.println("Nombre: " + j.getNombrejug());
                        System.out.println("Deporte: " + j.getDeporte());
                        System.out.println("Ciudad: " + j.getCiudad());
                        System.out.println("Pais: " + j.getPais().getNombrepais());
                        System.out.println("*****************************");
                    }
                } else {
                    System.out.println("No hay ningún jugador con los criterios de búsqueda descritos");
                }
            }
        } while (!nombre.equals("0"));
        
        odb.close();
    }
    
    public static void jugadorPais(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("jugadores.db");
        String nombre;
        
        do {            
            System.out.println("¿Que pais quieres consultar? (0 para salir)");
            nombre = lee.readLine();
            nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
            
            if (!nombre.equals("0")) {
                ICriterion crit = Where.like("pais.nombrepais", nombre + "%");
                CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
                
                ICriterion critP = Where.like("nombrepais", nombre + "%");
                CriteriaQuery queryP = new CriteriaQuery(Pais.class, critP);
                
                Objects<Jugador> jugadores = odb.getObjects(query);
                Objects<Pais> paises = odb.getObjects(queryP);
                
                System.out.println("Jugadores de " + paises.getFirst().getNombrepais());
                System.out.println("*****************************");
                
                if (!jugadores.isEmpty()) {
                    while (jugadores.hasNext()) {
                        Jugador j = jugadores.next();
                        System.out.println("Nombre: " + j.getNombrejug());
                        System.out.println("Deporte: " + j.getDeporte());
                        System.out.println("Ciudad: " + j.getCiudad());
                        System.out.println("*****************************");
                    }
                } else {
                    System.out.println("No hay ningún jugador con los criterios de búsqueda descritos");
                }
            }
        } while (!nombre.equals("0"));
        
        odb.close();
    }
    
    public static void sumaEdad(BufferedReader lee) {
        ODB odb = ODBFactory.open("jugadores.db");
        
        Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).sum("edad"));
        ObjectValues ov=val.nextValues();
        BigDecimal value = (BigDecimal)ov.getByAlias("edad");
        
        System.out.println("Suma de edades: " + value.longValue());
        System.out.println("*****************************");
        odb.close();
    }
    
    public static void totalJugadores(BufferedReader lee) {
        ODB odb = ODBFactory.open("jugadores.db");
        
        Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).count("nombrejug"));
        ObjectValues ov = val.nextValues();
        BigInteger value = (BigInteger)ov.getByAlias("nombrejug");
        
        System.out.println("Nº de jugadores: " + value.intValue());
        System.out.println("*****************************");
        
        odb.close();
    }
    
    public static void media(BufferedReader lee) {
        ODB odb = ODBFactory.open("jugadores.db");
        
        Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).avg("edad"));
        ObjectValues ov = val.nextValues();
        BigDecimal value = (BigDecimal)ov.getByAlias("edad");
        
        System.out.println("Media de la edad de los jugadores: " + value);
        
        odb.close();
    }
    
    public static void jugadoresCiudad(BufferedReader lee) {
        ODB odb = ODBFactory.open("jugadores.db");
        
        Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).
                field("ciudad").
                count("nombrejug").
                groupBy("ciudad"));
        
        while(val.hasNext()) {
            ObjectValues ov = val.next();
            
            System.out.println("Jugadores de la ciudad de "+ov.getByAlias("ciudad")+": " + ov.getByIndex(1));
            System.out.println("*****************************");
        }
        odb.close();
    }
}
