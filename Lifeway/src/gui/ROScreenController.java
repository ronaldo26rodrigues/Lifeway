package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ROScreenController {
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
    private TextField ocorrenciaField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField localField;
    @FXML
    private TextField comentariosField;

    


    public void SairConta(ActionEvent event) throws IOException {
        App x = new App();
        x.trocarCena("Login.fxml");

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

}
