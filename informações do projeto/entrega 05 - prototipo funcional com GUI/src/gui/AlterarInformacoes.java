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
import negocio.beans.ValidaCPF;
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
    public void irRetornar() throws IOException{
        if(Fachada.getInstance().getUsuarioLogado().getTipo().equals("CLIENTE")) {
            (new App()).trocarCena("Perfil.fxml");
        } else if (Fachada.getInstance().getUsuarioLogado().getTipo().equals("FUNCIONARIO")) {
            (new App()).trocarCena("PerfilADM.fxml");
    
        }
    }
    
    public void alterarInformacoes(ActionEvent event) throws ElementoJaExisteException, IOException, NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
    boolean alteracaoRealizada = true;
    if(!novoNome.getText().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setNome(novoNome.getText());
    }
    if(!novoCpf.getText().equals("")) {

        if(ValidaCPF.isCPF(novoCpf.getText())){
            Fachada.getInstance().getUsuarioLogado().setIdentificacao(novoCpf.getText());
        } else {
            alteracaoRealizada = false;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("CPF inválido");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("O CPF inserido é inválido. Tente novamente.");
            
            alert.showAndWait();  
            
            throw new CPFInvalidoException(novoCpf.getText());
        }

        
    }
    if(!novaSenha.getText().equals("")) {
        Fachada.getInstance().getUsuarioLogado().setSenha(ControladorUsuario.gerarSenhaHex(novaSenha.getText()));
    }
    System.out.println(novaDataNascimento.getValue());
    if(novaDataNascimento.getValue() != null) {
        Fachada.getInstance().getUsuarioLogado().setDataDeNascimeto(novaDataNascimento.getValue());
    }  

    if(alteracaoRealizada) irRetornar();
    
}    


     
} 
