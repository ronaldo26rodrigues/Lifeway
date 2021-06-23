package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
import negocio.controle.Fachada;

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
    private TextField ocorrencia;
    @FXML
    private DatePicker dataOcorrencia;
    
    @FXML
    private TextArea rua;
    @FXML
    private TextArea numeroCasa;
    @FXML
    private TextArea complemento;
    @FXML
    private TextArea pontoReferencia;

    @FXML
    private TextField detalhes;

    @FXML
    private Button botaoOcorrencia;


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
    public void registrarOcorrencia(ActionEvent event) throws IOException {
        System.out.println("botao de criar ocorrencia clicado");
        System.out.println(Fachada.getInstance().getUsuarioLogado());
        
        Fachada.getInstance().criarNovaOcorrencia(ocorrencia.getText(), detalhes.getText(), new Empresa("compesa", "Compesa", "agua"), Fachada.getInstance().getUsuarioLogado(), dataOcorrencia.getValue(), new Endereco(rua.getText(), Integer.parseInt(numeroCasa.getText()), complemento.getText(), pontoReferencia.getText()));

        for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
            System.out.println(registroDeOcorrencia);
        }
    }

}
