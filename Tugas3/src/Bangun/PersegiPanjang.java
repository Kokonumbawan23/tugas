/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bangun;

/**
 *
 * @author Lenovo
 */
public class PersegiPanjang implements MenghitungBidang{

    double panjang, lebar, keliling, luas;
    
    public PersegiPanjang(){};

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    public PersegiPanjang(double  panjang, double lebar){
    
        this.panjang = panjang;
        this.lebar = lebar;
         
    }

    public double getKeliling() {
        return keliling;
    }

    public double getLuas() {
        return luas;
    }
    
    @Override
    public void luas() {
       luas =  panjang * lebar;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keliling() {
        keliling =  (2*panjang) + (2*lebar); //To change body of generated methods, choose Tools | Templates.
    }
    
}
