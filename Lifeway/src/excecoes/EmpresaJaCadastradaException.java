package excecoes;

import negocio.beans.Empresa;

public class EmpresaJaCadastradaException extends Exception {

    private Empresa empresa;
    private ElementoJaExisteException e;

    public EmpresaJaCadastradaException(Empresa empresa) {
        if (empresa == null) {
            throw new IllegalArgumentException();
        }
        this.empresa = empresa;
    }

    public EmpresaJaCadastradaException(ElementoJaExisteException e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }

    @Override
    public String getMessage() {
        String mensagem = "Empresa já cadastrada.";
        if (this.empresa != null) {
            mensagem = String.format("Empresa %s já cadastrada no sistema.", empresa.getNome());
        }
        return mensagem;
    }

    // Getters & Setters

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ElementoJaExisteException getE() {
        return e;
    }

    public void setE(ElementoJaExisteException e) {
        this.e = e;
    }

}
