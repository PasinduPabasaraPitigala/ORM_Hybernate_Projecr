package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Route;

import java.io.IOException;

public class MainPageController {
    public Button MainLoginbtn;
    public AnchorPane AnchorPane1;

    public void btnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.LOGINFORM,AnchorPane1);
    }
}
