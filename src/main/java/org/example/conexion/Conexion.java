package org.example.conexion;

import org.example.modelo.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {


    private static final String URL = "jdbc:mysql://localhost:3306/proyecto_final";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Gonzalo209";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if(connection == null) {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }

        return connection;

    }

    public void cerrarConexion() {

        try {

            connection.close();

        } catch (SQLException e) {


        }

    }

}
