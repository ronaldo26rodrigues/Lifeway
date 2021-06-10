package negocio.beans;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;

public class Consumidor extends Identificavel {

    private TipoConsumidor tipo;
    private Endereco endereco;
    private String idEmpresa;

    private IRepositorioGenerico<Conta>repositorioContas;

    // private String idCliente;
    // private String numMedidor;

    /**
     * Construtor: Consumidor
     * @param nome
     * @param identificacao
     * @param dataNascimento
     * @param tipo
     * @param endereco
     */
    public Consumidor(String numMedidor, String idEmpresa, TipoConsumidor tipo, Endereco endereco) {
        //super(nome, identificacao, dataNascimento);
        super(numMedidor);
        this.idEmpresa = idEmpresa;
        this.tipo = tipo;
        this.endereco = endereco;
        this.repositorioContas = new RepositorioGenerico<>();
    }

    //Getters & Setters

    public TipoConsumidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsumidor tipo) {
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
        if (obj instanceof Consumidor) {
            Consumidor param = (Consumidor) obj;
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

    @Override
    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * @return the idEmpresa
     */
    public String getIdEmpresa() {
        return idEmpresa;
    }
    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }
    
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
