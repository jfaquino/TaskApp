package ado.edu.itla.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itla.taskapp.MainActivity;
import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.entidad.UsuarioLogeado;
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

                final EditText txtEmailUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
                final EditText txtContrasenaUsuario = (EditText) findViewById(R.id.txtNombreContrasena);
                final TextView lblErrorLogin = (TextView) findViewById(R.id.lblErrorLogin);

                Usuario us =(Usuario) usuarioRepositorio.buscar(txtEmailUsuario.getText().toString());
                if (us != null){
                    UsuarioLogeado usuarioLogeado = UsuarioLogeado.getInstance(us);
                    Log.i(LOG_TAG, us.getId().toString() + " - " + us.getEmail() + " - " + us.getNombre() + " - " + us.getContrasena());

                    if(us.getContrasena().equals(txtContrasenaUsuario.getText().toString()) && us.getTipoUsuario().equals(Usuario.TipoUsuario.NORMAL)) {
                        Intent intent = new Intent(LogInActivity.this, TareaUsuarioNormalActivity.class);
                        startActivity(intent);
                    }
                    else if (us.getContrasena().equals(txtContrasenaUsuario.getText().toString()) && us.getTipoUsuario().equals(Usuario.TipoUsuario.TECNICO)){
                        Intent intent = new Intent(LogInActivity.this, TareaUsuarioTecnicoActivity.class);
                        startActivity(intent);
                    }

                    else {
                        lblErrorLogin.setText("Usuario y contraseña no coinciden, Favor intentar nuevamente.");
                        Log.i(LOG_TAG, "El if te esta dando problemas papu");
                    }
                }
                else{
                    lblErrorLogin.setText("Usuario y contraseña no coinciden, Favor intentar nuevamente.");
                }



            }
        });
    }
    
}
