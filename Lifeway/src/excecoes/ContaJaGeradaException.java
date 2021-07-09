package excecoes;

import negocio.beans.Conta;

public class ContaJaGeradaException extends Exception {

    private Conta conta;
    private ElementoJaExisteException e;

    public ContaJaGeradaException(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException();
        }
        this.conta = conta;
    }

    public ContaJaGeradaException(ElementoJaExisteException e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }

    @Override
    public String getMessage() {
        String mensagem = "Esta conta já foi gerada.";
        if (this.conta != null) {
            mensagem = String.format("Uma conta já foi gerada para esta propriedade neste mês (%s).",
                    conta.getDataEmissao().getMonth().toString());
        }
        return mensagem;
    }

    //Getters & Setters

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ElementoJaExisteException getE() {
        return e;
    }

    public void setE(ElementoJaExisteException e) {
        this.e = e;
    }

    

}
