package ado.edu.itla.taskapp.repositorio;

import java.util.List;

import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.entidad.Usuario;

/**
 * Created by MESCyT on 21/7/2018.
 */

public interface TareaRepositorio {

    boolean guardar(Tarea tarea);
    Categoria buscar(int id);
    List<Tarea> buscarAsignada(Usuario usuario);
    List<Tarea> buscarCreadaPor(Usuario usuario);
}
