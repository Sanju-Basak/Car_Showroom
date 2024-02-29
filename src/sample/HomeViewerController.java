package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HomeViewerController {

    private Main main;

    public void regnumPressed(ActionEvent actionEvent) {
        try {
            main.showCarbyRegPage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void setMain(Main main) {
        this.main = main;
    }

    public void makemodelPressed(ActionEvent actionEvent) {
        try {
            main.showCarbyMakePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewcarPressed(ActionEvent actionEvent) {
        try {
            main.oos.writeUnshared("viewCar");
            String s= (String)main.ois.readUnshared();
            //listview
            main.showCarbyViewPageViewer(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void buycarPressed(ActionEvent actionEvent)
    {
        try {
            main.showBuyCarPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
