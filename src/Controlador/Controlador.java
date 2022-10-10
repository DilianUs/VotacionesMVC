/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Bitacora;
import Modelo.BitacoraProductos;
import Modelo.Fecha;
import Modelo.Producto;
import Vista.VistaVotacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author braul
 */
public class Controlador implements  ActionListener{
    private VistaVotacion ventana;
    private String nombre;
    private LinkedList<Producto> productos;
    private BitacoraProductos producto;
    private String extension = ".txt";
    
    public Controlador(VistaVotacion ventana, String nombre){
        this.productos = new LinkedList();
        this.ventana = ventana;
        this.nombre = nombre;
        this.ventana.getButton1().addActionListener(this);
        this.ventana.getButton2().addActionListener(this);
        this.ventana.getButton3().addActionListener(this);
        this.ventana.setResizable(false); 
        this.nombresBotones();
        this.votosActuales(); 
    }
    
   
    public void nombresBotones(){
        try {
            Bitacora.escribirBitacora(this.getClass(), new Object() {
            }.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {}
        
        this.producto = new BitacoraProductos();
        this.productos = this.producto.Productos(this.nombre);
        this.ventana.getButton1().setText(this.productos.get(0).getNombre());
        this.ventana.getButton2().setText(this.productos.get(1).getNombre());
        this.ventana.getButton3().setText(this.productos.get(2).getNombre());
    }
    
   
    public String votar(int i, Fecha fechaHora) {
        try {
            Bitacora.escribirBitacora(this.getClass(), new Object() {
            }.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {
        }
        this.producto.guardarVoto(this.productos.get(i).getNombre() + extension, fechaHora.toString());
        this.productos.get(i).votar();
        return Integer.toString(this.productos.get(i).getVotos());
    }
    
    public void votosActuales() {
        try {
            Bitacora.escribirBitacora(this.getClass(), new Object() {
            }.getClass().getEnclosingMethod().getName());
        } catch (IOException ex) {
        }
        this.ventana.getTextoTotalP1().setText(Integer.toString(this.productos.get(0).getVotos()));
        this.ventana.getTextoTotalP2().setText(Integer.toString(this.productos.get(1).getVotos()));
        this.ventana.getTextoTotalP3().setText(Integer.toString(this.productos.get(2).getVotos()));

    }
    
    @Override
    public void actionPerformed(ActionEvent actionUser){
        Fecha fecha = new Fecha();
        
        if(actionUser.getSource() == this.ventana.getButton1()){
            String votoRealizado = votar(0, fecha);
            this.ventana.getTextoTotalP1().setText(votoRealizado);
        }
        
        if(actionUser.getSource() == this.ventana.getButton2()){
            String votoRealizado = votar(1, fecha);
            this.ventana.getTextoTotalP2().setText(votoRealizado);
        }
        
         if(actionUser.getSource() == this.ventana.getButton3()){
            String votoRealizado = votar(2, fecha);
            this.ventana.getTextoTotalP3().setText(votoRealizado);
        }
    }
    
    
}
