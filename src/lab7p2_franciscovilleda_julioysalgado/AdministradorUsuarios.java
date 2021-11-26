package lab7p2_franciscovilleda_julioysalgado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorUsuarios {
    static Ventana vv = new Ventana();
    
    private ArrayList<Usuario> listaUsuario
            = new ArrayList();
    private ArrayList<Usuario> listaTemp
            = new ArrayList();
    private File archivo = null;
    private File factura = null;

    public AdministradorUsuarios(String path) {
        archivo = new File(path);
        factura = new File(path);
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public File getFactura() {
        return factura;
    }

    public void setFactura(File factura) {
        this.factura = factura;
    }
    
    public void escribirArchivoUser() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Usuario temp : listaUsuario) {
                if(temp instanceof Comprador){
                    bw.write(((Comprador) temp).getDinero() + ";");
                    bw.write(temp.getEdad() + ";");
                    bw.write(temp.getNombre() + ";");
                    bw.write(temp.getUsuario() + ";");
                    bw.write(temp.getContraseña() + ";");
                    
                    bw.write("(");
                    for (Accesorios SIU : ((Comprador)listaUsuario.get(listaUsuario.indexOf(temp))).getListaAccesorios()) {
                        bw.write(SIU.getID() + ",");
                        bw.write(SIU.getCantidad() + ",");
                        bw.write(SIU.getNombre() + ",");
                        bw.write((int) SIU.getPrecio() + ",");
                    }
                    bw.write(")");
                    bw.write("|");
                }
                if(temp instanceof Admin){
                    bw.write(temp.getNombre() + ";");
                    bw.write(temp.getUsuario() + ";");
                    bw.write(temp.getContraseña() + ";");
                    bw.write(temp.getEdad() + ";");
                    bw.write("|");
                }
            }
            bw.flush();
            
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivoUserComprador() throws IOException {
        Scanner sc = null;
        Scanner sm = null;
        FileReader canalLectura = null;
        BufferedReader RAMLectura = null;
        
        //listaUsuario = new ArrayList();
        if (archivo.exists()) {
            try {
                
                sc = new Scanner(archivo);
                  
                sc.useDelimiter(";");
                while (!sc.hasNext()) {                    
                    listaUsuario.add(new Comprador(
                            sc.nextInt(),
                            sc.nextInt(),
                            sc.next(),
                            sc.next(),
                            sc.next())
                    );
                    if(((Comprador)listaUsuario.get(0)).getListaAccesorios() == null){
                        canalLectura = new FileReader(archivo);
                        RAMLectura = new BufferedReader(canalLectura);

                        String linea;

                        while (!"|".equals(linea = RAMLectura.readLine())) {                
                            String lineaReq = linea.substring(linea.indexOf("(" + 1), linea.indexOf(")"));
                            sm = new Scanner(lineaReq);
                            sm.useDelimiter(",");
                            
                            for (int i = 0; i < lineaReq.length(); i++) {
                                ((Comprador)listaUsuario.get(0)).getListaAccesorios().add(new Accesorios(
                                        sm.nextInt(),
                                        sm.nextInt(),
                                        sm.next(),
                                        sm.nextDouble())
                                );
                            }
                        }
                        RAMLectura.close();
                        canalLectura.close();
                    }
                }
                
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    public void cargarArchivoUserAdmin() {
        Scanner sc = null;
        //listaUsuario = new ArrayList();
        
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listaUsuario.add(new Admin(
                            sc.nextInt(),
                            sc.next(),
                            sc.next(),
                            sc.next())
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    public void escribirArchivoFactura (int contador) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            fw = new FileWriter(factura, false);
            bw = new BufferedWriter(fw);
            
            if(((Comprador)listaUsuario.get(0)).getDinero() >= 0){
                
            }
            
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
}