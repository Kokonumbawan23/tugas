/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisprakpbo;

/**
 *
 * @author Lenovo
 */
public class AndroidDev extends Divisi implements Perhitungan{

    public AndroidDev() {
    }

    public AndroidDev(String nama, String nim, float tulis, float coding, float wwc) {
        this.nama = nama;
        this.nim = nim;
        this.tulis = tulis;
        this.coding = coding;
        this.wwc = wwc;
    }
    
    @Override
    public void hitungNilai() {
        
        float nilai;
        
        nilai = (float) ((0.2*this.tulis) + (0.5*this.coding) + (0.3*this.wwc));
        
        this.nilai = nilai;
    }

    @Override
    public void editNilai(float tulis,float coding,float wwc) {
        this.tulis = tulis;
        this.coding = coding;
        this.wwc = wwc;
    }

    public String getNama() {
        return nama;
    }
    
    public float getNilai() {
        return nilai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setTulis(float tulis) {
        this.tulis = tulis;
    }

    public void setCoding(float coding) {
        this.coding = coding;
    }

    public void setWwc(float wwc) {
        this.wwc = wwc;
    }
    
    
}
