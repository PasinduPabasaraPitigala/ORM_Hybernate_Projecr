package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Route;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane DashMainPanel;
    public Button btnStudent;
    public Button btnRooms;
    public Button btnResevation;
    public Button btnUser;
    public Button btnBack;
    public AnchorPane Pane1;

    public void StudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.STUDENTFORM,DashMainPanel);
    }

    public void RoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.ROOMFORM,DashMainPanel);
    }

    public void ResevationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.RESERVATION,DashMainPanel);
    }

    public void UserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.USERFORM,DashMainPanel);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.LOGINFORM,Pane1);
    }
}
