/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.trabajos;

import java.io.File;

/**
 *
 * @author usuario
 */
public interface IDirStructure {

    /**
     * Devuelve la ruta donde se desarrola el elemento
     *
     * @return
     */
    File getPath();

    /**
     * Lee la estructura actual de directorios
     *
     * @return
     */
    boolean readStructure();

    /**
     * Modifica la estructura de los directorios
     *
     * @return
     */
    boolean writeStructure();

}
