/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarymanagement;

/**
 *
 * @author MyPC
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
import java.util.*;
import java.io.File;
import java.io.FileReader;
//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
public class Main {
//public static ArrayList<Word>dic=new ArrayList<Word>();

    
    

    public static void main(String[] args) throws IOException  {

        DictionaryCommandLine D = new DictionaryCommandLine();
        
        D.dictionaryBasic();
        
        
        
        
    }

}
