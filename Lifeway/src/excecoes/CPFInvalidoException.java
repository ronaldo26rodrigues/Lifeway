package Excecoes;

public class CPFInvalidoException extends Exception {

    public CPFInvalidoException(String cpf) {
        super("CPF inválido.");
    }

}
