package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import negocio.beans.Cliente;
import negocio.beans.Usuario;
import negocio.controle.ControladorUsuario;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import excecoes.CPFInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;


public class AlterarInformacoes {

    @FXML
    private Button botaoSair;
    @FXML
    private Button botaoExtratos;
    @FXML
    private Button botaoPagamentos;
    @FXML
    private Button botaoPerfil;
    @FXML
    private Button botaoRO;
    @FXML
    private Button botaoHome;
    @FXML
    private TextField novoCpf;
    @FXML
    private PasswordField novaSenha;
    @FXML
    private TextField novoNome;
    @FXML
    private DatePicker novaDataNascimento;
    @FXML
    private Button salvarAlteracoes;

    /**
     * Método para cadastrar novo usuário.
     * @throws ElementoJaExisteException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws CPFInvalidoException
     */
    
    public void alterarInformacoes () throws ElementoJaExisteException, IOException, NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        boolean alteracaoRealizada = false;
        try {
            Usuario novoCliente = new Cliente(novoNome.getText(), novoCpf.getText(), novaSenha.getText(), novaDataNascimento.getValue());
            ControladorUsuario.getInstance().cadastrarUsuario(novoCliente);
            // System.out.println(nova.getSenha());
            alteracaoRealizada = true;
        } catch (CPFInvalidoException e) {
            System.out.println("Exception caught: CPF inválido.");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("CPF inválido");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("O CPF inserido é inválido. Tente novamente.");
            
            alert.showAndWait();  
        }

        (new App()).trocarCena("Perfil.fxml");

    }


}
