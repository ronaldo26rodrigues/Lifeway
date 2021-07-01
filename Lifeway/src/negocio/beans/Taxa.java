package negocio.beans;

public class Taxa {

    private double faixaDe;
    private double faixaAte;

    private double valor;
    private String tipoTaxa;
    private TipoPropriedade tipoPropriedade;
    private Bandeira bandeira;
    private Empresa empresa;

    public Taxa(double faixaDe, double faixaAte, double valor, String tipoTaxa, TipoPropriedade tipoPropriedade,
            Bandeira bandeira, Empresa empresa) {
        this.bandeira = bandeira;
        this.faixaAte = faixaAte;
        this.faixaDe = faixaAte;
        this.tipoPropriedade = tipoPropriedade;
        this.valor = valor;
        this.empresa = empresa;
        this.tipoTaxa = tipoTaxa;
    }

    // Geters & Setters

    /**
     * 
     * @return descrição/tipo de taxa
     */
    public String getTipoTaxa() {
        return tipoTaxa;
    }

    /**
     * 
     * @param tipoTaxa descrição/tipo de taxa
     */
    public void setTipoTaxa(String tipoTaxa) {
        this.tipoTaxa = tipoTaxa;
    }

    /**
     * 
     * @return empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * 
     * @param empresa
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return bandeira
     */
    public Bandeira getBandeira() {
        return bandeira;
    }

    /**
     * @return faixaAte (limite máximo da faixa)
     */
    public double getFaixaAte() {
        return faixaAte;
    }

    /**
     * @return faixaDe (limite mínimo da faixa)
     */
    public double getFaixaDe() {
        return faixaDe;
    }

    /**
     * @return tipoPropriedade
     */
    public TipoPropriedade getTipoPropriedade() {
        return tipoPropriedade;
    }

    /**
     * @return valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param bandeira
     */
    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    /**
     * @param faixaAte (limite máximo da faixa)
     */
    public void setFaixaAte(double faixaAte) {
        this.faixaAte = faixaAte;
    }

    /**
     * @param faixaDe (limite mínimo da faixa)
     */
    public void setFaixaDe(double faixaDe) {
        this.faixaDe = faixaDe;
    }

    /**
     * @param tipoPropriedade
     */
    public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }

    /**
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

}
