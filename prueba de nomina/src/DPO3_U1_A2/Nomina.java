/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPO3_U1_A2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author osiri
 */
public class Nomina extends javax.swing.JFrame {//Es el nombre de la clase

    String barra = File.separator;//Lo usamos para usar el separador SLASH
    
    String ubicacion = System.getProperty("user.dir")+barra+"Registros"+barra;//Creamos la ubicación donde se guarda el archivo
     
        
    public Nomina() {
        initComponents();
    }
    
    private void Crear(){//Método para crear el archivo
        String archivo = jTextNum.getText()+".txt";//Es la extensión del archivo así como el nombre que tendrá
        File crea_ubicacion = new File (ubicacion);
        File crea_archivo=new File (ubicacion+archivo);
        
        if(jTextNum.getText().equals("")){//Si se crea un archivo sin numero de empleado mandará un dialogo
            JOptionPane.showMessageDialog(rootPane, "No hay No de Empleado");
        }else{
            
            try{
             if(crea_archivo.exists()){//Si tratamos de ingresar o crear unn archivo ya existente nos marcará un dialogo
                JOptionPane.showMessageDialog(rootPane, "El archivo ya existe");
            }else{
                
                crea_ubicacion.mkdirs();//Los directorios en los que se guardara es decir del paquete
                Formatter crea = new Formatter(ubicacion+archivo);
                crea.format("%s\r\n%s\r\n%s", "No empleado ="+jTextNum.getText(),//lo que queremos que muestre
                        "Nombre ="+jTextName.getText(), "RFC ="+jTextRFC.getText());
                crea.close();
                JOptionPane.showMessageDialog(rootPane, "Archivo Creado");
                
            }
                           
            }catch (Exception e){
                JOptionPane.showMessageDialog(rootPane, "No fue posible crear el archivo");
            }
            

        }
        
    }

    private void Mostrar(){//Metodo para mostrar los datos en los cuadros de texto
        File url = new File(ubicacion+jTextNum.getText()+".txt");
        
        if(jTextNum.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Indique el numero de empleado");
        }else{
            if(url.exists()){//si existe entonces es necesario que muestre la informacion
                
                try{
                  
                    FileInputStream fis =new FileInputStream(url);
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
                    
                    jTextNum.setText(mostrar.getProperty("No Empleado"));
                    jTextName.setText(mostrar.getProperty("Nombre"));
                    jTextRFC.setText(mostrar.getProperty("RFC"));
                    
                }catch (Exception e){
                    
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El registro no es válido");//si se ingresa un no de empleado no registrado
            }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextNum = new javax.swing.JTextField();
        jTextName = new javax.swing.JTextField();
        jTextRFC = new javax.swing.JTextField();
        jbtnCrear = new javax.swing.JButton();
        jbtnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("No. Empleado");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 120, 120, 19);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setText("Nombre completo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 180, 150, 19);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setText("R.F.C.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 240, 90, 19);
        getContentPane().add(jTextNum);
        jTextNum.setBounds(290, 120, 213, 20);
        getContentPane().add(jTextName);
        jTextName.setBounds(290, 180, 213, 20);
        getContentPane().add(jTextRFC);
        jTextRFC.setBounds(290, 240, 213, 20);

        jbtnCrear.setText("Crear archivo");
        jbtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCrear);
        jbtnCrear.setBounds(210, 330, 97, 23);

        jbtnMostrar.setText("Mostrar");
        jbtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMostrar);
        jbtnMostrar.setBounds(420, 330, 69, 23);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setText("NOMINA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 20, 190, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/6a6af017f251ed81ccdc53caecab3bb2-fondo-de-vector-azul-minimalista.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 670, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMostrarActionPerformed
        Mostrar();//llamamos al metodo paraa el boton de mostrar
    }//GEN-LAST:event_jbtnMostrarActionPerformed

    private void jbtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearActionPerformed
        Crear();//llamamos al metodo para el boton de crear archivo
    }//GEN-LAST:event_jbtnCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextNum;
    private javax.swing.JTextField jTextRFC;
    private javax.swing.JButton jbtnCrear;
    private javax.swing.JButton jbtnMostrar;
    // End of variables declaration//GEN-END:variables
}
