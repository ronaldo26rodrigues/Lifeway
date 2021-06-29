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
import negocio.controle.Fachada;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import excecoes.CPFInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;


public class AlterarInformacoes {

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
    public void irRetornar(ActionEvent event) throws IOException{
        App n = new App();
        n.trocarCena("Perfil.fxml");

    }
    
    public void alterarInformacoes () throws ElementoJaExisteException, IOException, NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
    boolean alteracaoRealizada = false;
    if(!novoNome.getText().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setNome(novoNome.getText());
    }
    if(!novoCpf.getText().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setIdentificacao(novoCpf.getText());
    }
    if(!novaSenha.getText().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setSenha(ControladorUsuario.gerarSenhaHex(novaSenha.getText()));
    }
    if(!novaDataNascimento.getValue().toString().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setDataDeNascimeto(novaDataNascimento.getValue());
    }  


}    
     
} 
