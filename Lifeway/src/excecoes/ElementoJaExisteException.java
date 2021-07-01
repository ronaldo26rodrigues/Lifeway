package excecoes;

import java.lang.Exception;

public class ElementoJaExisteException extends Exception {

    private Object elemento;

    public ElementoJaExisteException(Object obj) {
        super("Objeto já existe neste repositório.");
        this.elemento = obj;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
