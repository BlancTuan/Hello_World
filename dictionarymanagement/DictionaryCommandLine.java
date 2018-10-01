
package dictionarymanagement;

import java.io.IOException;
import java.util.*;
/**
 *
 * @author MyPC
 */
public class DictionaryCommandLine {
    DictionaryManagement d = new DictionaryManagement();
  public void showAllWords()
    {
        System.out.println("No\t\tEnglish\t\tVietnamese");
        for(int i=0; i<d.dic.arr.size(); i++)
        {
            System.out.println(i+1 + "\t\t" + d.dic.arr.get(i).word_target +"\t\t" +d.dic.arr.get(i).word_explain);
        }
    }
        
   public void dictionaryBasic() 
   {
      // d.insertFromCommandline();
       //showAllWords();
       d.insertFromFile();
       showAllWords();
       
       Scanner sc = new Scanner(System.in, "UTF-8");
       String s=sc.nextLine();
               
       System.out.println(d.dictionaryLookup(s));
       
       
   }
}
