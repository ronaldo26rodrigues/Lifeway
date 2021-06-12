package negocio.beans;

import java.time.LocalDate;

public class Conta {
    
    private String idConta;
    private LocalDate data;
    private double consumo;
    private double valor;

    private boolean paga;

    public Conta(String idConta, LocalDate data, double consumo, double valor){
        this.idConta = idConta;
        this.data = data;
        this.consumo = consumo;
        this.valor = valor;
    }


    

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    /**
     * @return the consumo
     */
    public double getConsumo() {
        return consumo;
    }
    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }
    /**
     * @param consumo the consumo to set
     */
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @param paga the paga to set
     */
    public void setPaga(boolean paga) {
        this.paga = paga;
    }
    public boolean getPaga(){
        return paga;
    }

    
    public double calcularTotal() {
        double total = 0;
        //TODO
        return total;   
    }

    /**
     * toString: Conta
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Data: " + this.getData();
        resultado += "\n" + "Consumo: " + this.getConsumo();
        resultado += "\n" + "Valor: " + this.getValor();
        resultado += "\n" + "Paga: " + this.getPaga();
        return resultado;
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }
}
