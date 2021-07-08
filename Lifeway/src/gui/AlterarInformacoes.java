package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import negocio.beans.ValidaCPF;
import negocio.controle.Fachada;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
     * 
     * @throws ElementoJaExisteException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws CPFInvalidoException
     */
    public void irRetornar() throws IOException {
        if (Fachada.getInstance().getUsuarioLogado().getTipo().equals("CLIENTE")) {
            (new App()).trocarCena("Perfil.fxml");
        } else if (Fachada.getInstance().getUsuarioLogado().getTipo().equals("FUNCIONARIO")) {
            (new App()).trocarCena("PerfilADM.fxml");

        }
    }

    public void alterarInformacoes(ActionEvent event) throws ElementoJaExisteException, IOException,
            NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        
        
        boolean alteracaoRealizada = true;
        
        Alert alert = new Alert(AlertType.INFORMATION);

        //String textoAlerta = "";
        
        if (!novoNome.getText().equals("")) {
            if(novoNome.getText().equals(Fachada.getInstance().getUsuarioLogado().getNome())) {
                this.gerarAlertaErroInformacoes("Nome não alterado.");
            }
            else {
                Fachada.getInstance().getUsuarioLogado().setNome(novoNome.getText());
                this.gerarAlertaInformacoesAlteradas("Nome alterado com sucesso.");
            }
            
        }
        if (!novoCpf.getText().equals("")) {

            if (ValidaCPF.isCPF(novoCpf.getText())) {
                Fachada.getInstance().getUsuarioLogado().setIdentificacao(novoCpf.getText());
            } else {
                //alteracaoRealizada = false;
                
                alert.setTitle("CPF inválido");
                // alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("O CPF inserido é inválido. Tente novamente.");
                alert.showAndWait();

                throw new CPFInvalidoException(novoCpf.getText());
            }

        }
        if (!novaSenha.getText().equals("") ) {
            if(novaSenha.getText().equals(Fachada.getInstance().getUsuarioLogado().getSenha())) {
                this.gerarAlertaErroInformacoes("Senha não alterada.");
            }
            else {
                Fachada.getInstance().getUsuarioLogado().setSenha(novaSenha.getText());
                this.gerarAlertaInformacoesAlteradas("Senha alterada com sucesso.");
            }
        }
        System.out.println(novaDataNascimento.getValue());
        if (!novaDataNascimento.getValue().equals(null) ) {
            if(novaDataNascimento.getValue().equals(Fachada.getInstance().getUsuarioLogado().getDataDeNascimeto())) {
                this.gerarAlertaErroInformacoes("Data de nascimento não alterada.");
            }
            else {
                Fachada.getInstance().getUsuarioLogado().setDataNascimento(novaDataNascimento.getValue());
                this.gerarAlertaInformacoesAlteradas("Data de nascimento alterada com sucesso.");
            } 

        if (alteracaoRealizada) 
        irRetornar();

        //alert.showAndWait();
        

        }

    }

    private void gerarAlertaErroInformacoes(String mensagem) {
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Alteração não realizada");
        alert.setHeaderText("Não foi possível alterar suas informações.");
        alert.setContentText(mensagem);

        alert.showAndWait();

    }

    private void gerarAlertaInformacoesAlteradas(String mensagem) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alteração realizada");
        //alert.setHeaderText("");
        alert.setContentText(mensagem);

        alert.showAndWait();

    }

}
