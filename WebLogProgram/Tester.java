
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
        la.readFile("short-test_log");
        la.printAllHigherThanNum(200);
    }
    
    public void testUniqueIPVistsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        System.out.println(la.uniqueIPVisitsOnDay("Sep 14"));
        System.out.println(la.uniqueIPVisitsOnDay("Sep 30"));
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPsInRange = la.countUniqueIPsInRange(200, 299);
        System.out.println("there are " + uniqueIPsInRange + " IPs in range"); 
        
        uniqueIPsInRange = la.countUniqueIPsInRange(300, 399);
        System.out.println("there are " + uniqueIPsInRange + " IPs in range");

    }
}
