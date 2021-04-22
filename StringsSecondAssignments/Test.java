
/**
 * Write a description of Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test {
    
    String dna = "CTGCCTGCATGATCGTA";
            int pos = dna.indexOf("TG");
        int count = 0;
        while (pos >= 0) {
            count = count + 1;
            pos = dna.indexOf("TG",pos);
        }
        System.out.println(count);

}
