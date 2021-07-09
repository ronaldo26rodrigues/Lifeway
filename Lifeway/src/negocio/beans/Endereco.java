package negocio.beans;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String rua;
    private int numero;
    private String complemento;
    private String pontoDeReferencia;

    public Endereco() {

    }

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = "nenhum";
        this.pontoDeReferencia = "nenhum";
    }

    public Endereco(String rua, int numero, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.pontoDeReferencia = "nenhum";
    }

    public Endereco(String rua, int numero, String complemento, String pontodeReferencia) {
        this.rua = rua;
        this.numero = numero;
        setComplemento(complemento);
        setPontoDeReferencia(pontoDeReferencia);
    }

    // Getters & Setters

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento == null || complemento.equals("")) {
            this.complemento = "nenhum";
        } else {
            this.complemento = complemento;
        }
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        if (pontoDeReferencia == null || pontoDeReferencia.equals("")) {
            this.pontoDeReferencia = "nenhum";
        } else {
            this.pontoDeReferencia = pontoDeReferencia;
        }
    }

    /**
     * toString: Endereço
     */
    @Override
    public String toString() {
        return "Rua: " + this.rua + "\nNúmero: " + this.numero + "\nComplemento: " + this.complemento
                + "\nPonto de referência: " + this.pontoDeReferencia;
    }

    /**
     *
     * Método equals: endereço
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Endereco) {
            Endereco param = (Endereco) obj;
            if (param.getRua().equals(this.getRua()) && param.getNumero() == this.getNumero()) {
                resultado = true;
            }
        }
        return resultado;
    }

}
