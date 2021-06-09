package negocio;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Consumidor;

public class ControladorConsumidores {
    
    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    private static ControladorConsumidores instance;

    private ControladorConsumidores() {
        this.repositorioConsumidores = new RepositorioGenerico<>();
    }

    public ControladorConsumidores getInstance() {
        if (instance == null) {
            instance = new ControladorConsumidores();
        }
        return instance;
    }

    /**
     * @return the repositorioConsumidores
     */
    public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        return repositorioConsumidores;
    }
}
