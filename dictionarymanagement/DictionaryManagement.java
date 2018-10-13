package dictionarymanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.Serializable;
import java.io.Writer;
import static java.nio.file.Files.delete;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class DictionaryManagement {

    public Dictionary dic = new Dictionary();
    ArrayList<Word> arr = dic.arr;

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
            arr.add(tuvung);

        }

    }

    public ArrayList<Word> insertFromFile() {

        try {

            Scanner sc;
            File file = new File("dictionary.txt");
            sc = new Scanner(file);
           // System.out.println(file.getAbsolutePath());
            while (sc.hasNext()) {

                String line = sc.nextLine();
                String[] w;
                w = line.split("\t");

                Word tu = new Word(w[0], w[1]);
                arr.add(tu);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    public String dictionaryLookup(String s) {
        String a = "";

        try {

            Scanner sc;
            sc = new Scanner(new File("dictionary.txt"));

            while (sc.hasNext()) {

                String line = sc.nextLine();
                String[] w;
                w = line.split("\t");

                //   Word tu = new Word(w[0], w[1]);
                if (s.toLowerCase().trim().equals(w[0].toLowerCase().trim())) {
                    a = w[1];
                    break;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for (Word w : arr) {
//            if (s.toLowerCase().trim().equals(w.word_target)) {
//                a = w.word_explain;
//            }
//        }
        return a;
    }

    public void them() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu va nghia can them: ");
        String target = sc.nextLine(), explain = sc.nextLine();
        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionary.txt", true)));

            bw.write(target + "\t" + explain + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Da them!");
    }

    public void sua() {
        this.insertFromFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nh?p tu va nghia can sua: ");
        String tar = sc.nextLine();
        String new_explain = sc.nextLine();

        for (int i = 0; i < arr.size(); i++) {
            if (tar.equals(arr.get(i).word_target)) {
                arr.get(i).word_explain = new_explain;
            }
        }

        System.out.println("Da sua!");

    }

    public void xoa() {
        this.insertFromFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu Tieng Anh muon xoa: ");
        String tar = sc.nextLine();
        //insertFromFile();
        for (int i = 0; i < arr.size(); i++) {
            if (tar.equals(arr.get(i).word_target)) {
                arr.remove(i);
            }
        }
        System.out.println("Da xoa!");

    }

    public void dictionaryExportToFile() throws IOException {
        BufferedWriter bw = null;
        
        try {

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\MyPC\\OneDrive\\Documents\\NetBeansProjects\\DictionaryManagement\\src\\dictionarymanagement\\dictionary.txt")));

            for (int i = 0; i < arr.size(); i++) {

                bw.write(arr.get(i).word_target + "\t" + arr.get(i).word_explain + "\r\n");
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
