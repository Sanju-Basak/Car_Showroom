package sample;

import LoginServer.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class LoginController {

    private Main main;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    void loginAction(ActionEvent event) {
        String userName = userText.getText();
        String password = passwordText.getText();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);
        try {
            main.oos.writeUnshared(loginDTO);
            loginDTO=(LoginDTO) main.ois.readUnshared();
            if (loginDTO.isStatus()) {
                try {
                    main.showHomeManufacturerPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if(loginDTO.getUserName().equals("viewer")) {
                main.showHomeViewerPage();
            }
            else
            {
                main.showAlert();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

}
