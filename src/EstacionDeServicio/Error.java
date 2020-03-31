/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import java.util.Date;

/**
 *
 * @author SrDeLorean
 */
public class Error {
   
    private int id;
    private int idSurtidor;
    private int nIntentos;
    private Date fecha;
    
    //para transformar date a esa wea que tiene mysql
    //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    //System.out.println("Hora y fecha: "+hourdateFormat.format(fecha));
    public Error(int id, int idSurtidor, int nIntentos, Date fecha) {
        this.id = id;
        this.idSurtidor = idSurtidor;
        this.nIntentos = nIntentos;
        this.fecha= fecha;
    }
    
    public Error(int idSurtidor, int nIntentos) {
        this.idSurtidor = idSurtidor;
        this.nIntentos = nIntentos;
        this.fecha= new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSurtidor() {
        return idSurtidor;
    }

    public void setIdSurtidor(int idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public int getnIntentos() {
        return nIntentos;
    }

    public void setnIntentos(int nIntentos) {
        this.nIntentos = nIntentos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }  

}
