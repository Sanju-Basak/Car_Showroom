package sample;

import DataCar.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editCarController2 {
    @FXML
    public TextField carInfo;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public void init(String str)
    {
        carInfo.setText(str);
    }

    public void doneAction(ActionEvent actionEvent) {
        String str= "EditCar2," + carInfo.getText();
        try {
            main.oos.writeUnshared(str);
            main.showEditCarPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backAction(ActionEvent actionEvent) throws Exception{
        main.showEditCarPage();
    }

}
