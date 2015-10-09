/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.pictures;

import adm.jobs.IConfig;
import adm.jobs.IDirStructure;
import adm.jobs.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.jdom2.Element;

/**
 *
 * @author usuario
 */
public class Pictures implements Constants, IConfig, IDirStructure {

    private String name;
    private Element config;
    private File path;
    ArrayList<Picture> pictures = new ArrayList<>();

    public Pictures(String name, File path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public Element getConfig() {
        return config;
    }

    @Override
    public File getPath() {
        return path;
    }

    @Override
    public boolean readStructure() {

        class ImageFilter implements FilenameFilter {

            String[] suffixes;

            public ImageFilter() {
                suffixes = ImageIO.getReaderFileSuffixes();
            }

            @Override
            public boolean accept(File dir, String name) {
                for (String s : suffixes) {
                    if (name.endsWith(s)) {
                        return true;
                    }
                }
                return false;
            }
        }

        config.removeChildren(TAG_PICTURE);

        File[] files = path.listFiles(new ImageFilter());
        for (File f : files) {
            Element tagFoto = new Element(TAG_PICTURE);
            Element tagFotoArchivo = new Element(TAG_FILE);
            tagFotoArchivo.setAttribute(ATTRIBUTE_VALUE, f.getName());
            tagFoto.addContent(tagFotoArchivo);
            config.addContent(tagFoto);
        }
        return true;
    }

    @Override
    public boolean writeStructure() {
        return path.mkdir();
    }

}
