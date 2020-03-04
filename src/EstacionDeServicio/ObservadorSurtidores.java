/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SrDeLorean
 */
public class ObservadorSurtidores extends Observable implements Runnable{
    
    private int puerto;
    private DataInputStream dis;
    private DataOutputStream out;
    
    public ObservadorSurtidores(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        int port = 10012;
        try (ServerSocket listener = new ServerSocket(port)){
            System.out.println("Servidor iniciado y escuchando en el puerto " + port);
            while(true){
                Socket sc = listener.accept();
                System.out.println("Cliente " + sc.getRemoteSocketAddress() + " se ha conectado");
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                System.out.println(in.readUTF());
            }
        } catch (IOException ex) {
            Logger.getLogger(ObservadorSurtidores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
