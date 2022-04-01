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
public class Tabung extends Lingkaran implements MenghitungRuang{

    protected double tinggi,volume,luasPermukaan;
    
    public Tabung() {
    }

    public Tabung(double jarijari, double tinggi) {
        super(jarijari);
        this.tinggi = tinggi;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    
    @Override
    public void volume() {
       this.volume = this.luas * this.tinggi; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void luasPermukaan() {
        this.luasPermukaan = 2 * this.luas + this.keliling * this.tinggi; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setAll(double jarijari, double tinggi){
    
        this.setJarijari(jarijari);
        this.setDiameter();
        this.setTinggi(tinggi);
        
        this.luas();
        this.keliling();
        this.luasPermukaan();
        this.volume();
        
    }
    
    
    
}
