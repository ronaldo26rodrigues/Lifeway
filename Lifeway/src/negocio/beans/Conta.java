package negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Conta implements Serializable {

    private String idConta;
    private Propriedade propriedade;
    private Empresa empresa;
    private LocalDate dataEmissao;
    private double consumo;
    private double valorTotal;
    private Taxa taxaAplicada;
    private LocalDate dataVencimento;
    private boolean paga;
    private LocalDate pagaEm;

    public Conta(Propriedade propriedade, Empresa empresa, LocalDate dataEmissao, double consumo, double valorTotal,
            Taxa taxaAplicada) {

        Random rng = new Random();

        this.idConta = "C" + rng.nextInt(1000) + rng.nextInt(1000);
        this.propriedade = propriedade;
        this.empresa = empresa;
        this.dataEmissao = dataEmissao;
        this.consumo = consumo;
        this.valorTotal = valorTotal;
        this.taxaAplicada = taxaAplicada;
        this.pagaEm = null;
    }

    // Getters & Setters

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the taxasAplicadas
     */
    public Taxa getTaxaAplicada() {
        return taxaAplicada;
    }

    /**
     * @param taxasAplicadas the taxasAplicadas to set
     */
    public void setTaxaAplicada(Taxa taxaAplicada) {
        this.taxaAplicada = taxaAplicada;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean setPaga(boolean paga) {
        this.paga = paga;
    }

    public boolean getPaga() {
        return paga;
    }

    public double calcularTotal() {
        double total = 0;
        return total;
    }

    public LocalDate getPagaEm() {
        return pagaEm;
    }

    public void setPagaEm(LocalDate pagaEm) {
        this.pagaEm = pagaEm;
    }

    /**
     * Método equals: Conta
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Conta) {
            Conta param = (Conta) obj;
            if ((param.getIdConta() != null) && param.getIdConta().equals(this.getIdConta())) {
                resultado = true;
            }
        }
        return resultado;
    }

    /**
     * toString: Conta
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "Propriedade: " + this.getPropriedade();
        resultado += "\n" + "Empresa: " + this.getEmpresa().getNome();
        resultado += "\n" + "Data de emissão: " + this.getDataEmissao();
        resultado += "\n" + "Data de vencimento: " + this.getDataVencimento();
        resultado += "\n" + "Consumo: " + this.getConsumo();
        resultado += "\n" + "Valor a pagar: " + this.getValorTotal();
        resultado += "\n" + "Status de pagamento: " + this.getPaga();
        return resultado;
    }

    public boolean validar() {
        return true;
    }
}
