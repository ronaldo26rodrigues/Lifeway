package gui;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import excecoes.ElementoJaExisteException;
import excecoes.IDInvalidoException;
import excecoes.PropriedadeJaCadastradaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Propriedade;
import negocio.beans.TipoPropriedade;
import negocio.beans.ValidaCPF;
import negocio.controle.ControladorEmpresa;
import negocio.controle.Fachada;

public class PropriedadesScreenController implements Initializable {

    @FXML
    private Button retornar;
    @FXML
    private Button botaoOK;
    @FXML
    private TextArea cnpj;
    @FXML
    private ComboBox<Empresa> empresaCB;
    @FXML
    private ComboBox<TipoPropriedade> tipoCB;
    @FXML
    private TextArea rua;
    @FXML
    private TextArea numeroCasa;
    @FXML
    private TextArea complemento;
    @FXML
    private TextArea pontoReferencia;
    @FXML
    private TextArea cepCasa;
    @FXML
    private HBox hboxEmp;

    private List<Empresa> empresasPropriedade;

    public void irRetornar(ActionEvent event) throws IOException {
        App n = new App();
        n.trocarCena("Perfil.fxml");
    }

    public void criarPropriedadeAction(ActionEvent event) throws NoSuchAlgorithmException, IDInvalidoException,
            ElementoJaExisteException, PropriedadeJaCadastradaException {

        boolean erro = false;
        Propriedade novaPropriedade = null;

        if (tipoCB.getSelectionModel().getSelectedItem() == TipoPropriedade.COMERCIAL
                || tipoCB.getSelectionModel().getSelectedItem() == TipoPropriedade.INDUSTRIAL) {

            if (ValidaCPF.isCNPJ(cnpj.getText())) {
                novaPropriedade = new Propriedade(tipoCB.getSelectionModel().getSelectedItem(), cnpj.getText(),
                        new Endereco(rua.getText(), Integer.parseInt(numeroCasa.getText()), complemento.getText(),
                                pontoReferencia.getText()),
                        Fachada.getInstance().getUsuarioLogado(), new ArrayList<>(empresasPropriedade));
                try {
                    Fachada.getInstance().cadastrarPropriedadeComercial(novaPropriedade);
                } catch (PropriedadeJaCadastradaException e) {
                    erro = true;
                }
            } else {
                erro = true;

                Alert alertPropriedades = new Alert(AlertType.ERROR);
                alertPropriedades.setTitle("Propriedade não cadastrada");
                alertPropriedades.setContentText("CNPJ inválido.");
                alertPropriedades.showAndWait();
            }

        } else {

            novaPropriedade = new Propriedade(tipoCB.getSelectionModel().getSelectedItem(),
                    new Endereco(rua.getText(), Integer.parseInt(numeroCasa.getText()), complemento.getText(),
                            pontoReferencia.getText()),
                    Fachada.getInstance().getUsuarioLogado(), new ArrayList<>(empresasPropriedade));

            try {
                Fachada.getInstance().cadastrarPropriedade(novaPropriedade);

            } catch (ElementoJaExisteException e) {
                erro = true;
                throw new PropriedadeJaCadastradaException(e);
            }
        }

        if (erro == false) {
            Alert alertPropriedades = new Alert(AlertType.INFORMATION);
            alertPropriedades.setTitle("Propriedade adicionada");
            alertPropriedades.setContentText("Propriedade registrada com sucesso! \n Iremos informar suas taxas.");
            alertPropriedades.showAndWait();
        }

        rua.clear();
        complemento.clear();
        numeroCasa.clear();
        empresaCB.getSelectionModel().clearSelection();
        tipoCB.getSelectionModel().clearSelection();
        cnpj.clear();
        complemento.clear();
        pontoReferencia.clear();
        cepCasa.clear();
        empresasPropriedade.clear();
        hboxEmp.getChildren().clear();

    }

    public void addEmpresa() {

        if (!empresasPropriedade.contains(empresaCB.getSelectionModel().getSelectedItem())) {
            EmpresaTag eTag = new EmpresaTag(empresaCB.getSelectionModel().getSelectedItem());
            eTag.getIconX().setOnMouseClicked(new EventHandler<Event>() {
                public void handle(Event arg0) {
                    empresasPropriedade.remove(eTag.getEmpresa());
                    hboxEmp.getChildren().remove(eTag);
                };
            });
            empresasPropriedade.add(empresaCB.getSelectionModel().getSelectedItem());
            hboxEmp.getChildren().addAll(eTag);
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<Empresa> empresaList = FXCollections
                .observableArrayList(ControladorEmpresa.getInstance().listarEmpresas());

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

        tipoCB.getItems().addAll(TipoPropriedade.values());

        empresasPropriedade = new ArrayList<>();

    }
}
