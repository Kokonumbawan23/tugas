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
public class Lingkaran implements MenghitungBidang{

    protected double jarijari, diameter, luas, keliling;
    
    public Lingkaran(){};
    
    public Lingkaran(double jarijari){
        
        this.jarijari = jarijari;
        this.diameter = 2*jarijari;
    }

    public double getJarijari() {
        return jarijari;
    }

    public void setJarijari(double jarijari) {
        this.jarijari = jarijari;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter() {
        this.diameter = 2 * this.jarijari;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public void setKeliling(double keliling) {
        this.keliling = keliling;
    }
    
    @Override
    public void luas() {
        luas = 3.14 * jarijari * jarijari; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keliling() {
        keliling = 3.14 * diameter; //To change body of generated methods, choose Tools | Templates.
    }
    
}
