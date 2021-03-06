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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    private ConexionBDGoogleCloud conexionBDGoogleCloud = new ConexionBDGoogleCloud();
    private ConexionBD cn = new ConexionBD();
    private Connection con;
    private DefaultTableModel model;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Surtidor> surtidores;
    private Thread hiloEscuchandoSurtidores;
    private int idEstacion=1;
    
    public EstacionDeServicio() {
        initComponents();
        this.surtidores = new ArrayList<>();
        c = new ObservadorSucursal(5000,this);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
        e = new ObservadorSurtidores(10012);
        e.addObserver(this);
        hiloEscuchandoSurtidores = new Thread(e);
        hiloEscuchandoSurtidores.start();
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
        jLabel3 = new javax.swing.JLabel();
        puerto = new javax.swing.JTextField();
        reiniciar = new javax.swing.JButton();
        detener = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nuevosPrecios = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

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

        jLabel3.setText("Puerto");

        reiniciar.setText("Reiniciar");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });

        detener.setText("Detener");
        detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerActionPerformed(evt);
            }
        });

        jLabel4.setText("Escuchar surtidores");

        nuevosPrecios.setText("Nuevos Precios");
        nuevosPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevosPreciosActionPerformed(evt);
            }
        });

        jLabel5.setText("Cambiar precio E.S");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton1)))
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idSurtidor, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(puerto))
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevosPrecios)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(reiniciar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(detener, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reiniciar)
                    .addComponent(nuevosPrecios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detener)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idSurtidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idSurtidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idSurtidorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Surtidor s;
        s = new Surtidor(Integer.parseInt(this.idSurtidor.getText()), this.listarPrecios(), Integer.parseInt(this.puerto.getText()));
        this.surtidores.add(s);
        this.idSurtidor.setText("");
        this.puerto.setText("");
        JOptionPane.showMessageDialog(null, "operacion realizada con exito");
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        // TODO add your handling code here:
        e = new ObservadorSurtidores(10012);
        e.addObserver(this);
        hiloEscuchandoSurtidores = new Thread(e);
        hiloEscuchandoSurtidores.start();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void detenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerActionPerformed

        // TODO add your handling code here:
        hiloEscuchandoSurtidores.stop();

    }//GEN-LAST:event_detenerActionPerformed

    private void nuevosPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevosPreciosActionPerformed
        // TODO add your handling code here:
        Precios p = this.listarPreciosGoogleCloud();
        this.enviarListaDePreciosASurtidores(p);
        p.imprimirPrecios();
        this.agregarPrecios(p);
    }//GEN-LAST:event_nuevosPreciosActionPerformed

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
                this.agregarCompra(c);

            }if (arg instanceof Error) {
                Error c = (Error) arg;
                this.agregarError(c);
            }
        }
        
               
    }
    
    public ArrayList listarCompras(String tipoCombustible) throws SQLException {
        
        String sql = "select * from compras where tipoCombustible = "+tipoCombustible;
        ArrayList<Compra> array = new ArrayList<>();
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Compra compra = new Compra(rs.getInt("idCompra"),rs.getInt("idSurtidor"),rs.getString("tipoCombustible"),rs.getDouble("litrosCargados"),rs.getInt("precioTotal"), rs.getDate("fecha"));
                array.add(compra);
            }

           
        } catch (Exception e) {
            //algo
        }
        
        return array;

    }
    
        public void agregarCompra(Compra c) {
        int id=-1;
        try {
            java.sql.Date sqlDate = new java.sql.Date(c.getFecha().getTime());
            String sql = "insert into compras(idSurtidor, tipoCombustible, litrosCargados, precioTotal, fecha) values('" + c.getIdsurtidor() + "','" + c.getTipoConbustible() + "','" + c.getLitrosCargados() + "','" + c.getPrecioTotal() + "','" + sqlDate + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                id=rs.getInt(1);
                System.out.println("id:" + id);
            }
        } catch (Exception e) {
            System.out.println("Falla en agregar compra");
            System.out.println(e);
        }
        if(id==-1){
            System.out.println("error");
            return;
        }
        enviarDatosGoogle a = new enviarDatosGoogle(this, c, idEstacion, id);
        Thread t = new Thread(a);
        t.start();
    }

    private void enviarListaDePreciosASurtidores(Precios p) {
        String ip = "localhost";
        for (int i = 0; i < this.surtidores.size(); i++) {
            try (Socket ss = new Socket(ip, this.surtidores.get(i).getPuerto())) {
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detener;
    private javax.swing.JTextField idSurtidor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton nuevosPrecios;
    private javax.swing.JTextField puerto;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables

    private Precios listarPrecios() {
        //String sql = "SELECT b93,b95,b97,disel,kerosene FROM precios WHERE id = (select MAX(id) FROM precios);";
        String sql = "Select * from precios";
        Precios p = null;
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                p = new Precios(rs.getDouble("b93"),rs.getDouble("b95"),rs.getDouble("b97"),rs.getDouble("disel"),rs.getDouble("kerosene"));
            }

           
        } catch (Exception e) {
            //algo
        }
        
        
        return p;
    }

    public void agregarPrecios(Precios p) {
        try {
            java.sql.Date sqlDate = new java.sql.Date(p.getFecha().getTime());
            String sql = "insert into precios(b93,b95, b97, disel, kerosene, fecha) values('" + p.getB93() + "','" + p.getB95() + "','" + p.getB97() + "','" + p.getDisel() + "','" + p.getKerosene() + "','" + sqlDate + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Falla en agregar precio");
            System.out.println(e);
        }
    }

    public double getLitrosConsumidos(String tipoCombustible) {   
        String sql = "select SUM(litrosCargados) as tabla from compras where tipoCombustible = "+tipoCombustible;
        double litros =0;
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                litros = rs.getDouble("tabla");
            }
            

        } catch (Exception e) {
            //algo
            System.out.println(e);
        }
        
        return litros;
    }

    public int getCantidadDeCargas(String tipoCombustible) {
        String sql = "select COUNT(idCompra) as tabla from compras where tipoCombustible = "+tipoCombustible;
        int cantidadDeCarga = 0;
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                cantidadDeCarga = rs.getInt("tabla");
            }
            

        } catch (Exception e) {
            //algo
            System.out.println(e);
        }
        return cantidadDeCarga;
    }

    /**
     * Milla haste cargo
     * @param c 
     */
    private void agregarError(Error c) {
        try {
            java.sql.Date sqlDate = new java.sql.Date(c.getFecha().getTime());
            String sql = "insert into errores(idSurtidor, nIntentos, fecha) values('" + c.getIdSurtidor() + "','" + c.getnIntentos() + "','" + sqlDate + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Falla en agregar error");
            System.out.println(e);
        }
    }
    
    private Precios listarPreciosGoogleCloud() {
        //String sql = "SELECT b93,b95,b97,disel,kerosene FROM precios WHERE id = (select MAX(id) FROM precios);";
        String sql = "Select * from precios where idSucursal=" + this.idEstacion;
        Precios precio = null;
        try {
            con = conexionBDGoogleCloud.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                precio = new Precios(rs.getDouble("b93"),rs.getDouble("b95"),rs.getDouble("b97"),rs.getDouble("diesel"),rs.getDouble("kerosene"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return precio;
    }

    public ObservadorSucursal getC() {
        return c;
    }

    public ObservadorSurtidores getE() {
        return e;
    }

    public ConexionBDGoogleCloud getConexionBDGoogleCloud() {
        return conexionBDGoogleCloud;
    }

    public ConexionBD getCn() {
        return cn;
    }

    public Connection getCon() {
        return con;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public Statement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public ArrayList<Surtidor> getSurtidores() {
        return surtidores;
    }

    public Thread getHiloEscuchandoSurtidores() {
        return hiloEscuchandoSurtidores;
    }

    public int getIdEstacion() {
        return idEstacion;
    }

    public JButton getDetener() {
        return detener;
    }

    public JTextField getIdSurtidor() {
        return idSurtidor;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JButton getNuevosPrecios() {
        return nuevosPrecios;
    }

    public JTextField getPuerto() {
        return puerto;
    }

    public JButton getReiniciar() {
        return reiniciar;
    }

    public void setConexionBDGoogleCloud(ConexionBDGoogleCloud conexionBDGoogleCloud) {
        this.conexionBDGoogleCloud = conexionBDGoogleCloud;
    }

    
    
}
