package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JButton clientesButton;
    private JLabel Titulo;
    private JPanel Panel;

    public Inicio() {
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                VistaCliente ventanaCliente = new VistaCliente();
            }
        });
        JFrame ventana = new JFrame("Sistema Bancario");
        ventana.setContentPane(Panel);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

    }


}
