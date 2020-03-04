/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import Surtidor.Surtidor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SrDeLorean
 */
public class EstacionDeServicio extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form EstacionDeServicioo
     */
    private ObservadorSucursal c;
    private ObservadorSurtidores e;
    
    private ConexionBD cn = new ConexionBD();
    private Connection con;
    private DefaultTableModel model;
    private Statement st;
    private ResultSet rs;
    
    public EstacionDeServicio() {
        initComponents();
        c = new ObservadorSucursal(5000);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
        e = new ObservadorSurtidores(6000);
        e.addObserver(this);
        Thread estacion = new Thread(e);
        estacion.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idSurtidor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        idSurtidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSurtidorActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar nuevo surtidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(idSurtidor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idSurtidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idSurtidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idSurtidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idSurtidorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Surtidor s;
        s = new Surtidor(Integer.parseInt(this.idSurtidor.getText()), this.listarPrecios());
        this.idSurtidor.setText("");
        JOptionPane.showMessageDialog(null, "operacion realizada con exito");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EstacionDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstacionDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstacionDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstacionDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstacionDeServicio().setVisible(true);
            }
        });
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        if (arg instanceof Precios) {
            Precios p = (Precios) arg;
            this.enviarListaDePreciosASurtidores(p);
            p.imprimirPrecios();
            this.agregarPrecios(p);
        }
        else{
            if (arg instanceof Compra) {
                Compra c = (Compra) arg;
                c.imprimirCompra();
//                //aca se crea la wea en la base de datos
            }
            else{
                 //code block
                System.out.println("F");
            
            }
        }
        
               
    }
    
    public Precios listarPrecios() {
       
        return null;
    }

    public void agregarPrecios(Precios p) {
        try {
            String sql = "insert into precios(b93,b95, b97, disel, kerosene) values('" + p.getB93() + "','" + p.getB95() + "','" + p.getB97() + "','" + p.getDisel() + "','" + p.getKerosene() + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Compra Registrada con Exito");
        } catch (Exception e) {
        }
    }
    
    public void agregarCompra(Compra c) {
        try {
            String sql = "insert into compras(idCompra,idSurtidor, tipoCombustible, litrosCargados, precioTotal) values('" + c.getIdsurtidor() + "','" + c.getTipoConbustible() + "','" + c.getLitrosCargados() + "','" + c.getPrecioTotal() + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Compra Registrada con Exito");
        } catch (Exception e) {
        }
    }

    private void enviarListaDePreciosASurtidores(Precios p) {
        String ip = "localhost";
        int port = 8000;
        try (Socket ss = new Socket(ip, port)) {
            DataOutputStream out = new DataOutputStream(ss.getOutputStream());
            out.writeDouble(p.getB93());
            out.writeDouble(p.getB95());
            out.writeDouble(p.getB97());
            out.writeDouble(p.getDisel());
            out.writeDouble(p.getKerosene());
        } catch (IOException ex) {
            Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idSurtidor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
