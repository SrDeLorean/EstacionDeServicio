package EstacionDeServicio;

import java.io.Serializable;

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

    public Precios(double b93, double b95, double b97, double disel, double kerosene) {
        this.b93 = b93;
        this.b95 = b95;
        this.b97 = b97;
        this.disel = disel;
        this.kerosene = kerosene;
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
}
