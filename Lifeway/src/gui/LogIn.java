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

        App m = new App();
        Usuario usuarioLogado = null;
        boolean erro = false;

        for (Usuario usuario : ControladorUsuario.getInstance().listarUsuarios()) {

            // chama método gerarSenhaHex para criptografar senha digitada
            // e comparar com a senha guardada no sistema
            String senhaInseridaHex = ControladorUsuario.gerarSenhaHex(senha.getText());

            if (usuario.getIdentificacao().equals(removeCaracteresEspeciais(cpf.getText())) && usuario.getSenha().equals(senhaInseridaHex)) {
                if(checkBox.isSelected() == false) {
                    if(usuario.getTipo() == "CLIENTE") {
                        usuarioLogado = usuario;
                        ControladorUsuario.getInstance().login(usuarioLogado);
                        m.trocarCena("Menu.fxml"); 
                    } else if (usuario.getTipo() == "FUNCIONARIO") {
                        erro = true;
                        this.gerarAlertaErroLogin("Realize login como funcionário.");                   
                    }
                }

                if(checkBox.isSelected() == true) {
                    if(usuario.getTipo() == "FUNCIONARIO") {
                        usuarioLogado = usuario;
                        ControladorUsuario.getInstance().login(usuarioLogado);
                        m.trocarCena("HomeADM.fxml");
                    } else if(usuario.getTipo() == "CLIENTE") {
                        erro = true;
                        this.gerarAlertaErroLogin("Você não possui um perfil de funcionário.");
                    }
                }
            }

        }

        if (usuarioLogado == null && erro == false) {
            this.gerarAlertaErroLogin("Usuário ou senha incorretos.");
        }
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

    
    private void gerarAlertaErroLogin(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro no login");
        alerta.setHeaderText("Não foi possível realizar seu login.");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
