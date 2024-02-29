package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deletecarController
{
    @FXML
    public TextField regText;
    @FXML
    public Label confirm;

    private Main main;
    void setMain(Main main) {
        this.main = main;
    }

    public void deleteAction(ActionEvent actionEvent) {
        String s= "deleteCar,"+ regText.getText();
        try {
            main.oos.writeUnshared(s);
            if((Boolean)main.ois.readUnshared())
                confirm.setText("Deleted Successfully !");
            else
                confirm.setText("Not found !!");
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