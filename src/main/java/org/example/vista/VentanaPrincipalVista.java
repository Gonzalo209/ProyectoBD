package org.example.vista;

import org.example.control.*;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipalVista extends JInternalFrame {

    private static JTextField txtId = new JTextField(10);
    private static JTextField txtBuscarId = new JTextField(10);
    private static JTextField txtNombre = new JTextField(10);
    private static JTextField txtApellidos = new JTextField(10);
    private static JTextField txtTelefono = new JTextField(10);
    private static JTextField txtEdad = new JTextField(10);
    private static JTextField txtPeso = new JTextField(10);
    private static JTextField txtTalla = new JTextField(10);
    private static JTextField txtPadecimiento = new JTextField(10);
    private static JTextField txtNumEstudios = new JTextField(10);
    private static JButton btnAgregar = new JButton("Agregar");
    private static JButton btnEliminar = new JButton("Eliminar");
    private static JButton btnModificar = new JButton("Modificar");
    private static JButton btnBuscar = new JButton("Buscar");

    public VentanaPrincipalVista() {

        super("Alta/Baja/Modificacion de pacientes", false, true, false, true);

        setSize(590 ,410);

        add(crearPanelPrincipal());

        setVisible(true);

    }

    private JPanel crearPanelEdicion() {

        JPanel pnlEdicion = new JPanel();

        JLabel lblId = new JLabel("Id: ");
        JLabel lblNombre = new JLabel("Nombre: ");
        JLabel lblApellidos = new JLabel("Apellidos: ");
        JLabel lblTelefono = new JLabel("Telefono: ");
        JLabel lblEdad = new JLabel("Edad: ");
        JLabel lblPeso = new JLabel("Peso: ");
        JLabel lblTalla = new JLabel("Talla: ");
        JLabel lblPadecimiento = new JLabel("Padecimiento: ");
        JLabel lblNumEstudios = new JLabel("Numero De Estudios: ");

        pnlEdicion.setLayout(new GridLayout(9, 2, 3, 3));

        pnlEdicion.setBorder(BorderFactory.createTitledBorder("REGISTRO DE PACIENTE"));

        txtId.addKeyListener(new ValidacionNumerosControl());

        txtId.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblId);
        pnlEdicion.add(txtId);

        txtNombre.addKeyListener(new ValidacionLetrasControl());

        txtNombre.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblNombre);
        pnlEdicion.add(txtNombre);

        txtApellidos.addKeyListener(new ValidacionLetrasControl());

        txtApellidos.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblApellidos);
        pnlEdicion.add(txtApellidos);

        txtTelefono.addKeyListener(new ValidacionNumerosControl());

        txtTelefono.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblTelefono);
        pnlEdicion.add(txtTelefono);

        txtEdad.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblEdad);
        pnlEdicion.add(txtEdad);

        txtPeso.addKeyListener(new ValidacionBotonAgregarControl());

        txtPeso.addKeyListener(new ValidacionDecimalPesoControl());

        pnlEdicion.add(lblPeso);
        pnlEdicion.add(txtPeso);

        txtTalla.addKeyListener(new ValidacionBotonAgregarControl());

        txtTalla.addKeyListener(new ValidacionDecimalTallaControl());

        pnlEdicion.add(lblTalla);
        pnlEdicion.add(txtTalla);

        txtPadecimiento.addKeyListener(new ValidacionLetrasControl());

        txtPadecimiento.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblPadecimiento);
        pnlEdicion.add(txtPadecimiento);

        txtNumEstudios.addKeyListener(new ValidacionNumerosControl());

        txtNumEstudios.addKeyListener(new ValidacionBotonAgregarControl());

        pnlEdicion.add(lblNumEstudios);
        pnlEdicion.add(txtNumEstudios);

        return pnlEdicion;

    }

    private JPanel crearPanelPrincipal() {

        JPanel pnlPrincipal = new JPanel();

        pnlPrincipal.setLayout(new BorderLayout());

        pnlPrincipal.add(crearPanelBusqueda(), BorderLayout.NORTH);

        pnlPrincipal.add(crearPanelEdicion(), BorderLayout.CENTER);

        pnlPrincipal.add(crearPanelControl(), BorderLayout.SOUTH);

        return pnlPrincipal;

    }

    private JPanel crearPanelBusqueda() {

        JPanel pnlBusqueda = new JPanel();

        pnlBusqueda.setLayout(new BoxLayout(pnlBusqueda, BoxLayout.X_AXIS));

        pnlBusqueda.setBorder(BorderFactory.createTitledBorder("BUSQUEDA DE PACIENTE"));

        JLabel lblBuscar = new JLabel("Buscar ID: ");

        pnlBusqueda.add(lblBuscar);

        pnlBusqueda.add(Box.createHorizontalStrut(20));

        pnlBusqueda.add(txtBuscarId);

        txtBuscarId.addKeyListener(new ValidacionNumerosControl());

        txtBuscarId.addKeyListener(new ValidacionBotonBusquedaControl());

        pnlBusqueda.add(Box.createHorizontalStrut(20));

        btnBuscar.addActionListener(new VentanaPrincipalControl());

        btnBuscar.setEnabled(false);

        pnlBusqueda.add(btnBuscar);

        return pnlBusqueda;

    }

    private JPanel crearPanelControl() {

        JPanel pnlControl = new JPanel();

        pnlControl.setLayout(new BoxLayout(pnlControl, BoxLayout.X_AXIS));

        pnlControl.setBorder(BorderFactory.createTitledBorder("OPCIONES DE CONTROL"));

        btnAgregar.setEnabled(false);

        btnAgregar.addActionListener(new VentanaPrincipalControl());

        btnEliminar.addActionListener(new VentanaPrincipalControl());

        btnModificar.addActionListener(new VentanaPrincipalControl());

        pnlControl.add(Box.createHorizontalStrut(100));

        pnlControl.add(btnAgregar);

        pnlControl.add(Box.createHorizontalStrut(20));

        pnlControl.add(btnEliminar);

        btnEliminar.setEnabled(false);

        btnModificar.setEnabled(false);

        pnlControl.add(Box.createHorizontalStrut(20));

        pnlControl.add(btnModificar);

        return pnlControl;

    }

    public static JTextField getTxtId() {

        return txtId;

    }

    public static JTextField getTxtNombre() {

        return txtNombre;

    }

    public static JTextField getTxtApellidos() {

        return txtApellidos;

    }

    public static JTextField getTxtTelefono() {

        return txtTelefono;

    }

    public static JTextField getTxtEdad() {

        return txtEdad;

    }

    public static JTextField getTxtPeso() {

        return txtPeso;

    }

    public static JTextField getTxtTalla() {

        return txtTalla;

    }

    public static JTextField getTxtPadecimiento() {

        return txtPadecimiento;

    }

    public static JTextField getTxtNumEstudios() {

        return txtNumEstudios;

    }

    public static JTextField getTxtBuscarId() {

        return txtBuscarId;

    }

    public static JButton getBtnAgregar() {

        return btnAgregar;

    }
    public static JButton getBtnEliminar() {

        return btnEliminar;

    }
    public static JButton getBtnModificar() {

        return btnModificar;

    }

    public static JButton getBtnBuscar() {

        return btnBuscar;

    }

}