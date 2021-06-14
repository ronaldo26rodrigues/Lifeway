package negocio.beans;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Propriedade {

    private String idPropriedade;
    private TipoPropriedade tipo;
    private Endereco endereco;
    private Cliente clienteProprietario;
    private String idEmpresa;
    private Empresa empresaContratada;

    private IRepositorioGenerico<Conta>repositorioContas;

    // private String idCliente;
    // private String numMedidor;

    /**
     * Construtor: Propriedade
     * @param idPropriedade
     * @param tipo
     * @param endereco
     */
    public Propriedade(TipoPropriedade tipo,Endereco endereco, Cliente clienteProprietario, String idPropriedade, String idEmpresa) {
        
        this.tipo = tipo;
        this.endereco = endereco;
        this.clienteProprietario = clienteProprietario;
        this.idPropriedade = idPropriedade;
        this.idEmpresa = idEmpresa;
        
        this.repositorioContas = new RepositorioGenerico<>();
    }


    //Getters & Setters

    
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

    public Cliente getClienteProprietario() {
        return clienteProprietario;
    }

    public void setClienteProprietario(Cliente clienteProprietario) {
        this.clienteProprietario = clienteProprietario;
    }


    /**
     * @return the repositorioContas
     */
    public IRepositorioGenerico<Conta> getRepositorioContas() {
        return repositorioContas;
    }
    
    /**
     * @param repositorioContas the repositorioContas to set
     */
    public void setRepositorioContas(IRepositorioGenerico<Conta> repositorioContas) {
        this.repositorioContas = repositorioContas;
    }


    
    // /**
    //  * @return numMedidor
    //  */
    // public String getNumMedidor() {
    //     return numMedidor;
    // }
    // /**
    //  * @param numMedidor  set numMedidor
    //  */
    // public void setNumMedidor(String numMedidor) {
    //     this.numMedidor = numMedidor;
    // }

    /**
     * eu acho que pra comparar propriedades, basta comparar endereço,
     * já que o método deve estar atrelado a um cliente específico,
     * mas não tenho ctz. Mudar?
     * Equals: Propriedade (compara id, tipo e endereço)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Propriedade) {
            Propriedade param = (Propriedade) obj;
            if ( /* (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && param.getTipo().equals(this.getTipo())
                && */param.getEndereco().equals(this.getEndereco()) ) {
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
    //public String getIdEmpresa() {
       // return idEmpresa;
    //}

    //public void setId(String id) {
        // TODO Auto-generated method stub
    //}
    
    // /**
    //  * @return the idCliente
    //  */
    // public String getIdCliente() {
    //     return idCliente;
    // }
    // /**
    //  * @param idCliente the idCliente to set
    //  */
    // public void setIdCliente(String idCliente) {
    //     this.idCliente = idCliente;
    // }
    
}
