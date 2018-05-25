
package controlador;

import Pruebas.PruebaCliente;
import modelo.Cliente;
import vista.FormCliente;
import vista.FormTarjeta;
import vista.Inicio;
import vista.VistaCliente;

import javax.swing.*;
import modelo.Tarjeta;
import vista.Login;

public class GUIController {
   private static FormCliente formCliente;

   
   private static FormTarjeta formTarjeta;
   private Inicio inicio;
   private static VistaCliente guiCliente;
   public static final String Username = "admin";
   public static final String  Password = "1234";
   private Login login ; 
   private static JFrame ventana;


   public GUIController(){
      inicio = new Inicio();
      inicio.setVisible(true);
      
      //agrega cliente de prueba
      PruebaCliente.agregar();


   }
   

   public static void runFormCliente(Cliente toEdit) {

       if (toEdit != null) {
           formCliente = new FormCliente(toEdit);
           formCliente.setVisible(true);
       } else JOptionPane.showMessageDialog(null,"Seleccione un cliente en la tabla");
   }
    public static void runFormCliente() {
         new FormCliente(null)
        .setVisible(true);
        
    }
    
    
   public static Tarjeta runFormTarjeta(Tarjeta tarjeta) {
       formTarjeta =  new FormTarjeta(tarjeta);
       formTarjeta.setVisible(true);
       return formTarjeta.getTarjeta();
   }

   public Inicio runInicio() {
       return inicio;
   }

    public static void runGUICliente() {
       ventana = new JFrame();
       guiCliente = new VistaCliente();
       ventana.setContentPane(guiCliente);
       ventana.setVisible(true);
       ventana.setSize(420, 600);
       
    }
}



