package vista;

import controlador.ClienteController;
import modelo.Cliente;
import pruebas.PruebaCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VistaCliente {
    private JPanel panel;
    private JButton addButton;
    private JButton editButton;
    private JButton borrarButton;
    private JTextField searchTextField;
    private JTable tableList;
    private JButton consignarButton;
    private JButton retirarButton;
    private JButton refreshButton;
    private final String cols[] = {"cod", "Nombre", "Saldo"};
    private DefaultTableModel table = new DefaultTableModel(cols, 0);

    public VistaCliente() {
        JFrame ventana = new JFrame("Sistema Bancario");
        $$$setupUI$$$();
        ventana.setContentPane(panel);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

        searchTextField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                System.out.println(searchTextField.getText());

            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });


        searchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                loadTable();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // mientras desarrollo
                PruebaCliente.agregar();

                FormCliente dialog = new FormCliente(null);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cliente toEdit = getSelectedClient();
                if (toEdit != null) {
                    FormCliente edit = new FormCliente(toEdit);
                    edit.pack();
                    edit.setVisible(true);
                } else JOptionPane.showMessageDialog(panel, "Seleccione un cliente en la tabla");
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cliente eliminar = getSelectedClient();
                if (eliminar != null) {
                    int dialogResult = JOptionPane.showConfirmDialog(panel,
                            "Seguro que desea borrar este cliente?", "Warning", 1);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        int idRow = tableList.getSelectedRow();
                        String elminado = ClienteController.eliminarCliente(
                                eliminar.getCodigo()
                        );
                        JOptionPane.showMessageDialog(panel, elminado);
                        table.removeRow(idRow);
                    }

                }
                else JOptionPane.showMessageDialog(panel, "Seleccione un cliente en la tabla");
            }
        });
        consignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cliente cliente = getSelectedClient();
                if (cliente != null) {
                    String monto = JOptionPane.showInputDialog(panel, "Ingrese cantidad a consignar");
                    JOptionPane.showMessageDialog(panel, "Saldo agregado, el nuevo saldo es: " +
                            cliente.addSaldo(Double.parseDouble(monto)));
                    loadTable();
                } else JOptionPane.showMessageDialog(panel, "Seleccione un cliente en la tabla");

            }
        });
        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cliente cliente = getSelectedClient();
                if (cliente != null) {
                    String monto = JOptionPane.showInputDialog(panel, "Ingrese cantidad a retirar");
                    Double nuevoSaldo = cliente.retirarSaldo(Double.parseDouble(monto));

                    if (nuevoSaldo != null) {
                        JOptionPane.showMessageDialog(panel, "Retiro realizado, el nuevo saldo es: " +
                                nuevoSaldo);
                        loadTable();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Fondos insuficientes");
                    }
                } else JOptionPane.showMessageDialog(panel, "Seleccione un cliente en la tabla");

            }
        });
        searchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //if (searchTextField.getText() == "Buscar")
                searchTextField.setText("");
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadTable();
            }
        });
    }

    private void createUIComponents() {

        tableList = new JTable(table);

    }

    private Cliente getSelectedClient() {
        int idRow = tableList.getSelectedRow();
        if (idRow != -1) {
            Cliente cliente = ClienteController.buscarCliente(
                    Integer.parseInt(table.getValueAt(idRow, 0).toString())
            );
            return cliente;
        } else return null;

    }

    private void loadTable() {
        String busqueda = searchTextField.getText();
        if (table.getRowCount() < 10) {
            List<Cliente> buscados = ClienteController.buscarCliente(busqueda);

            table.setRowCount(0);
            buscados.forEach((c) -> {
                table.addRow(c.toTableRow());
            });
        }

    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(13, 3, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 11, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        editButton = new JButton();
        editButton.setText("Editar Cliente");
        panel.add(editButton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        borrarButton = new JButton();
        borrarButton.setText("Borrar Cliente");
        panel.add(borrarButton, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel.add(tableList, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        addButton = new JButton();
        addButton.setText("Agregar Nuevo");
        addButton.setToolTipText("Agregar nuevo cliente");
        panel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        consignarButton = new JButton();
        consignarButton.setText("Consignar");
        panel.add(consignarButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        retirarButton = new JButton();
        retirarButton.setText("Retirar");
        panel.add(retirarButton, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        refreshButton = new JButton();
        refreshButton.setText("Actualizar Tabla");
        panel.add(refreshButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Buscar por nombre:");
        panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchTextField = new JTextField();
        searchTextField.setText("");
        searchTextField.setToolTipText("Buscar cliente");
        panel.add(searchTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
