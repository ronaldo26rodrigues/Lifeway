package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente extends Usuario {
    
    private LocalDate dataNascimento;
    //numero propriedades?

    DateTimeFormatter meuFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(String nome, String identificacao, String senha, LocalDate dataNascimento) {
        super(nome, identificacao, senha);
        this.dataNascimento = dataNascimento;
    }



    //Getters & Setters

    //chama o super?

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public DateTimeFormatter getMeuFormatador() {
        return meuFormatador;
    }

    public void setMeuFormatador(DateTimeFormatter meuFormatador) {
        this.meuFormatador = meuFormatador;
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
