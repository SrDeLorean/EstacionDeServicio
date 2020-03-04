package EstacionDeServicio;

/**
 *
 * @author SrDeLorean
 */
public class Compra {
    
    private int id;
    private int idsurtidor;
    private String tipoConbustible;
    private double litrosCargados;
    private int precioTotal;

    public Compra(int id, int idsurtidor, String tipoConbustible, double litrosCargados, int precioTotal) {
        this.id = id;
        this.idsurtidor = idsurtidor;
        this.tipoConbustible = tipoConbustible;
        this.litrosCargados = litrosCargados;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsurtidor() {
        return idsurtidor;
    }

    public void setIdsurtidor(int idsurtidor) {
        this.idsurtidor = idsurtidor;
    }

    public String getTipoConbustible() {
        return tipoConbustible;
    }

    public void setTipoConbustible(String tipoConbustible) {
        this.tipoConbustible = tipoConbustible;
    }

    public double getLitrosCargados() {
        return litrosCargados;
    }

    public void setLitrosCargados(double litrosCargados) {
        this.litrosCargados = litrosCargados;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
