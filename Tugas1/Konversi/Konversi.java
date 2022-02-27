/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konversi;

/**
 *
 * @author Lenovo
 */
public class Konversi {
    
    public double celcius,reamur,fahrenheit,kelvin;
    
    public Konversi(double n){
    
        this.celcius = n;
        
    }
    
    public void convertReamur(){
        
        this.reamur = (4 * this.celcius)/5;
               
    }
    
     public void convertFahr(){
        
        this.fahrenheit = (9 * this.celcius)/5 + 32;
               
    }
     
      public void convertKelvin(){
        
        this.kelvin = this.celcius + 273.15;
               
    }
      
      public void setCelcius(double n){
          
        this.celcius = n;  
      }
      
      public void printConvert(){
      
        this.convertFahr();
        this.convertReamur();
        this.convertKelvin();
        
        System.out.println("\nSuhu dalam celcius : " + this.celcius + "°C");
        System.out.println("Dalam Fahrenheit : " + this.fahrenheit + "°F");
        System.out.println("Dalam Reamur : " + this.reamur + "°R");
        System.out.println("Dalam Kelvin : " + this.kelvin + "°K");
        
      
      
      }
    
}
