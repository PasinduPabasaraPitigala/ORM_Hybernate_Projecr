package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Route;

import java.io.IOException;

public class LoginFormController {
    public PasswordField lblPassword;
    public TextField lblUserName;
    public Button btnLogin;
    public AnchorPane AnchorPane1;

    public void btnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.DASHBOARD,AnchorPane1);
        System.out.println(lblUserName.getText());
        String tempUsername =lblUserName.getText();
        String tempPassword =lblPassword.getText();
        System.out.println(lblPassword.getText());
        if (tempUsername.equals("Pasindu") && tempPassword.equals("2001")) {
            /*Navigation.navigate(Route.DASHBOARD,Anchorpane1);*/
            Navigation.navigate(Route.DASHBOARD,AnchorPane1);
            System.out.println(lblPassword.getText());
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try again!").show();
        }
    }
}
