import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class logIn {
    
public logIn(){

}
@FXML
private Button botaoCriarConta;
@FXML
private Button botaoLogin;
@FXML
private Label loginErrado;
@FXML
private TextField cpf;
@FXML
private PasswordField senha;



public void criar(ActionEvent event) throws IOException{
    checar();
    
}

public void entrar(ActionEvent event) throws IOException{
    checkLogin();
}

private void checar() throws IOException{
    App p = new App();
    p.trocarCena("SignUP.fxml");
    
}


private void checkLogin() throws IOException{
    App m = new App();
    if(cpf.getText().toString().equals("123") && senha.getText().toString().equals("123")){
        loginErrado.setText("Sucesso!");
    
        m.trocarCena("Menu.fxml");
    }

    else if(cpf.getText().isEmpty() && senha.getText().isEmpty()){
        loginErrado.setText("Por favor insira suas informações");
    }
    else{
        loginErrado.setText("Nome ou senha incorretas");
    }
}
}
