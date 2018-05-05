package vista;

import controlador.ClienteController;
import modelo.Cliente;
import pruebas.PruebaCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
    private final Object cols[] = {"cod", "Nombre", "Saldo"};
    private DefaultTableModel table = new DefaultTableModel(cols, 0);


    public VistaCliente() {
        JFrame ventana = new JFrame("Sistema Bancario");

        ventana.setContentPane(panel);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        tableList.setModel(table);

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

                } else JOptionPane.showMessageDialog(panel, "Seleccione un cliente en la tabla");
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
        {
            List<Cliente> buscados = ClienteController.buscarCliente(busqueda);

            table.setRowCount(0);
            buscados.forEach((c) -> {
                if (table.getRowCount() < 10)
                    table.addRow(c.toTableRow());
            });
        }

    }


}
