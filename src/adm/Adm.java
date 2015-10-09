/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm;

import adm.jobs.Jobs;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author usuario
 */
public class Adm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Adm adm = new Adm();
    }

    public final String PATH = "C:\\Documents and Settings\\usuario\\Escritorio\\trabajos";

    public Jobs trabajos;

    public Adm() {
        trabajos = new Jobs(new File(PATH));
        try {
            trabajos.readConfigDoc();
        } catch (Exception ex) {
            trabajos.generateDescriptorFromDirectory();
            try {
                trabajos.saveConfigFile();
            } catch (IOException ex1) {
                Logger.getLogger(Adm.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}
