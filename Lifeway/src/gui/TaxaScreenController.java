package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import excecoes.ElementoJaExisteException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.beans.Bandeira;
import negocio.beans.Funcionario;
import negocio.beans.Taxa;
import negocio.beans.TipoPropriedade;
import negocio.controle.Fachada;

public class TaxaScreenController implements Initializable {

    
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
    private ComboBox<TipoPropriedade> tipoProprCB;
    @FXML
    private ComboBox<Bandeira> bandeiraCB;
    @FXML
    private TextField de;
    @FXML
    private TextField ate;
    @FXML
    private TextField valor;
    @FXML
    private TextField valorBandeira;

    @FXML
    private TableView<Taxa> taxaList;
    @FXML
    private TableColumn<Taxa, String> colunaTipoPropriedade;
    @FXML
    private TableColumn<Taxa, String> colunaDe;
    @FXML
    private TableColumn<Taxa, String> colunaAte;
    @FXML
    private TableColumn<Taxa, String> colunaValor;
    @FXML
    private TableColumn<Taxa, String> colunaBandeira;

    private Taxa taxaSelecionada;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoProprCB.getItems().addAll(TipoPropriedade.values());
        bandeiraCB.getItems().addAll(Bandeira.values());

        colunaAte.setCellValueFactory(new PropertyValueFactory<>("faixaDe"));
        colunaDe.setCellValueFactory(new PropertyValueFactory<>("faixaAte"));
        colunaTipoPropriedade.setCellValueFactory(new PropertyValueFactory<>("tipoPropriedade"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaBandeira.setCellValueFactory(new PropertyValueFactory<>("bandeira"));


        atualizarLista();

        taxaList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Taxa>(){
            @Override
            public void changed(ObservableValue<? extends Taxa> arg0, Taxa arg1, Taxa arg2) {
                taxaSelecionada = taxaList.getSelectionModel().getSelectedItem();
                
            }
        });

    }

    public void criarTaxa() throws ElementoJaExisteException {
        Taxa novaTaxa = new Taxa(Double.parseDouble(de.getText()), Double.parseDouble(ate.getText()), Double.parseDouble(valor.getText()), "tipoTaxa", tipoProprCB.getSelectionModel().getSelectedItem(), bandeiraCB.getSelectionModel().getSelectedItem(), ((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa());
        Fachada.getInstance().criarTaxa(novaTaxa);
        atualizarLista();
    }

    public void modificarTaxa() {
        
    }


    void atualizarLista() {
        taxaList.getItems().removeAll(Fachada.getInstance().listarTaxas());
        for (Taxa taxa : Fachada.getInstance().listarTaxas()) {
            if(taxa.getEmpresa().equals(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())) {
                taxaList.getItems().addAll(taxa);
            }
        }
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

    

}
