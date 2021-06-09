package negocio;

import java.time.LocalDate;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoJaExisteException;
import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Funcionario;

public class ControladorEmpresas {
    
    private IRepositorioGenerico<Empresa> repositorioEmpresas;
    private static ControladorEmpresas instance;

    private ControladorEmpresas() {
        this.repositorioEmpresas = new RepositorioGenerico<>();
    }

    public ControladorEmpresas getInstance() {
        if(instance == null) {
            instance = new ControladorEmpresas();
        }

        return instance;
    }

    /**
     * @return the repositorioEmpresas
     */
    public IRepositorioGenerico<Empresa> getRepositorioEmpresas() {
        return repositorioEmpresas;
    }

    private Empresa selecionarEmpresa(String idEmpresa){
        return repositorioEmpresas.buscarPorID(idEmpresa);
    }

    //@Override
    // public void inserir(Empresa obj) throws ObjetoJaExisteException {
    //     repositorioEmpresas.inserir(obj);
    // }

    //@Override
    //public void remover(Empresa obj) throws ObjetoNaoExisteException {

    //}

    public Empresa criarEmpresa(String idEmpresa, String nome, String servico){
        Empresa novaEmpresa = new Empresa(idEmpresa, nome, servico);
        try {
            repositorioEmpresas.inserir(novaEmpresa);
        } catch (Exception e) {
            return null;
        }
        return novaEmpresa;
    }
    public void removerEmpresa(String idEmpresa){
        repositorioEmpresas.removerPorID(idEmpresa);
    }

    public Funcionario criarFuncionarioNaEmpresa(String empresa, String cpf, String nome, LocalDate dataNascimento, String cargo){
        Funcionario novoFuncionario = new Funcionario(nome, cpf, dataNascimento, cargo);
        Empresa empresaSelecionada = selecionarEmpresa(empresa);

        try {
            empresaSelecionada.getRepositorioFuncionarios().inserir(novoFuncionario);
        } catch (Exception e) {
            return null;
        }
        return novoFuncionario;
    }

    public void removerFuncionarioNaEmpresa(String idEmpresa, String idFuncionario){
        Empresa empresaSelecionada = selecionarEmpresa(idEmpresa);
        empresaSelecionada.getRepositorioFuncionarios().removerPorID(idFuncionario);
    }

    /* public Cliente criarClienteNaEmpresa(String idEmpresa, String nome, String cpf, LocalDate dataNascimento){
        Empresa empresaSelecionada = selecionarEmpresa(idEmpresa);
        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento);
        try {
            empresaSelecionada.getRepositorioClientes().inserir(novoCliente);
        } catch (Exception e) {
            return null;
        }
        return novoCliente;
    }

    public void removerClienteDaEmpresa(String idEmpresa, String idCliente){
        Empresa empresaSelecionada = selecionarEmpresa(idEmpresa);
        empresaSelecionada.getRepositorioClientes().removerPorID(idCliente);
    } */


}
