package modelo;

/**
 * Clase donde creamos el objeto Animal
 *
 * @author IvanSM
 */
public class Animal {
    // Artibutos

    private String nombre;
    private String tipo;
    private int anios;
    private float peso;
    private float estatura;
    private String nombreAtraccion;
    private String nombrePista;

    // Constructores
    /**
     *
     */
    public Animal() {

    }

    /**
     * Constructor con el parametro clave primaria
     *
     * @param nombre String
     */
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con todos los parametro para crear un objeto animal.
     *
     * @param nombre String
     * @param tipo String
     * @param anios int
     * @param peso float
     * @param estatura float
     * @param nombreAtraccion String
     * @param nombrePista String
     */
    public Animal(String nombre, String tipo, int anios, float peso, float estatura, String nombreAtraccion,
            String nombrePista) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.anios = anios;
        this.peso = peso;
        this.estatura = estatura;
        this.nombreAtraccion = nombreAtraccion;
        this.nombrePista = nombrePista;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public String getNombrePista() {
        return nombrePista;
    }

    public void setNombrePista(String nombrePista) {
        this.nombrePista = nombrePista;
    }

}
