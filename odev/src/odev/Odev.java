/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package odev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;  

/**
 *
 * @author Lenovo
 */
public class Odev {

public static void main(String[] args) throws IOException {  
    
    try {
      File liste = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\odev\\src\\ÖgrenciListesi.txt");
      if (liste.createNewFile()) {
        System.out.println("Oluşturuldu: " + liste.getName());
      } else {
        System.out.println("Zaten Var.");
      }
    } catch (IOException e) {
      System.out.println("Bir Hata Oluştu.");
      e.printStackTrace();
    }

//    String path = System.getProperty("user.dir") +"ÖgrenciListesi.txt";
    
    
    JFrame f=new JFrame("Öğrenci Listesi");  
    final JTextField tf=new JTextField("Kaydedilecek İsmi Girin");  
    tf.setBounds(50,50, 200,20);
    
    JButton b1=new JButton("Kaydet");  
    b1.setBounds(50,100,95,30);  
    b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){
        
        try {
            FileWriter icineYaz = new FileWriter("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\odev\\src\\ÖgrenciListesi.txt", true);
            icineYaz.write(tf.getText()+"\n");
            icineYaz.close();
        } catch (IOException ex) {
            System.out.println("İsim Listeye Eklenirken Bir Hata Oldu!");

        }

            tf.setText("Sıradaki İsmi Girin");  
        }  
    });  
    f.add(b1);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
    
    JButton b2=new JButton("Yazdır"); 
    b2.setBounds(50,150,95,30);  
    
    JTextArea ta=new JTextArea("");  
    ta.setBounds(50,200, 200,400);  
    f.add(ta);  
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  

    
    b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent a){
      try {
      File liste = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\odev\\src\\ÖgrenciListesi.txt");
      Scanner oku = new Scanner(liste);
      int i = 1;
      while (oku.hasNextLine()) {
            String data = oku.nextLine();
            ta.append(i+" - "+data+"\n");
            i++;
      }
            oku.close();
      } catch (FileNotFoundException e) {
            ta.append("Bir Hata Olustu!");
            e.printStackTrace();
      }
//        ta.setText(data);  
        
       } 
    });  
    f.add(b2);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    

}   
    
}
