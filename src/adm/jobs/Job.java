/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.jobs;

import adm.pictures.Pictures;
import java.io.File;
import org.jdom2.Element;

/**
 *
 * @author usuario
 */
public class Job implements Constants, IConfig, IDirStructure {

    private String name;
    private Element config;
    private File path;

    private Pictures budgetPics;
    private Pictures processPics;

    public Job(String name) {
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
        File subPath = null;
        subPath = new File(path, PATH_BUDGET_PICTURES);
        if (subPath.exists()) {
            budgetPics = new Pictures(NAME_BUDGET_PICTURES, subPath);
        }
        subPath = new File(path, PATH_PROCESS_PICTURES);
        if (subPath.exists()) {
            processPics = new Pictures(NAME_PROCESS_PICTURES, subPath);
        }
        return true;
    }

    @Override
    public boolean writeStructure() {
        path.mkdir();
        if (budgetPics != null) {
            budgetPics.writeStructure();
        }
        if (processPics != null) {
            processPics.writeStructure();
        }
        return true;
    }

    @Override
    public File getPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the budgetPics
     */
    public Pictures getBudgetPics() {
        return budgetPics;
    }

    /**
     * @return the processPics
     */
    public Pictures getProcessPics() {
        return processPics;
    }

}
