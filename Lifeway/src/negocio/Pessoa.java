package negocio;

import java.time.LocalDate;

public abstract class Pessoa {
    
    private String nome;
    private String identificacao;
    private LocalDate dataNascimento;

    /**
     * Construtor: Pessoa
     * @param nome
     * @param identificacao
     * @param dataNascimento
     */
    public Pessoa(String nome, String identificacao, LocalDate dataNascimento) {
        this. nome = nome;
        this.identificacao = identificacao;
        this.dataNascimento = dataNascimento;
    }


    //Getters & Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

}
