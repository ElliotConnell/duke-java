
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    public void tester (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //countryInfo(parser, "Nauru");
        //parser = fr.getCSVParser();
        
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        
        //numberOfExporters();
        //parser = fr.getCSVParser();
        
        //bigExporters();
        //parser = fr.getCSVParser();
                
    }
    
    
    public void countryInfo(CSVParser parser, String country){
        //count variable as check
        int count = 0;
        // for each row of in the csv file
        for (CSVRecord record : parser) {
            //look at the country column
            String countries = record.get("Country");
            //Check if contains "country"
            if (countries.contains(country)){
                //set the variables
                country = record.get("Country");
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                //print the variables
                System.out.println(country + ": " + exports + ": " + value);
                //increase the count variable
                count += 1;                
            }
            
        }
        //if  count variable is 0 print "NOT FOUND"
        if (count == 0) {
            System.out.println("NOT FOUND");
        }
        
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
        // for each row in the csv file
        for (CSVRecord record : parser) {
            //look at the export column
            String exports = record.get("Exports");
            //check if string contains exportitem1 and exportitem2
            if (exports.contains(exportitem1) && exports.contains(exportitem2)) {
                // set country variable
                String country = record.get("Country");
                //print country
                System.out.println(country);
            }
        }
    }

}
