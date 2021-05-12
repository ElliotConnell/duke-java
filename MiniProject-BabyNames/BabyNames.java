
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
        int boysCount = 0;
        int girlsCount = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boysCount += 1;
            }
            if (rec.get(1).equals("F")){
                totalGirls += numBorn;
                girlsCount += 1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total number of boys names = " + boysCount);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total number of girls names = " + girlsCount);
        
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("us_babynames_by_year/yob1905.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        // set fileresource with file from year givin
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
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
        
        int result = getRank(1960, "Emily", "F");
        System.out.println("Emily names rank = " + result);
        
        result = getRank(1971, "Frank", "M");
        System.out.println("Frank names rank = " + result);
        
        //result = getRank(2014, "Noah", "F");
        //System.out.println("names rank = " + result);
    }
    
    public String getName(int year, int rank, String gender) {
        //set file resource with file from name given
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
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
        
        String result = getName(1980, 350, "F");
        System.out.println("girls name at nominated rank = " + result);
        
        result = getName(1982, 450, "M");
        System.out.println("boys name at nominated rank = " + result);
        
        //result = getName(2014, 6, "F");
        //System.out.println("name at nominated rank = " + result);
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
        int highestYear = 1850;
        int highestRank = 999999999;
        
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            String yearString = fileName.substring(3, 7);
            int year = Integer.parseInt(yearString);
            
            int rank = getRank(year, name, gender);
            
            if (highestRank == 0) {
                highestRank = rank;
                highestYear = year;
            }
            
            if ((rank < highestRank) && (rank != -1)) {
                highestRank = rank;
                highestYear = year;
            }
            
            if (rank == -1) {
                continue;
            }
            
        }
        
        
        
        return highestYear;
    }
    
    public void testYearOfHighestRank() {
        int result = yearOfHighestRank("Mich", "M");
        System.out.println("year of highest rank = " + result);
    }
    
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int totalRank = 0;
        int count = 0;
        
         for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            String yearString = fileName.substring(3, 7);
            int year = Integer.parseInt(yearString);
            
            int rank = getRank(year, name, gender);
            
            
            if (rank != -1){
                totalRank += rank;
                count += 1;
            }
            
        }
        
        if (totalRank == 0) {
            return -1;
        }
        
        double doubleTotalRank = totalRank;
        double doubleCount = count;
        
        
        return doubleTotalRank/doubleCount;
    }
    
       
    public void testGetAverageRank() {
        double result = getAverageRank("Susan", "F");
        System.out.println("average rank of Susan = " + result);
        
        result = getAverageRank("Robert", "M");
        System.out.println("average rank of Robert = " + result);
    }

    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
        int totalBirths = 0;
        boolean found = false;
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String recName = rec.get(0);
            String recGen = rec.get(1);
            int births = Integer.parseInt(rec.get(2));
            
            if (recName.equals(name) && recGen.equals(gender)){
                found = true;
                break;
            }
            
            if (recGen.equals(gender)) {
                totalBirths += births;
            }    
        }
        
        if (found == false) {
            System.out.println("name not found");
        }
            
        return totalBirths;    
            
            
    }
    
    
    public void testGetTotalBirthsRankedHigher() {
        int result = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println("totals births ranked higher than Emily in 1990 = " + result);
        
        result = getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println("totals births ranked higher than Drew in 1990 = " + result);
    }
}
