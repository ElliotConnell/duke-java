
/**
 * Write a description of Part3 here.
 * 
 * @author Elliot Connell 
 * @version 7/4/21
 */
public class Part3 {
    
    public boolean twoOccurances(String stringa,String stringb){
        
        //return true if stringA appears twice in string b
        int i=-1;       
        int curr = stringb.indexOf(stringa);
        int lena = stringa.length();
        int pos=0;
        
        if(curr==-1) {
            return false;
        }
        
        curr=0;
        
        while(curr!=-1) {
            curr=stringb.indexOf(stringa, pos);
            i++;
            pos = curr+lena;            
        }
        
        if (i>=2) return true;
        
        else return false;
        
    }
    
    public String lastPart(String stringa,String stringb) {
        //finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa.  
        String result = "";
        int startIndex = stringb.indexOf(stringa);
        int len = stringa.length();
        
        if (startIndex == -1) // no ATG
        {
            //If stringa does not occur in stringb, then return stringb
            return stringb;
        }
        
        result = stringb.substring(startIndex + len);
                
        return result;
        
    }
    
    public void testing() {
        boolean test = twoOccurances("by","A story by Abby Long");;
        System.out.println(test);
        
        test = twoOccurances("a", "banana");
        System.out.println(test);
        
        test = twoOccurances("atg", "ctgtatgta");
        System.out.println(test);
        
        String test1 = lastPart("an", "banana");
        System.out.println(test1);
        
        test1 = lastPart("zoo", "forest");
        System.out.println(test1);
    }
    

}
