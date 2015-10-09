/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.pictures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author usuario
 */
public class Picture {

    BufferedImage image;
    BufferedImage icon;
    File file;

    public Picture(File archivo) {
        this.file = archivo;
    }

    public void loadImagen(IconGenerator generator) {
        try {
            image = ImageIO.read(file);
            icon = generator.generateBI(image);
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
