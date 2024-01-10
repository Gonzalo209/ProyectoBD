package org.example.control;

import org.example.vista.Login;
import org.example.vista.MenuPrincipalVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControl extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        String menu = e.getActionCommand();

        switch (menu) {

            case "Iniciar Sesion" -> accederLogin();

        }

    }

    private void accederLogin() {

        if(! verificarCampos()) {

            if(Login.getTxtUsuario().getText().equals("Equipo 4")) {

                new Login().dispose();

                MenuPrincipalVista menuPrincipalVista = new MenuPrincipalVista();

                menuPrincipalVista.setVisible(true);


            } else {

                JOptionPane.showMessageDialog(null, "Username o password incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Ingrese su username y password", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private boolean verificarCampos() {

        boolean activado = false;

        if(Login.getTxtUsuario().getText().isEmpty() && Login.getTxtPassword().getPassword().length < 1) {

            activado = true;

        }

        return activado;

    }

}