
/**
 * Write a description of class LogAnalyzer here.
 * 
 * The Class LogAnalyzer, which has been started for you.
 * 
 * Duke University Course resource
 * 
 * @author Duke University 
 * @version 16/06/21
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     } 
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String s : fr.lines()){
             LogEntry curr = WebLogParser.parseEntry(s);
             records.add(curr);             
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for(LogEntry le: records) {
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)) {
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs.size();
     }
         
     public void printAllHigherThanNum(int num){
         for(LogEntry le: records) {
             int statusCode = le.getStatusCode();
             if (statusCode > num){
                 System.out.println(le);
             }
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
         ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
         for (LogEntry le: records) {
             Date d = le.getAccessTime();
             String str = d.toString();
             String strSubstring = str.substring(4, 10);
             
             if (strSubstring.equals(someday)){
                 String ipAddr = le.getIpAddress();
                 if  (!uniqueIPsOnDay.contains(ipAddr)){
                     uniqueIPsOnDay.add(ipAddr);
                 }
             }
         }
         System.out.println(uniqueIPsOnDay.size());
         return uniqueIPsOnDay;
     }
     
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for (LogEntry le: records) {
             int statusCode = le.getStatusCode();
             if ((statusCode >= low) && (statusCode <= high)){
                 String ipAddr = le.getIpAddress();
                 if(!uniqueIPs.contains(ipAddr)) {
                     uniqueIPs.add(ipAddr);
                    }
             }
         }
         return uniqueIPs.size();
     }
     
     
}
