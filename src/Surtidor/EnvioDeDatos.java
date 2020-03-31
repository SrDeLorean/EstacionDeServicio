/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Surtidor;

import EstacionDeServicio.Precios;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SrDeLorean
 */
public class EnvioDeDatos implements Runnable{

    private Surtidor papa;

    public EnvioDeDatos(Surtidor papa) {
        this.papa = papa;
    }
    
    @Override
    public void run() {
        if (!papa.getCantidadDeCarga().getText().isEmpty() ) {
            if (papa.isNumeric(papa.getCantidadDeCarga().getText())) {
                int contador=1;
                DataOutputStream out;
                Socket ss;
                while(true){
                    try {
                        papa.getMensajeDeError().setText("Conectando con el servidor");
                        String ip = "localhost";
                        SocketAddress sa = new InetSocketAddress(ip, papa.getPort());
                        ss = new Socket();
                        if(ss.isConnected()){
                            break;
                        }
                        try {
                            ss.connect(sa);
                        } catch (IOException ex) {
                        }
                        if(ss.isConnected()){
                            break;
                        }
                        papa.getMensajeDeError().setText("error en la conexion, intentando nuevamente");
                        Thread.sleep(2000);
                        contador+=1;
                        papa.getMensajeDeError().setText("Intentando nuevamente");
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    
                }
                try {
                    out = new DataOutputStream(ss.getOutputStream());
                    out.writeInt(contador);
                    out.writeInt(papa.getId());
                    out.writeUTF(papa.getjComboBox1().getItemAt(papa.getjComboBox1().getSelectedIndex()));
                    out.writeDouble(Double.parseDouble(papa.getCantidadDeCarga().getText()));
                    Double a = Double.parseDouble(papa.getTotalAPagar().getText());
                    int value = (int)Math.round(a);
                    out.writeInt(value);
                    papa.getMensajeDeError().setText("");
                    JOptionPane.showMessageDialog(null, "La boleta fue generada satisfactoriamente", "Boleta", JOptionPane.INFORMATION_MESSAGE);
                    papa.getCantidadDeCarga().setText("");
                    papa.getjComboBox1().setSelectedIndex(0);
                    papa.getTotalAPagar().setText("0");
                    papa.getValorPorLitro().setText(Double.toString(papa.getPrecios().getB93()));
                    ss.close();
                    } catch (IOException ex) {
                    Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La cantidad de carga debe ser numerica", "Error cantidad de carga", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes generar una boleta vacia", "Boleta vacia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
