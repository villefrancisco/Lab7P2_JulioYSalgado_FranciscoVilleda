package lab7p2_franciscovilleda_julioysalgado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorUsuarios {
    
    private ArrayList<Usuario> listaUsuario
            = new ArrayList();
    private File archivo = null;

    public AdministradorUsuarios(String path) {
        archivo = new File(path);
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
    
    public void escribirArchivoUser() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        AdministradorAccesorios aa 
                = new AdministradorAccesorios("./AccesoriosDisponibles");
        aa.cargarArchivoAcc();
        try {
            
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Usuario temp : listaUsuario) {
                if(temp instanceof Comprador){
                    bw.write(temp.getNombre() + ";");
                    bw.write(temp.getUsuario() + ";");
                    bw.write(temp.getContraseña() + ";");
                    bw.write(temp.getEdad() + ";");
                    for (Accesorios SIU : ((Comprador)listaUsuario.get(listaUsuario.indexOf(temp))).getListaAccesorios()) {
                        bw.write(SIU.getID());
                        bw.write(SIU.getCantidad());
                        bw.write(SIU.getNombre());
                        bw.write((int) SIU.getPrecio());
                    }
                }
                if(temp instanceof Admin){
                    bw.write(temp.getNombre() + ";");
                    bw.write(temp.getUsuario() + ";");
                    bw.write(temp.getContraseña() + ";");
                    bw.write(temp.getEdad() + ";");
                }
            }
            bw.flush();
            
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivoUser() {
        Scanner sc = null;
        listaUsuario = new ArrayList();
        if (archivo.exists()) {
            try {
                
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {                    
                    listaUsuario.add(new Usuario(
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
    
}