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
        try {
            
            fw = new FileWriter(archivo, false);
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
    
    public void cargarArchivoUserComprador() {
        Scanner sc = null;
        Scanner sm = null;
        FileReader canalLectura = null;
        BufferedReader RAMLectura = null;
        
        listaUsuario = new ArrayList();
        if (archivo.exists()) {
            try {
                
                sc = new Scanner(archivo);
                  
                sc.useDelimiter(";");
                while (!sc.equals("|")) {                    
                    listaUsuario.add(new Comprador(
                            sc.nextInt(),
                            sc.nextInt(),
                            sc.next(),
                            sc.next(),
                            sc.next())
                    );
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
                
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    public void cargarArchivoUserAdmin() {
        Scanner sc = null;
        listaUsuario = new ArrayList();
        
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
        }//FIN IF
    }
    
}