
import Controlador.Controlador;
import Vista.VistaVotacion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author braul
 */
public class Main {
    public static void main(String[] args) {
        VistaVotacion view = new VistaVotacion();
        Controlador control = new Controlador(view, "productos.txt");
        view.setVisible(true);
        
    }
}
