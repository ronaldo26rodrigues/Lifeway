package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import negocio.beans.Cliente;
import negocio.beans.Usuario;
import negocio.controle.ControladorUsuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import excecoes.IDInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;

public class SignUp {

    @FXML
    private Button botaoLogar;
    @FXML
    private Button botaoCriarConta;
    @FXML
    private TextField cpf;
    @FXML
    private PasswordField senha;
    @FXML
    private TextField nome;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private CheckBox checkBoxEmpresa;

   
   

    public void voltar(ActionEvent event) throws IOException {
        App voltarp = new App();
        voltarp.trocarCena("Login.fxml");
    }

    public void irCriarEmpresa(ActionEvent event) throws IOException {
        if (checkBoxEmpresa.isSelected() == true) {
            App oi = new App();
            oi.trocarCena("SignUPEmpresa.fxml");
        }

    }

    /**
     * Método para cadastrar novo usuário.
     * 
     * @throws ElementoJaExisteException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws IDInvalidoException
     */
    public void criarConta() throws ElementoJaExisteException, IOException, NoSuchAlgorithmException,
            UsuarioJaCadastradoException, IDInvalidoException {

        boolean cadastroRealizado = false;

        try {
            Usuario novoCliente = new Cliente(nome.getText(), removeCaracteresEspeciais(cpf.getText()), senha.getText(),
                    dataNascimento.getValue());
            ControladorUsuario.getInstance().cadastrarUsuario(novoCliente);
            System.out.println(novoCliente.getSenha());
            cadastroRealizado = true;
        } catch (IDInvalidoException | UsuarioJaCadastradoException e) {
            System.out.println("Exception caught: CPF inválido ou já cadastrado.");
            this.gerarAlertaErroCadastro(e.getMessage());
        }
        
   

        System.out.println(ControladorUsuario.getInstance().listarUsuarios());

        if (cadastroRealizado == true) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastro realizado");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro realizado com sucesso. Faça seu login!");
            alert.showAndWait();

            botaoCriarConta.setFont(Font.font(16));
            botaoCriarConta.setText("Faça seu login.");
            botaoCriarConta.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent arg0) {
                    App voltarp = new App();
                    try {
                        voltarp.trocarCena("Login.fxml");
                    } catch (Exception e) {
                    }
                };
            });
        }

    }

    private void gerarAlertaErroCadastro(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro de cadastro");
        alerta.setHeaderText("Não foi possível realizar seu cadastro");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }


    private String removeCaracteresEspeciais(String cpf) {
        if (cpf.contains(".")) {
            cpf= cpf.replace(".", "");
        }
        if (cpf.contains("-")) {
            cpf= cpf.replace("-", "");
        }
        if (cpf.contains("/")) {
            cpf= cpf.replace("/", "");
        }
        return cpf;
    }

}