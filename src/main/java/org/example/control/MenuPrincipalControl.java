package org.example.control;

import org.example.vista.MenuPrincipalVista;
import org.example.vista.VentanaDatosPaciente;
import org.example.vista.VentanaPrincipalVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalControl implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String menu = e.getActionCommand();

        switch (menu) {

            case "Agregar/Baja/Mod Pacientes" -> MenuPrincipalVista.getEscritorio().add(new VentanaPrincipalVista());
            case "Mostrar Pacientes" -> MenuPrincipalVista.getEscritorio().add(new VentanaDatosPaciente());
            case "Salir" -> System.exit(0);

        }

    }

}
