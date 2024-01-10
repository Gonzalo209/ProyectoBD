package org.example.control;

import org.example.modelo.Paciente;
import org.example.modelo.PacienteBD;
import org.example.vista.MensajeVista;
import org.example.vista.VentanaPrincipalVista;

import java.awt.event.*;

public class VentanaPrincipalControl implements ActionListener {

    private static PacienteBD pacienteBD = new PacienteBD();

    @Override
    public void actionPerformed(ActionEvent e) {

        String menu = e.getActionCommand();

        switch (menu) {

            case "Agregar" -> agregarPaciente();
            case "Buscar" -> buscar();
            case "Eliminar" -> eliminar();
            case "Modificar" -> modificar();

        }

    }

    private void agregarPaciente() {

        pacienteBD.agregarPaciente(new Paciente(Integer.parseInt(VentanaPrincipalVista.getTxtId().getText()),
                VentanaPrincipalVista.getTxtNombre().getText(),
                VentanaPrincipalVista.getTxtApellidos().getText(),
                VentanaPrincipalVista.getTxtTelefono().getText(),
                Integer.parseInt(VentanaPrincipalVista.getTxtId().getText()),
                Integer.parseInt(VentanaPrincipalVista.getTxtEdad().getText()),
                Float.parseFloat(VentanaPrincipalVista.getTxtPeso().getText()),
                Float.parseFloat(VentanaPrincipalVista.getTxtTalla().getText()),
                VentanaPrincipalVista.getTxtPadecimiento().getText(),
                Integer.parseInt(VentanaPrincipalVista.getTxtNumEstudios().getText())));

        limpiarCampos();

    }

    private void eliminar() {

        pacienteBD.eliminar(Integer.parseInt(VentanaPrincipalVista.getTxtBuscarId().getText()));

        activarBotones(false, false, false);

        habilitarODeshabilitarJTextField(true);

        limpiarCampos();

    }

    private void buscar() {

        if(pacienteBD.buscar(Integer.parseInt(VentanaPrincipalVista.getTxtBuscarId().getText()))) {

            activarBotones(false, true, true);

            habilitarODeshabilitarJTextField(false);

        } else {

            MensajeVista.mensajeError("No se encontro el paciente", "Error");

            VentanaPrincipalVista.getBtnBuscar().setText("");

            VentanaPrincipalVista.getBtnBuscar().setEnabled(false);

        }

    }

    private void modificar() {

        pacienteBD.modificar();

        activarBotones(false, false, false);

        habilitarODeshabilitarJTextField(true);

        limpiarCampos();

    }

    private void limpiarCampos() {

        VentanaPrincipalVista.getTxtId().setText("");
        VentanaPrincipalVista.getTxtNombre().setText("");
        VentanaPrincipalVista.getTxtApellidos().setText("");
        VentanaPrincipalVista.getTxtTelefono().setText("");
        VentanaPrincipalVista.getTxtEdad().setText("");
        VentanaPrincipalVista.getTxtPeso().setText("");
        VentanaPrincipalVista.getTxtTalla().setText("");
        VentanaPrincipalVista.getTxtPadecimiento().setText("");
        VentanaPrincipalVista.getTxtNumEstudios().setText("");
        VentanaPrincipalVista.getTxtBuscarId().setText("");

    }

    private void activarBotones(boolean btn1, boolean btn2, boolean btn3) {

        VentanaPrincipalVista.getBtnAgregar().setEnabled(btn1);
        VentanaPrincipalVista.getBtnEliminar().setEnabled(btn2);
        VentanaPrincipalVista.getBtnModificar().setEnabled(btn3);
        VentanaPrincipalVista.getBtnBuscar().setEnabled(false);

    }

    private void habilitarODeshabilitarJTextField(boolean activado) {

        VentanaPrincipalVista.getTxtId().setEnabled(activado);
        VentanaPrincipalVista.getTxtNombre().setEnabled(activado);
        VentanaPrincipalVista.getTxtApellidos().setEnabled(activado);

    }

}