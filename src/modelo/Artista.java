package modelo;

/**
 * Clase donde creamos el objeto Artista
 * @author IvanSM
 */

public class Artista {
    // Artibutos

    private String nif; // es la clave primaria
    private String nombre;
    private String apellidos;
    private String nifJefe;

    // Constructores
    public Artista() {    
        
    }
    /**
     * Constructor con parametro clave primaria
     * @param nif String
     */
    //Constructor con la clave primaria
    public Artista(String nif) {
        this.nif = nif;
    }
    
    /**
     * Constructor con todos los parametros para crear un objeto 
     * @param nif String
     * @param nombre String
     * @param apellidos String
     * @param nifJefe String
     */
    public Artista(String nif, String nombre, String apellidos, String nifJefe) {
        super();
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nifJefe = nifJefe;
    }

    // Getters and Setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNifJefe() {
        return nifJefe;
    }

    public void setNifJefe(String nifJefe) {
        this.nifJefe = nifJefe;
    }

}
