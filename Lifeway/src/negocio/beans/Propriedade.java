package negocio.beans;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Propriedade {

    //extends Cliente?
    private TipoPropriedade tipo;
    private Endereco endereco;
    //private String idEmpresa; ?

    private IRepositorioGenerico<Conta>repositorioContas;
    private String numMedidor;

    // private String idCliente;
    // private String numMedidor;

    /**
     * Construtor: Propriedade
     * @param numMedidor
     * @param tipo
     * @param endereco
     */
    public Propriedade(String numMedidor, TipoPropriedade tipo, Endereco endereco) {
        //super(nome, identificacao, dataNascimento);
        //super(numMedidor);
        //this.idEmpresa = idEmpresa;
        this.numMedidor = numMedidor;
        this.tipo = tipo;
        this.endereco = endereco;
        
        this.repositorioContas = new RepositorioGenerico<>();
    }

    //Getters & Setters

    public TipoPropriedade getTipo() {
        return tipo;
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
     * Equals: Consumidor (compara id, tipo e endereço)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Propriedade) {
            Propriedade param = (Propriedade) obj;
            if ( /* (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && */ param.getTipo().equals(this.getTipo())
                && param.getEndereco().equals(this.getEndereco()) ) {
                    resultado = true;
                }
        }
        return resultado;
    }


    /**
     * toString: Consumidor
     */
    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\n" + "Tipo: " + this.getTipo();
        resultado += "\n" + "Endereço: " + this.getEndereco();
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
