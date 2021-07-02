package negocio.beans;

import java.io.Serializable;

public enum Bandeira {

    VERDE, AMARELA, VERMELHA;

    private float valor;

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

}
