package negocio.beans;

public class TaxaFixa {
    private double maximo;
    private double valorFixo;

    public TaxaFixa(double maximo, double valorFixo){
        this.maximo = maximo;
        this.valorFixo = valorFixo;
    }

    /**
     * @return the maximo
     */
    public double getMaximo() {
        return maximo;
    }
    /**
     * @return the valorFixo
     */
    public double getValorFixo() {
        return valorFixo;
    }
    /**
     * @param maximo the maximo to set
     */
    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }
    /**
     * @param valorFixo the valorFixo to set
     */
    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

}
