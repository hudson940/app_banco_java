/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import vista.FormCliente;
import vista.Login;
import vista.VistaCliente;



public class Main {
    
    private static JFrame ventana;
    
    public static void main(String[] args) {
         ventana = new JFrame();
         Login login = new Login();
         ventana.setContentPane(login);
         ventana.setVisible(true);
         ventana.setSize(400, 400);
        
       
        
        
    }

    public static void dispose() {
        ventana.dispose();
    }
    
}
