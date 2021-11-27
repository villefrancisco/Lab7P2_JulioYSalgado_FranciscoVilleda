package lab7p2_franciscovilleda_julioysalgado;

import java.util.Random;

public class Accesorios {
    Random rng = new Random();
    
    private int ID, cantidad;
    private String nombre;
    private double precio;

    public Accesorios() {
    }
    
    public Accesorios(int ID, int cantidad, String nombre, double precio) {
        int num = rng.nextInt(999999) + 100000;
        setID(num);
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return ID + "";
    }
    
    
}