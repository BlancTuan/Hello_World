/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarymanagement;
import java.util.*;
/**
 *
 * @author MyPC
 */
public class EngComparator implements Comparator<Word>{
    public int compare(Word w1, Word w2)
    {
        return w1.word_target.compareTo(w2.word_target);
    }
    
}
