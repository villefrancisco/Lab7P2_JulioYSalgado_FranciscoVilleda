package lab7p2_franciscovilleda_julioysalgado;

public class Usuario {
    protected int edad;
    protected String nombre, usuario, contraseña, tipo;

    public Usuario() {
    }
    
    public Usuario(int edad, String nombre, String usuario, String contraseña, String tipo) {
        this.edad = edad;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
