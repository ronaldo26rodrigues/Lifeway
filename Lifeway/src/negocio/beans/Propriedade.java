package negocio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Propriedade implements Serializable {

    private String idPropriedade;
    private TipoPropriedade tipo;
    private Endereco endereco;
    private Usuario clienteProprietario;
    private String idEmpresa;
    private boolean inadimplente;
    private String cnpj;
    private List<Empresa> listaEmpresasFornecedoras;


    /**
     * Construtor de Propriedade.
     * 
     * @param tipo
     * @param endereco
     * @param cliente
     * @param listaEmpresasFornecedoras
     */
    public Propriedade(TipoPropriedade tipo, Endereco endereco, Usuario cliente,
            List<Empresa> listaEmpresasFornecedoras) {

        Random rng = new Random();
        idPropriedade = "PR" + rng.nextInt(1000) + rng.nextInt(1000);

        this.listaEmpresasFornecedoras = listaEmpresasFornecedoras;
        this.tipo = tipo;
        this.endereco = endereco;
        this.clienteProprietario = cliente;
        this.listaEmpresasFornecedoras = listaEmpresasFornecedoras;

    }

    /**
     * Construtor: Propriedade
     * 
     * @param idPropriedade
     * @param tipo
     * @param endereco
     */
    public Propriedade(TipoPropriedade tipo, Endereco endereco, Cliente clienteProprietario, String idPropriedade,
            String idEmpresa) {

        this.tipo = tipo;
        this.endereco = endereco;
        this.clienteProprietario = clienteProprietario;
        this.idPropriedade = idPropriedade;
        this.idEmpresa = idEmpresa;
        this.inadimplente = false;
    }


    /**
     * Construtor de Propriedade comercial/industrial.
     * 
     * @param tipo
     * @param cnpj
     * @param endereco
     * @param cliente
     * @param empresa
     */
    public Propriedade(TipoPropriedade tipo, String cnpj, Endereco endereco, Usuario cliente, List<Empresa> listaEmpresasFornecedoras) {

        Random rng = new Random();
        idPropriedade = "PR" + rng.nextInt(1000) + rng.nextInt(1000);

        this.listaEmpresasFornecedoras = listaEmpresasFornecedoras;
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.clienteProprietario = cliente;

        this.endereco = endereco;
    }

    // Getters & Setters

    public boolean getInadimplente() {
        return this.inadimplente;
    }

    public void setClienteProprietario(Usuario clienteProprietario) {
        this.clienteProprietario = clienteProprietario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }

    public TipoPropriedade getTipo() {
        return tipo;
    }

    public void setListaEmpresasFornecedoras(List<Empresa> listaEmpresasFornecedoras) {
        this.listaEmpresasFornecedoras = listaEmpresasFornecedoras;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdPropriedade() {
        return idPropriedade;
    }

    public void setIdPropriedade(String idPropriedade) {
        this.idPropriedade = idPropriedade;
    }

    public void setTipo(TipoPropriedade tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getClienteProprietario() {
        return clienteProprietario;
    }

    public void setClienteProprietario(Cliente clienteProprietario) {
        this.clienteProprietario = clienteProprietario;
    }

    public List<Empresa> getListaEmpresasFornecedoras() {
        return listaEmpresasFornecedoras;
    }

    public void setListaEmpresasFornecedoras(ArrayList<Empresa> listaEmpresasFornecedoras) {
        this.listaEmpresasFornecedoras = listaEmpresasFornecedoras;
    }

    /**
     *
     * Método equals: endereço
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Propriedade) {
            Propriedade param = (Propriedade) obj;
            if (param.getEndereco().equals(this.getEndereco())) {
                resultado = true;
            }
        }
        return resultado;
    }

    /**
     * toString: Propriedade
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Cliente proprietário: " + this.getClienteProprietario().getNome();
        resultado += "\n" + "ID da propriedade: " + this.getIdPropriedade();
        resultado += "\n" + "Tipo de propriedade: " + this.getTipo();
        resultado += "\n" + "Endereço: " + this.getEndereco();
        resultado += "\n" + "Empresa distribuidora: " + this.getListaEmpresasFornecedoras();

        return resultado;
    }

    public boolean validar() {
        return true;
    }

    /**
     * @return the idEmpresa
     */
    // public String getIdEmpresa() {
    // return idEmpresa;
    // }

    // public void setId(String id) {
    // }

    // /**
    // * @return the idCliente
    // */
    // public String getIdCliente() {
    // return idCliente;
    // }
    // /**
    // * @param idCliente the idCliente to set
    // */
    // public void setIdCliente(String idCliente) {
    // this.idCliente = idCliente;
    // }

}
