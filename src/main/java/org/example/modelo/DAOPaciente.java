package org.example.modelo;

import java.sql.SQLException;

public interface DAOPaciente {

    public void agregarPaciente(Paciente paciente);
    public void eliminar(int id);
    public void modificar();
    public boolean buscar(int id);

}
