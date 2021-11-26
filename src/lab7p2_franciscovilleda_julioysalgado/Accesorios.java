package lab7p2_franciscovilleda_julioysalgado;

public class Accesorios {
    private int ID, cantidad;
    private String nombre;
    private double precio;

    public Accesorios() {
    }
    
    public Accesorios(int ID, int cantidad, String nombre, double precio) {
        this.ID = ID;
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