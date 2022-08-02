package ifpr.pgua.eic.tvs.tdd.models;

public class Lance {

    private String comprador;
    private double valor;
    
    public Lance(String comprador, double valor) {
        this.comprador = comprador;
        this.valor = valor;
    }
    
    public String getComparador() {
        return comprador;
    }
    public void setComparador(String comprador) {
        this.comprador = comprador;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    } 
}
