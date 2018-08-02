package ado.edu.itla.taskapp.entidad;

public class UsuarioLogeado extends Usuario{
    private static final UsuarioLogeado ourInstance = new UsuarioLogeado();

    private UsuarioLogeado() {

    }

    public static UsuarioLogeado getInstance(Usuario usuario) {
        ourInstance.setNombre(usuario.getNombre());
        ourInstance.setEmail(usuario.getEmail());
        ourInstance.setId(usuario.getId());
        ourInstance.setTipoUsuario(usuario.getTipoUsuario());
        ourInstance.setContrasena(usuario.getContrasena());

        return ourInstance;
    }
    public static UsuarioLogeado getInstance() {
        return ourInstance;
    }
}
