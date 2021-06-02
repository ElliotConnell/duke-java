
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
        ArrayList<String> alFileName = new ArrayList<String>();
        
        for (String sKey: fr.words()){
            alFileName.clear();
            //System.out.println(sKey);
            
            if (fileMap.containsKey(sKey)) {
                alFileName = fileMap.get(sKey);
                if (!alFileName.contains(f.getName())) {
                    alFileName.add(f.getName());
                }
            }
            else {
                alFileName.add(f.getName());
            }
            
            fileMap.put(sKey, alFileName);
            System.out.println(alFileName);
            System.out.println(fileMap);
            System.out.println();
            
        }
    }
    
    public void buildWordFileMap() {
        fileMap.clear();
        ArrayList<String> alFileMap = new ArrayList<String>();
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
        
        for (String sKey: fileMap.keySet()) {
             alFileMap = fileMap.get(sKey);
             for (String s: alFileMap) {
                 System.out.println("  " + s);
             }
               
        }
    }
    

}
