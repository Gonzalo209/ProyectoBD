package org.example.control;

import org.example.vista.Login;
import org.example.vista.MensajeVista;
import org.example.vista.MenuPrincipalVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControl implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        String menu = e.getActionCommand();

        switch (menu) {

            case "Iniciar Sesion" -> accederLogin();

        }

    }

    private void accederLogin() {

        if(! verificarCampos()) {

            char[] ps = Login.getTxtPassword().getPassword();
            String password = new String(ps);

            if(Login.getTxtUsuario().getText().equals("Equipo 4") && password.equals("pin")) {

                MenuPrincipalVista menuPrincipalVista = new MenuPrincipalVista();

                menuPrincipalVista.setVisible(true);

            } else {

                MensajeVista.mensajeError("Username o password incorrecto", "Error");

            }

        } else {

            MensajeVista.mensajeError("Ingrese su username y password", "Error");

        }

    }

    private boolean verificarCampos() {

        boolean activado = false;

        if(Login.getTxtUsuario().getText().isEmpty() && Login.getTxtPassword().getPassword().length <= 0) {

            activado = true;

        }

        return activado;

    }

}