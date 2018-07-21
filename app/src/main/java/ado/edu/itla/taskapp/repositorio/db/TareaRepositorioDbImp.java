package ado.edu.itla.taskapp.repositorio.db;

import java.util.List;

import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.TareaRepositorio;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TareaRepositorioDbImp implements TareaRepositorio {
    @Override
    public boolean guardar(Tarea tarea) {
        return false;
    }

    @Override
    public Categoria buscar(int id) {
        return null;
    }

    @Override
    public List<Tarea> buscarAsignada(Usuario usuario) {
        return null;
    }

    @Override
    public List<Tarea> buscarCreadaPor(Usuario usuario) {
        return null;
    }
}
