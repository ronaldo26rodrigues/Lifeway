package negocio;

import java.time.LocalDate;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Usuario;
import negocio.beans.Propriedade;
import negocio.beans.Cliente;
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


    public Usuario criarCliente(String nome, String identificavel, String senha, LocalDate dataNascimento){
        
        Usuario novoCliente = new Cliente(nome, identificavel, senha, dataNascimento);
        
        try {
            repositorioClientes.inserir(novoCliente);
        } catch (Exception e) {
            return null;
        }
        return novoCliente;
    }

    public void removerCliente(String cpf){
        repositorioClientes.remover(cpf);
    }

    public List<Usuario> listarClientes(){
        return repositorioClientes.listar();
    }




    //fica aqui ou em controlador propriedades?
    public Propriedade adicionarPropriedade(String cpfCliente, String idEmpresa, String numMedidor, TipoPropriedade tipo, Endereco endereco){
        Propriedade novaPropriedade = new Propriedade(numMedidor, tipo, endereco);
        Usuario clienteSelecionado = repositorioClientes.buscar(cpfCliente);
        try {
            clienteSelecionado.getRepositorioPropriedades().inserir(novaPropriedade);
        } catch (Exception e) {
            return null;
        }
        return novaPropriedade;
    }

    public void removerPropriedade(String idCliente, String numMedidor){
        Usuario clienteSelecionado = repositorioClientes.buscarPorID(idCliente);
        clienteSelecionado.getRepositorioPropriedades().removerPorID(numMedidor);
    }


    public List<Propriedade> listarPropriedadesDoCliente(String idCliente) {
        return repositorioClientes.buscarPorID(idCliente).getRepositorioPropriedades().listar();
    }

}
