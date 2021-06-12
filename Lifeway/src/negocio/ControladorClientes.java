package negocio;

import java.time.LocalDate;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Usuario;
import negocio.beans.Propriedade;
import negocio.beans.Endereco;
import negocio.beans.TipoPropriedade;

public class ControladorClientes {

    private IRepositorioGenerico<Usuario> repositorioClientes;
    private static ControladorClientes instance;

    private ControladorClientes(){
        this.repositorioClientes = new RepositorioGenerico<>();
    }

    public static ControladorClientes getInstance(){
        if(instance == null){
            instance = new ControladorClientes();
        }
        return instance;
    }

    /**
     * @return the repositorioClientes
     */
    public IRepositorioGenerico<Usuario> getRepositorioClientes() {
        return repositorioClientes;
    }


    public Usuario criarCliente(String nome, String cpf, LocalDate dataNascimento){
        Usuario novoCliente = new Usuario(nome, cpf, dataNascimento);
        
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

    public Propriedade adicionarConsumidorAoCliente(String cpfCliente, String idEmpresa, String numMedidor, TipoPropriedade tipo, Endereco endereco){
        Propriedade novoConsumidor = new Propriedade(numMedidor, tipo, endereco);
        Usuario clienteSelecionado = repositorioClientes.buscarPorID(cpfCliente);
        try {
            clienteSelecionado.getRepositorioConsumidores().inserir(novoConsumidor);
        } catch (Exception e) {
            return null;
        }
        return novoConsumidor;
    }

    public void removerConsumidorDoCliente(String idCliente, String numMedidor){
        Usuario clienteSelecionado = repositorioClientes.buscarPorID(idCliente);
        clienteSelecionado.getRepositorioConsumidores().removerPorID(numMedidor);
    }

    public List<Usuario> listarClientes(){
        return repositorioClientes.listar();
    }

    public List<Propriedade> listarConsumidoresDoCliente(String idCliente) {
        return repositorioClientes.buscarPorID(idCliente).getRepositorioConsumidores().listar();
    }

}
