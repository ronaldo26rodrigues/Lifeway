package testes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
import negocio.controle.Fachada;

public class Teste {
    public static void main(String[] args) {
        
        
        System.out.println(Fachada.getInstance().listarPropriedade());
    }
}
