package org.example.modelo;

import java.util.List;

public interface DAOPaciente {

    public List<Paciente> listar();
    public void agregarPaciente(Paciente paciente);
    public void eliminar(int id);
    public void modificar();
    public boolean buscar(int id);

}
