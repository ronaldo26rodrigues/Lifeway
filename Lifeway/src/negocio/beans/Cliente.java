package negocio.beans;

import java.time.LocalDate;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Cliente extends Pessoa {

    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    //private String cadastro;

    public Cliente(String nome, String cpf, LocalDate dataNascimento){
        super(nome, cpf, dataNascimento);
        repositorioConsumidores = new RepositorioGenerico<>();
    }

    /**
     * @return repositorioConsumidores
     */
    public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        return repositorioConsumidores;
    }
    
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

    @Override
    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    

}
