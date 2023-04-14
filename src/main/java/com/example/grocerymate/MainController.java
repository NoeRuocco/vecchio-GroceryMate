package com.example.grocerymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainController {
    //After starting the application the start button will show the login view
    @FXML
    Button StartButton;
    public void ShowLoginView(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) StartButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/start/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //Login method -> spostarlo in UserManagement
    @FXML
    TextField UsernameField;
    @FXML
    PasswordField PasswordField;
    @FXML
    Label LoginStatusLabel;
    @FXML
    Button LoginButton;
    String username = "admin";
    String password = "admin";
    public void UserLogin(ActionEvent actionEvent) {
        String username_input = UsernameField.getText();
        String password_input = PasswordField.getText();


        if (username_input.compareTo(username) == 0 && password_input.compareTo(password) == 0) {
            Stage stage = (Stage) LoginButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/grocery/GroceryList.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            stage.show();

        }
        else
            LoginStatusLabel.setText("Login status: INVALID USERNAME OR PASSWORD.");
    }
}