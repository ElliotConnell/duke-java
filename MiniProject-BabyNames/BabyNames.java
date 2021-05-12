
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class BabyNames {
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("testing/yob2014short.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        // set fileresource with file from year givin
        FileResource fr = new FileResource("testing/yob" + year + "short.csv");
        // set rank counter
        int rank = 0;
        boolean found = false;
        
        // loop through lines of csv
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String recName = rec.get(0);
            String recGen = rec.get(1);
            
            if (recGen.equals(gender)) {
                rank += 1;
                if (recName.equals(name)) {
                    found = true;
                    break;
                }
            }
        }
        if (found == false) {
            return -1;
        }
            
                
        
        return rank;
    }
    
    public void testGetRank() {
        
        int result = getRank(2014, "Sophia", "F");
        System.out.println("names rank = " + result);
        
        result = getRank(2014, "Noah", "M");
        System.out.println("names rank = " + result);
        
        result = getRank(2014, "Noah", "F");
        System.out.println("names rank = " + result);
    }
    
    public String getName(int year, int rank, String gender) {
        //set file resource with file from name given
        FileResource fr = new FileResource("testing/yob" + year + "short.csv");
        // set rank counter
        int rankCount = 0;
        String name = "";
        boolean found = false;
        
        // loop through lines of csv
        for (CSVRecord rec : fr.getCSVParser(false)) {
            
            //String recName = rec.get(0);
            String recGen = rec.get(1);
            
            if (recGen.equals(gender)) {
                rankCount += 1;
                if (rankCount == rank) {
                    name = rec.get(0);
                    found = true;
                }
            }
        }
        if (found == false) {
            name = "no name";
        }
        
        return name;
    }
    
    public void testGetName() {
        
        String result = getName(2014, 1, "F");
        System.out.println("name at nominated rank = " + result);
        
        result = getName(2014, 3, "M");
        System.out.println("name at nominated rank = " + result);
        
        result = getName(2014, 6, "F");
        System.out.println("name at nominated rank = " + result);
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
         String newName = "";
         int rank = getRank(year, name, gender);
         
         if (rank != -1) {
             newName = getName(newYear, rank, gender);
         }
         
         else {
             newName = "no one";
         }
            
         System.out.println(name + " born in year " + year + " would be " + newName + " if they were born in " + newYear);
        
    }
    
    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestYear = 0;
        int highestRank = 0;
        
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            String yearString = fileName.substring(3, 7);
            int year = Integer.parseInt(yearString);
            
            int rank = getRank(year, name, gender);
            
            if (highestRank == 0) {
                highestRank = rank;
                highestYear = year;
            }
            
            if (rank < highestRank) {
                highestRank = rank;
                highestYear = year;
            }
            
        }
        
        if (highestYear == 0) {
            return -1;
        }
        
        return highestYear;
    }
    
    public void testYearOfHighestRank() {
        int result = yearOfHighestRank("Mason", "M");
        System.out.println("year of highest rank = " + result);
    }

}
