package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editCarController {
    @FXML
    public TextField regText;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public void searchAction(ActionEvent actionEvent) {
        String s= "EditCar," + regText.getText();
        try {
            main.oos.writeUnshared(s);
            String str= (String)main.ois.readUnshared();
            main.showEditCarPage2(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backAction(ActionEvent actionEvent) {
        try {
            main.showHomeManufacturerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
