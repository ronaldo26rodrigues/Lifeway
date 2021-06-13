package negocio.beans;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Empresa {
    
    private String nome;
    private String servico;
    private String idEmpresa;
    private Taxas taxas;

    // private String identificacao;

    private IRepositorioGenerico<Usuario> repositorioClientes;
    //private IRepositorioGenerico<Funcionario> repositorioFuncionarios;
    private IRepositorioGenerico<RelatorioDeOcorrencia> repositorioRDO;

    public Empresa(String idEmpresa, String nome, String servico) {
        //super(idEmpresa);
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.servico = servico;

        this.taxas = new Taxas();

        repositorioClientes = new RepositorioGenerico<>();
        //repositorioFuncionarios = new RepositorioGenerico<>();
        repositorioRDO = new RepositorioGenerico<>();

    }


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
    public IRepositorioGenerico<RelatorioDeOcorrencia> getRepositorioRDO() {
        return repositorioRDO;
    }
    /**
     * @param repositorioRDO the repositorioReports to set
     */
    public void setRepositorioRDO(IRepositorioGenerico<RelatorioDeOcorrencia> repositorioRDO) {
        this.repositorioRDO = repositorioRDO;
    }

    /**
     * @return the taxas
     */
    public Taxas getTaxas() {
        return taxas;
    }
    /**
     * @param taxas the taxas to set
     */
    public void setTaxas(Taxas taxas) {
        this.taxas = taxas;
    }


    /**
     * Equals: Empresa (compara id e tipo de serviço)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Empresa) {
            Empresa param = (Empresa) obj;
            if ( /* (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && */ param.getServico().equals(this.getServico()) ) {
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
        // resultado += "\n" + "Identificação: " + this.getIdentificacao();
        resultado += "\n" + "Serviço: " + this.getServico();
        return resultado;
      

}
    public boolean validar() {
        // TODO Auto-generated method stub
        return false;
        }
    }