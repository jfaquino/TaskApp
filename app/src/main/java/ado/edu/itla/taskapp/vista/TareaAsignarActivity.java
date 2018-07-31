package ado.edu.itla.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.entidad.UsuarioLogeado;
import ado.edu.itla.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itla.taskapp.repositorio.TareaRepositorio;
import ado.edu.itla.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itla.taskapp.repositorio.db.CategoriaRepositorioDbImp;
import ado.edu.itla.taskapp.repositorio.db.UsuarioRepositorioDbImp;

public class TareaAsignarActivity extends AppCompatActivity {

    private CategoriaRepositorio categoriaRepositorio;
    private UsuarioRepositorio usuarioRepositorio;
    private static final String LOG_TAG = "TareaAsignarActivity";


    Spinner spnCategorias, spnUsuarioTecnico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_asignar);

        categoriaRepositorio = new CategoriaRepositorioDbImp(this);
        usuarioRepositorio = new UsuarioRepositorioDbImp(this);

        //Obtiene y muestra la Lista de Categorias
        List<Categoria> categorias = categoriaRepositorio.buscar(null);
        spnCategorias = findViewById(R.id.spnCategoria);
        ArrayAdapter<Categoria> adaptadorCategoria = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categorias);
        adaptadorCategoria.insert(new Categoria().setNombre("Seleccione una categoria"), 0);
        spnCategorias.setAdapter(adaptadorCategoria);

        //Obtiene la Categoria seleccionada
        spnCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){

                    Categoria cat = (Categoria) spnCategorias.getSelectedItem();
                    Log.i(LOG_TAG, cat.getId().toString() + " - " + cat.getNombre());

//                    Categoria categoriaSeleccionada = categorias.get(position-1);
//                    Log.i("Prueba", categoriaSeleccionada.getId().toString() + " - " + categoriaSeleccionada.getNombre());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Obtiene y muestra la Lista de Usuarios Tecnicos
        List<Usuario> usuarios = usuarioRepositorio.buscarTecnicos(null);
        spnUsuarioTecnico = findViewById(R.id.spnUsuarioTecnico);
        ArrayAdapter<Usuario> adaptadorUsuarioTecnico = new ArrayAdapter(this,android.R.layout.simple_spinner_item,usuarios);
        adaptadorUsuarioTecnico.insert(new  Usuario().setNombre("Seleccione un Técnico ").setId(0), 0);
        spnUsuarioTecnico.setAdapter(adaptadorUsuarioTecnico);



        //Obtiene el Usuario seleccionado
        spnUsuarioTecnico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){

                    Usuario us = (Usuario) spnUsuarioTecnico.getSelectedItem();
                    Log.i(LOG_TAG, us.getId().toString() + " - " + us.getNombre() );

//                    Usuario usuarioTecnicoSeleccionado = usuarios.get(position-1);
//                    Log.i("PRUEBA", usuarioTecnicoSeleccionado.getId().toString() + " - " + usuarioTecnicoSeleccionado.getNombre());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }
}
