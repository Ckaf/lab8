package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.tools.ErorAlert;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Button entrance;

    @FXML
    private Button registration;

    @FXML
    void initialize() {
        entrance.setOnAction(event -> {
            if (!pass_field.getText().isEmpty() && !login_field.getText().isEmpty()) {
                SendCommand.Autorizaton(pass_field.getText(), login_field.getText());
                Stage stage = (Stage) registration.getScene().getWindow();
                // do what you have to do
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/visual/work.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Lab 8");
                stage.setScene(new Scene(root1));
                stage.show();
            } else {
                ErorAlert.alert("Ошибка ввода данных, поля не могут быть пустыми");
            }
        });
        registration.setOnAction(event -> {
            if (!pass_field.getText().isEmpty() && !login_field.getText().isEmpty()) {
                SendCommand.Registration(pass_field.getText(), login_field.getText());

                Stage stage = (Stage) registration.getScene().getWindow();
                // do what you have to do
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/visual/work.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Lab 8");
                stage.setScene(new Scene(root1));
                stage.show();
            } else {
                ErorAlert.alert("Ошибка ввода данных, поля не могут быть пустыми");
            }
        });

    }
}
