package org.example.vista;

import org.example.modelo.PacienteBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class VentanaDatosPaciente extends JInternalFrame {

    public VentanaDatosPaciente() {

        super("Datos de los pacientes", false, true, false, true);

        setSize(590 ,410);

        add(crearPanelPrincipal());

        setVisible(true);

    }

    private JPanel crearPanelPrincipal() {

        JPanel pnlPrincipal = new JPanel();

        DefaultTableModel modelo = new DefaultTableModel();

        PacienteBD pacienteBD = new PacienteBD();

        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Numero");
        modelo.addColumn("Edad");
        modelo.addColumn("Peso");
        modelo.addColumn("Talla");
        modelo.addColumn("Padecimiento");
        modelo.addColumn("Numero Estudios");

        JTable tabla = new JTable(modelo);

        pnlPrincipal.add(tabla);

        if(pacienteBD.cargarDatos() == null) {

            MensajeVista.mensajeError("No hay pacientes agregados", "Error");

        } else {

            modelo.addRow(pacienteBD.cargarDatos());

        }

        JScrollPane scrollPane = new JScrollPane(tabla);

        pnlPrincipal.add(scrollPane);

        return pnlPrincipal;

    }

}
