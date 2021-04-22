import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for (Point p : s.getPoints()){
            count = count + 1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        double sides = getNumPoints(s);
               
        return perimeter/sides;
    }

    public double getLargestSide(Shape s) {
        double sideLength = 0.0;
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // compare current distance to previous distance
            if (currDist > sideLength){
                // Update distance if currDist is longer
                sideLength = currDist;
            }
            
        }
        return sideLength;
    }

    public double getLargestX(Shape s) {
        double larX = -9999;
        
        for (Point currPt : s.getPoints()) {
            double x = currPt.getX();
            
            if (x > larX) {
                larX = x;
            }
        }
        // Put code here
        return larX;
    }

  

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double larPer = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            Shape s = new Shape(fr);
            double p = getPerimeter(s);
                        
            if (p > larPer) {
                larPer = p;            
            }
            
        }
        return larPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        
        double larPer = 0;
        String temp = null;    // replace this code
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            Shape s = new Shape(fr);
            double p = getPerimeter(s);
                        
            if (p > larPer) {
                larPer = p;
                temp = f.getName();            
            }
            
        }
        
        return temp;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double sides = getNumPoints(s);
        System.out.println("number of points = " + sides);
        double avg = getAverageLength(s);
        System.out.println("average side length = " + avg);
        double longest = getLargestSide(s);
        System.out.println("longest side = " + longest);
        double larX = getLargestX(s);
        System.out.println("largest x value = " + larX);
        
    }
    
    public void testPerimeterMultipleFiles() {
        double larPer = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter in selected files = " + larPer);
        
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("file name of file = " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
        getNumPoints(triangle);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
