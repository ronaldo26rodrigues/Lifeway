package gui;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import excecoes.EmpresaJaCadastradaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import negocio.beans.Usuario;
import negocio.controle.ControladorUsuario;

public class LogIn {

    public LogIn() {

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
    @FXML
    private CheckBox checkBox;

    public void criar(ActionEvent event) throws IOException {
        checar();

    }

    public void entrar(ActionEvent event) throws IOException, NoSuchAlgorithmException, EmpresaJaCadastradaException {
        checkLogin();

    }

    private void checar() throws IOException {
        App p = new App();
        p.trocarCena("SignUP.fxml");

    }

    /**
     * Método para validar log in (confere se CPF e senha estão corretos)
     * 
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private void checkLogin() throws IOException, NoSuchAlgorithmException {
        /*
         * App m = new App(); if(cpf.getText().toString().equals("123") &&
         * senha.getText().toString().equals("123")){ loginErrado.setText("Sucesso!");
         * 
         * m.trocarCena("Menu.fxml"); }
         * 
         * else if(cpf.getText().isEmpty() && senha.getText().isEmpty()){
         * loginErrado.setText("Por favor insira suas informações"); } else{
         * loginErrado.setText("Nome ou senha incorretas"); }
         */

        App m = new App();
        Usuario usuarioLogado = null;
        for (Usuario usuario : ControladorUsuario.getInstance().listarUsuarios()) {

            // chama método gerarSenhaHex para criptografar senha digitada
            // e comparar com a senha guardada no sistema
            String senhaInseridaHex = ControladorUsuario.gerarSenhaHex(senha.getText());

            if (usuario.getIdentificacao().equals(cpf.getText()) && usuario.getSenha().equals(senhaInseridaHex)
                    && checkBox.isSelected() == false) {
                usuarioLogado = usuario;
                ControladorUsuario.getInstance().login(usuarioLogado);
                m.trocarCena("Menu.fxml");
            }
            if (usuario.getIdentificacao().equals(cpf.getText()) && usuario.getSenha().equals(senhaInseridaHex)
                    && checkBox.isSelected() == true) {
                if (usuario.getTipo().equals("FUNCIONARIO")) {

                    usuarioLogado = usuario;
                    ControladorUsuario.getInstance().login(usuarioLogado);
                    m.trocarCena("MenuFuncionario.fxml");
                } else {
                    // loginErrado.setText("Você não possui um perfil de funcionário");
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro no login");
                    alert.setHeaderText("Não foi possível realizar seu login");
                    alert.setContentText("Você não possui um perfil de funcionário.");

                    alert.showAndWait();
                }
            }
        }
        if (usuarioLogado == null && checkBox.isSelected() == false) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro no login");
            alert.setHeaderText("Não foi possível realizar seu login");
            alert.setContentText("Usuário ou senha incorretos.");

            alert.showAndWait();
        }
    }
}
