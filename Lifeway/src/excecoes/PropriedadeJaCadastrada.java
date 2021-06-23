package excecoes;

import negocio.beans.Propriedade;

public class PropriedadeJaCadastrada extends Exception {
    
    private Propriedade propriedade;
    private ElementoJaExisteException e;

    public PropriedadeJaCadastrada(Propriedade propriedade) {
        if (propriedade == null) {
            throw new IllegalArgumentException();
        }
        this.propriedade = propriedade;
    }

    public PropriedadeJaCadastrada(ElementoJaExisteException e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }
    
    @Override
    public String getMessage(){
        String mensagem = "Propriedade já cadastrada no perfil.";
        if(this.propriedade != null) {
            mensagem = String.format("Propriedade já cadastrada no perfil do usuário %s." , 
                propriedade.getClienteProprietario().getNome());
        }
        return mensagem;
    }

}
