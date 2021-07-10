package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.beans.Conta;
import negocio.beans.Funcionario;
import negocio.beans.Propriedade;
import negocio.beans.Taxa;
import negocio.controle.Fachada;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import excecoes.ContaJaGeradaException;
import excecoes.ElementoJaExisteException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ConsumidorLista implements Initializable {

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
    private TableView<Propriedade> consumidorList;
    @FXML
    private TableColumn<Propriedade, String> colunaProprietario;
    @FXML
    private TableColumn<Propriedade, String> colunaTipo;
    @FXML
    private TableColumn<Propriedade, String> colunaEndereco;
    @FXML
    private TableColumn<Propriedade, String> colunaSituacao;
    @FXML
    private TableColumn<Propriedade, String> colunaInadimplente;
    @FXML
    private Label labelConsumidorList;
    @FXML
    private TextArea valorConsumido;
    @FXML
    private DatePicker dataDeLeitura;

    Propriedade propriedadeSelecionada;

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

    public void atualizarLista() {
        Fachada.getInstance().checarInadimplentes();
        consumidorList.getItems().removeAll(consumidorList.getItems());
        for (Propriedade propriedade : Fachada.getInstance().listarPropriedade()) {
            if (Fachada.getInstance().getUsuarioLogado() instanceof Funcionario) {

                if (propriedade.getListaEmpresasFornecedoras()
                        .contains(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())) {
                    consumidorList.getItems().addAll(propriedade);

                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        colunaProprietario.setCellValueFactory(new PropertyValueFactory<>("clienteProprietario"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("idPropriedade"));
        colunaInadimplente.setCellValueFactory(new PropertyValueFactory<>("inadimplente"));

        atualizarLista();

        consumidorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Propriedade>() {

            @Override
            public void changed(ObservableValue<? extends Propriedade> arg0, Propriedade arg1, Propriedade arg2) {
                propriedadeSelecionada = consumidorList.getSelectionModel().getSelectedItem();
            }

        });
    }

    public void criarConta() throws ElementoJaExisteException, ContaJaGeradaException {

        double valorTotal = 0;
        Taxa taxaAplicada = null;

        for (Taxa taxa : Fachada.getInstance().listarTaxas()) {
            if (taxa.getEmpresa().equals(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())
                    && taxa.getTipoPropriedade().equals(propriedadeSelecionada.getTipo())
                    && taxa.getFaixaDe() <= Double.parseDouble(valorConsumido.getText())
                    && taxa.getFaixaAte() >= Double.parseDouble(valorConsumido.getText())) {
                valorTotal += Double.parseDouble(valorConsumido.getText()) * taxa.getValor();
                valorTotal += Double.parseDouble(valorConsumido.getText()) * taxa.getBandeira().getValor();
                taxaAplicada = taxa;
            }
        }

        // apenas gera a conta se existe uma taxa a ser aplicada
        if (taxaAplicada == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Conta não gerada");
            alertaErro.setHeaderText("Crie uma nova taxa.");
            alertaErro.setContentText("Nenhuma taxa para este valor foi registrada no sistema.");
            alertaErro.showAndWait();
        } else {
            Conta novaConta = new Conta(propriedadeSelecionada,
                    ((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa(), dataDeLeitura.getValue(),
                    Double.parseDouble(valorConsumido.getText()), valorTotal, taxaAplicada);
            novaConta.setDataVencimento(novaConta.getDataEmissao().plusDays(15));
            try {
                Fachada.getInstance().criarNovaConta(novaConta);
                atualizarLista();
            } catch (ElementoJaExisteException e) {
                e.printStackTrace();

                System.out.println("Exception caught: conta duplicada");

                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Esta conta já foi gerada");
                // alerta.setHeaderText();
                alertaErro.setContentText("Uma conta já foi gerada para esta propriedade neste mês.");
                alertaErro.showAndWait();

                throw new ContaJaGeradaException(e);

            }

            Alert alertaContaCriada = new Alert(Alert.AlertType.INFORMATION);
            alertaContaCriada.setTitle("Conta gerada.");
            alertaContaCriada.setHeaderText("Conta gerada");
            alertaContaCriada.setContentText("A conta foi gerada com sucesso.");
            alertaContaCriada.showAndWait();
        }
    }
}
