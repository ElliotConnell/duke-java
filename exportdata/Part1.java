
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
        
        //String result = countryInfo(parser, "Nauru");
        //parser = fr.getCSVParser();
        //System.out.println(result);
        
        //listExportersTwoProducts(parser, "fish", "nuts");
        //parser = fr.getCSVParser();
        
        //String result = numberOfExporters(parser, "sugar");
        //parser = fr.getCSVParser();
        //System.out.println("exporters = " + result);
        
        
        bigExporters(parser, "$999,999,999,999");
        parser = fr.getCSVParser();
                
    }
    
    
    public String countryInfo(CSVParser parser, String country){
        // set the string info
        String info = "";
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
                info = country + ": " + exports + ": " + value;
                //increase the count variable
                count += 1;                
            }
            
        }
        //if  count variable is 0 print "NOT FOUND"
        if (count == 0) {
            info = "NOT FOUND";
        }
        
        return info;
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
    
    public String numberOfExporters(CSVParser parser, String exportitem){
        // set the variable count
        int count = 0;
        // for each row of csv file
        for (CSVRecord record : parser) {
            // look in the exports column
            String exports = record.get("Exports");
            //check if string contains exportitem
            if (exports.contains(exportitem)){
                count += 1;
            }
        }
        //convert count to string
        String countStr = String.valueOf(count);
        return countStr;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        //for each row of csv file
        for (CSVRecord  record : parser) {
            //set amount length
            int amLength = amount.length();
            // set values length
            String values = record.get("Value (dollars)");
            int vaLength = values.length();
            // if values length is greater than amount length
            if (amLength < vaLength){
                //print country
                String country = record.get("Country");
                System.out.println(country + " " + values);
            }
        }
    }

}
