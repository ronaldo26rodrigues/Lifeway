package negocio.beans;

import java.util.List;
import java.util.Map;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Empresa {
    
    private String nome;
    private String servico;
    private String idEmpresa;
    private Taxas taxas;
    public Taxas taxaFixa;
    public Taxas taxasPorTipo;
    private double maximo;
    private double valorFixo;
    private List<TaxasPorTipo> taxasTipo;
    private Map<String, Double> tarifas;
    private Bandeira bandeira;
    private TipoPropriedade tipo;
    private Map<ValoresDeAte, Double>  faixa;


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

        /**
         * @return the maximo
         */
        public double getMaximo() {
            return maximo;
        }
        /**
         * @return the valorFixo
         */
        public double getValorFixo() {
            return valorFixo;
        }
        /**
         * @param maximo the maximo to set
         */
        public void setMaximo(double maximo) {
            this.maximo = maximo;
        }
        /**
         * @param valorFixo the valorFixo to set
         */
        public void setValorFixo(double valorFixo) {
            this.valorFixo = valorFixo;
        }
    
        public void taxaFixa(double maximo, double valorFixo){
            this.maximo = maximo;
            this.valorFixo = valorFixo;
        }

        public void Taxa(){
            this.taxasTipo = new ArrayList<>();
            this.tarifas = new HashMap<>(); 
        }
    
        public void Taxa(Bandeira bandeira, float valorBandeira){
            this.taxasTipo = new ArrayList<>();
            this.tarifas = new HashMap<>();
            this.bandeira = bandeira;
            bandeira.setValor(valorBandeira);
        }
    
        /**
         * @param taxasPorTipo set taxasPorTipo
         */
        public void setTaxasPorTipo(List<TaxasPorTipo> taxasPorTipo) {
            this.taxasTipo = taxasTipo;
        }
        /**
         * @param tarifas set tarifas
         */
        public void setTarifas(Map<String, Double> tarifas) {
            this.tarifas = tarifas;
        }
        /**
         * @return the taxasPorTipo
         */
        public List<TaxasPorTipo> getTaxasPorTipo() {
            return taxasTipo;
        }
        public TaxasPorTipo getTaxasDoTipo(TipoPropriedade tipo){
            TaxasPorTipo taxaDoTipo = null;
            for (TaxasPorTipo t : taxasTipo) {
                if(t.getTipo().equals(tipo)){
                    taxaDoTipo = t;
                }
            }
            return taxaDoTipo;
        }
        /**
         * @return the bandeira
         */
        public Bandeira getBandeira() {
            return bandeira;
        }
        /**
         * @return the tarifas
         */
        public Map<String, Double> getTarifas() {
            return tarifas;
        }
    
        public void adicionarTarifa(String nome, Double valor){
            this.tarifas.put(nome, valor);
        }
    
        public void definirBandeira(Bandeira bandeira, float valor){
            this.bandeira = bandeira;
            this.bandeira.setValor(valor);
        }
    
        public void criarTaxaDoTipo(TipoPropriedade tipo){
            this.taxasPorTipo.add(new TaxasPorTipo(tipo));
        }
        public void TaxasTipo(TipoPropriedade tipo){
            this.tipo = tipo;
            faixa = new HashMap<>();
        }
    
    
        /**
         * @return the adicional
         */
        public Map<ValoresDeAte, Double> getAdicional() {
            return faixa;
        }
        /**
         * @return the tipo
         */
        public TipoPropriedade getTipo() {
            return tipo;
        }
    
        /**
         * @param adicional the adicional to set
         */
        public void setAdicional(Map<ValoresDeAte, Double> adicional) {
            this.faixa = adicional;
        }
    
        /**
         * @param tipo the tipo to set
         */
        public void setTipo(TipoPropriedade tipo) {
            this.tipo = tipo;
        }
    
        public void adicionarAdicional(double de, double ate, double valor){
            faixa.put(new ValoresDeAte(de, ate) , valor);
        }
    }
    }