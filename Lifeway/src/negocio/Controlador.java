package negocio;

import java.time.LocalDate;
import java.util.List;

import negocio.beans.Bandeira;
import negocio.beans.Cliente;
import negocio.beans.Consumidor;
import negocio.beans.Conta;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Funcionario;
import negocio.beans.Report;
import negocio.beans.TaxaFixa;
import negocio.beans.TipoConsumidor;

public class Controlador implements IControlador {
    
    private static Controlador instance;

    private ControladorEmpresas controladorEmpresas;
    // private ControladorFuncionarios controladorFuncionarios;
    private ControladorConsumidores controladorConsumidores;
    // private ControladorContas controladorContas;
    private ControladorClientes controladorClientes;

    private Controlador() {
        //construtor privado
        this.controladorEmpresas = ControladorEmpresas.getInstance();
        // this.controladorFuncionarios = controladorFuncionarios.getInstance();
        // this.controladorContas = controladorContas.getInstance();
        this.controladorConsumidores = ControladorConsumidores.getInstance();
        this.controladorClientes = ControladorClientes.getInstance();
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }


    // Controles de clientes

    public Cliente criarCliente(String nome, String cpf, LocalDate dataNascimento){
        return this.controladorClientes.criarCliente(nome, cpf, dataNascimento);
    }

    public void removerCliente(String cpf){
        this.controladorClientes.removerCliente(cpf);
    }

    public Consumidor adicionarConsumidorAoCliente(String cpfCliente, String idEmpresa, String numMedidor, TipoConsumidor tipo, Endereco endereco){
        return this.controladorClientes.adicionarConsumidorAoCliente(cpfCliente, idEmpresa, numMedidor, tipo, endereco);
    }

    public void removerConsumidorDoCliente(String idCliente, String numMedidor){
        this.controladorClientes.removerConsumidorDoCliente(idCliente, numMedidor);
    }


    // Controles de empresas

    public Empresa criarEmpresa(String idEmpresa, String nome, String servico) {
        return this.controladorEmpresas.criarEmpresa(idEmpresa, nome, servico);
    }

    public void removerEmpresa(String idEmpresa){
        this.controladorEmpresas.removerEmpresa(idEmpresa);
    }

    public Funcionario criarFuncionarioNaEmpresa(String empresa, String cpf, String nome, LocalDate dataNascimento, String cargo) {
        return this.controladorEmpresas.criarFuncionarioNaEmpresa(empresa, cpf, nome, dataNascimento, cargo);
    }

    public void removerFuncionarioNaEmpresa(String idEmpresa, String idFuncionario) {
        this.controladorEmpresas.removerFuncionarioNaEmpresa(idEmpresa, idFuncionario);
    }

    // Controles de taxa

    public void adicionarTaxaFixaPorTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo, TaxaFixa taxaFixa){
        this.controladorEmpresas.adicionarTaxaFixaPorTipoNaEmpresa(idEmpresa, tipo, taxaFixa);
    }

    public void adicionarTaxaAdicionalPorTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo, double de, double ate, double valor){
        this.controladorEmpresas.adicionarTaxaAdicionalPorTipoNaEmpresa(idEmpresa, tipo, de, ate, valor);
    }

    public void adicionarTarifaNaEmpresa(String idEmpresa, String nomeTarifa, Double valor){
        this.controladorEmpresas.adicionarTarifaNaEmpresa(idEmpresa, nomeTarifa, valor);
    }
    
    public void definirBandeiraDaEmpresa(String idEmpresa, Bandeira bandeira, float valor){
        this.controladorEmpresas.definirBandeiraDaEmpresa(idEmpresa, bandeira, valor);
    }

    public void adicionarTaxaDoTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo){
        this.controladorEmpresas.adicionarTaxaDoTipoNaEmpresa(idEmpresa, tipo);
    }


    // controle de consumidores


    public void acessarCliente(String idCliente){
        controladorConsumidores.acessarCliente(idCliente);
    }

    public void adicionarContaAoConsumidor(String idConta, String idEmpresa, String numMedidor, LocalDate data, double consumo){
        controladorConsumidores.adicionarContaAoConsumidor(idConta, idEmpresa, numMedidor, data, consumo);
    }

    public void pagarContaDoMes(String idConta, String numMedidor, int mes){
        controladorConsumidores.pagarContaDoMes(idConta, numMedidor, mes);
    }

    public List<Conta> listarContasPendentes(String numMedidor){
        return controladorConsumidores.listarContasPendentes(numMedidor);
    }

    public List<Conta> listarContas(String numMedidor){
        return controladorConsumidores.listarContas(numMedidor);
    }

    public List<Funcionario> listarFuncionariosDaEmpresa(String idEmpresa){
        return controladorEmpresas.listarFuncionariosDaEmpresa(idEmpresa);
    }

    public List<Empresa> listarEmpresas() {
        return controladorEmpresas.listarEmpresas();
    }

    public List<Cliente> listarClientes() {
        return controladorClientes.listarClientes();
    }

    public List<Consumidor> listarConsumidoresDoCliente(String idCliente) {
        return controladorClientes.listarConsumidoresDoCliente(idCliente);
    }


    // Controles de reports

    public void reportarProblema(String protocolo, String assunto, String mensagem, String idEmpresa, LocalDate data, Endereco endereco) {
        this.controladorEmpresas.reportarProblema(protocolo, assunto, mensagem, idEmpresa, data, endereco);
    }

    public void resolverProblema(String idEmpresa, String protocolo) {
        this.controladorEmpresas.resolverProblema(idEmpresa, protocolo);
    }

    public List<Report> listarProblemas(String idEmpresa) {
        return this.controladorEmpresas.listarProblemas(idEmpresa);
    }

    public List<Report> listarProblemasPendentes(String idEmpresa) {
        return this.controladorEmpresas.listarProblemasPendentes(idEmpresa);
    }

    

}
