package excecoes;

public class ElementoNaoExisteException extends Exception {

    public ElementoNaoExisteException(String objString){
            super("O objeto: " + objString + " não existe.");
        }

}
