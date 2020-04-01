/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author SrDeLorean
 */
public class enviarDatosGoogle implements Runnable{

    private EstacionDeServicio papa;
    private Compra c;
    private int idEstacion;
    private int id;
    public enviarDatosGoogle(EstacionDeServicio papa, Compra c, int idEstacion, int id){
        this.papa=papa;
        this.c=c;
        this.idEstacion=idEstacion;
        this.id=id;
    }
    
    
    @Override
    public void run() {
        while (true){
            papa.setConexionBDGoogleCloud(new ConexionBDGoogleCloud());
            try {
                java.sql.Date sqlDate = new java.sql.Date(c.getFecha().getTime());
                String sql = "insert into compras(idSucursal, idCompra, idSurtidor, tipoConbustible, litrosCargados, precioTotal, fecha) values('" + this.idEstacion + "','" + id + "','" + c.getIdsurtidor() + "','" + c.getTipoConbustible() + "','" + c.getLitrosCargados() + "','" + c.getPrecioTotal() + "','" + sqlDate + "')";
                Connection con = papa.getConexionBDGoogleCloud().getConnection();
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                return;
            } catch (Exception e) {

            }
        }
    }
    
}
