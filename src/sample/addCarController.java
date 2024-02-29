package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addCarController {

    @FXML
    public TextField message;
    @FXML
    public Label confirm;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }

    public void addAction(ActionEvent actionEvent) {
        String s= "addCar," + message.getText();
        try {
            main.oos.writeUnshared(s);
            if((Boolean)main.ois.readUnshared())
                confirm.setText("Added Successfully !");
            else
                confirm.setText("Give car info properly !");
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
