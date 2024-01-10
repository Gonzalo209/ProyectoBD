package org.example.vista;

import javax.swing.*;

public class MensajeVista extends JOptionPane {

    public static void mensajeAviso(String mensaje, String titulo) {

        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);

    }

    public static void mensajeError(String mensaje, String titulo) {

        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);

    }

}
