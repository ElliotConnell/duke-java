
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
             String d = le.getAccessTime().toString().substring(4, 10);
             
             if (d.equals(someday)){
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
     
     public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         
         for (LogEntry le: records){
             String ip = le.getIpAddress();
             if (!counts.containsKey(ip)){
                 counts.put(ip, 1);
             }
             else{
                 counts.put(ip, counts.get(ip) + 1);
             }
             
         }
         return counts;
     }
     
     public int mostNumberOfVisitsByIP(HashMap<String, Integer> map){
         int maxValue = 0;
         for (String ipAddr: map.keySet()){         
            int visits = map.get(ipAddr);
            if(visits > maxValue){
                maxValue = visits;
            }
        }
        return maxValue;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map){
         ArrayList<String> ipAddr = new ArrayList<String>();
         int maxValue = mostNumberOfVisitsByIP(map);
         
         for(String ip: map.keySet()){
             int visits = map.get(ip);
             if ((visits == maxValue) && (!ipAddr.contains(ip))){
                 ipAddr.add(ip);
             }
         }
         
         return ipAddr;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> dayCount = new HashMap<String, ArrayList<String>>();
         
         for (LogEntry le : records) {
             ArrayList <String> ipAddr = new ArrayList<String>();
             String date = le.getAccessTime().toString().substring(4, 10);
             String ip = le.getIpAddress();
             if (!dayCount.containsKey(date)){
                 ipAddr.add(ip);
                 dayCount.put(date, ipAddr);
             }
             else { 
                 ipAddr = dayCount.get(date);
                 ipAddr.add(ip);
                 dayCount.put(date, ipAddr);
             }
         }

         return dayCount;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         String result = "";
         int maxVisits = 0;
         
         for(String key: map.keySet()){
             if (map.get(key).size() > maxVisits) {
                 maxVisits = map.get(key).size();
                 result = key;
             }             
         }         
         
         return result;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay( HashMap<String, ArrayList<String>> map, String day){
         ArrayList <String> visits = map.get(day);
         HashMap<String, Integer> newMap = new HashMap<String, Integer>();
         
         for (String ip: visits){
             if (!newMap.containsKey(ip)){
                 newMap.put(ip, 1);
             }
             else{
                 newMap.put(ip, newMap.get(ip)+1);
             }
         }
         
         
         return iPsMostVisits(newMap);
     }
}
