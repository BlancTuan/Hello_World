package dictionaryy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryCommandLine extends DictionaryManagement {

    public void showAllWords() {
        this.insertFromFile();
        System.out.println("No\t\t| English\t\t| Vietnamese");
        for (int i = 0; i < this.arr.size(); i++) {
            System.out.println(i + 1 + "\t\t| " + this.arr.get(i).word_target + "\t\t| " + this.arr.get(i).word_explain);
        }
    }

    public void dictionaryBasic() throws IOException {

       
        this.insertFromFile();
        while (true) {
           
            System.out.println("Moi ban nhap lua chon:\n 0 - Tim kiem\n 1 - Them du lieu\n 2 - Sua du lieu\n 3 - Xoa du lieu\n 4 - Tim tu goi y\n 5 - In du lieu cua tu dien");
            Scanner scan = new Scanner(System.in);
            int luachon1 = scan.nextInt();
            if (luachon1 == 0) {
               
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap tu Tieng Anh: ");
                String s = sc.nextLine();
              
                if(this.dictionaryLookup(s).equals(""))System.out.println("Tu nay khong co trong du lieu cua chung toi!");
               else System.out.println("Nghia cua tu la: "+this.dictionaryLookup(s));
            } else if (luachon1 == 1) {
                this.them();
               
            } else if (luachon1 == 2) {
                this.sua();
             
                
            } else if (luachon1 == 3) {
                this.xoa();
            
              
            } else if(luachon1==4){
                System.out.println("Nhap tu goi y: ");
                Scanner sc = new Scanner(System.in);
                String sub = sc.nextLine();
                ArrayList<String> HintList = new ArrayList<String>();
                HintList = this.dictionarySearcher(sub);
                for (int i = 0; i < HintList.size(); i++) {
                    System.out.println(HintList.get(i));
                }
            }
            else 
            {
                 System.out.println("Dang load du lieu ...");
                showAllWords();
            }
            System.out.println("\n\tBan co muon ket thuc chuong trinh khong? : 1 - Co, 0 - Khong");
            int luachon2 = scan.nextInt();
            if (luachon2 == 0) {
                continue;
            } else {
                this.dictionaryExportToFile();
                break;
            }
        }

    }

    public ArrayList<String> dictionarySearcher(String s) {
       
        ArrayList<String> HintList = new ArrayList<String>();

        int l = s.length();
        
         for (int i = 0; i < arr.size(); i++) {

            if (l <= arr.get(i).word_target.length()) {
                String a = arr.get(i).word_target.substring(0, l);

                if (a.equals(s)) {

                    HintList.add(arr.get(i).word_target);
                }
            }

        }

        return HintList;
    }
}
