package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.controle.ControladorEmpresa;
import negocio.controle.Fachada;
import javafx.util.Callback;

public class ROScreenController implements Initializable {

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
    @FXML
    private ComboBox<Empresa> empresaCB;

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
        Alert alert = new Alert(AlertType.INFORMATION);
        if (ocorrencia.getText().equals("") || dataOcorrencia.getValue() == (null)
                || empresaCB.getSelectionModel().getSelectedItem().equals(null) || rua.getText().equals("")
                || numeroCasa.getText().equals("")) {

            alert.setTitle("Ocorrência não registrada");
            alert.setContentText("Ocorrência não registrada! \n Preencha os espaços.");
        }

        else {
            try {
                Fachada.getInstance().criarNovaOcorrencia(ocorrencia.getText(), detalhes.getText(),
                        empresaCB.getSelectionModel().getSelectedItem(), Fachada.getInstance().getUsuarioLogado(),
                        dataOcorrencia.getValue(), new Endereco(rua.getText(), Integer.parseInt(numeroCasa.getText()),
                                complemento.getText(), pontoReferencia.getText()));
                alert.setTitle("Ocorrência registrada");
                alert.setContentText("Ocorrência registrada! \n Aguarde seu atendimento.");
                ocorrencia.clear();
                rua.clear();
                detalhes.clear();
                numeroCasa.clear();
                empresaCB.getSelectionModel().clearSelection();
                dataOcorrencia.setValue(LocalDate.now());
                complemento.clear();
                pontoReferencia.clear();
            } catch (NumberFormatException nFE) {
                alert.setContentText("Número da casa deve ser enumerado");
            }
        }

        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Empresa> empresaList = FXCollections
                .observableArrayList(ControladorEmpresa.getInstance().listarEmpresas());

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
}
