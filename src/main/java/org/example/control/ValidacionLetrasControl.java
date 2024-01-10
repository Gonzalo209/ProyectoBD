package org.example.control;

import org.example.vista.MensajeVista;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionLetrasControl extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {

        boolean letra = e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'  || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z'
                || (int) e.getKeyChar() == 8;

        if(! letra) {

            MensajeVista.mensajeError("Ingrese solo letras", "Error");

            e.consume();

        }

    }

}
