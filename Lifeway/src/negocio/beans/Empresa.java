package negocio.beans;

import java.util.List;
import java.util.Random;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

    private String nome;
    private String servico;
    private String idEmpresa;

    private List<Taxa> taxas;

    // private List<TaxasPorTipo> taxasPorTipo;
    // private Map<String, Double> tarifas;
    // private Bandeira bandeira;

    // private String identificacao;

    // private IRepositorioGenerico<Usuario> repositorioFuncionarios;
    // private IRepositorioGenerico<Funcionario> repositorioFuncionarios;
    // private IRepositorioGenerico<RegistroDeOcorrencia> repositorioRDO;

    public Empresa(String nome, String servico) {
        // super(idEmpresa);
        Random rng = new Random();
        this.idEmpresa = "EMP" + rng.nextInt(1000) + rng.nextInt(1000);
        this.nome = nome;
        this.servico = servico;

        this.taxas = new ArrayList<>();

        // repositorioFuncionarios = new RepositorioGenerico<>();
        // repositorioFuncionarios = new RepositorioGenerico<>();
        // repositorioRDO = new RepositorioGenerico<>();

    }

    // métodos para receber as taxas instanciadas pelo funcionário

    // method(type): type

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

    /**
     * @return the taxas
     */
    public List<Taxa> getTaxas() {
        return taxas;
    }

    /**
     * @param taxas the taxas to set
     */
    public void setTaxas(List<Taxa> taxas) {
        this.taxas = taxas;
    }

    

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Empresa) {
            Empresa param = (Empresa) obj;
            if ((param.getIdEmpresa() != null) && param.getIdEmpresa().equals(this.getIdEmpresa()) &&
                 param.getNome().equals(this.getNome()) &&
                 param.getServico().equals(this.getServico())) {
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
        resultado += "Nome: " + this.getNome();
        resultado += "\n" + "ID: " + this.getIdEmpresa();
        resultado += "\n" + "Serviço: " + this.getServico();
        return resultado;

    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return false;
    }

}
