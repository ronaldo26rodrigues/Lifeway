package negocio.controle;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import jdk.vm.ci.code.RegisterAttributes;
import negocio.beans.RegistroDeOcorrencia;

public class ControladorRO {

    private static ControladorRO instance;
    

    private IRepositorioGenerico<RegistroDeOcorrencia> repositorioRO;

    private ControladorRO() {
        repositorioRO = new RepositorioGenerico<>();
    }

    public static ControladorRO getInstance() {
        if(instance == null) {
            instance = new ControladorRO();
        }
        return instance;
    }

    public void criarNovaOcorrencia() {
        
    }

}
