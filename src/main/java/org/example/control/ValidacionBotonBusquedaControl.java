package org.example.control;

import org.example.vista.VentanaPrincipalVista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionBotonBusquedaControl extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {

        if(! VentanaPrincipalVista.getTxtBuscarId().getText().isEmpty()) {

            VentanaPrincipalVista.getBtnBuscar().setEnabled(true);

        } else {

            VentanaPrincipalVista.getBtnBuscar().setEnabled(false);

        }

    }

}
