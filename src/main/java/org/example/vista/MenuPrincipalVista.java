package org.example.vista;

import org.example.control.MenuPrincipalControl;

import javax.swing.*;

public class MenuPrincipalVista extends JFrame {

    private static JDesktopPane escritorio = new JDesktopPane();

    public MenuPrincipalVista() {

        super("Menu Principal");

        add(escritorio);

        setJMenuBar(getBarraMenu());

        setSize(600, 470);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private JMenuBar getBarraMenu() {

        var barraMenu = new JMenuBar();

        var mSistema = new JMenu("Sistema");
        var mPacientes = new JMenu("Pacientes");

        var isSalir = new JMenuItem("Salir");
        var ipAltaBajaMod = new JMenuItem("Agregar/Baja/Mod Pacientes");
        var ipMostra = new JMenuItem("Mostrar Pacientes");

        isSalir.addActionListener(new MenuPrincipalControl());

        mSistema.add(isSalir);

        ipAltaBajaMod.addActionListener(new MenuPrincipalControl());

        ipMostra.addActionListener(new MenuPrincipalControl());

        mPacientes.add(ipAltaBajaMod);
        mPacientes.add(ipMostra);

        barraMenu.add(mSistema);
        barraMenu.add(mPacientes);

        return barraMenu;

    }

    public static JDesktopPane getEscritorio() {

        return escritorio;

    }

}