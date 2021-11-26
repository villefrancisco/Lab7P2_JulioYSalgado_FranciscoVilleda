package lab7p2_franciscovilleda_julioysalgado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorAccesorios {
    
    private ArrayList<Accesorios> listaAccesorio
            = new ArrayList();
    private File archivo = null;
    
    public AdministradorAccesorios(String path) {
        archivo = new File(path);
    }

    public ArrayList<Accesorios> getListaAccesorio() {
        return listaAccesorio;
    }

    public void setListaAccesorio(ArrayList<Accesorios> listaAccesorio) {
        this.listaAccesorio = listaAccesorio;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    public void escribirArchivoAcc() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Accesorios temp : listaAccesorio) {
                bw.write(temp.getID()+ ",");
                bw.write(temp.getNombre()+ ",");
                bw.write(temp.getPrecio()+ ",");
                bw.write(temp.getCantidad()+ ",");
                bw.write("#");
            }
            bw.flush();
            
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    public void cargarArchivoAcc() {
        Scanner sc = null;
        listaAccesorio = new ArrayList();
        if (archivo.exists()) {
            try {
                
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    listaAccesorio.add(new Accesorios(
                            sc.nextInt(),
                            sc.nextInt(),
                            sc.next(),
                            sc.nextDouble())
                    );
                }
                
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
}
