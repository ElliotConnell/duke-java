
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
        
        countryInfo(parser, "Nauru");
        parser = fr.getCSVParser();
        
        //listExportersTwoProducts();
        //parser = fr.getCSVParser();
        
        //numberOfExporters();
        //parser = fr.getCSVParser();
        
        //bigExporters();
        //parser = fr.getCSVParser();
                
    }
    
    
    public void countryInfo(CSVParser parser, String country){
        
        int count = 0;
        // for each row of in the csv file
        for (CSVRecord record : parser) {
            //look at the country column
            String countries = record.get("Country");
            //int count = 0;
            //Check if contains "country"
            if (countries.contains(country)){
                country = record.get("Country");
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country + ": " + exports + ": " + value);
                count += 1;                
            }
            
        }
        
        if (count == 0) {
            System.out.println("NOT FOUND");
        }
        
    }
    
    

}
