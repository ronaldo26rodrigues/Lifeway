package gui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import negocio.beans.Cliente;
import negocio.beans.Usuario;
import negocio.beans.ValidaCPF;
import negocio.controle.ControladorUsuario;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import Excecoes.CPFInvalidoException;
import Excecoes.ElementoJaExisteException;
import Excecoes.UsuarioJaCadastradoException;

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

    /**
     * Método para cadastrar novo usuário.
     * @throws ElementoJaExisteException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws CPFInvalidoException
     */
    public void criarConta() throws ElementoJaExisteException, IOException, NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        //ControladorUsuario.getInstance().criarNovoUsuario(new Cliente(nome.getText(), cpf.getText(), senha.getText(), dataNascimento.getValue()));;
        boolean cadastroRealizado = false;
        try {
            Usuario novoCliente = new Cliente(nome.getText(), cpf.getText(), senha.getText(), dataNascimento.getValue());
            ControladorUsuario.getInstance().cadastrarUsuario(novoCliente);
            System.out.println(novoCliente.getSenha());
            cadastroRealizado = true;
        } catch (CPFInvalidoException e) {
            System.out.println("Exception caught: CPF inválido.");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("CPF inválido");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("O CPF inserido é inválido. Tente novamente.");
            
            alert.showAndWait();  
        }

        System.out.println(ControladorUsuario.getInstance().listarUsuarios());

        if(cadastroRealizado == true) {
            botaoCriarConta.setFont(Font.font(14));
            botaoCriarConta.setText("Conta criada!\nFaça seu login.");
            botaoCriarConta.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent arg0) {
                    App voltarp = new App();
                    try {
                        voltarp.trocarCena("Login.fxml");
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    
                };
            });
        }

    }

   
       
        
    
}