package negocio;

import java.time.LocalDate;
import java.util.List;

import negocio.beans.*;

public interface IControlador {
    

    // controles de cliente

    /**
     * Recebe os dados de um cliente e cria seu perfil no sistema
     * @param nome
     * @param cpf
     * @param dataNascimento
     */
    Usuario criarCliente(String nome, String cpf, LocalDate dataNascimento);

    /**
     * Remove um cliente de cpf informado no sistema
     * @param cpf
     */
    void removerCliente(String cpf);

    /**
     * Recebe dados para a criação e adição de um consumidor, propriedade de um cliente informado e cadastrado na empresa informada
     * @param cpfCliente
     * @param idEmpresa
     * @param numMedidor
     * @param tipo
     * @param endereco
     * @return
     */
    Propriedade adicionarPropriedade(String cpfCliente, String idEmpresa, String numMedidor, TipoPropriedade tipo, Endereco endereco);

    /**
     * Remove o consumidor informado de um dado cliente
     * @param idCliente
     * @param numMedidor
     */
    void removerPropriedade(String idCliente, String numMedidor);


    // Controles de empresa
    
    /**
     * Recebe dados para criar uma empresa e adicioná-la ao sistema
     * @param idEmpresa
     * @param nome
     * @param servico
     * @return
     */
    Empresa criarEmpresa(String idEmpresa, String nome, String servico);

    /**
     * Remove do sistema a empresa do identificador informado
     * @param idEmpresa
     */
    void removerEmpresa(String idEmpresa);

    /**
     * Recebe dados para a criação de um perfil de funcionario na empresa informada
     * @param empresa
     * @param cpf
     * @param nome
     * @param dataNascimento
     * @param cargo
     * @return
     */
    //Funcionario criarFuncionarioNaEmpresa(String empresa, String cpf, String nome, LocalDate dataNascimento, String cargo);

    /**
     * Recebe o identificador de um funcionário para excluir seu perfil da empresa
     * @param idEmpresa
     * @param idFuncionario
     */
    //void removerFuncionarioNaEmpresa(String idEmpresa, String idFuncionario);

    /**
     * Cria uma taxa fixa para um dado tipo de consumidor na empresa
     * A classe taxaFixa recebe os parâmetros: [1] consumo máximo, onde um consumo até este valor terá um [2] preço fixo 
     * @param idEmpresa
     * @param tipo
     * @param taxaFixa
     */
    void adicionarTaxaFixaPorTipoNaEmpresa(String idEmpresa, TipoPropriedade tipo, TaxaFixa taxaFixa);

    /**
     * Cria uma faixa de preço a uma empresa
     * A faixa define um preço para um excedente entre os valores [1] de e [2] até
     * @param idEmpresa
     * @param tipo
     * @param de
     * @param ate
     * @param valor
     */
    void adicionarTaxaAdicionalPorTipoNaEmpresa(String idEmpresa, TipoPropriedade tipo, double de, double ate, double valor);

    /**
     * Adiciona uma tarifa fixa na empresa
     * @param idEmpresa
     * @param nomeTarifa
     * @param valor
     */
    void adicionarTarifaNaEmpresa(String idEmpresa, String nomeTarifa, Double valor);


    void definirBandeiraDaEmpresa(String idEmpresa, Bandeira bandeira, float valor);
    void adicionarTaxaDoTipoNaEmpresa(String idEmpresa, TipoPropriedade tipo);
    void acessarCliente(String idCliente);
    void adicionarContaAoConsumidor(String idConta, String idEmpresa, String numMedidor, LocalDate data, double consumo);
    void pagarContaDoMes(String idConta, String numMedidor, int mes);
    List<Conta> listarContasPendentes(String numMedidor);
    List<Conta> listarContas(String numMedidor);
    //List<Funcionario> listarFuncionariosDaEmpresa(String idEmpresa);
    
    List<Empresa> listarEmpresas();
    List<Usuario> listarClientes();

    List<Propriedade> listarPropriedades(String idCliente);

    void reportarProblema(String protocolo, String assunto, String mensagem, String idEmpresa, LocalDate data, Endereco endereco);
    void resolverProblema(String idEmpresa, String protocolo);
    List<RelatorioDeOcorrencia> listarProblemas(String idEmpresa);
    List<RelatorioDeOcorrencia> listarProblemasPendentes(String idEmpresa);

}
