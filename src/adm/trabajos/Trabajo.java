/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.trabajos;

import java.io.File;
import org.jdom2.Element;

/**
 *
 * @author usuario
 */
public class Trabajo implements XmlConstants, IConfig, IDirStructure {

    private String name;
    private Element config;
    private File path;

    public Trabajo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Element getConfig() {
        return config;
    }

    @Override
    public boolean readStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeStructure() {

    }

    @Override
    public File getPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
