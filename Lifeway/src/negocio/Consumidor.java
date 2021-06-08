package negocio;

import java.time.LocalDate;

public class Consumidor extends Pessoa {

    private TipoConsumidor tipo;
    private Endereco endereco;
    private String numMedidor;

    /**
     * Construtor: Consumidor
     * @param nome
     * @param identificacao
     * @param dataNascimento
     * @param tipo
     * @param endereco
     */
    public Consumidor(String nome, String identificacao, LocalDate dataNascimento, TipoConsumidor tipo, Endereco endereco) {
        super(nome, identificacao, dataNascimento);
        this.tipo = tipo;
        this.endereco = endereco;
    }

    //Getters & Setters

    public TipoConsumidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsumidor tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    /**
     * @return the numMedidor
     */
    public String getNumMedidor() {
        return numMedidor;
    }
    /**
     * @param numMedidor the numMedidor to set
     */
    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }
    
    
}
