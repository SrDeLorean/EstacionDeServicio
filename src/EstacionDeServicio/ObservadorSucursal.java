/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SrDeLorean
 */
public class ObservadorSucursal implements Runnable{

    private int puerto;
    
    public ObservadorSucursal(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor=null;
        Socket sc= null;
        DataInputStream inSocket;
        DataOutputStream outSocket;
        try{
            
            servidor = new ServerSocket(puerto, 128, InetAddress.getByName("192.168.0.2"));
            System.out.println(servidor.getInetAddress());
            InetSocketAddress a = new InetSocketAddress(InetAddress.getByName("192.168.0.2"), puerto);
            //servidor.bind(a, puerto);
            System.out.println(servidor.getInetAddress().getHostAddress());
            while(true){
                sc = servidor.accept();
                inSocket = new DataInputStream(sc.getInputStream());
                outSocket= new DataOutputStream(sc.getOutputStream()); 
                System.out.println(inSocket.readUTF());
                outSocket.writeUTF("fuerte y claro");
                inSocket.close();
                outSocket.close();
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ObservadorSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    private void actualizarPrecios() throws IOException, ClassNotFoundException{
        while (true) {
            int largo = dis.readInt();
            byte[] bytes= new byte[largo];
            for(int i=0; i<largo; i++){
                bytes[i]=dis.readByte();
            }
            ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
            ObjectInputStream is = new ObjectInputStream(bs);
            Precios precios = (Precios)is.readObject();
            is.close();
        }
    }
    */
    private void enviarTransacciones(){
        while (true) {
            
        }
    }
}

