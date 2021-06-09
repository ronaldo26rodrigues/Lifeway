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
     * @return numMedidor
     */
    public String getNumMedidor() {
        return numMedidor;
    }
    /**
     * @param numMedidor  set numMedidor
     */
    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }

    /**
     * Equals: Consumidor (compara id, tipo e endereço)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Consumidor) {
            Consumidor param = (Consumidor) obj;
            if ( (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && param.getTipo().equals(this.getTipo())
                && param.getEndereco().equals(this.getEndereco()) ) {
                    resultado = true;
                }
        }
        return resultado;
    }


    /**
     * toString: Consumidor
     */
    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\n" + "Tipo: " + this.getTipo();
        resultado += "\n" + "Endereço: " + this.getEndereco();
        return resultado;
    }
    
}
