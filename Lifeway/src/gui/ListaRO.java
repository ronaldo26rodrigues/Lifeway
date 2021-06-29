package gui;

    import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
    import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.beans.Funcionario;
import negocio.beans.RegistroDeOcorrencia;
import negocio.controle.Fachada;

import java.io.IOException;
    import java.net.URL;
import java.nio.channels.SelectableChannel;
import java.util.ResourceBundle;

    public class ListaRO implements Initializable{
        

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
        private Label labelConsumidorList;

        @FXML
        private Button marcarResolvido;

        @FXML
        private CheckBox apenasPendentes;

        RegistroDeOcorrencia registroSelecionado;


        /*
        String[] consumidores = {"Vicente, Rona, Ganso"}; */

        String consumidorAtual;

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

        public void marcarResolvidoEvent(ActionEvent event) throws IOException {
            registroSelecionado.setResolvido(true);
            atualizarLista();
        }

        public void atualizarLista() {
            listaRO.getItems().removeAll(Fachada.getInstance().listarROcorrencias());
                for (RegistroDeOcorrencia registroDeOcorrencia : Fachada.getInstance().listarROcorrencias()) {
                    if(registroDeOcorrencia.getEmpresa().equals(((Funcionario) Fachada.getInstance().getUsuarioLogado()).getEmpresa())) {
                    if(registroDeOcorrencia.getResolvido() == false && apenasPendentes.isSelected()) listaRO.getItems().addAll(registroDeOcorrencia); else if(apenasPendentes.isSelected()==false) listaRO.getItems().addAll(registroDeOcorrencia);
                }
            }
        }

        

        

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
            
            colunaAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
            colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
            colunaLocal.setCellValueFactory(new PropertyValueFactory<>("endereco"));
            colunaEstado.setCellValueFactory(new PropertyValueFactory<>("resolvido"));

            atualizarLista();
            

            listaRO.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegistroDeOcorrencia>(){

                @Override
                public void changed(ObservableValue<? extends RegistroDeOcorrencia> arg0, RegistroDeOcorrencia arg1, RegistroDeOcorrencia arg2) {
                    registroSelecionado = listaRO.getSelectionModel().getSelectedItem();
                    
                    labelConsumidorList.setText(registroSelecionado.toString());
                }
                
            });
            
            
            
            
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