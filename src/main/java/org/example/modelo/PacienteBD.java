package org.example.modelo;

import org.example.conexion.Conexion;
import org.example.vista.MensajeVista;
import org.example.vista.VentanaPrincipalVista;

import javax.swing.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteBD implements DAOPaciente {

    private Connection getConnection() throws SQLException {

        return Conexion.getConnection();

    }

    @Override
    public List<Paciente> listar() {

        List<Paciente> pacienteList = new ArrayList<>();

        try {

            PreparedStatement lista = getConnection().prepareStatement("SELECT pe.id, pe.nombre, pe.apellido, pe.telefono, pa.edad,\n" +
                    "pa.peso, pa.talla, pa.padecimiento, pa.num_estudio FROM persona pe \n" +
                    "INNER JOIN paciente pa ON pe.id = pa.id;");

            ResultSet resultSet = lista.executeQuery();

            while(resultSet.next()) {

                pacienteList.add(new Paciente(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("telefono"),
                        resultSet.getInt(resultSet.getInt("id")),
                        resultSet.getInt("edad"),
                        resultSet.getFloat("peso"),
                        resultSet.getFloat("talla"),
                        resultSet.getString("padecimiento"),
                        resultSet.getInt("num_estudio")));

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return pacienteList;

    }

    public Object[] cargarDatos() {

        Object[] datos = null;

        if(listar().isEmpty()) {

            return null;

        } else {

            for (int i = 0; i < listar().size(); i++) {

                int id = listar().get(i).getPersonaId();
                String nombre = listar().get(i).getNombre();
                String apellido = listar().get(i).getApellidos();
                String telefono = listar().get(i).getTelefono();
                int edad = listar().get(i).getEdad();
                float peso = listar().get(i).getPeso();
                float talla = listar().get(i).getTalla();
                String padecimiento = listar().get(i).getPadecimiento();
                int num = listar().get(i).getNumEstudios();

                datos = new Object[]{id, nombre, apellido, telefono, edad, peso, talla, padecimiento, num};

            }

        }

        return datos;
    }

    @Override
    public void agregarPaciente(Paciente paciente)  {

            try {

                PreparedStatement agrPersona = getConnection().prepareStatement("INSERT INTO persona(id, nombre, apellido," +
                    "telefono) VALUES(?, ?, ?, ?)");

                agrPersona.setInt(1, paciente.getIdPersona());
                agrPersona.setString(2, paciente.getNombre());
                agrPersona.setString(3, paciente.getApellidos());
                agrPersona.setString(4, paciente.getTelefono());

                int agregado = agrPersona.executeUpdate();

                if(agregado == 1) {

                    MensajeVista.mensajeAviso("Datos personales agregados", "Registro casi realizado");

                } else {

                    MensajeVista.mensajeError("Error al agregar los datos personales", "Error");

                }

                PreparedStatement agrPaciente = getConnection().prepareStatement("INSERT INTO paciente(id, edad, peso, talla, padecimiento, num_estudio) VALUES(?, ?, ?, ?, ?, ?)");

                agrPaciente.setInt(1, paciente.getIdPersona());
                agrPaciente.setInt(2, paciente.getEdad());
                agrPaciente.setFloat(3, paciente.getPeso());
                agrPaciente.setFloat(4, paciente.getTalla());
                agrPaciente.setString(5, paciente.getPadecimiento());
                agrPaciente.setInt(6, paciente.getNumEstudios());

                int agregadoN = agrPaciente.executeUpdate();

                if (agregadoN == 1) {

                    MensajeVista.mensajeAviso("Se ha registrado el paciente", "Registro realizado");

                } else {

                    MensajeVista.mensajeError("Error al agregar al paciente", "Error");

                }

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

    }

    public boolean buscar(int id) {

        boolean encontrad = false;

        try {

            PreparedStatement bscPersona = getConnection().prepareStatement("SELECT * FROM persona WHERE id = ?");

            bscPersona.setInt(1, id);

            ResultSet encontrado = bscPersona.executeQuery();

            if(encontrado.next()) {

                VentanaPrincipalVista.getTxtId().setText(encontrado.getString("id"));
                VentanaPrincipalVista.getTxtNombre().setText(encontrado.getString("nombre"));
                VentanaPrincipalVista.getTxtApellidos().setText(encontrado.getString("apellido"));
                VentanaPrincipalVista.getTxtTelefono().setText(encontrado.getString("telefono"));

                encontrad = true;

            }

            PreparedStatement bscPaciente = getConnection().prepareStatement("SELECT * FROM paciente WHERE id = ?");

            bscPaciente.setInt(1, id);

            ResultSet encontradoPac = bscPaciente.executeQuery();

            if(encontradoPac.next()) {

                VentanaPrincipalVista.getTxtEdad().setText(encontradoPac.getString("edad"));
                VentanaPrincipalVista.getTxtPeso().setText(encontradoPac.getString("peso"));
                VentanaPrincipalVista.getTxtTalla().setText(encontradoPac.getString("talla"));
                VentanaPrincipalVista.getTxtPadecimiento().setText(encontradoPac.getString("padecimiento"));
                VentanaPrincipalVista.getTxtNumEstudios().setText(encontradoPac.getString("num_estudio"));

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return encontrad;

    }

        @Override
    public void eliminar(int id) {

        boolean encontradoPa = false, encontradoPe = false;

        try {

            PreparedStatement elmPaciente = getConnection().prepareStatement("DELETE FROM paciente WHERE id = ?");

            elmPaciente.setInt(1, id);

            int encontradoP = elmPaciente.executeUpdate();

            if(encontradoP == 1) {

                encontradoPa = true;

                PreparedStatement elmPersona = getConnection().prepareStatement("DELETE FROM persona WHERE id = ?");

                elmPersona.setInt(1, id);

                int encontrado = elmPersona.executeUpdate();

                if (encontrado == 1) {

                    encontradoPe = true;

                }

            }

            if(encontradoPa && encontradoPe) {

                MensajeVista.mensajeAviso("El registro se ha eliminado", "Registro eliminado");

            } else {

                MensajeVista.mensajeError("Error al eliminar el registro", "Error");

            }

        } catch (SQLException e) {


        }

    }

    @Override
    public void modificar() {

        boolean encontrad = false, encontradoPe = false;

        try{

            PreparedStatement mdfPaciente = getConnection().prepareStatement("UPDATE paciente SET " +
                    "id = ?, edad = ?, peso = ?, talla = ?, padecimiento = ?, num_estudio = ?");

            mdfPaciente.setInt(1, Integer.parseInt(VentanaPrincipalVista.getTxtId().getText()));
            mdfPaciente.setInt(2, Integer.parseInt(VentanaPrincipalVista.getTxtEdad().getText()));
            mdfPaciente.setFloat(3, Float.parseFloat(VentanaPrincipalVista.getTxtPeso().getText()));
            mdfPaciente.setFloat(4, Float.parseFloat(VentanaPrincipalVista.getTxtTalla().getText()));
            mdfPaciente.setString(5, VentanaPrincipalVista.getTxtPadecimiento().getText());
            mdfPaciente.setInt(6, Integer.parseInt(VentanaPrincipalVista.getTxtNumEstudios().getText()));

            int encontradoP = mdfPaciente.executeUpdate();

            if(encontradoP == 1) {

                encontrad = true;

                PreparedStatement mdfPersona = getConnection().prepareStatement("UPDATE persona SET " +
                        "id = ?, nombre = ?, apellido = ?, telefono = ? WHERE id = ?");

                mdfPersona.setInt(1, Integer.parseInt(VentanaPrincipalVista.getTxtId().getText()));
                mdfPersona.setString(2, VentanaPrincipalVista.getTxtNombre().getText());
                mdfPersona.setString(3, VentanaPrincipalVista.getTxtApellidos().getText());
                mdfPersona.setString(4, VentanaPrincipalVista.getTxtTelefono().getText());

                int encontrado = mdfPersona.executeUpdate();

                if (encontrado == 1) {

                    encontradoPe = true;

                }

            }

            if(encontrad && encontradoPe) {

                MensajeVista.mensajeAviso("Se han modificado los datos del paciente", "Registro modificado");

            } else {

                MensajeVista.mensajeAviso("Error al modificar los datos del paciente", "Error");

            }

        } catch (SQLException e) {


        }

    }

}