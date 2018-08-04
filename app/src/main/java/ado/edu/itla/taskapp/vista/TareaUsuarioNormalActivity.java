package ado.edu.itla.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.entidad.UsuarioLogeado;
import ado.edu.itla.taskapp.repositorio.TareaRepositorio;
import ado.edu.itla.taskapp.repositorio.db.TareaRepositorioDbImp;

public class TareaUsuarioNormalActivity extends AppCompatActivity {

    private TareaRepositorio tareaRepositorio;
    private final String LOG_TAG = "TareaUsNormalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_usuario_normal);

        tareaRepositorio = new TareaRepositorioDbImp(this);
        UsuarioLogeado usuarioLogeado = UsuarioLogeado.getInstance();
        List<Tarea> tareas = tareaRepositorio.buscarCreadaPor(usuarioLogeado);

        ListView tareaListView = (ListView) findViewById(R.id.tarea_usuario_normal_listview);
        tareaListView.setAdapter(new TareaListAdapterUNormal(this, tareas));

        tareaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Tarea t = (Tarea) parent.getItemAtPosition(position);
                Intent intent = new Intent(TareaUsuarioNormalActivity.this, TareaDetalleActivity.class);
                intent.putExtra("tarea", t);
                startActivity(intent);

            }
        });

        Button btnCrearNuevaTarea = (Button) findViewById(R.id.btnCrearNuevaTarea);
        btnCrearNuevaTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TareaUsuarioNormalActivity.this, TareaAsignarActivity.class);
                startActivity(intent);
            }
        });

//        Log.i(LOG_TAG, tareas.get(1).toString());


    }
}
