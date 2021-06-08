package negocio;

import java.time.LocalDate;

public class Conta {
    
    private LocalDate data;
    private double consumo;
    private double valor;

    public Conta(LocalDate data, double consumo, double valor){
        this.data = data;
        this.consumo = consumo;
        this.valor = valor;
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
    
}
