import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class signUp {

    @FXML
    private Button botaoLogar;
    @FXML


    public void voltar(ActionEvent event) throws IOException {
       check();

    }

    private void check() throws IOException{
        App g = new App();
        g.trocarCena("Login.fxml");
        
    }
}