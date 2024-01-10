package org.example.control;

import org.example.vista.MensajeVista;
import org.example.vista.VentanaPrincipalVista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionDecimalTallaControl extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {

        boolean numero = e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || (int) e.getKeyChar() == 8;

        if(! numero && e.getKeyChar() != '.') {

            MensajeVista.mensajeError("Ingrese solo numeros", "Error");

            e.consume();

        }

        if(e.getKeyChar() == '.' && VentanaPrincipalVista.getTxtTalla().getText().contains(".")) {

            e.consume();

        }

    }

}

