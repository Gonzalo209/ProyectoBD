package org.example.control;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidacionNumerosControl extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {

        boolean numero = e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || (int) e.getKeyChar() == 8;

        if(! numero) {

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros", "Error", JOptionPane.ERROR_MESSAGE);

            e.consume();

        }

    }

}