package org.example.vista;

import org.example.control.LoginControl;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private static JTextField txtUsuario = new JTextField(10);
    private static JPasswordField txtPassword = new JPasswordField(10);

    public Login() {

        super("Login");

        add(crearPanelPrincipal());

        setSize(300, 270);

        setResizable(false);

        setVisible(true);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private JPanel crearPanelEdicion() {

        JPanel pnlEdicion = new JPanel();

        pnlEdicion.setLayout(new GridLayout(2, 2, 3, 3));

        JLabel lblUsuario = new JLabel("Usuario: ");

        pnlEdicion.add(lblUsuario);

        pnlEdicion.add(txtUsuario);

        JLabel lblPassword = new JLabel("Password: ");

        pnlEdicion.add(lblPassword);

        pnlEdicion.add(txtPassword);

        return pnlEdicion;

    }

    private JPanel crearPanelControl() {

        JPanel pnlControl = new JPanel();

        pnlControl.setLayout(new BorderLayout());

        JButton btnIniciarSesion = new JButton("Iniciar Sesion");

        btnIniciarSesion.addActionListener(new LoginControl());

        pnlControl.add(btnIniciarSesion, BorderLayout.CENTER);

        return pnlControl;

    }

    private JPanel crearPanelPrincipal() {

        JPanel pnlPrincipal = new JPanel();

        pnlPrincipal.add(crearPanelEdicion());

        pnlPrincipal.add(crearPanelControl());

        return pnlPrincipal;

    }

    public static JTextField getTxtUsuario() {

        return txtUsuario;

    }

    public static JPasswordField getTxtPassword() {

        return txtPassword;

    }

}