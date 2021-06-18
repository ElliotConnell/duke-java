
/**
 * Write a description of class Tester here.
 * 
 * The Tester class from the lesson, which has been started for you.
 * 
 * Duke University Course resource
 * 
 * @author Duke University 
 * @version 16/06/21
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("there are " + uniqueIPs + " IPs");       
    }
    
    public void testPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVistsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println(la.uniqueIPVisitsOnDay("Mar 17"));
        //System.out.println(la.uniqueIPVisitsOnDay("Sep 30"));
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        int uniqueIPsInRange = la.countUniqueIPsInRange(300, 399);
        System.out.println("there are " + uniqueIPsInRange + " IPs in range"); 
        
        //uniqueIPsInRange = la.countUniqueIPsInRange(300, 399);
        //System.out.println("there are " + uniqueIPsInRange + " IPs in range");

    }
    
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
    public void testMostNumberOfVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        int result = la.mostNumberOfVisitsByIP(counts);
        System.out.println("most visits by a single ip = " + result);
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        ArrayList<String> result = la.iPsMostVisits(counts);
        System.out.println(result);
    }
    
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> result = la.iPsForDays();
        System.out.println(result);
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> myMap = la.iPsForDays();
        String result = la.dayWithMostIPVisits(myMap);
        System.out.println("day with most ip visits = " + result); 
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> myMap = la.iPsForDays();
        ArrayList<String> result = la.iPsWithMostVisitsOnDay(myMap, "Sep 30");
        System.out.println(result); 
    }
}
