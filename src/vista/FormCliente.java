package vista;

import controlador.ClienteController;
import modelo.Cliente;
import modelo.Tarjeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormCliente extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel nombreLabel;
    private JLabel emailLabel;
    private JLabel celLabel;
    private JLabel saldoLabel;
    private JLabel tarjetaLabel;
    private JTextField nombreTextField;
    private JTextField direccionTextField;
    private JTextField emailTextField;
    private JTextField saldoTextField;
    private JTextField celTextField;
    private JPanel panel;
    private JButton crearTcButton;
    private JTextField tarjetaTextField;
    private Cliente toEdit;
    private Tarjeta tarjeta;

    public FormCliente(Cliente toEdit) {
        this.toEdit = toEdit;
        if (toEdit != null) {
            nombreTextField.setText(toEdit.getNombre());
            direccionTextField.setText(toEdit.getDireccion());
            celTextField.setText(toEdit.getCelular());
            emailTextField.setText(toEdit.getEmail());
            saldoTextField.setText("" + toEdit.getSaldo());
            saldoTextField.setEnabled(false);
            tarjetaTextField.setText("" + toEdit.getTarjeta_credito());
            tarjeta = toEdit.getTarjeta_credito();
            crearTcButton.setText("Editar TC");
        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (toEdit == null) {
                    onOK();
                } else {
                    onOK(toEdit);
                }

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

        crearTcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormTarjeta dialog = new FormTarjeta(tarjeta);
                dialog.pack();
                dialog.setVisible(true);
                tarjetaTextField.setText(tarjeta.toString());
                if (dialog.getTarjeta() != null)
                    tarjeta = dialog.getTarjeta();

            }
        });
    }

    private void onOK() {

        ClienteController.agregarCliente(
                nombreTextField.getText(),
                direccionTextField.getText(),
                emailTextField.getText(),
                celTextField.getText(),
                Double.parseDouble(saldoTextField.getText()),
                tarjeta
        );

        dispose();
    }

    private void onOK(Cliente toEdit) {
        ClienteController.editarCliente(
                toEdit.getCodigo(),
                nombreTextField.getText(),
                direccionTextField.getText(),
                emailTextField.getText(),
                celTextField.getText(),
                tarjeta
        );
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void createUIComponents() {


    }

}
