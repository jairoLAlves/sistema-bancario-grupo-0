module br.com.banco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.bootstrapfx.core;
    requires spring.security.crypto;
    requires jakarta.validation;
    requires org.hibernate.validator;

    requires jdk.jshell;


    opens br.com.banco.validations to org.hibernate.validator;
    opens br.com.banco to javafx.fxml;
    opens br.com.banco.screen to javafx.fxml;
    exports br.com.banco;

}