package excecoes;

import java.lang.Exception;

public class ObjetoJaExisteException extends Exception {
    
    public ObjetoJaExisteException(String objString){
        super("O objeto: " + objString + " já existe neste repositório");
    }
}
