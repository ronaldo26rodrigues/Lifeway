package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import negocio.beans.Conta;
import negocio.controle.Fachada;
import negocio.beans.RegistroDeOcorrencia;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

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
    private Label contasPendentes;
    @FXML
    private Label registrosPendentes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        int nContasPendentes = 0;

        for (Conta conta : Fachada.getInstance().listarContas()) {
            if (conta.getPropriedade().getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())
                    && conta.getPaga() == false) {
                nContasPendentes++;
            }
        }

        if (nContasPendentes == 0) {
            contasPendentes.setText("Você está com suas contas em dia!");
        } else if (nContasPendentes == 1) {
            contasPendentes
                    .setText("Você tem " + nContasPendentes + " conta para pagar. Acesse a pagina de Pagamentos.");
        } else {
            contasPendentes
                    .setText("Você tem " + nContasPendentes + " conta para pagar. Acesse a página de Pagamentos.");
        }

        int nRegistrosPendentes = 0;

        for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
            if (registroDeOcorrencia.getUsuario().equals(Fachada.getInstance().getUsuarioLogado())
                    && registroDeOcorrencia.getResolvido() == false) {
                nRegistrosPendentes++;
            }
        }

        if (nRegistrosPendentes == 0) {
            registrosPendentes.setText("Você não tem ocorrências em processo.");
        } else if (nRegistrosPendentes == 1) {
            registrosPendentes.setText("Você tem " + nRegistrosPendentes + " ocorrência em processo.");
        } else {
            registrosPendentes.setText("Você tem " + nRegistrosPendentes + " ocorrências em processo.");
        }

    }

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

    public void irListaTaxas() throws IOException {
        App d = new App();
        d.trocarCena("Taxas.fxml");
    }

}