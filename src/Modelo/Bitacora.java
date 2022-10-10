/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author braul
 */
public class Bitacora {
    public void crearArchivo(String nombre){
        try {
           Bitacora.escribirBitacora(this.getClass(), new Object(){}.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {
        }
        
        File archivo = new File(nombre);
        
        if(archivo.exists()){
            return;
        }else{
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void escribirBitacora(Class clase, String metodo) throws IOException{
        File archivo = new File("bitacora.txt");
        Date fecha = new Date();
        Timestamp tiempoActual = new Timestamp(fecha.getTime());

        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        FileWriter fileWritter = new FileWriter(archivo.getName(), true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(tiempoActual.toString() + " " + clase.getName() + " ." + metodo + "\n");
        bufferWritter.close();
    }
}
