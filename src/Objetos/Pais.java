
package Objetos;

/**
 *
 * @author a18danielmr
 */
public class Pais {
    private int id;
    private String nombrepais;

    public Pais(int id, String nombrepais) {
        this.id = id;
        this.nombrepais = nombrepais;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }
    
    
}
