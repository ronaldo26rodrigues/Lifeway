package negocio;

import dados.IRepositorioGenerico;

public class Cliente {

    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    private String cadastro;

    /**
     * @return repositorioConsumidores
     */
    public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        return repositorioConsumidores;
    }
    /**
     * @return cadastro
     */
    public String getCadastro() {
        return cadastro;
    }
    /**
     * @param cadastro set cadastro
     */
    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }


    //equals cliente

    /**
     * toString: Cliente ???
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Cadastro: " + this.getCadastro();
        return resultado;
    }

}
