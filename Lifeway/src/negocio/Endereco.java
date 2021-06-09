package negocio;

public class Endereco {
    
    private String rua;
    private int numero;
    private String complemento;
    private String pontoDeReferencia;

    public Endereco() {

    }

    public Endereco(String rua, int numero){
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
        this.complemento = complemento;
        this.pontoDeReferencia = pontodeReferencia;
    }


    //Getters & Setters
    
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
        this.complemento = complemento;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }

    /**
     * toString: Endereço
     */
    @Override
    public String toString() {
        return "Rua: " + this.rua + 
        " | Número: " + this.numero + 
        " | Complemento: " + this.complemento + 
        " | Ponto de referência: " + this.pontoDeReferencia;
    }

    
}
