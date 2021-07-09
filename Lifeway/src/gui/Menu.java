package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import negocio.beans.Conta;
import negocio.beans.Empresa;
import negocio.beans.Propriedade;
import negocio.controle.ControladorEmpresa;
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
    private Button adicionarPropriedades;
    @FXML
    private Label contasPendentes;
    @FXML
    private Label registrosPendentes;
    @FXML
    private TableView<Propriedade> consumidorList;
    @FXML
    private TableColumn<Propriedade, String> colunaTipo;
    @FXML
    private TableColumn<Propriedade, String> colunaEndereco;
    @FXML
    private TableColumn<Propriedade, String> colunaSituacao;
    @FXML
    private TableColumn<Propriedade, String> colunaInadimplente;
    @FXML
    private TableView<RegistroDeOcorrencia> listaRO;
    @FXML
    private TableColumn<RegistroDeOcorrencia, String> colunaAssunto;
    @FXML
    private TableColumn<RegistroDeOcorrencia, String> colunaLocal;
    @FXML
    private TableColumn<RegistroDeOcorrencia, String> colunaData;
    @FXML
    private TableColumn<RegistroDeOcorrencia, String> colunaEstado;
    @FXML
    private ComboBox<Empresa> empresaCB;
    
    Propriedade propriedadeSelecionada;

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

        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("idPropriedade"));
        colunaInadimplente.setCellValueFactory(new PropertyValueFactory<>("inadimplente"));

        Fachada.getInstance().checarInadimplentes();
        consumidorList.getItems().removeAll(consumidorList.getItems());
        

        for (Propriedade propriedade : Fachada.getInstance().listarPropriedade()) {
            if (propriedade.getClienteProprietario().equals(Fachada.getInstance().getUsuarioLogado())) {
                consumidorList.getItems().addAll(propriedade);
            }
        }

        colunaAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaLocal.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<>("resolvido"));

        for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
            if (registroDeOcorrencia.getUsuario().equals(Fachada.getInstance().getUsuarioLogado())) {
                listaRO.getItems().addAll(registroDeOcorrencia);
                // if (registroDeOcorrencia.getResolvido() == false &&
                // apenasPendentes.isSelected())
                // listaRO.getItems().addAll(registroDeOcorrencia);
                // else if (apenasPendentes.isSelected() == false)
                // listaRO.getItems().addAll(registroDeOcorrencia);
            }
        }

        ObservableList<Empresa> empresaList = FXCollections
                .observableArrayList(Fachada.getInstance().listarEmpresas());
        empresaCB.setItems(empresaList);
        // empresaCB.getItems().addAll(empresaList);
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
        
        consumidorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Propriedade>(){
            @Override
            public void changed(ObservableValue<? extends Propriedade> arg0, Propriedade arg1, Propriedade arg2) {

                propriedadeSelecionada = consumidorList.getSelectionModel().getSelectedItem();
                
            }







            
        });
    
        
    
    
    
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
    public void irAdicionarPropriedades(ActionEvent event) throws IOException {
        App w = new App();
        w.trocarCena("Propriedades.fxml");

    }

    public void addEmpresa(ActionEvent event) throws IOException {
       
       if(!propriedadeSelecionada.getListaEmpresasFornecedoras().contains(empresaCB.getSelectionModel().getSelectedItem())) {
        propriedadeSelecionada.getListaEmpresasFornecedoras().add(empresaCB.getSelectionModel().getSelectedItem());
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Empresa adicionada com sucesso");
        alerta.setContentText("Propriedade cadastrada");
        alerta.showAndWait();
       }

       
       else {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Empresa não adicionada");
        alert.setContentText("Propriedade já tem cadastro nessa empresa");
        alert.showAndWait();
       }
    }



}