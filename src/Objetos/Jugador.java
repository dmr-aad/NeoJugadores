
package Objetos;

/**
 *
 * @author a18danielmr
 */
public class Jugador {
    
    private String nombrejug;
    private String deporte;
    private String ciudad;
    private int edad;
    private Pais pais;

    public Jugador() {
    }

    public Jugador(String nombrejug, String deporte, String ciudad, int edad, Pais pais) {
        this.nombrejug = nombrejug;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.edad = edad;
        this.pais = pais;
    }

    public String getNombrejug() {
        return nombrejug;
    }

    public void setNombrejug(String nombrejug) {
        this.nombrejug = nombrejug;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
