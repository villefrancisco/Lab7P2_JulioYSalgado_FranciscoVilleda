package lab7p2_franciscovilleda_julioysalgado;

import java.util.ArrayList;

public class Comprador extends Usuario {
    private ArrayList<Accesorios> listaAccesorios
            = new ArrayList();
    private int dinero;

    public Comprador() {
    }
    
    public Comprador(int dinero) {
        this.dinero = dinero;
    }

    public Comprador(String tipo, int dinero, int edad, String nombre, String usuario, String contraseña) {
        super(edad, nombre, usuario, contraseña, tipo);
        this.dinero = dinero;
    }

    public ArrayList<Accesorios> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorios> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getContraseña() {
        return contraseña;
    }

    @Override
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
