package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa extends Identificavel {
    
    private String nome;
    // private String senha;
    // private String identificacao;
    private LocalDate dataNascimento;

    DateTimeFormatter meuFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construtor: Pessoa
     * @param nome
     * @param identificacao
     * @param dataNascimento
     */
    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        super(cpf);
        this. nome = nome;
        this.dataNascimento = dataNascimento;
    }


    //Getters & Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /* public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    } */

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

    // /**
    //  * Equals: Pessoa (compara id)
    //  */
    // @Override
    // public boolean equals(Object obj) {
    //     boolean resultado = false;
    //     if (obj instanceof Pessoa) {
    //         Pessoa param = (Pessoa) obj;
    //         if ( (param.getIdentificacao() != null) 
    //             && param.getIdentificacao().equals(this.getIdentificacao()) ) {
    //                 resultado = true;
    //             }
    //     }
    //     return resultado;
    // }

   
    /**
     * toString: Pessoa: nome, id, data de nascimento
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + super.toString();
        resultado += "\n" + "Nome: " + this.getNome();
        resultado += "\n" + "Data de Nascimento: " + this.getDataNascimento().format(meuFormatador);
        // resultado += "\n" + "Identificação: " + this.getIdentificacao();
        return resultado;
    }
     

}
