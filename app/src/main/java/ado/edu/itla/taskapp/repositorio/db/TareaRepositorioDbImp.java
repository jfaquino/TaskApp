package ado.edu.itla.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import java.util.List;

import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.TareaRepositorio;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TareaRepositorioDbImp implements TareaRepositorio {

    private ConexionDb conexionDb;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_DESCRIPCION = "descripcion";
    private static final String CAMPO_FECHA = "fecha";
    private static final String CAMPO_FECHA_COMPLETADO = "fecha_completado";
    private static final String CAMPO_ESTADO = "estado";
    private static final String CAMPO_USUARIO_CREADOR_ID = "usuario_creador_id";
    private static final String CAMPO_USUARIO_ASIGNADO_ID = "usuario_asignado_id";
    private static final String CAMPO_CATEGORIA_ID = "categoria_id";
    private static final String TABLA_TAREA = "tarea";

    public  TareaRepositorioDbImp(Context context){
        conexionDb = new ConexionDb(context);
    }
    @Override
    public boolean guardar(Tarea tarea) {

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, tarea.getNombre());
        cv.put(CAMPO_DESCRIPCION, tarea.getDescripcion());
        cv.put(CAMPO_FECHA, tarea.getFecha().getTime());
        cv.put(CAMPO_FECHA_COMPLETADO, tarea.getFechaTerminado().getTime());
        cv.put(CAMPO_ESTADO, tarea.getEstado().name());
        cv.put(CAMPO_USUARIO_CREADOR_ID, tarea.getUsuarioCreador().getId());
        cv.put(CAMPO_USUARIO_ASIGNADO_ID, tarea.getUsuarioAsignado().getId());
        cv.put(CAMPO_CATEGORIA_ID, tarea.getCategoria().getId());

        SQLiteDatabase db = conexionDb.getWritableDatabase();

        if(tarea.getId() != null && tarea.getId() > 0){
            int cantidad = db.update(TABLA_TAREA,cv, "id = ?", new String[]{tarea.getId().toString()});
            db.close();
            return cantidad > 0;
        }
        else {
            Long id = db.insert(TABLA_TAREA, null, cv);
            db.close();

            if(id.intValue() > 0){
                tarea.setId(id.intValue());
                return true;
            }
        }

        return false;
    }

    @Override
    public Tarea buscar(int id) {
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
