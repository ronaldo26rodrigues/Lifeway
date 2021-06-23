package negocio.beans;

public class Taxa {
    
    private double faixaDe;
    private double faixaAte;

    private double valor;
    private TipoPropriedade tipoPropriedade;
    private Bandeira bandeira;



    public Taxa(double faixaDe, double faixaAte, double valor, TipoPropriedade tipoPropriedade, Bandeira bandeira) {
        this.bandeira = bandeira;
        this.faixaAte = faixaAte;
        this.faixaDe = faixaAte;
        this.tipoPropriedade = tipoPropriedade;
        this.valor = valor;
    }



    /**
     * @return the bandeira
     */
    public Bandeira getBandeira() {
        return bandeira;
    }
    /**
     * @return the faixaAte
     */
    public double getFaixaAte() {
        return faixaAte;
    }
    /**
     * @return the faixaDe
     */
    public double getFaixaDe() {
        return faixaDe;
    }
    /**
     * @return the tipoPropriedade
     */
    public TipoPropriedade getTipoPropriedade() {
        return tipoPropriedade;
    }
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }
    
    /**
     * @param bandeira the bandeira to set
     */
    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
    /**
     * @param faixaAte the faixaAte to set
     */
    public void setFaixaAte(double faixaAte) {
        this.faixaAte = faixaAte;
    }
    /**
     * @param faixaDe the faixaDe to set
     */
    public void setFaixaDe(double faixaDe) {
        this.faixaDe = faixaDe;
    }
    /**
     * @param tipoPropriedade the tipoPropriedade to set
     */
    public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }
    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }


}
