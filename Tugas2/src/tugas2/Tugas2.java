/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import Bangun.Balok;
import Bangun.Tabung;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Tugas2 {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Balok balok = new Balok();
        Tabung tabung = new Tabung();
        
        int repeat = 1;
        
        while(repeat == 1){
        
        System.out.println("==========");
        System.out.println("Menu Utama");
        System.out.println("==========");
        
        
        
        System.out.println("1. Hitung Balok\n2. Hitung Tabung\n0. Exit\n");
        System.out.print("Pilih : ");
        
        int masukan = input.nextInt();
        
        
            
            switch(masukan){

                case 1:{

                    System.out.print("Input Panjang : ");
                    double panjang = input.nextDouble();
                    System.out.print("Input Lebar : ");
                    double lebar = input.nextDouble();
                    System.out.print("Input Tinggi : ");
                    double tinggi = input.nextDouble();

                    balok.setAll(panjang,lebar,tinggi);

                    System.out.println("Luas Persegi Panjang : " + balok.getLuas() );
                    System.out.println("Keliling Persegi Panjang : " + balok.getKeliling() );
                    System.out.println("Luas Permukaan Balok : " + balok.getLuasPermukaan() );
                    System.out.println("Volume Balok : " + balok.getVolume() );
                    
                    repeat = confirm();
                    
                    break;

                }

                case 2:{

                    System.out.print("Input jari-jari : ");
                    double jarijari = input.nextDouble();
                    System.out.print("Input Tinggi : ");
                    double tinggi = input.nextDouble();

                    tabung.setAll(jarijari,tinggi);

                    System.out.println("Luas Lingkaran : " + tabung.getLuas() );
                    System.out.println("Keliling Lingkaran : " + tabung.getKeliling() );
                    System.out.println("Luas Permukaan Tabung : " + tabung.getLuasPermukaan() );
                    System.out.println("Volume Tabung : " + tabung.getVolume() );
                    
                    repeat = confirm();
                    
                    break;
                    }                
                }
            }
        }
    
    public static int confirm(){
        System.out.print("Ulangi? (Ya: 1 || Tidak: 0) ");
        return input.nextInt();
    }
}
