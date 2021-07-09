package testes;

import negocio.controle.Fachada;

public class Teste {
    public static void main(String[] args) {
        
        System.out.println(Fachada.getInstance().listarPropriedade());
    }
}
