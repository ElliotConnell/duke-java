
/**
 * Part 4: Finding Web Links
 * 
 * @author Elliot Connell
 * @version 8/4/21
 */
import edu.duke.*;

public class Part4 {
    public void findWebLinks() {
        
        URLResource file = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
           for (String item : file.words()) {
               String itemLower = item.toLowerCase();
               int pos = itemLower.indexOf("youtube.com");
               if (pos != -1) {
                   int beg = item.indexOf("\"",pos);
                   int end = item.lastIndexOf("\"", pos+1);
                   System.out.println(item.substring(beg+1,end));
        
    }
    
    
}
}
}


