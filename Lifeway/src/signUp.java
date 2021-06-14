import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class signUp {

    @FXML
    private Button botaoLogar;
    @FXML


    public void voltar(ActionEvent event) throws IOException {
       
       App voltarp = new App();
       voltarp.trocarCena("Login.fxml");
    }

   
       
        
    
}