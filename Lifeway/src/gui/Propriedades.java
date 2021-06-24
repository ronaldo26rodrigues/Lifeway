package gui;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Propriedades {
    

    @FXML
    private Button retornar;

    public void irRetornar(ActionEvent event) throws IOException{
        App n = new App();
        n.trocarCena("Perfil.fxml");

    }
}
