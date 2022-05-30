package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase donde programamos los metodos consultas a la VD Animales
 *
 * @author IvanSM
 */
public class AnimalDAO extends Conexion {
    // Metodos	
    // 

    /**
     * Creamos el metodo create() para poder insertar datos en la base de datos.
     *
     * @param animal AnimalObj
     * @see create(a)
     * @return boolean
     */
    public boolean create(Animal animal) {
        Connection conexion = getConexion();

        // Si el animal pasado es nulo no haremos nada
        if (animal != null) {
            String sql = "INSERT INTO circo.animales (nombre, tipo, anhos, peso, estatura, nombre_atraccion, nombre_pista) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {

                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, animal.getNombre());
                sentencia.setString(2, animal.getTipo());
                sentencia.setInt(3, animal.getAnios());
                sentencia.setFloat(4, animal.getPeso());
                sentencia.setFloat(5, animal.getEstatura());
                sentencia.setString(6, animal.getNombreAtraccion());
                sentencia.setString(7, animal.getNombrePista());
                sentencia.executeUpdate();
                conexion.close(); // Cerramos la conexion
            } catch (SQLException ex) {
                System.out.println("Error al insertar.");
                return false;
            }
        }
        System.out.println("Se ha guardado con exito.");
        return true;
    }

    // 
    /**
     * Lee los datos con la clave primaria construye un objeto con sus datos y
     * lo devuelve.
     *
     * @param animal Animalobj
     * @return boolean
     */
    public boolean read(Animal animal) {
        String sql = "SELECT * FROM animales WHERE upper(nombre) = ?";
        try {
            Connection conexion = getConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, animal.getNombre()); // Asignamos la clave primaria a buscar
            ResultSet rs = sentencia.executeQuery();
            // Al estar buscando por la clave primaria. solo existen dos alternativas:
            // 1. La encuentra: el resulSet tendrá un unico registro.
            // 2. No la encuentra: el resulSet estará vacio.
            if (rs.next()) { // Si hay un registro
                animal.setTipo(rs.getString("tipo"));
                animal.setAnios(rs.getInt("anhos"));
                animal.setPeso(rs.getFloat("peso"));
                animal.setEstatura(rs.getFloat("estatura"));
                animal.setNombreAtraccion(rs.getString("nombre_atraccion"));
                animal.setNombrePista(rs.getString("nombre_pista"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error al consultar un animal.");
            return false;
        } finally {
            try {
                conexion.close(); // cerramos la conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

}
