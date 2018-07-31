package ado.edu.itla.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import ado.edu.itla.taskapp.MainActivity;
import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itla.taskapp.repositorio.db.UsuarioRepositorioDbImp;

public class LogInActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LogInActivity";
    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioRepositorio = new UsuarioRepositorioDbImp(this);

        Button btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });




        Button btnIniciar = findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LogInActivity.this, TareaAsignarActivity.class);
//                startActivity(intent);

                final EditText txtEmailUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
                Usuario xd =(Usuario) usuarioRepositorio.buscar(txtEmailUsuario.getText().toString());
                if (xd != null){
                    Log.i(LOG_TAG, xd.getId().toString() + " - " + xd.getEmail());
                }

            }
        });
    }
    
}
