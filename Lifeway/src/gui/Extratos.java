package gui;

   
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
    import java.net.URL;
    import java.util.ResourceBundle;

    public class Extratos implements Initializable{
        

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
        private TableView<Extratos> Extratos;

        @FXML
        private TableColumn<Extratos, String> colunaNome;
        @FXML
        private TableColumn<Extratos, String> colunaTipo;
        @FXML
        private TableColumn<Extratos, String> colunaData;
        @FXML
        private TableColumn<Extratos, String> colunaValor;


       


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
        

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
            
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
            colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

           // for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
             //   Extratos.getItems().addAll(registroDeOcorrencia);
            //}
            
            
            
            
            /* consumidorList.getItems().addAll(consumidores);   
            consumidorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                consumidorAtual = consumidorList.getSelectionModel().getSelectedItem();       
                labelConsumidorList.setText(consumidorAtual);       
                }
                
            }); */
        }

    
    }