package negocio.beans;

import java.time.LocalDate;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public abstract class Usuario {

    private IRepositorioGenerico<Propriedade> repositorioPropriedades;
    //private String cadastro;
    private String nome;
    private String identificacao;
    private String senha;
    //private LocalDate dataNascimento;
    //private String id;

    public Usuario(String nome, String identificacao, String senha){
        this.nome = nome;
        this.identificacao = identificacao;
        this.senha = senha;

        repositorioPropriedades = new RepositorioGenerico<>();
    }

    /**
     * @return repositorioConsumidores
     */
    //public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        //return repositorioConsumidores;
    //}
    
    // /**
    //  * @return cadastro
    //  */
    // public String getCadastro() {
    //     return cadastro;
    // }
    // /**
    //  * @param cadastro set cadastro
    //  */
    // public void setCadastro(String cadastro) {
    //     this.cadastro = cadastro;
    // }


    //equals cliente

    /**
     * toString: Cliente ???
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + super.toString() /* "Cadastro: " + this.getCadastro() */; 
        return resultado;
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    public IRepositorioGenerico<Propriedade> getRepositorioPropriedades() {
        return repositorioPropriedades;
    }

    public void setRepositorioPropriedades(IRepositorioGenerico<Propriedade> repositorioPropriedades) {
        this.repositorioPropriedades = repositorioPropriedades;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}
