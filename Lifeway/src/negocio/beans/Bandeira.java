package negocio.beans;

import java.io.Serializable;

public class Bandeira implements Serializable{
    
    private double valor;
    private TipoBandeira tipoBandeira;
    
    public Bandeira(double valor, TipoBandeira tipoBandeira) {
        this.valor = valor;
        this.tipoBandeira = tipoBandeira;
    }

    // Getters & Setters

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoBandeira getTipoBandeira() {
        return tipoBandeira;
    }

    public void setTipoBandeira(TipoBandeira tipoBandeira) {
        this.tipoBandeira = tipoBandeira;
    }

    /**
     * ToString: Bandeira
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "Tipo de bandeira: " + this.getTipoBandeira();
        resultado += "\n" + "Valor: " + this.getValor();
        return resultado;
    }

}
