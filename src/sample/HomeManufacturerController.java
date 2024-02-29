package sample;

import DataCar.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HomeManufacturerController {
    @FXML
    public Label welcome;
    private Main main;

    @FXML
    private Button button;

    /*public void init(String msg) {
        //message.setText(msg);
        //Image img = new Image(Main.class.getResourceAsStream("1.png"));
        //image.setImage(img);
    }*/

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void viewcarAction(ActionEvent actionEvent) {
        try {
            main.oos.writeUnshared("viewCar");
            String s= (String)main.ois.readUnshared();
            //listview
            main.showCarbyViewPageManu(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAction(ActionEvent actionEvent) {
        try {
            main.showDeleteCarPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addcarAction(ActionEvent actionEvent) {
        try {
            main.showAddCarPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editcarAction(ActionEvent actionEvent) {
        try {
            main.showEditCarPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
