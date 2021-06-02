
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
        ArrayList<String> filename = new ArrayList<String>();
        
        for (String sKey: fr.words()){
            filename.clear();
            //System.out.println(sKey);
            
            if (fileMap.containsKey(sKey)) {
                filename = fileMap.get(sKey);
                if (!filename.contains(f.getName())) {
                    filename.add(f.getName());
                }
            }
            else {
                filename.add(f.getName());
            }
            
            fileMap.put(sKey, filename);
        }
    }
    

}
