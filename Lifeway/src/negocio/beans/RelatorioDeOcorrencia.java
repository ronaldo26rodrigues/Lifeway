package negocio.beans;

import java.time.LocalDate;

import negocio.ControladorEmpresas;

public class RelatorioDeOcorrencia {
    
    private String protocolo;
    private String assunto;
    private String mensagem;
    private String idEmpresa;
    private LocalDate data;
    private Endereco endereco;
    private boolean resolvido;

    public RelatorioDeOcorrencia(String protocolo, String assunto, String mensagem, String idEmpresa, LocalDate data, Endereco endereco){
        //super(protocolo);
        this.protocolo = protocolo;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.idEmpresa = idEmpresa;
        this.data = data;
        this.endereco = endereco;

        resolvido = false;
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
    public String getIdEmpresa() {
        return idEmpresa;
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
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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

        texto += "\n" + "Assunto: " + this.assunto;
        texto += "\n" + "Mensagem: " + this.mensagem;
        texto += "\n" + "Empresa: " + this.idEmpresa;
        texto += "\n" + "Data: " + this.data;
        texto += "\n" + "Endereço: " + this.endereco;
        texto += "\n" + "Resolvido: " + this.resolvido;

        return texto;

    }


    
}
