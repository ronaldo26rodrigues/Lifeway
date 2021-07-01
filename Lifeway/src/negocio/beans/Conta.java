package negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String idConta;
    private Cliente cliente;
    private Empresa empresa;
    private LocalDate dataEmissao;
    private double consumo;
    private double valorTotal;
    private List<Taxa> taxasAplicadas;
    private LocalDate dataVencimento;

    private boolean paga;

    public Conta(String idConta, Cliente cliente, Empresa empresa, LocalDate dataEmissao, double consumo,
            double valorTotal) {
        this.idConta = idConta;
        this.cliente = cliente;
        this.empresa = empresa;
        this.dataEmissao = dataEmissao;
        this.consumo = consumo;
        this.valorTotal = valorTotal;

        this.taxasAplicadas = new ArrayList<>();
    }

    // Getters & Setters

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    public List<Taxa> getTaxasAplicadas() {
        return taxasAplicadas;
    }

    /**
     * @param taxasAplicadas the taxasAplicadas to set
     */
    public void setTaxasAplicadas(List<Taxa> taxasAplicadas) {
        this.taxasAplicadas = taxasAplicadas;
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

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public boolean getPaga() {
        return paga;
    }

    public double calcularTotal() {
        double total = 0;
        // TODO
        return total;
    }

    /**
     * toString: Conta
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Cliente: " + this.getCliente().getNome();
        resultado += "\n" + "Empresa: " + this.getEmpresa().getNome();
        resultado += "\n" + "Data de emissão: " + this.getDataEmissao();
        resultado += "\n" + "Data de vencimento: " + this.getDataVencimento();
        resultado += "\n" + "Consumo: " + this.getConsumo();
        resultado += "\n" + "Valor a pagar: " + this.getValorTotal();
        resultado += "\n" + "Status de pagamento: " + this.getPaga();
        return resultado;
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }
}
