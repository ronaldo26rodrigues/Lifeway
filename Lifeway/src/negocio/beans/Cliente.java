package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    
    private LocalDate dataNascimento;
    private List<Propriedade> propriedades;

    //numero propriedades?

    DateTimeFormatter meuFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(String nome, String identificacao, String senha, LocalDate dataNascimento) {
        super(nome, identificacao, senha);
        this.dataNascimento = dataNascimento;

        this.propriedades = new ArrayList<>();
    }


    @Override
    public String getTipo() {
        return "CLIENTE";
    }

    //Getters & Setters

    

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }


    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }


    public DateTimeFormatter getMeuFormatador() {
        return meuFormatador;
    }

    public void setMeuFormatador(DateTimeFormatter meuFormatador) {
        this.meuFormatador = meuFormatador;
    }


    

    /**
    * Equals: Cliente (compara id)
    */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Cliente) {
            Cliente param = (Cliente) obj;
            if ( (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) ) {
                    resultado = true;
                }
        }
        return resultado;
     }

   
    /**
     * toString: Pessoa: nome, id, data de nascimento
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + super.toString();
        //resultado += "\n" + "Nome: " + this.getNome();
        resultado += "\n" + "Data de Nascimento: " + this.getDataNascimento().format(meuFormatador);
        // resultado += "\n" + "Identificação: " + this.getIdentificacao();
        resultado += "\n" + "Senha: " + this.getSenha(); //TESTE
        return resultado;
    }



     

}
