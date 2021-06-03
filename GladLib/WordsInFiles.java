
/**
 * Write a description of WordsInFiles here.
 * 
 * Write a program to determine which words occur in the greatest number of files, and for each word, 
 * which files they occur in. 
 * 
 * @author (Elliot Connell) 
 * @version (1/6/21)
 */
import edu.duke.*;
import java.util.*;
import java.io.*; 

public class WordsInFiles {
    
    private HashMap<String, ArrayList<String>> fileMap;
    
    public WordsInFiles(){
        fileMap = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        
        
        
        for (String sKey: fr.words()){
            
            ArrayList<String> alFileName = new ArrayList<String>();
           
            
            if (fileMap.containsKey(sKey)) {
                alFileName = fileMap.get(sKey);
                if (!alFileName.contains(f.getName())) {
                    alFileName.add(f.getName());
                }
            }
            else {
                if (!alFileName.contains(f.getName())){
                    alFileName.add(f.getName());
                }
            }
            
            fileMap.put(sKey, alFileName);
            //System.out.println(alFileName);
            //System.out.println(fileMap);
            //System.out.println();
            
        }
    }
    
    public void buildWordFileMap() {
        fileMap.clear();
        
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
        
        
    }
    
    private int maxNumber() {
        int maxFiles = 0;
        
        for (String word: fileMap.keySet()) {
            ArrayList<String> tempFiles = new ArrayList<String> (fileMap.get(word));
            int noOfFiles = tempFiles.size();
            
            if (noOfFiles > maxFiles) {
                maxFiles = noOfFiles;
            }
        }
        return maxFiles;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> numList = new ArrayList<String>();
        
        for(String s: fileMap.keySet()){
            ArrayList<String> list = fileMap.get(s);
            if (number == list.size()) {
                numList.add(s);
            }
        }
        
        return numList;
    }
    
    public void tester() {
        buildWordFileMap();
        //int result = maxNumber();
        //System.out.println(result);
        
        ArrayList<String> test = wordsInNumFiles(3);
        System.out.println(test);
        test = wordsInNumFiles(2);
        System.out.println(test);
    }

}
