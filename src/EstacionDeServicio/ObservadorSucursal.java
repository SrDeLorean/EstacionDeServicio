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
public class ObservadorSucursal extends Observable implements Runnable{

    private int puerto;
    private ServerSocket servidor;
    private Socket sc;
    private DataInputStream inSocket;
    private DataOutputStream outSocket;
    
    public ObservadorSucursal(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try{
            servidor = new ServerSocket(puerto);
            while(true){
                sc = servidor.accept();
                inSocket = new DataInputStream(sc.getInputStream());
                outSocket= new DataOutputStream(sc.getOutputStream()); 
                switch(inSocket.readInt()) {
                    case 1:
                        // code block
                        actualizarPrecios();
                        break;
                    case 2:
                        enviarTransacciones();
                        break;
                    default:
                        // code block
                        System.out.println("F");
                  }
                inSocket.close();
                outSocket.close();
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ObservadorSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void actualizarPrecios() throws IOException{
        double b93 = inSocket.readDouble();
        double b95 = inSocket.readDouble();
        double b97 = inSocket.readDouble();
        double disel = inSocket.readDouble();
        double kerosene = inSocket.readDouble();
        this.setChanged();
        this.notifyObservers("actualizarPrecios");
        this.clearChanged();
        Precios precios = new Precios(b93,b95,b97,disel,kerosene);
        this.setChanged();
        this.notifyObservers(precios);
        this.clearChanged();
    }
  
    private void enviarTransacciones() throws IOException{
        int idSucursal = inSocket.readInt();
        String tipoCombustible = inSocket.readUTF();
        
    }
}

