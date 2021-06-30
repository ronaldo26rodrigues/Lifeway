package testes;

import java.time.LocalDate;

import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
import negocio.controle.Fachada;

public class Teste {
    public static void main(String[] args) {
        Fachada.getInstance().criarNovaOcorrencia("poste", "caiu na rua", new Empresa("compesa", "agua"), new Cliente("Ronaldo", "122", "a", LocalDate.now()), LocalDate.now(), new Endereco());
        
        for (RegistroDeOcorrencia r : Fachada.getInstance().listarROcorrencias()) {
            System.out.println(r);
        }
    }
}
