package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Animal;
import modelo.AnimalDAO;
import vista.VentanaAnimales;

/**
 * Clase donde se programa los eventos de los botones que necesiten acceso a la BD de la ventana formulario de Animales 
 * 
 * @author IvanSM
 */
public class CtrlAnimales implements ActionListener {

    private Animal animal;
    private AnimalDAO consulta;
    private VentanaAnimales formAnimal;

    /**
     * Constructor para conectar un objeto animal con la consulta y recoger los
     * datos del formulario de la Ventana Animal
     *
     * @param animal ObjAnimal
     * @param consulta AnimalDAO
     * @param formAnimal VentanaAnimales formulario
     */
    public CtrlAnimales(Animal animal, AnimalDAO consulta, VentanaAnimales formAnimal) {
        this.animal = animal;
        this.consulta = consulta;
        this.formAnimal = formAnimal;
        this.formAnimal.btnGuardar.addActionListener(this);
    }

    //Metodos
    /**
     *
     */
    public void limpiar() {
        formAnimal.txtNombre.setText(null);
        formAnimal.txtTipo.setText(null);
        formAnimal.txtAnios.setText(null);
        formAnimal.txtEstatura.setText(null);
        formAnimal.txtPeso.setText(null);
    }

    /**
     *
     */
    public void iniciar() {
        formAnimal.setTitle("Animales");
        formAnimal.setLocationRelativeTo(null);
        formAnimal.txtTipo.setVisible(false);
    }

    /**
     * Evento para el boton guardar de venatana Animales, envialos datos
     * recogidos del formulario a la base de datos
     *
     * @param  e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formAnimal.btnGuardar) {//Boton que hará el evento
            animal.setNombre(formAnimal.txtNombre.getText());
            animal.setTipo(formAnimal.txtTipo.getText());
            animal.setAnios(Integer.parseInt(formAnimal.txtAnios.getText())); //Se debe usar Integer.parseInt para transformar el string en int
            animal.setPeso(Float.parseFloat(formAnimal.txtPeso.getText())); //Se debe usar Float.parseFloat para transformar el string en float
            animal.setEstatura(Float.parseFloat(formAnimal.txtEstatura.getText()));
            animal.setNombreAtraccion(formAnimal.listNombreAtraccion.getSelectedItem().toString());// Recogemos el valor seleccionado en la lista 
            animal.setNombrePista(formAnimal.listNombrePista.getSelectedItem().toString());
            if (consulta.create(animal)) {
                JOptionPane.showMessageDialog(null, "Registro insertado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar.");
                limpiar();
            }
        }
    }

}
