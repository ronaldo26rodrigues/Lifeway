package negocio;

import java.time.LocalDate;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Cliente;
import negocio.beans.Consumidor;
import negocio.beans.Endereco;
import negocio.beans.TipoConsumidor;

public class ControladorClientes {

    private IRepositorioGenerico<Cliente> repositorioClientes;
    private static ControladorClientes instance;

    private ControladorClientes(){
        this.repositorioClientes = new RepositorioGenerico<>();
    }

    public ControladorClientes getInstance(){
        if(instance == null){
            instance = new ControladorClientes();
        }
        return instance;
    }

    /**
     * @return the repositorioClientes
     */
    public IRepositorioGenerico<Cliente> getRepositorioClientes() {
        return repositorioClientes;
    }


    public Cliente criarCliente(String nome, String cpf, LocalDate dataNascimento){
        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento);
        
        try {
            repositorioClientes.inserir(novoCliente);
        } catch (Exception e) {
            return null;
        }
        return novoCliente;
    }

    public void removerCliente(String cpf){
        repositorioClientes.removerPorID(cpf);
    }

    public Consumidor adicionarConsumidorAoCliente(String cpfCliente, String idEmpresa, String numMedidor, TipoConsumidor tipo, Endereco endereco){
        Consumidor novoConsumidor = new Consumidor(numMedidor, idEmpresa, tipo, endereco);
        Cliente clienteSelecionado = repositorioClientes.buscarPorID(cpfCliente);
        try {
            clienteSelecionado.getRepositorioConsumidores().inserir(novoConsumidor);
        } catch (Exception e) {
            return null;
        }
        return novoConsumidor;
    }

    public void removerConsumidorDoCliente(String idCliente, String numMedidor){
        Cliente clienteSelecionado = repositorioClientes.buscarPorID(idCliente);
        clienteSelecionado.getRepositorioConsumidores().removerPorID(numMedidor);
    }
    
}
