package excecoes;

public class ObjetoNaoExisteException extends Exception {

    public ObjetoNaoExisteException(String objString){
            super("O objeto: " + objString + " não existe.");
        }

}
