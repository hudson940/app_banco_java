package vista;

import modelo.Tarjeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormTarjeta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField limiteTextField;
    private JTextField fechaTextField;
    private JTextField interesTextField;
    private JTextField numeroTextField;
    Tarjeta tarjeta;

    public FormTarjeta(Tarjeta tarjetaEdit) {
        if (tarjetaEdit != null) {
            numeroTextField.setText("" + tarjetaEdit.getNumero());
            limiteTextField.setText("" + tarjetaEdit.getLimite());
            fechaTextField.setText(tarjetaEdit.getFechaCorte());
            interesTextField.setText("" + tarjetaEdit.getInteres());
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        tarjeta = new Tarjeta(
                Integer.parseInt(numeroTextField.getText()),
                Double.parseDouble(limiteTextField.getText()),
                fechaTextField.getText(),
                Float.parseFloat(interesTextField.getText())
        );

        dispose();


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Tarjeta getTarjeta() {
        return tarjeta;

    }

}
