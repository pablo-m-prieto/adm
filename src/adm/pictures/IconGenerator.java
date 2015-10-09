/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.pictures;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author usuario
 */
public class IconGenerator {

    int maxWidth = 32;
    int maxHeight = 32;
    int type = BufferedImage.TYPE_4BYTE_ABGR;

    public Dimension scale(Dimension actual) {
        float actualRatio = (float) actual.width / (float) actual.height;
        float heightAtMaxWidth = (float) maxWidth / actualRatio;
        float widthAtMaxHeight = (float) maxHeight * actualRatio;
        if (heightAtMaxWidth > maxHeight) {
            return new Dimension((int) widthAtMaxHeight, maxHeight);
        } else {
            return new Dimension(maxWidth, (int) heightAtMaxWidth);
        }
    }

    public BufferedImage generateBI(BufferedImage image) {
        Dimension d = scale(new Dimension(image.getWidth(), image.getWidth()));
        BufferedImage result = new BufferedImage(d.width, d.height, type);
        Graphics2D gd = result.createGraphics();
        gd.drawImage(image, 0, 0, d.width, d.height, null);
        return result;
    }

}
