
/**
 * How Many Genes?
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany (String stringa, String stringb) {
        int startIndex = 0;
        int count = 0;
        int currIndex=0;
        
        while(currIndex != -1) {
            
            currIndex = stringb.indexOf(stringa, startIndex);
            
            count=count+1;
            
            startIndex = currIndex + stringa.length();
            
            if (currIndex == -1) {
                break;
            }
               
        }
        
        return count - 1;
        
    }
    
    public void testhowMany(){
        String stringb = "CCCTATGCCCTAAATTAA";
        String stringa = "TAA";
        
        int find = howMany(stringa, stringb);
        System.out.println("No. of occurances = " + find);
    }

}
