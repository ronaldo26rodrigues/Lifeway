package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public abstract class Usuario {

    private IRepositorioGenerico<Propriedade> repositorioPropriedades;

    private String nome;
    private String identificacao;
    private String senha;
    private LocalDate dataDeNascimeto;


    public Usuario(String nome, String identificacao, String senha, LocalDate dataDeNascimeto){
        this.nome = nome;
        this.identificacao = identificacao;
        this.senha = senha;
        this.dataDeNascimeto = dataDeNascimeto;

        repositorioPropriedades = new RepositorioGenerico<>();
    }


    // Método abstrato getTipo
    public abstract String getTipo();


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



    //Validar CPF
    


    /**
     * Equals: Usuário
     */

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if(obj instanceof Usuario) {
            Usuario param = (Usuario) obj;
            if( (param.getIdentificacao() != null) 
            && param.getIdentificacao().equals(this.getIdentificacao()) ) {
                resultado = true;
            }
        }   
        return resultado;
    }

    /**
     * toString: Usuario
     */
    @Override
    public String toString() {

        DateTimeFormatter meuFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado = "";
        resultado += "Nome: " + this.getNome();
        resultado += "\n" + "Data de Nascimento: " + this.getDataDeNascimeto().format(meuFormatador);
        resultado += "\n" + "ID: " + this.getIdentificacao();
        return resultado;
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }


    //Getters & Setters
    public LocalDate getDataDeNascimeto() {
        return dataDeNascimeto;
    }
    public void setDataDeNascimeto(LocalDate dataDeNascimeto) {
        this.dataDeNascimeto = dataDeNascimeto;
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
