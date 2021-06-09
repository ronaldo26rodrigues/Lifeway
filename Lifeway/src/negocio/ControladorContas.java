package negocio;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Conta;

public class ControladorContas {
    
    private IRepositorioGenerico<Conta> repositorioContas;
    private static ControladorContas instance;

    private ControladorContas() {
        this.repositorioContas = new RepositorioGenerico<>();
    }

    public ControladorContas getInstance() {
        if (instance == null) {
            instance = new ControladorContas();
        }
        return instance;
    }


    //método para emitir conta (por data, empresa, consumidor e ???)
    //public Conta emitirConta(Consumidor c, Empresa e, LocalDate data)

    public List<Conta> listar() {
        return repositorioContas.listar();
    }
}
