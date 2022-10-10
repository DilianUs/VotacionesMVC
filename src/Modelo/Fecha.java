/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author braul
 */
public class Fecha {
    public String Fecha(Date date){
        try {
            Bitacora.escribirBitacora(this.getClass(), new Object(){}.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {
        }
        return LocalDate.now() + "," + LocalTime.now();
    }
    
    @Override
    public String toString(){
        return LocalDate.now() + ","+ LocalTime.now();
    }
}
