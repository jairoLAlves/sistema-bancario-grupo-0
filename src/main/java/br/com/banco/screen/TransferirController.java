package br.com.banco.screen;

import br.com.banco.App;
import br.com.banco.model.Conta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TransferirController  implements Initializable {

    private App mainApp;
    private Optional<Conta> destinatario;


    private ObservableList<Conta> dadosDaLista = FXCollections.observableArrayList();

    public void TransferirController(App mainApp) {
        this.mainApp = mainApp;
        destinatario = Optional.empty();
        this.updateScreen();

    }


    private void updateScreen(){
        dadosDaLista.clear();

        if(mainApp != null){
            String cpf = text_cpf.getText();
            if(cpf != null && !cpf.isBlank()){
                dadosDaLista.addAll(mainApp.contaController.buscarPorCpf(cpf));
            }else{
                dadosDaLista.addAll(mainApp.contaController.getContas());
            }

        }
    }

    @FXML
    private void transferir(){

        String str_valor = valor_transferencia.getText();

        if(str_valor != null  && !str_valor.isBlank() ){
            Double valor = Double.parseDouble(str_valor);

            destinatario.ifPresent(conta -> {

               var result =  mainApp.contaController.transferir(mainApp.contaLogada, conta.getNumeroConta(), valor);

                switch (result.getStatus()){
                    case SUCCESS -> {
                        mainApp.showAlert("Sucesso", result.getMsg(), Alert.AlertType.INFORMATION);
                    }
                    case INFO -> {
                        mainApp.showAlert("Info", result.getMsg(), Alert.AlertType.WARNING);
                    }
                    case ERROR -> {
                        mainApp.showAlert("Error", result.getMsg(), Alert.AlertType.ERROR);

                    }

                }


            });

        }



    }

    @FXML
    private Label lbl_nome_titular;
    @FXML
    private Label lbl_tipo_conta;

    @FXML
    private ListView<Conta> list_view_contas;


    @FXML
    private TextField text_cpf;

    @FXML
    private TextField valor_transferencia;

    @FXML
    private void buscar(){
        updateScreen();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        list_view_contas.setItems(dadosDaLista);

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

        TextFormatter<String> textFormatterValor = new TextFormatter<>(change -> {
            String novoTexto = change.getControlNewText();
            // Regex: \\d* significa "apenas dígitos"
            if (novoTexto.matches("\\d*")) {
                return change;
            }
            return null; // Rejeita a mudança se tiver letras
        });



        text_cpf.setTextFormatter(textFormatterCPF);
        valor_transferencia.setTextFormatter(textFormatterValor);

        list_view_contas.setCellFactory(param -> new ListCell<Conta>() {
            @Override
            protected void updateItem(Conta item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {

                    setText("Titular: " + item.getTitular().getNome() + " - Conta: " + item.getNumeroConta()+" - Tipo: "+item.getTipo());
                }
            }
        });



        list_view_contas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                // Exemplo: preencher os labels ao clicar
                lbl_nome_titular.setText(newValue.getTitular().getNome());
                lbl_tipo_conta.setText(newValue.getTipo().toString());
                destinatario = Optional.of(newValue);

                destinatario.ifPresent(conta -> System.out.println("Selecionado: " + conta));

            }
        });

    }
}
