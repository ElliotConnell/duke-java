/**
 * Write a description of GladLibMap here.
 * Start with your GladLibs program you completed earlier in this lesson. 
 * Make a copy of it and call it GladLibMap.java. Now modify this program 
 * to use one HashMap that maps word types to ArrayList of possible words 
 * to select. Your program should still work for the additional categories 
 * verbs and fruits and should not use duplicate words from a category. 
 * 
 * @author (Elliot Connell) 
 * @version (04/06/21)
 */

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedCategories;
    
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    

    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        usedWords = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
        
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] categories = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb","fruit"};
        
        for (String s: categories){
            ArrayList<String> list = readIt(source + "/" + s + ".txt");
            myMap.put(s, list);
        }
        
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")) {
            return ""+myRandom.nextInt(50) + 5;
        }
        else {
            return randomFrom(myMap.get(label));
        }
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String word = w.substring(first+1,last);
        String sub = getSubstitute(word);
        
        if (!usedWords.contains(sub)){
            usedWords.add(sub);
            
        }
        else {
            return processWord(w);
            //usedCategories.add(w);
        }
        
        if (!usedCategories.contains(word)){
            usedCategories.add(word);
        }
        
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private int totalWordsInMap() {
        int total = 0;
        
        for (String category: myMap.keySet()) {
            total += myMap.get(category).size();
        }
        
        return total;
    }
    
    private int totalWordsConsidered(){
        int total = 0;
        
        for (String s : usedCategories) {
            if (!s.equals("number")){
                total = total + myMap.get(s).size();
            }
        }
        
        return total;
    }
    
    public void makeStory(){
        usedWords.clear();
        System.out.println("\n");
        String story = fromTemplate("datalong/madtemplate.txt");
        printOut(story, 60);
        System.out.println("No of replaced words = " + usedWords.size());
        int total = totalWordsInMap();
        System.out.println("no of words in maps = " + total);
        int considered = totalWordsConsidered();
        System.out.println("no of words considered = " + considered);
        System.out.println(usedCategories);
    }
}


	

	





