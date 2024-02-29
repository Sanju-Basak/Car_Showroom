package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ShowviewCarController {
    @FXML
    public TextArea massege;
    private Main main;

    void setMain(Main main) {
        this.main = main;
    }
    public void init(String str)
    {
        massege.setText(str);
    }
    public void backAction(ActionEvent actionEvent) {
        try {
            main.showHomeManufacturerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
