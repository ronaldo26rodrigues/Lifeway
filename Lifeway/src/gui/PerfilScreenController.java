package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import negocio.beans.Cliente;
import negocio.controle.ControladorUsuario;


public class PerfilScreenController implements Initializable {

    
    
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
    private Button adicionarPropriedades;
    @FXML
    private Button alterarInformacoes;


    @FXML
    private Label nomePerfil;

    @FXML
    private Label cpfPerfil;

    @FXML 
    Label dataNascimentoPerfil;

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(nomePerfil != null) {
            nomePerfil.setText(ControladorUsuario.getInstance().getUsuarioLogado().getNome());
            cpfPerfil.setText(ControladorUsuario.getInstance().getUsuarioLogado().getIdentificacao());
            dataNascimentoPerfil.setText((ControladorUsuario.getInstance().getUsuarioLogado()).getDataDeNascimeto().toString());
        }
        
    }


    public void SairConta(ActionEvent event) throws IOException {
        App x = new App();
        x.trocarCena("Login.fxml");

    }
    public void irAdicionarPropriedades(ActionEvent event) throws IOException {
        App w = new App();
        w.trocarCena("Propriedades.fxml");

    }

    public void irExtratos(ActionEvent event) throws IOException {
        App v = new App();
        v.trocarCena("Extratos.fxml");

    }


    public void irPagamentos(ActionEvent event) throws IOException {
        App a = new App();
        a.trocarCena("Pagamentos.fxml");

    }
    public void irPerfil(ActionEvent event) throws IOException {
        App b = new App();
        b.trocarCena("Perfil.fxml");

    }
    public void irRO(ActionEvent event) throws IOException {
        App c = new App();
        c.trocarCena("RO.fxml");

    }
    public void irHome(ActionEvent event) throws IOException {
        App d = new App();
        d.trocarCena("Menu.fxml");

    }

    public void irAlterarInformacoes(ActionEvent event) throws IOException {
        App f = new App();
        f.trocarCena("AlterarInformacoes.fxml");

    }


    
    

}
