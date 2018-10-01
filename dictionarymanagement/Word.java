package dictionarymanagement;

import java.io.Serializable;
public class Word implements Serializable{
    private static final long serialVersionUID = 1L;
   public String word_target, word_explain;
   
   public Word(String target, String explain)
   {
       
       this.word_target = target;
       this.word_explain = explain;
   }
    
}
