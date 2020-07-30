package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.Client.Client;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Client.connect("localhost",8000);
        Parent root = FXMLLoader.load(getClass().getResource("/sample/visual/sample.fxml"));
        primaryStage.setTitle("Lab_8");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
