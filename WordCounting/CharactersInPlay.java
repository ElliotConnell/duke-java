
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
    
    public void CharactersInPlay() {
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
            myCounts.add(index, value + 1);
        }
        
    }

}
