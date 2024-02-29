package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuyCarController {
    @FXML
    public TextField message;

    @FXML
    public Label confirm;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public void buyAction(ActionEvent actionEvent) {
        String s= "buyCar,"+ message.getText();
        try {
            main.oos.writeUnshared(s);
            if((Boolean)main.ois.readUnshared())
                confirm.setText("Bought Successfully !");
            else
                confirm.setText("Not Available !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backAction(ActionEvent actionEvent) {
        try {
            main.showHomeViewerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
