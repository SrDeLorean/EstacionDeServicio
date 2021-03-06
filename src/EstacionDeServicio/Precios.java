package EstacionDeServicio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SrDeLorean
 */
public class Precios implements Serializable{
    
    private double b93;
    private double b95;
    private double b97;
    private double disel;
    private double kerosene;
    private Date fecha;

    public Precios(double b93, double b95, double b97, double disel, double kerosene) {
        this.b93 = b93;
        this.b95 = b95;
        this.b97 = b97;
        this.disel = disel;
        this.kerosene = kerosene;
        this.fecha=new Date();
    }
    
    public Precios(double b93, double b95, double b97, double disel, double kerosene, Date fecha) {
        this.b93 = b93;
        this.b95 = b95;
        this.b97 = b97;
        this.disel = disel;
        this.kerosene = kerosene;
        this.fecha= fecha;
    }

    public double getB93() {
        return b93;
    }

    public double getB95() {
        return b95;
    }

    public double getB97() {
        return b97;
    }
    
    public double getDisel() {
        return disel;
    }

    public double getKerosene() {
        return kerosene;
    }
    
    @Override
    public String toString(){
        String s = this.b93+"/"+this.b95+"/"+this.b97+"/"+this.disel+"/"+this.kerosene;
        return s;
    }
    
    public void imprimirPrecios(){
        System.out.println("Precios");
        System.out.println(b93);
        System.out.println(b95);
        System.out.println(b97);
        System.out.println(disel);
        System.out.println(kerosene);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
