package br.com.banco.screen;

import br.com.banco.App;
import br.com.banco.enums.ContaT;
import br.com.banco.enums.Operacao;
import br.com.banco.enums.Status;
import br.com.banco.model.Conta;
import br.com.banco.model.Results;
import br.com.banco.model.Titular;
import br.com.banco.model.Transacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController  implements Initializable {

    private App mainApp;


    public void HomeController(App mainApp) {
        this.mainApp = mainApp;

        this.updateHome();

    }

    @FXML
    private void depositar(){

        var msg  =  mainApp.promptInput("Valor de depósito");

        if( msg != null && !msg.isBlank()){
            double valor = 0.0;
            Results result = null;


            try {
                valor = Double.parseDouble(msg);

                 result = mainApp.contaController.depositar(
                        mainApp.contaLogada,
                        valor,
                        null
                );

            } catch (Exception  e) {

                result = new Results("Valor invalido", Status.ERROR, null);
            }





            switch (result.getStatus()){
                case SUCCESS -> {
                    mainApp.showAlert("Sucesso", result.getMsg(), Alert.AlertType.INFORMATION);
                    this.updateHome();

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
    private void sacar(){

        var msg  =  mainApp.promptInput("Valor de Saque");

        if( msg != null && !msg.isBlank()){
            double valor = 0.0;
            Results result = null;


            try {
                valor = Double.parseDouble(msg);

                result = mainApp.contaController.sacar(
                        mainApp.contaLogada,
                        valor
                );

            } catch (Exception  e) {

                result = new Results("Valor invalido", Status.ERROR, null);
            }



            switch (result.getStatus()){
                case SUCCESS -> {
                    mainApp.showAlert("Sucesso", result.getMsg(), Alert.AlertType.INFORMATION);
                    this.updateHome();

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
    private void transferir(){

        mainApp.transferirScreen();
        updateHome();


    }


    @FXML
    private Button btn_transferir;

    @FXML
    private void logout(){
        mainApp.logaout();
    }


    @FXML
    private Label labelNome;

    @FXML
    private Label labelConta;

    @FXML
    private Label labelTipoConta;

    @FXML
    private Label labelSaldo;


    @FXML
    private TableView<Transacao> tableTransacoes;



    @FXML
    private TableColumn<Transacao, String> tbc_desc;

    @FXML
    private TableColumn<Transacao, Operacao> tbc_operacao ;

    @FXML
    private TableColumn<Transacao, Double> tbc_valor ;

    @FXML
    private TableColumn<Transacao, LocalDateTime> tbc_data ;







    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Vincula a coluna ao atributo "descricao" da classe Transacao
        tbc_desc.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        // Vincula a coluna ao atributo "operacao"
        tbc_operacao.setCellValueFactory(new PropertyValueFactory<>("operacao"));

        // Vincula a coluna ao atributo "valor"
        tbc_valor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        // Vincula a coluna ao atributo "data"
        tbc_data.setCellValueFactory(new PropertyValueFactory<>("data"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        tbc_data.setCellFactory(column -> new TableCell<Transacao, LocalDateTime>() {
            @Override
            protected void updateItem(LocalDateTime item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(formatter.format(item));
                }
            }
        });


    }

    private void atualizarTabela() {
        if (this.mainApp != null && this.mainApp.contaLogada != null) {
            // Pega a lista de transações da conta
            List<Transacao> lista = this.mainApp.contaLogada.getExtrato();
            // Converte para ObservableList (necessário para TableView)
            ObservableList<Transacao> obsList = FXCollections.observableArrayList(lista);
            // Joga os dados na tabela
            tableTransacoes.setItems(obsList);
        }
    }


    private void updateHome(){

        if(this.mainApp != null && this.mainApp.contaLogada != null){

            Conta conta  = this.mainApp.contaLogada;
            Titular titular = conta.getTitular();

            if(conta.getTipo() == ContaT.SALARIO){
                btn_transferir.setDisable(true);
            }


            labelNome.setText(titular.getNome());
            labelConta.setText(conta.getNumeroConta().toString());
            labelSaldo.setText(Double.toString(conta.getSaldo()));
            labelTipoConta.setText(conta.getTipo().name());

            this.atualizarTabela();

        }

    }
}
