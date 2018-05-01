package vista;

import javax.swing.*;
import java.awt.event.*;

public class VistaCliente {
    private JPanel panel;
    private JButton addButton;
    private JButton editButton;
    private JButton borrarButton;
    private JTextField searchTextField;
    private JTable listTable;

    public VistaCliente() {
        searchTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(searchTextField.getText().equals("Buscar"))
                searchTextField.setText("");
            }
        });
        searchTextField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                System.out.println(searchTextField.getText());

            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {
                System.out.println(searchTextField.getText());
            }
        });

        createUIComponents();
        searchTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("focus");
                if(searchTextField.getText().equals("Buscar"))
                    searchTextField.setText("");
            }
        });
        searchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(searchTextField.getText());
                listTable.add(searchTextField);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCliente addCliente = new AddCliente();
            }
        });
    }

    private void createUIComponents() {
        JFrame ventana = new JFrame("Sistema Bancario");
        ventana.setContentPane(panel);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
