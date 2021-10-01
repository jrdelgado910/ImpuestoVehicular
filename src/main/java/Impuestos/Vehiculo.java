
package Impuestos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Vehiculo {

   

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    private String marca;
    private String linea;
    private int año;
    
    private Vehiculo(String marca, String linea, int año){
        this.marca=marca;
        this.linea=linea;
        this.año=año;
    }
     Vehiculo(){
    }
     // valores tomados de la secretaria de hacienda https://www.shd.gov.co/shd/vehiculos
     // tarifas https://www.grupor5.com/blog/movilidad/impuesto-vehicular
     // descuento por pronto pago https://www.bluradio.com/blu360/bogota/pico-y-placa-para-pagar-el-impuesto-vehicular-con-un-10-de-descuento-en-bogota
    public String liquidacion(double vH, boolean desP, boolean tipV, boolean traV){
        double impuesto=0, impP=0, impT=0, impTr=0;
        
        if(tipV==true && desP == true && traV == true){
            impuesto=vH*0.1;
            impP=impuesto;
            impT=impuesto*0.05;
            impuesto=impuesto-impT;
            impTr=impuesto*0.11;
            impuesto=impuesto-impTr;
        }else if (tipV==true && desP == true && traV == false){
            impuesto=vH*0.1;
            impP=impuesto;
            impT=impuesto*0.05;
            impuesto=impuesto-impT;
        }else if (tipV==true && desP == false && traV == true){
            impuesto=vH*0.05;
            impT=impuesto;
            impTr=impuesto*0.11;
            impuesto=impuesto-impTr;
        }else if (tipV==true && desP == false && traV == false){
            impuesto=vH*0.05;
            impT=impuesto;
        }else{
            if(vH>0 && vH<49470000){
                impuesto=vH*0.015;
            }else if(vH>49470001 && vH<111305000){
                impuesto=vH*0.025; 
            }else if(vH>111305001){
                impuesto=vH*0.035;
            }
            
            if(desP == true && traV == true){
             impP=impuesto*0.1;
             impuesto=impuesto-impP;
             impTr=impuesto*0.11;
             impuesto=impuesto-impTr;
            }else if(desP == true && traV == false){
             impP=impuesto*0.1;
             impuesto=impuesto-impP; 
            }else if(desP == false && traV == true){
             impTr=impuesto*0.11;  
             impuesto=impuesto-impTr; 
            }else if(desP == false && traV == false){
             impuesto=impuesto;
            }
        }
        
      String patron = "###, ###, ###, ###. ##"; 
      DecimalFormat objDF = new DecimalFormat (patron);
      String desPron = objDF.format (impP);
      String destip = objDF.format (impT);
      String destrac = objDF.format (impTr);
      String imp = objDF.format (impuesto);
 
        
        return "Despuesnto por pago oportuno: $"+desPron+"\n"+
               "Descuento por servicio publico: $"+destip+"\n"+
               "Descuento por traslado de cuenta: $"+destrac+"\n\n"+
               "Liquidacion de impuesto anual: $"+imp;
        
    }
  
    
    public Double ValorV(String marca, String linea, int año){
        double valor=0;
        if(marca.equals("Chevrolet")){
            if(linea.equals("Astra")){
            valor=17000000;    
            }else if(linea.equals("Aveo")){
            valor=25000000;   
            }else if(linea.equals("Beat")){
            valor=40290000;
            }else if(linea.equals("Camaro")){
            valor=140000000;  
            }  
        }else if(marca.equals("Renault")){
            if(linea.equals("Kwid")){
            valor=38100000;    
            }else if(linea.equals("Sandero")){
            valor=47300000;   
            }else if(linea.equals("Logan")){
            valor=46490000;
            }else if(linea.equals("Megane")){
            valor=23900000;  
            }    
        }else if(marca.equals("Audi")){
            if(linea.equals("A6")){
            valor=257900000;    
            }else if(linea.equals("Q2")){
            valor=127900000;   
            }else if(linea.equals("Q3")){
            valor=154900000;
            }else if(linea.equals("Q8")){
            valor=339900000;  
            }
        }else if(marca.equals("Mazda")){
            if(linea.equals("Sedane")){
            valor=64200000;    
            }else if(linea.equals("Cx-30")){
            valor=84700000;   
            }else if(linea.equals("Cx-9")){
            valor=185800000;
            }else if(linea.equals("Mazda2")){
            valor=63700000;  
            }
        }else if(marca.equals("Toyota")){
            if(linea.equals("Prado")){
            valor=164000000;    
            }else if(linea.equals("Hilux")){
            valor=220000000;   
            }else if(linea.equals("Corolla")){
            valor=80000000;
            }else if(linea.equals("Yaris")){
            valor=59200000;  
            }
        }else if(marca.equals("BMW")){
            if(linea.equals("Coupe")){
            valor=299900000;    
            }else if(linea.equals("M240i")){
            valor=169900000;   
            }else if(linea.equals("M235i")){
            valor=182900000;
            }else if(linea.equals("i3")){
            valor=167900000;  
            }
        }
        
        if(año==2021){
            valor=valor-(valor*0.09);
        }else if(año==2020){
            valor=valor-(valor*0.18);
        }else if(año==2019){
            valor=valor-(valor*0.27);
        }else if(año==2018){
            valor=valor-(valor*0.36);
        }else if(año==2017){
            valor=valor-(valor*0.45);
        }else if(año==2016){
            valor=valor-(valor*0.54);
        }
        return valor;

    }
    
    
}
