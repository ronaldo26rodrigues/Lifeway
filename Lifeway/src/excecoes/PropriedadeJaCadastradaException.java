package excecoes;

import negocio.beans.Propriedade;

public class PropriedadeJaCadastradaException extends Exception {

    private Propriedade propriedade;
    private ElementoJaExisteException e;

    public PropriedadeJaCadastradaException(Propriedade propriedade) {
        if (propriedade == null) {
            throw new IllegalArgumentException();
        }
        this.propriedade = propriedade;
    }

    public PropriedadeJaCadastradaException(ElementoJaExisteException e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }

    @Override
    public String getMessage() {
        String mensagem = "Propriedade já cadastrada no perfil.";
        if (this.propriedade != null) {
            mensagem = String.format("Propriedade já cadastrada no perfil do usuário %s.",
                    propriedade.getClienteProprietario().getNome());
        }
        return mensagem;
    }


    //Getters & Setters

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public ElementoJaExisteException getE() {
        return e;
    }

    public void setE(ElementoJaExisteException e) {
        this.e = e;
    }
  

}
