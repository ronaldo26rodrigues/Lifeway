package gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.beans.Cliente;
import negocio.controle.ControladorUsuario;

import java.io.IOException;

import excecoes.ElementoJaExisteException;

public class SignUp {

    @FXML
    private Button botaoLogar;

    @FXML
    private Button botaoCriarConta;

    @FXML
    private TextField cpf;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField nome;

    @FXML
    private DatePicker dataNascimento;

    public void voltar(ActionEvent event) throws IOException {
       
       App voltarp = new App();
       voltarp.trocarCena("Login.fxml");
    }

    public void criarConta() throws ElementoJaExisteException {
        ControladorUsuario.getInstance().criarNovoUsuario(new Cliente(nome.getText(), cpf.getText(), senha.getText(), dataNascimento.getValue()));;
        System.out.println(ControladorUsuario.getInstance().listarUsuarios());
    }

   
       
        
    
}