/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;


import Konversi.Konversi;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Main {

    static Scanner input;
    static double celcius;
    static boolean x = true;
    
    public static void main(String[] args) {
        
        System.out.println("+---------------------------+");
        System.out.println("| PROGRAM KONVERSI SUHU AIR |");
        System.out.println("+---------------------------+");

        Main.input = new Scanner(System.in);
        
        celcius = masukan();
        
        Konversi convert = new Konversi(celcius);
        
        while(x){
        
            switch(menu()){
                
                case 1 : {
                
                    convert.printConvert();
                    
                    break;
                }
                
                case 2 : {
                
                    convert.setCelcius(masukan());
                    
                    System.out.println();
                    
                    break;
                
                }
                
                case 3 : {
                    x = false;
                    
                    System.out.println();
                    System.out.println();
                    
                    break;
                        }
                
                default: {
                    System.out.println("\nOpsi tidak ada, silahkan masukkan opsi yang benar");
                    
                    System.out.println();
                    System.out.println();
                }
            
            }
        
        } 
        
    }
    
    public static double masukan(){
        
        System.out.print("\nSuhu dalam celcius : ");
        return input.nextDouble();
        
    }
    
    public static int menu(){
       
        System.out.println("\nOpsi: ");
        System.out.println("--- ");
        System.out.println("1. Lihat Data Konversi");
        System.out.println("2. Edit Data Konversi");
        System.out.println("3. Exit");
        System.out.print("Pilih : ");
        return input.nextInt();
        
        
    
    }
    

   
    
}
