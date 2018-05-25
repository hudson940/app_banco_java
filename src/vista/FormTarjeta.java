/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import modelo.Tarjeta;

/**
 *
 * @author EFRA
 */
public class FormTarjeta extends javax.swing.JFrame {

    private Tarjeta tarjeta;

    /**
     * Crea una instancia del formulario para tarjeta
     * @param t tarjeta si se ingresa en modo de edición
     */
    public FormTarjeta(Tarjeta t) {
        initComponents();
        this.tarjeta = t;
        try
        {
            numeroTextField.setText(String.valueOf(tarjeta.getNumero()));
            limiteTextField.setText(String.valueOf(tarjeta.getLimite()));
            fechaTextField.setText(tarjeta.getFechaCorte());
            interesTextField.setText(String.valueOf(tarjeta.getInteres()));
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numeroTextField = new javax.swing.JTextField();
        limiteTextField = new javax.swing.JTextField();
        fechaTextField = new javax.swing.JTextField();
        interesTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero");

        jLabel2.setText("Limite");

        jLabel3.setText("Fecha Corte");

        jLabel4.setText("Interes");

        numeroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroTextFieldActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(numeroTextField)
                    .addComponent(limiteTextField)
                    .addComponent(fechaTextField)
                    .addComponent(interesTextField))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(limiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fechaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(interesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(validarCampos()){
           try{
           tarjeta = new Tarjeta(
                Integer.parseInt(numeroTextField.getText()),
                Double.parseDouble(limiteTextField.getText()),
                fechaTextField.getText(),
                Float.parseFloat(interesTextField.getText())
        );
           dispose();
      } catch(NumberFormatException e){
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
      }
     
       

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numeroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fechaTextField;
    private javax.swing.JTextField interesTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField limiteTextField;
    private javax.swing.JTextField numeroTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * Valida que todos los campos esten llenos.
     * 
     */
    
    private boolean validarCampos() {
        if(
           fechaTextField.getText().isEmpty()||
           interesTextField.getText().isEmpty()||
           limiteTextField.getText().isEmpty()||
           numeroTextField.getText().isEmpty()
           ){
            JOptionPane.showMessageDialog(null,"llena todos los campos "
                  );
            return false;
        }
        try{
        if(Integer.parseInt(fechaTextField.getText()) <= 0  ||
           Double.parseDouble(interesTextField.getText()) <= 0 ||
           Double.parseDouble(limiteTextField.getText()) <= 0 ||
           Integer.parseInt(numeroTextField.getText()) <= 0  ){
            JOptionPane.showMessageDialog(null,"Todos los campos deben ser númericos y maroyes que cero"
                  );
            return false;
        }
        } catch(NumberFormatException e){
          JOptionPane.showMessageDialog(this, e.getMessage());
            }
        
        return true;
      
           
                
                
         }

    /**
     *
     * @return
     */
    public Tarjeta getTarjeta(){
        return tarjeta;
    }
}