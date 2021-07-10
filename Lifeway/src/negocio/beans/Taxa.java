package negocio.beans;

import java.io.Serializable;

public class Taxa implements Serializable {

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
        this.faixaDe = faixaDe;
        this.tipoPropriedade = tipoPropriedade;
        this.valor = valor;
        this.empresa = empresa;
        this.tipoTaxa = tipoTaxa;
    }

    // Geters & Setters

    public String getTipoTaxa() {
        return tipoTaxa;
    }

    public void setTipoTaxa(String tipoTaxa) {
        this.tipoTaxa = tipoTaxa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public double getFaixaAte() {
        return faixaAte;
    }

    public double getFaixaDe() {
        return faixaDe;
    }

    public TipoPropriedade getTipoPropriedade() {
        return tipoPropriedade;
    }

    public double getValor() {
        return valor;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public void setFaixaAte(double faixaAte) {
        this.faixaAte = faixaAte;
    }

    public void setFaixaDe(double faixaDe) {
        this.faixaDe = faixaDe;
    }

    public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado += "Empresa distribuidora: " + this.getEmpresa().getNome();
        resultado += "\n" + "Tipo de propriedade: " + getTipoPropriedade();
        resultado += "\n" + "De " + getFaixaDe() + " Até " + getFaixaAte();
        resultado += "\n" + "Valor: " + getValor();
        resultado += "\n" + "Bandeira " + getBandeira() + ": " + getBandeira().getValor();
        return resultado;
    }

}
