package Excecoes;

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
    public String getMessage(){
        String mensagem = "Empresa já cadastrada.";
        if(this.empresa != null) {
            mensagem = String.format("Empresa %s já cadastrada no sistema." , 
            empresa.getNome());
        }
        return mensagem;
    }
}
