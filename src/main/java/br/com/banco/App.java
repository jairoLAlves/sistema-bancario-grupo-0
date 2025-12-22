package br.com.banco;
import br.com.banco.controller.ContaController;
import br.com.banco.model.Conta;
import br.com.banco.model.Transacao;
import br.com.banco.screen.HomeController;
import br.com.banco.screen.LoginController;
import br.com.banco.screen.TransferirController;
import br.com.banco.services.ContaService;
import br.com.banco.utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdk.jshell.execution.Util;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;


public class App extends Application  {

    public final ContaController contaController = new ContaController();
    private Stage stage;
    public  Conta contaLogada = null;
    private Utils utils = new Utils();


    @Override
    public void start(Stage stage) throws Exception {

        try {

            this.stage = stage;

            loginScreen();
            stage.show();



        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    public void loginScreen()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 450, 450);

            LoginController controller = fxmlLoader.getController();

            controller.LoginController(this);


            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

            this.stage.setTitle("Login");
            this.stage.setResizable(false);
            this.stage.setScene(scene);

        } catch (Exception e) {

            e.printStackTrace();
            // TODO - mostar tela de error
        }



    }

    public void homeScreen()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);

            HomeController controller = fxmlLoader.getController();

            controller.HomeController(this);

            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            this.stage.setTitle("Home");
            this.stage.setResizable(false);
            this.stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO - mostar tela de error
        }






    }


    public void logaout(){
        this.contaLogada = null;
        this.loginScreen();
    }

    public void transferirScreen() {
        try {
            Stage popupStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transferir.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);

            TransferirController controller = fxmlLoader.getController();
            controller.TransferirController(this);

            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initOwner(this.stage);
            popupStage.setTitle("Transferir");
            popupStage.setScene(scene);
            popupStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void showAlert(String titulo, String msg, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public String promptInput(String msg) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Operação");
        dialog.setHeaderText(null);

        dialog.getEditor().setTextFormatter(
                new TextFormatter<>(change -> {
                    String novoTexto = change.getControlNewText();
                    // Regex: \\d* significa "apenas dígitos"
                    if (novoTexto.matches("\\d*")) {
                        return change;
                    }
                    return null; // Rejeita a mudança se tiver letras
                })
        );

        dialog.setContentText(msg);
        return dialog.showAndWait().orElse(null);
    }



}