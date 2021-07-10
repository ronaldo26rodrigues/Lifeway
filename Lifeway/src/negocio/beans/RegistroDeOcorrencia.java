package negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistroDeOcorrencia implements Serializable {

    private String protocolo;
    private String assunto;
    private String mensagem;
    private Empresa empresa;
    private Usuario cliente;
    private LocalDate data;
    private Endereco endereco;
    private boolean resolvido;

    public RegistroDeOcorrencia(String protocolo, String assunto, String mensagem, Empresa empresa, Usuario cliente,
            LocalDate data, Endereco endereco) {
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

    public String getAssunto() {
        return assunto;
    }

    public LocalDate getData() {
        return data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean getResolvido() {
        return this.resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public boolean validar() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof RegistroDeOcorrencia) {
            RegistroDeOcorrencia param = (RegistroDeOcorrencia) obj;
            if (param.getProtocolo().equals(this.getProtocolo()) && param.getEmpresa().equals(this.getEmpresa())
                    && param.getUsuario().equals(this.getUsuario())) {
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "\n" + "Protocolo: " + this.protocolo;
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
