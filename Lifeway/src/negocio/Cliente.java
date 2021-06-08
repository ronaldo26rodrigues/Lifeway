package negocio;

import dados.IRepositorioGenerico;

public class Cliente {
    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    private String cadastro;

    /**
     * @return the repositorioConsumidores
     */
    public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        return repositorioConsumidores;
    }
    /**
     * @return the cadastro
     */
    public String getCadastro() {
        return cadastro;
    }
    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

}
