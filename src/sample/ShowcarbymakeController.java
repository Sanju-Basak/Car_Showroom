package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ShowcarbymakeController {
    @FXML
    public Button searchbutton;
    @FXML
    public TextField modeltext;
    @FXML
    public TextField makeText;
    @FXML
    public TextArea massege;

    private Main main;
    public void searchAction(ActionEvent actionEvent) {
        String s1= makeText.getText();
        String s2= modeltext.getText();
        String s= "CarMake&Model," + s1 + ","+ s2;
        try {
            main.oos.writeUnshared(s);
            String str= (String) main.ois.readUnshared();
            if(str.equals(""))
                massege.setText("Not found !!");
            else
                massege.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void setMain(Main main) {
        this.main = main;
    }

    public void backAction(ActionEvent actionEvent) {
        try {
            main.showHomeViewerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
