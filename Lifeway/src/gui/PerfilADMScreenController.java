package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import negocio.controle.ControladorUsuario;

public class PerfilADMScreenController implements Initializable {

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
        if (nomePerfil != null) {
            nomePerfil.setText(ControladorUsuario.getInstance().getUsuarioLogado().getNome());
            cpfPerfil.setText(ControladorUsuario.getInstance().getUsuarioLogado().getIdentificacao());
            dataNascimentoPerfil
                    .setText((ControladorUsuario.getInstance().getUsuarioLogado()).getDataDeNascimeto().toString());

        }

    }

    public void irAlterarInformacoes(ActionEvent event) throws IOException {
        App d = new App();
        d.trocarCena("AlterarInformacoes.fxml");
    }

    public void SairConta(ActionEvent event) throws IOException {
        App x = new App();
        x.trocarCena("Login.fxml");

    }

    public void irListaConsumidores(ActionEvent event) throws IOException {
        App w = new App();
        w.trocarCena("ListaConsumidores.fxml");

    }

    public void irPerfilADM(ActionEvent event) throws IOException {
        App v = new App();
        v.trocarCena("PerfilADM.fxml");

    }

    public void irListaRO(ActionEvent event) throws IOException {
        App a = new App();
        a.trocarCena("ListaRO.fxml");

    }

    public void irHomeADM(ActionEvent event) throws IOException {
        App d = new App();
        d.trocarCena("HomeADM.fxml");

    }

}