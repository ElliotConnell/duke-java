
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class Part1 {
    
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        //set currColdest to null
        CSVRecord lowestSoFar = null;
        //for each row of the csv file
        for (CSVRecord currentRow : parser) {
            
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                // check if currentRow temp > largestSoFar
                if ((currentTemp < lowestTemp) && (currentTemp != -9999)){
                    //if so update largestSoFar to currentRow
                    lowestSoFar = currentRow;
                }
                //add check for invalid readings
                if (lowestTemp == -9999) {
                    lowestSoFar = currentRow;
                }
            }
           
            
        }
        return lowestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("data/2014/weather-2014-05-01.csv");
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("TimeEDT"));
        
    }
    
    public String fileWithColdestTemperature() {
        CSVRecord lowestSoFar = null;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get lowest in file
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
                temp = f;
            }
            
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                // check if currentRow temp > largestSoFar
                if ((currentTemp < lowestTemp) && (currentTemp != -9999)){
                    //if so update largestSoFar to currentRow
                    lowestSoFar = currentRow;
                    temp = f;
                }
                //add check for invalid readings
                if (lowestTemp == -9999) {
                    lowestSoFar = currentRow;
                    temp = f;
                }
            }
            
        }
        return temp.getName();
    }
    
        
    public void testFileWithColdestTemperature(){
        String name = fileWithColdestTemperature();
        FileResource fr = new FileResource("data/2013/" + name);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = coldestHourInFile(parser);

        System.out.println("coldest day was in file " + name);
        System.out.println("coldest temperature on that day was " + lowest.get("TemperatureF"));
        System.out.println("all the temperatures on the coldest day");
        parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        //set lowest to null to null
        CSVRecord lowestSoFar = null;
        //for each row of the csv file
        for (CSVRecord currentRow : parser) {
            String humidity = currentRow.get("Humidity");
            
            
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            
            if (!humidity.equals("N/A")) {
                double currentHumidity = Double.parseDouble(humidity);
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                // check if currentRow temp > largestSoFar
                if (currentHumidity < lowestHumidity){
                    //if so update largestSoFar to currentRow
                    lowestSoFar = currentRow;;
                }
            }
            
            
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource("data/2014/weather-2014-07-22.csv");
        CSVRecord lowest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("lowest humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestSoFar = null;
        File temp = null;
        
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get lowest in file
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            String humidity = currentRow.get("Humidity");
            
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            
            if (humidity == "N/A"){
                lowestSoFar = lowestSoFar;
            }
                        
            
            if (!humidity.equals("N/A")) {
                
                double currentHumidity = Double.parseDouble(humidity);
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                // check if currentRow temp > largestSoFar
                
                
                
            
                if (currentHumidity < lowestHumidity){
                    //if so update largestSoFar to currentRow
                    lowestSoFar = currentRow;
                        
                    
                }
                
            }
            
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInManyFiles() {
        
        CSVRecord lowest = lowestHumidityInManyFiles();

        System.out.println("lowest humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemp = 0;
        double count = 0;
        
        for (CSVRecord currentRow : parser) {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            totalTemp = totalTemp += currentTemp;
            count = count += 1;
            
        }
        return totalTemp/count;
    }
    
    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource("data/2013/weather-2013-08-10.csv");
        double aveTemp = averageTemperatureInFile(fr.getCSVParser());
        
        System.out.println("average temperature in file is " + aveTemp);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemp = 0;
        double count = 0;
        
        for (CSVRecord currentRow : parser) {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            if (currentHumidity >= value){
                totalTemp = totalTemp += currentTemp;
                count = count += 1;
            }
            
        }
        return totalTemp/count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource("data/2013/weather-2013-09-02.csv");
        double aveTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        
        if (aveTemp == 0) {
            System.out.println("no temperatures with that humidity");
        }
        else {
            System.out.println("average temperature when high humidity is " + aveTemp);
        }
    }

}
