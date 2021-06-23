package negocio.beans;

import java.time.LocalDate;

// import negocio.ControladorEmpresas;

public class RegistroDeOcorrencia {
    
    private String protocolo;
    private String assunto;
    private String mensagem;
    private Empresa empresa;
    private Usuario cliente;
    private LocalDate data;
    private Endereco endereco;
    private boolean resolvido;
    

    public RegistroDeOcorrencia(String protocolo, String assunto, String mensagem, 
        Empresa empresa, Usuario cliente, LocalDate data, Endereco endereco){
        this.protocolo = protocolo;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.empresa = empresa;
        this.cliente = cliente;
        this.data = data;
        this.endereco = endereco;

        resolvido = false;
    }
    
    
    
    public Usuario getUsuario() {
        return cliente;
    }

    public void setUsuario(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }


    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }
    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }
    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }
    /**
     * @return the idEmpresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }
    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean getResolvido(){
        return this.resolvido;
    }
    /**
     * @param resolvido the resolvido to set
     */
    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
    

    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String toString() {
        String texto="";
        texto += "\n" + "Usuario: " + this.cliente.getNome();
        texto += "\n" + "Empresa: " + this.empresa.getNome();
        texto += "\n" + "Assunto: " + this.assunto;
        texto += "\n" + "Mensagem: " + this.mensagem;
        texto += "\n" + "Data: " + this.data;
        texto += "\n" + "Endereço: " + this.endereco;
        texto += "\n" + "Status: " + this.resolvido;

        return texto;

    }


    
}
