package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ShowcarbyregController {
    @FXML
    public TextField regtext;
    @FXML
    public TextArea massage2;
    @FXML
    public Button search;

    private Main main;

    void setMain(Main main) {
        this.main = main;
    }

    public void searchAction(ActionEvent actionEvent) {
        String s= regtext.getText();
        System.out.println(s);
        s= "regNum," + s;
        try {
            main.oos.writeUnshared(s);
            String s1= (String) main.ois.readUnshared();
            massage2.setText(s1);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            main.showHomeViewerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
