
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class BatchInversions {
    
    // i start with the image i wanted (inImage)
    public ImageResource makeInversions(ImageResource inImage) {
        // i made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // for each pixel in outImage
        for (Pixel pixel : outImage.pixels()) {
            // look at corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // compute inPixel's red + inPixel's blue + inPixel's green
            // calculate inverted RGB values
            int invRed = 255 - inPixel.getRed();
            int invBlue = 255 - inPixel.getBlue();
            int invGreen = 255 - inPixel.getGreen();
            // set pixel's red to inverted value
            pixel.setRed(invRed);
            // set pixel's blue to invert value
            pixel.setBlue(invBlue);
            // set pixel's green to invert value
            pixel.setGreen(invGreen);
        }
        // return the outImage
        return outImage;
        
    }

}
