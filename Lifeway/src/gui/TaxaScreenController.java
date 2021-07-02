package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import negocio.beans.Bandeira;
import negocio.beans.Taxa;
import negocio.beans.TipoPropriedade;

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
    private TableView<Taxa> taxaList;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoProprCB.getItems().addAll(TipoPropriedade.values());
        bandeiraCB.getItems().addAll(Bandeira.values());



        // ObservableList<Taxa> taxaList

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
