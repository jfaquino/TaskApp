package ado.edu.itla.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.entidad.UsuarioLogeado;
import ado.edu.itla.taskapp.repositorio.TareaRepositorio;
import ado.edu.itla.taskapp.repositorio.db.TareaRepositorioDbImp;

public class TareaUsuarioTecnicoActivity extends AppCompatActivity {

    private TareaRepositorio tareaRepositorio;
    private final String LOG_TAG = "TareaUsTecnicoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_usuario_tecnico);

        tareaRepositorio = new TareaRepositorioDbImp(this);
        UsuarioLogeado usuarioLogeado = UsuarioLogeado.getInstance();
        List<Tarea> tareas = tareaRepositorio.buscarAsignada(usuarioLogeado);

        ListView tareaListView = (ListView) findViewById(R.id.tarea_usuario_tecnico_listview);
        tareaListView.setAdapter(new TareaListAdapterUTecnico(this, tareas));

        tareaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Tarea t = (Tarea) parent.getItemAtPosition(position);
                Intent intent = new Intent(TareaUsuarioTecnicoActivity.this, TareaDetalleActivity.class);
                intent.putExtra("tarea", t);
                startActivity(intent);
            }
        });
    }
}
