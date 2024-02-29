package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main extends Application {
    private Stage stage;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;
    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException{
        Socket socketServer= new Socket("127.0.0.1", 44444);
        ois= new ObjectInputStream(socketServer.getInputStream());
        oos= new ObjectOutputStream(socketServer.getOutputStream());
        //new ReadThread(this);
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 584, 450));
        stage.show();
    }
    public void showHomeManufacturerPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homeManufacturer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeManufacturerController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }

    public void showHomeViewerPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homeViewer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeViewerController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();

    }
    public void showCarbyRegPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showcarbyreg.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ShowcarbyregController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Registration");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();

    }

    public void showCarbyMakePage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showcarbymake.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ShowcarbymakeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Car by Make & Model");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();

    }
    public void showCarbyViewPageManu(String s) throws Exception
    {
        String str= s;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showviewCar.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ShowviewCarController controller = loader.getController();
        controller.init(str);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Car lists");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }

    public void showCarbyViewPageViewer(String s) throws Exception
    {
        String str= s;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showviewCar2.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ShowviewCarController2 controller = loader.getController();
        controller.init(str);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Car Lists");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }

    public void showDeleteCarPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("deleteCar.fxml"));
        Parent root = loader.load();

        // Loading the controller
        deletecarController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Delete");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public void showBuyCarPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("buycar.fxml"));
        Parent root = loader.load();

        // Loading the controller
        BuyCarController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Buy");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public void showAddCarPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addCar.fxml"));
        Parent root = loader.load();

        // Loading the controller
        addCarController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Add");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public void showEditCarPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editcar.fxml"));
        Parent root = loader.load();

        // Loading the controller
        editCarController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Edit");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public void showEditCarPage2(String  str) throws Exception
    {
        String s= str;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editcar2.fxml"));
        Parent root = loader.load();

        // Loading the controller
        editCarController2 controller = loader.getController();
        controller.init(s);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Edit");
        stage.setScene(new Scene(root, 586, 450));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
