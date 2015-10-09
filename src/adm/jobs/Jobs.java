/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author usuario
 */
public class Jobs implements Constants, IConfig {

    public final String CONFIG_FILENAME = "config.xml";

    private File directory;
    private Document configDoc;
    private Element config;
    private ArrayList<Job> trabajos = new ArrayList<>();

    public Jobs(File directory) {
        this.directory = directory;
    }

    public void generateDescriptorFromDirectory() {

        File[] dirs = directory.listFiles((File pathname) -> pathname.isDirectory());

        //creo el nuevo documento
        Element tagTrabajos = new Element(TAG_JOBS);
        configDoc = new Document(tagTrabajos);

        for (File dir : dirs) {
            Element tagTrabajo = new Element(TAG_JOB);
            Element tagRuta = new Element(TAG_PATH);
            tagRuta.setAttribute(ATTRIBUTE_VALUE, dir.getPath());
            tagTrabajo.addContent(tagRuta);
            tagTrabajos.addContent(tagTrabajo);
        }
    }

    public File generateConfigFileName() {
        return new File(directory, CONFIG_FILENAME);
    }

    public Document getConfigDoc() {
        return configDoc;
    }

    public Document readConfigDoc() throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        configDoc = (Document) builder.build(generateConfigFileName());
        return configDoc;
    }

    public void saveConfigFile() throws IOException {
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        xmlOutputter.output(configDoc, new FileOutputStream(generateConfigFileName()));
    }

    /**
     * @return the directory
     */
    public File getDirectory() {
        return directory;
    }

    /**
     * @return the trabajos
     */
    public ArrayList<Job> getTrabajos() {
        return trabajos;
    }

    public Job addTrabajo(String name) {
        Job trabajo = null;
        for (Job t : trabajos) {
            if (t.getName().equals(name)) {
                trabajo = t;
                break;
            }
        }
        if (trabajo == null) {
            File subDir = new File(directory, name);
            subDir.mkdir();

        }
        if (trabajos.add(trabajo)) {

        }
    }

    @Override
    public Element getConfig() {
        return config;
    }

}
