package negocio.beans;

import java.io.Serializable;
import java.util.Random;

public class Propriedade implements Serializable {

    private String idPropriedade;
    private TipoPropriedade tipo;
    private Endereco endereco;
    private Usuario clienteProprietario;
    private String idEmpresa;
    private Empresa empresaContratada;
    private boolean inadimplente;

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

    public Propriedade(TipoPropriedade tipo, Endereco endereco, Usuario cliente, Empresa empresa) {

        Random rng = new Random();
        idPropriedade = "PR" + rng.nextInt(1000) + rng.nextInt(1000);

        this.tipo = tipo;
        this.clienteProprietario = cliente;
        this.empresaContratada = empresa;
        this.endereco = endereco;
    }

    // Getters & Setters

    public boolean getInadimplente() {
        return this.inadimplente;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }

    public TipoPropriedade getTipo() {
        return tipo;
    }

    public Empresa getEmpresaContratada() {
        return empresaContratada;
    }

    public void setEmpresaContratada(Empresa empresaContratada) {
        this.empresaContratada = empresaContratada;
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
        resultado += "\n" + "Empresa distribuidora: " + this.getEmpresaContratada().getNome();

        return resultado;
    }

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * @return the idEmpresa
     */
    // public String getIdEmpresa() {
    // return idEmpresa;
    // }

    // public void setId(String id) {
    // TODO Auto-generated method stub
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
