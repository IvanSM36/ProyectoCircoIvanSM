package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Animal;
import modelo.AnimalDAO;
import vista.VentanaAnimales;
import vista.VentanaDatosAnimal;

/**
 * Clase donde se programa los eventos de los botones que necesiten acceso a la
 * BD de la ventana datos Animales , Se necesitara una clase por cada metodo ya que en nuestro caso el boton buscar esta en otra ventana
 *
 * @author IvanSM
 */
public class CtrlAnimalesRead implements ActionListener {

    private Animal animal;
    private AnimalDAO consulta;
    private VentanaAnimales formAnimal;
    private VentanaDatosAnimal visualAnimal;

    /**
     * Constructor para consultar los datos de la base de datos
     * venatanaDatosAnimal
     *
     * @param animal AnimalObj
     * @param consulta AnimalDAO
     * @param datosAnimal VentanaDatosAnimal datos Animales
     */
    public CtrlAnimalesRead(Animal animal, AnimalDAO consulta, VentanaDatosAnimal datosAnimal) {
        this.animal = animal;
        this.consulta = consulta;
        this.visualAnimal = datosAnimal;
        this.visualAnimal.btnBuscar.addActionListener(this);
    }

    //Metodos
    /*
    * Metodo que limpia los campos del formulario
    *@param
    *@retrun 
     */
    public void limpiar() {
        formAnimal.txtNombre.setText(null);
        formAnimal.txtTipo.setText(null);
        formAnimal.txtAnios.setText(null);
        formAnimal.txtEstatura.setText(null);
        formAnimal.txtPeso.setText(null);
    }

    /**
     * Evento para el boton buscar que busca los datos en la BD los recoge e
     * inserta en los campos correspondientes.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == visualAnimal.btnBuscar) {
            animal.setNombre(visualAnimal.txtNombre.getText());
            if (consulta.read(animal)) {
                visualAnimal.txtTipo.setText(animal.getTipo());
                visualAnimal.txtAnios.setText(String.valueOf(animal.getAnios())); //Convertimos int en String
                visualAnimal.txtPeso.setText(String.valueOf(animal.getPeso())); //Convertimos Float en String
                visualAnimal.txtEstatura.setText(String.valueOf(animal.getEstatura()));
                visualAnimal.txtNombreAtraccion.setText(animal.getNombreAtraccion());
                visualAnimal.txtNombrePista.setText(animal.getNombrePista());
                if (consulta.read(animal)) {
                    JOptionPane.showMessageDialog(null, "Consulta realizada.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al consultar.");
                    limpiar();
                }
            }
        }
    }

}
