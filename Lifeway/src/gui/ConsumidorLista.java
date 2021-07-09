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
import negocio.beans.Empresa;
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

    // String[] consumidores = {"Vicente", "Rona", "Ganso"};

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
            for (Empresa empresa : propriedade.getListaEmpresasFornecedoras()) {
                if (empresa.equals(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())) {
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

        /*
         * consumidorList.getSelectionModel().selectedItemProperty().addListener(new
         * ChangeListener<String>(){
         * 
         * @Override public void changed(ObservableValue<? extends String> arg0, String
         * arg1, String arg2) { consumidorAtual =
         * consumidorList.getSelectionModel().getSelectedItem();
         * labelConsumidorList.setText(consumidorAtual); }
         * 
         * });
         */
    }

    public void criarConta() throws ElementoJaExisteException {

        double valorTotal = 0;
        Taxa taxaAplicada = null;

        for (Taxa taxa : Fachada.getInstance().listarTaxas()) {
            if (taxa.getTipoPropriedade().equals(propriedadeSelecionada.getTipo())
                    && taxa.getFaixaDe() <= Double.parseDouble(valorConsumido.getText())
                    && taxa.getFaixaAte() >= Double.parseDouble(valorConsumido.getText())) {
                valorTotal += Double.parseDouble(valorConsumido.getText()) * taxa.getValor();
                valorTotal += Double.parseDouble(valorConsumido.getText()) * taxa.getBandeira().getValor();
                taxaAplicada = taxa;
            }
           
        }
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Conta adicionada!!!");
        alerta.setContentText("Voce adicionou uma conta para o cliente!!!");
        alerta.showAndWait();
      
        // public Conta(String idConta,Propriedade propriedade , Empresa empresa,
        // LocalDate dataEmissao, double consumo,
        // double valorTotal)

        Conta novaConta = new Conta(propriedadeSelecionada,
                ((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa(), dataDeLeitura.getValue(),
                Double.parseDouble(valorConsumido.getText()), valorTotal, taxaAplicada);
        novaConta.setDataVencimento(novaConta.getDataEmissao().plusDays(15));
        try {
            Fachada.getInstance().criarNovaConta(novaConta);
            atualizarLista();
        } catch (ContaJaGeradaException e) {
            e.printStackTrace();
            // alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Esta conta já foi gerada");
            // alerta.setHeaderText();
            alerta.setContentText("Uma conta já foi gerada para esta propriedade neste mês.");
            alerta.showAndWait();
        }
        // Random rng = new Random();

    }

}
