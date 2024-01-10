package org.example.control;

import org.example.vista.VentanaPrincipalVista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionBotonAgregarControl extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {

        if(verificarCamposVacios()) {

            VentanaPrincipalVista.getBtnAgregar().setEnabled(true);

        } else {

            VentanaPrincipalVista.getBtnAgregar().setEnabled(false);

        }


    }

    private boolean verificarCamposVacios() {

        boolean estaVacio = false;

        if(! VentanaPrincipalVista.getTxtId().getText().isEmpty() && ! VentanaPrincipalVista.getTxtNombre().getText().isEmpty() &&
                ! VentanaPrincipalVista.getTxtApellidos().getText().isEmpty() && ! VentanaPrincipalVista.getTxtTelefono().getText().isEmpty() &&
                ! VentanaPrincipalVista.getTxtEdad().getText().isEmpty() && ! VentanaPrincipalVista.getTxtPeso().getText().isEmpty() &&
                ! VentanaPrincipalVista.getTxtTalla().getText().isEmpty() && ! VentanaPrincipalVista.getTxtPadecimiento().getText().isEmpty() &&
                ! VentanaPrincipalVista.getTxtNumEstudios().getText().isEmpty()) {

            estaVacio = true;

        }

        return estaVacio;

    }

}