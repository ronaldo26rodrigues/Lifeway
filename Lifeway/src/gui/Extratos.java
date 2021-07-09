package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import negocio.beans.Conta;
import negocio.beans.Empresa;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import negocio.controle.Fachada;

public class Extratos implements Initializable {

    @FXML
    private TableView<Conta> contaList;
    @FXML
    private TableColumn<Conta, String> colunaPropriedade;
    @FXML
    private TableColumn<Conta, String> colunaEmissao;
    @FXML
    private TableColumn<Conta, String> colunaVencimento;
    @FXML
    private TableColumn<Conta, String> colunaPreco;
    @FXML
    private TableColumn<Conta, String> colunaTaxa;
    @FXML
    private TableColumn<Conta, String> colunaPagaEm;
    @FXML
    private TableColumn<Conta, String> empresaFornecedora;
    @FXML
    private ComboBox<Empresa> empresaCB;
    @FXML
    private ComboBox<Month> mesCB;
    @FXML
    private ComboBox<Integer> anoCB;
    @FXML
    private CheckBox empresaCheck;
    @FXML
    private CheckBox mesAnoCheck;

    private Conta contaSelecionada;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        colunaPropriedade.setCellValueFactory(new PropertyValueFactory<>("propriedade"));
        colunaEmissao.setCellValueFactory(new PropertyValueFactory<>("dataEmissao"));
        colunaVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colunaTaxa.setCellValueFactory(new PropertyValueFactory<>("taxaAplicada"));
        colunaPagaEm.setCellValueFactory(new PropertyValueFactory<>("pagaEm"));
        empresaFornecedora.setCellValueFactory(new PropertyValueFactory<>("empresaFornecedora"));

        atualizarLista();

        contaList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conta>() {
            @Override
            public void changed(ObservableValue<? extends Conta> arg0, Conta arg1, Conta arg2) {
                contaSelecionada = contaList.getSelectionModel().getSelectedItem();
            }
        });

        mesCB.getItems().addAll(Month.values());

        anoCB.getItems()
                .setAll(IntStream.rangeClosed(1980, LocalDate.now().getYear()).boxed().collect(Collectors.toList()));

        ObservableList<Empresa> empresaList = FXCollections.observableArrayList(Fachada.getInstance().listarEmpresas());
        
        System.out.println(empresaList);
        empresaCB.setItems(empresaList);

        empresaCB.setCellFactory(new Callback<ListView<Empresa>, ListCell<Empresa>>() {

            @Override
            public ListCell<Empresa> call(ListView<Empresa> arg0) {

                final ListCell<Empresa> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(Empresa arg0, boolean arg1) {
                        super.updateItem(arg0, arg1);

                        if (arg0 != null) {
                            setText(arg0.getNome());
                        } else {
                            setText(null);
                        }
                    };
                };
                return cell;
            }
        });
    }

    public void atualizarLista() {
        contaList.getItems().removeAll(contaList.getItems());
        for (Conta conta : Fachada.getInstance().listarContas()) {
            if (conta.getPropriedade().getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())
                    && conta.getPaga() == true) {
                contaList.getItems().addAll(conta);
            }
        }
    }

    public void filtrar() {
        if (empresaCheck.isSelected() && !mesAnoCheck.isSelected()) {
            filtrarEmpresas();
        }
        if (mesAnoCheck.isSelected() && !empresaCheck.isSelected()) {
            filtrarMesAno();
        }
        if (mesAnoCheck.isSelected() && empresaCheck.isSelected()) {
            contaList.getItems().removeAll(contaList.getItems());
            for (Conta conta : Fachada.getInstance().listarContas()) {
                if (conta.getPropriedade().getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())
                        && conta.getPaga() == true
                        && conta.getEmpresa().equals(empresaCB.getSelectionModel().getSelectedItem())
                        && conta.getPagaEm().getMonth() == mesCB.getSelectionModel().getSelectedItem()
                        && conta.getPagaEm().getYear() == anoCB.getSelectionModel().getSelectedItem()) {
                    contaList.getItems().addAll(conta);
                }
            }
        }
    }

    public void filtrarEmpresas() {
        contaList.getItems().removeAll(contaList.getItems());
        if (empresaCheck.isSelected()) {
            for (Conta conta : Fachada.getInstance().listarContas()) {
                if (conta.getEmpresa().equals(empresaCB.getSelectionModel().getSelectedItem()) && conta.getPropriedade()
                        .getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())
                        && conta.getPaga() == true) {
                    contaList.getItems().addAll(conta);
                }
            }
        }
    }

    public void filtrarMesAno() {
        contaList.getItems().removeAll(contaList.getItems());
        for (Conta conta : Fachada.getInstance().listarContas()) {
            if (conta.getPagaEm().getMonth() == mesCB.getSelectionModel().getSelectedItem()
                    && conta.getPagaEm().getYear() == anoCB.getSelectionModel().getSelectedItem()
                    && conta.getPropriedade().getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())
                    && conta.getPaga() == true) {
                contaList.getItems().addAll(conta);
            }
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