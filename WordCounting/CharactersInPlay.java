
/**
 * Write a description of CharactersInPlay here.
 * Write a program to print out the main characters in one of Shakespeare’s plays, those with the most speaking parts. 
 * You should identify a speaking part by reading the file line-by-line and finding the location of the first period 
 * on the line. Then you will assume that everything up to the first period is the name of a character and count how 
 * many times that occurs in the file. You will only print those characters that appear more often than others. Notice
 * our method is somewhat error prone. For example, a period is also used to indicate the end of a sentence. By printing
 * out only those characters that appear a lot, we will get rid of most of the errors. Periods that indicate the end of
 * a sentence will likely be a unique phrase so you won’t print that as it would just occur once or maybe twice. 
 * 
 * @author (Elliot Connell) 
 * @version (28/05/21)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class CharactersInPlay {
    
    private ArrayList<String> myNames;
    private ArrayList<Integer> myCounts;
    
    public CharactersInPlay() {
        myNames = new ArrayList<String>();
        myCounts = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        String name = person;
        
        int index = myNames.indexOf(name);
        
        if (index == -1) {
            myNames.add(name);
            myCounts.add(1);
        }
        
        else {
            int value = myCounts.get(index);
            myCounts.set(index, value + 1);
        }
        
    }
    
    public void findAllCharacters() {
        myNames.clear();
        myCounts.clear();
        FileResource resource = new FileResource();
        
        for (String line : resource.lines()) {
            int endIndex = line.indexOf(".");
            if (endIndex != -1) {
                String character = line.substring(0, endIndex);
                update(character);
            }
            
        } 
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        for (int k=0; k < myNames.size(); k++) {
            int parts = myCounts.get(k);
            if ((parts >= num1) && (parts <= num2)) {
                System.out.println(myNames.get(k));
            }
        }
    }
    
    public void tester() {
        findAllCharacters();
        
        //for (int k=0; k < myNames.size(); k++){
        //    if (myCounts.get(k) > 50) {
        //        System.out.println(myNames.get(k) + "\t" + myCounts.get(k));
        //    }
        //}
        
        charactersWithNumParts(10, 15);
        //charactersWithNumParts(3, 3);
        
    }

}
