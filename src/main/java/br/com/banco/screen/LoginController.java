package br.com.banco.screen;

import br.com.banco.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class LoginController implements Initializable {

        private App mainApp;


        public void LoginController(App app){
            this.mainApp = app;

        }


        @FXML
        private TextField TextFieldCpf;

        @FXML
        private PasswordField TextFieldSenha;

        @FXML
        protected void btnLogar() {

            String cpf = TextFieldCpf.getText();
            String senha = TextFieldSenha.getText();




            if(mainApp != null){

                var  result = mainApp.contaController.autenticar(cpf, senha);

                switch (result.getStatus()){
                   case SUCCESS -> {
                       mainApp.contaLogada = result.getConta();
                       mainApp.showAlert("Sucesso", result.getMsg(), Alert.AlertType.INFORMATION);
                       mainApp.homeScreen();
                   }
                   case INFO -> {
                       mainApp.showAlert("Info", result.getMsg(), Alert.AlertType.WARNING);
                   }
                   case ERROR -> {
                       mainApp.showAlert("Error", result.getMsg(), Alert.AlertType.ERROR);

                   }


               }



            }



        }

        @FXML
        protected void btnCadastar(){

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TextFormatter<String> textFormatterCPF = new TextFormatter<>(
                change -> {
                    String novoTexto = change.getControlNewText();

                    // Regra 1: Verifica se o texto resultante contém APENAS números (Regex \\d*)
                    // Regra 2: Verifica se o tamanho não excede 11 dígitos
                    if (novoTexto.matches("\\d*") && novoTexto.length() <= 11) {
                        return change; // Aceita a digitação
                    }
                    return null; // Rejeita (não digita nada na tela)
                }
        );
        TextFieldCpf.setTextFormatter(textFormatterCPF);
    }
}
