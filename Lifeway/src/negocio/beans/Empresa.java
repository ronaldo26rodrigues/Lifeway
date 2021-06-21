package negocio.beans;

import java.util.List;
import java.util.Map;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Empresa {
    
    private String nome;
    private String servico;
    private String idEmpresa;
    private Taxas taxas;

    // private List<TaxasPorTipo> taxasPorTipo;
    // private Map<String, Double> tarifas;
    // private Bandeira bandeira;

    // private String identificacao;

    private IRepositorioGenerico<Usuario> repositorioClientes;
    //private IRepositorioGenerico<Funcionario> repositorioFuncionarios;
    private IRepositorioGenerico<RegistroDeOcorrencia> repositorioRDO;

    public Empresa(String idEmpresa, String nome, String servico) {
        //super(idEmpresa);
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.servico = servico;

        // this.taxas = new Taxas();

        repositorioClientes = new RepositorioGenerico<>();
        //repositorioFuncionarios = new RepositorioGenerico<>();
        repositorioRDO = new RepositorioGenerico<>();

    }

    //métodos para receber as taxas instanciadas pelo funcionário

    //method(type): type

    // Getters & Setters

    
    public String getNome() {
        return nome;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }


    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
    /* public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    } */

    /**
     * @return the repositorioClientes
     */
    public IRepositorioGenerico<Usuario> getRepositorioClientes() {
        return repositorioClientes;
    }
    /**
     * @return the repositorioFuncionarios
     */
    //public IRepositorioGenerico<Funcionario> getRepositorioFuncionarios() {
        //return repositorioFuncionarios;
    //}
    /**
     * @param repositorioClientes the repositorioClientes to set
     */
    public void setRepositorioClientes(IRepositorioGenerico<Usuario> repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }
    /**
     * @param repositorioFuncionarios the repositorioFuncionarios to set
     */
    //public void setRepositorioFuncionarios(IRepositorioGenerico<Funcionario> repositorioFuncionarios) {
        //this.repositorioFuncionarios = repositorioFuncionarios;
    //}

    /**
     * @return the repositorioReports
     */
    public IRepositorioGenerico<RegistroDeOcorrencia> getRepositorioRDO() {
        return repositorioRDO;
    }
    /**
     * @param repositorioRDO the repositorioReports to set
     */
    public void setRepositorioRDO(IRepositorioGenerico<RegistroDeOcorrencia> repositorioRDO) {
        this.repositorioRDO = repositorioRDO;
    }

    // /**
    //  * @return the taxas
    //  */
    // public Taxas getTaxas() {
    //     return taxas;
    // }
    // /**
    //  * @param taxas the taxas to set
    //  */
    // public void setTaxas(Taxas taxas) {
    //     this.taxas = taxas;
    // }


    /**
     * Equals: Empresa (compara id)
     */

    // /**
    //  * @return the bandeira
    //  */
    // public Bandeira getBandeira() {
    //     return bandeira;
    // }
    // /**
    //  * @return the tarifas
    //  */
    // public Map<String, Double> getTarifas() {
    //     return tarifas;
    // }
    // /**
    //  * @return the taxasPorTipo
    //  */
    // public List<TaxasPorTipo> getTaxasPorTipo() {
    //     return taxasPorTipo;
    // }
    
    // /**
    //  * @param bandeira the bandeira to set
    //  */
    // public void setBandeira(Bandeira bandeira) {
    //     this.bandeira = bandeira;
    // }
    // /**
    //  * @param tarifas the tarifas to set
    //  */
    // public void setTarifas(Map<String, Double> tarifas) {
    //     this.tarifas = tarifas;
    // }
    // /**
    //  * @param taxasPorTipo the taxasPorTipo to set
    //  */
    // public void setTaxasPorTipo(List<TaxasPorTipo> taxasPorTipo) {
    //     this.taxasPorTipo = taxasPorTipo;
    // }


    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Empresa) {
            Empresa param = (Empresa) obj;
            if (  (param.getIdEmpresa() != null) 
                && param.getIdEmpresa().equals(this.getIdEmpresa()) ) {
                    resultado = true;
                }
        }
        return resultado;
    }

    /**
     * toString: Empresa
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Nome: " + this.getNome();
        resultado += "\n" + "ID: " + this.getIdEmpresa();
        resultado += "\n" + "Serviço: " + this.getServico();
        return resultado;
      
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return false;
        }
    }