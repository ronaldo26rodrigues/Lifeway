package main;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import excecoes.CPFInvalidoException;
import excecoes.UsuarioJaCadastradoException;
import negocio.beans.Bandeira;
import negocio.beans.Cliente;
import negocio.beans.Usuario;
import negocio.controle.ControladorUsuario;
import negocio.beans.Propriedade;
import negocio.beans.Conta;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
//import negocio.beans.TaxaFixa;
import negocio.beans.TipoPropriedade;

public class TesteMain {
    public static void main(String[] args) throws NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException { 

        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        
        Usuario u1 = new Cliente("Fulano", "45038837719", "senha123", LocalDate.of(1992, 05, 12));
        controladorUsuario.cadastrarUsuario(u1);
        
        //controladorUsuario.criarNovoUsuario(usuario);

        //teste cpf inválido
        Usuario u2 = new Cliente("Cicrano", "1503771", "senha0101", LocalDate.of(1994, 07, 11));
        controladorUsuario.cadastrarUsuario(u2);

        //teste usuário já cadastrado
        Usuario u3 = new Cliente("Fulano", "45038837719", "senha123", LocalDate.of(1992, 05, 12));
        controladorUsuario.cadastrarUsuario(u3);

        for (Usuario usuario : controladorUsuario.listarUsuarios()) {
            System.out.println(usuario);
            System.out.println("--------------");
        }
    }

}
