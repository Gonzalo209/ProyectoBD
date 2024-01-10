package org.example.control;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionLetrasControl extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {

        boolean letra = e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'  || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z'
                || (int) e.getKeyChar() == 8;

        if(! letra) {

            JOptionPane.showMessageDialog(null, "Ingrese solo letras ", "Error", JOptionPane.ERROR_MESSAGE);

            e.consume();

        }

    }

}
