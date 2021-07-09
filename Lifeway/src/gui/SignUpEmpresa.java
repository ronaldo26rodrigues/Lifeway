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
import negocio.beans.Empresa;
import negocio.beans.Funcionario;
import negocio.beans.Usuario;
import negocio.controle.ControladorUsuario;
import negocio.controle.Fachada;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import excecoes.IDInvalidoException;
import excecoes.MenorDeIdadeException;
import excecoes.ElementoJaExisteException;
import excecoes.EmpresaJaCadastradaException;
import excecoes.UsuarioJaCadastradoException;

public class SignUpEmpresa {

    @FXML
    private Button botaoFazerLogin;
    @FXML
    private TextField cpf;
    @FXML
    private PasswordField senha;
    @FXML
    private TextField nome;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private CheckBox checkBoxEmpresa2;
    @FXML
    private TextField nomeDaEmpresa;
    @FXML
    private TextField servicoDaEmpresa;
    @FXML
    private TextField criarContaDoFuncionario;

    public void voltar(ActionEvent event) throws IOException {

        App voltarp = new App();
        voltarp.trocarCena("Login.fxml");
    }

    public void irCriarEmpresa2(ActionEvent event) throws IOException {
        if (checkBoxEmpresa2.isSelected() == false) {
            App oi = new App();
            oi.trocarCena("SignUP.fxml");

            Alert AlertaSignUp = new Alert(AlertType.INFORMATION);
            AlertaSignUp.setTitle("Cadastro realizado");
            AlertaSignUp.setHeaderText(null);
            AlertaSignUp.setContentText("Sua empresa foi cadastrada com sucesso. Faça seu login!");

            cpf.clear();
            senha.clear();
            nome.clear();
            dataNascimento.setValue(LocalDate.now());
            servicoDaEmpresa.clear();
            criarContaDoFuncionario.clear();

            AlertaSignUp.showAndWait();
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
    public boolean maiorDeDeizoto(){
        long  idade= ChronoUnit.YEARS.between(this.dataNascimento.getValue(),LocalDate.now());
        
        boolean maiorDeDezoito = false;
        if(idade >=  18) maiorDeDezoito = true;
        return maiorDeDezoito;
    }
    public void criarConta() throws ElementoJaExisteException, IOException, NoSuchAlgorithmException,
            UsuarioJaCadastradoException, IDInvalidoException, EmpresaJaCadastradaException {

        boolean cadastroRealizado = false;

        try {
            Empresa novaEmpresa = new Empresa(nomeDaEmpresa.getText(), servicoDaEmpresa.getText());
            Fachada.getInstance().criarNovaEmpresa(novaEmpresa);
            Usuario novoFuncionario = new Funcionario(nome.getText(), removeCaracteresEspeciais(cpf.getText()), senha.getText(),
                    dataNascimento.getValue(), novaEmpresa);
                    ControladorUsuario.getInstance().cadastrarUsuario(novoFuncionario);
            System.out.println(novoFuncionario.getSenha());
            cadastroRealizado = true;
        } catch (EmpresaJaCadastradaException | IDInvalidoException | MenorDeIdadeException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Cadastro não realizado, empre");
            alert.setContentText("");
            alert.showAndWait();
            
            
        }

        System.out.println(ControladorUsuario.getInstance().listarUsuarios());

        if (cadastroRealizado == true) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastro realizado");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro realizado com sucesso. Faça seu login!");

            alert.showAndWait();

            criarContaDoFuncionario.setFont(Font.font(16));
            criarContaDoFuncionario.setText("Faça seu login.");
            criarContaDoFuncionario.setOnAction(new EventHandler<ActionEvent>() {
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