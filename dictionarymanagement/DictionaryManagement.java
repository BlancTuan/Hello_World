/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarymanagement;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.Serializable;
//import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class DictionaryManagement {

    public Dictionary dic = new Dictionary();

    public void insertFromCommandline() {

        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 0; i < n; i++) {
            Scanner input = new Scanner(System.in);
            String eng, viet;
            eng = input.nextLine();
            viet = input.nextLine();
            Word tuvung = new Word(eng, viet);
            dic.arr.add(tuvung);

        }

    }
    
    public void insertFromFile(){

        try {   

               Scanner sc;
            sc = new Scanner(new File("dictionari.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] w;
                w = line.split(":");
                
                Word tu = new Word(w[0], w[1]);
              dic.arr.add(tu);
            }               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        /*BufferedReader bf = null;
        try {
            String s;
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("dictionaries.txt")));
            while ((s = bf.readLine()) != null) {
                //s = bf.readLine();
                String[] w = s.split(":");
                Word tu = new Word(w[0], w[1]);
                dic.arr.add(tu);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    public String dictionaryLookup(String s) {
       
        
        //Collections.sort(dic.arr, new EngComparator());
        Collections.sort(dic.arr, new Comparator<Word>()
    {
        @Override
        public int compare(Word w1, Word w2)
        {
            return (w1.word_target.compareTo(w2.word_target));
        }
    }
    );
            String a = null;
        int size = dic.arr.size(), i = 0, j = size - 1;
          for(Word w : dic.arr)
                
             if(s.compareTo(w.word_target)==0)
               a = (w.word_explain);
           
    
         
         
        /*while (i < j) {
            int mid = (i+j)/ 2;
             int index = s.compareTo(dic.arr.get(mid).word_target);
          
                if(index == 0)
                    a = dic.arr.get(mid).word_explain;
                    
                else if(index < 0)
                    j = mid-1;
                else 
                    i = mid+1;
            }*/
     
	
        return a;
    }
}
       
        