/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author braul
 */
public class BitacoraProductos extends Bitacora{
   
    public BitacoraProductos(){
        super();
    }
    
    public int cantidadVotos(String nombre){
        try {
            Bitacora.escribirBitacora(this.getClass(),new Object(){}. getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {}
         int votos = 0;
         this.crearArchivo(nombre);
         File archivo = new File(nombre);
        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader linea = new BufferedReader(reader);
            String cadena;
            while ((cadena = linea.readLine())!= null) {
                votos++;
            }
            linea.close();
            return votos;
        } catch (IOException e) {
            System.out.println(e.getMessage() + "No se pudo leer el archivo");
            return 0;
        }
    }
    
    
    public LinkedList<String> Votos(String nombre) {
        try { Bitacora.escribirBitacora(this.getClass(), new Object(){}.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {}
        LinkedList<String> votos = new LinkedList();
        this.crearArchivo(nombre);
        File archivo = new File(nombre);

        try {
            FileReader reader = new FileReader(archivo); 
            BufferedReader line = new BufferedReader(reader); 

            String cadena;
            while ((cadena = line.readLine()) != null) {
                votos.add(cadena);
            }

            line.close();

            return votos;
        } catch (IOException e) {
            System.out.println(e.getMessage() + " No fue posible leer el archivo");
            return votos;
        }
    }
    
    
    public static String next = System.lineSeparator();
    public void guardarVoto(String nombre, String fecha) {
        try {
            Bitacora.escribirBitacora(this.getClass(), new Object(){}.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {
        }
        
        LinkedList<String> cadena = this.Votos(nombre);
        cadena.add(fecha);

        File archivo = new File(nombre);
        try {
            FileWriter writer = new FileWriter(archivo);

            for (int i = 0; i < cadena.size(); i++) {
                String movimiento = cadena.get(i);
                writer.write(movimiento + next);
            }
            writer.close();
        } catch (IOException ex) {

        }

    }
    
    public LinkedList<Producto> Productos(String nombre) {
        try { 
            Bitacora.escribirBitacora(this.getClass(), new Object(){}.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {}
        
        LinkedList<Producto> salida = new LinkedList();
        String extension = ".txt";
        this.crearArchivo(nombre);
        File archivo = new File(nombre);

        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader linea = new BufferedReader(reader);

            String cadena;
            while ((cadena = linea.readLine()) != null) {

                int i = this.cantidadVotos(cadena + extension);
                Producto producto = new Producto(cadena, i);
                salida.add(producto);

            }
            linea.close();
            return salida;

        } catch (IOException e) {
            System.out.println(e.getMessage() + "No fue posible leer el archivo");
            return salida;
        }
    }
    
    
    
    
}
