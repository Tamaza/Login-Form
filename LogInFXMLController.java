/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginForm.controller;

import LoginForm.model.oop.LogIn;
import LoginForm.model.oop.User;
import LoginForm.view.Runner;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInFXMLController implements Initializable {
    
    @FXML
    private Label usernameLabel, passwordLabel, forgotLabel, registerLabel;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button enterButton;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    
    public void actionOnRegisterLabelClicked() throws IOException {
        Runner r = new Runner();
        Parent root = FXMLLoader.load(r.getClass().getResource("RegistrationFXML.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Registration");
        stage.setResizable(false);
        stage.showAndWait();
    }
    
    public void actionOnForgotPasswordLabelClicked() throws IOException {
        Runner r = new Runner();
        Parent root = FXMLLoader.load(r.getClass().getResource("ForgotPasswordFXML.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Forgot Password?");
        stage.setResizable(false);
        stage.showAndWait();
    }
    
    public void actionOnEnterButton() throws IOException {
        String username = usernameField.getText();
        String password = Integer.toString(passwordField.getText().hashCode());
        if (LogIn.logIn(username, password)) {
            User.currentUsername = username;
            Runner r = new Runner();
            Parent root = FXMLLoader.load(r.getClass().getResource("ChatFXML.fxml"));
            Scene scene = new Scene(root);
            Runner.setScene(scene);
        } else {
            // AlterBox
        }
    }
    
}
