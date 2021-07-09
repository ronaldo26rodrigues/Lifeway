package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import negocio.beans.Funcionario;
import negocio.beans.Propriedade;
import negocio.beans.RegistroDeOcorrencia;
import negocio.controle.Fachada;

public class MenuFuncionario implements Initializable {

    @FXML
    private Button botaoSair;
    @FXML
    private Button botaoCriarLeitura;
    @FXML
    private Button botaoVerListaConsumires;
    @FXML
    private Button botaoPerfilADM;
    @FXML
    private Button botaoListaRO;
    @FXML
    private Button botaoHomeADM;
    @FXML
    private Label ocorrenciasPendentes;
    @FXML
    private Label tipoEmpresa;
    @FXML
    private Label propriedadeAtiva;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        int nOcorrenciasPendentes = 0;
        for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
            if (registroDeOcorrencia.getEmpresa()
                    .equals(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())
                    && registroDeOcorrencia.getResolvido() == false) {
                nOcorrenciasPendentes++;
            }
        }
        if (nOcorrenciasPendentes == 0) {
            ocorrenciasPendentes.setText("Você não tem ocorrências para serem resolvidas");
        } else {
            ocorrenciasPendentes.setText("Há " + nOcorrenciasPendentes + " ocorrências enviadas para serem resolvidas");
        }

        int nPropriedadeRegistrada = 0;
        int nPropriedadeInadimplente = 0;
        Fachada.getInstance().checarInadimplentes();
        for (Propriedade propriedadeAtiva : Fachada.getInstance().listarPropriedade()) {
            if (propriedadeAtiva.getListaEmpresasFornecedoras()
                    .contains(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())) {
                nPropriedadeRegistrada++;
                if (propriedadeAtiva.getInadimplente())
                    nPropriedadeInadimplente++;
            }
        }
        if (nPropriedadeRegistrada == 0) {
            propriedadeAtiva.setText("Ainda não existem propriedades registradas.");
        } else if (nPropriedadeRegistrada == 1) {
            propriedadeAtiva.setText("Existe " + nPropriedadeRegistrada + " propriedade registrada e "
                    + nPropriedadeInadimplente + " inadimplentes.");
        } else {
            propriedadeAtiva.setText("Existem " + nPropriedadeRegistrada + " propriedades registradas e "
                    + nPropriedadeInadimplente + " inadimplentes.");
        }

        tipoEmpresa.setText("Você faz parte da Empresa "
                + ((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa().getNome() + " fornecedora de "
                + ((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa().getServico());

    }

    public void SairConta(ActionEvent event) throws IOException {
        App x = new App();
        x.trocarCena("Login.fxml");
    }

    public void irCriarLeitura(ActionEvent event) throws IOException {
        App v = new App();
        v.trocarCena("CriarLeitura.fxml");
    }

    public void irListaConsumidores(ActionEvent event) throws IOException {
        App a = new App();
        a.trocarCena("ConsumidorLista.fxml");
    }

    public void irPerfilADM(ActionEvent event) throws IOException {
        App b = new App();
        b.trocarCena("PerfilADM.fxml");
    }

    public void irListaRO(ActionEvent event) throws IOException {
        App c = new App();
        c.trocarCena("ListaRO.fxml");
    }

    public void irHomeADM(ActionEvent event) throws IOException {
        App d = new App();
        d.trocarCena("HomeADM.fxml");
    }

    public void irListaTaxas() throws IOException {
        App d = new App();
        d.trocarCena("Taxas.fxml");
    }
}