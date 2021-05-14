
/**
 * Write a description of GrayScaleConvertor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class GrayScaleConvertor {
    
    
    // i started with the image i wanted (inImage)
    public ImageResource makeGray(ImageResource inImage) {
        // i made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // compute inPixel's red + inPixel's blue + inPixel's green
            // divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) /3;
            // set pixel's red to average
            pixel.setRed(average);
            // set pixel's green to average 
            pixel.setBlue(average);
            // set pixel's blue to average
            pixel.setGreen(average);
        }
        // outImage is your answer
        return outImage;    
            
    }
    
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }

}
