package LoginForm.controller;

import LoginForm.model.enums.Gender;

import LoginForm.model.enums.Month;
import LoginForm.model.exceptions.IllegalEmailException;
import LoginForm.model.exceptions.IllegalNameException;
import LoginForm.model.exceptions.IllegalNumberException;
import LoginForm.model.exceptions.IllegalPasswordException;
import LoginForm.model.exceptions.IllegalSurnameException;
import LoginForm.model.exceptions.IllegalUsernameException;
import LoginForm.model.oop.Checker;
import LoginForm.model.oop.Registration;
import LoginForm.model.oop.User;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RegistrationFXMLController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private Label nameLabel, surnameLabel, usernameLabel, passwordLabel, repeatPassworlabel, mailLabel, numberLabel,
            genderLabel, dateLabel, groupLabel, titleLabel;

    @FXML
    private Label errorNameLabel, errorSurnameLabel, errorUsernameLabel, errorPasswordLabel,
            errorRepeatPasswordLabel, errorMailLabel, errorNamberLabel;

    @FXML
    private TextField nameField, surnameField, usernameField, mailField, numberField;

    @FXML
    private PasswordField passwordField, repeatPasswordField;

    @FXML
    private ComboBox<String> genderComboBox, yearComboBox, monthComboBox, dayComboBox, groupComboBox;

    @FXML
    private Button registerButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // filling gender combobox
        genderComboBox.getItems().clear();
        Gender genders[] = Gender.values();
        for (Gender g : genders) {
            genderComboBox.getItems().add(g.toString());
        }
        genderComboBox.setValue(Gender.FEMALE.toString());

        // filling year combobox
        yearComboBox.getItems().clear();
        for (int i = 2016; i >= 1930; i--) {
            String s = Integer.toString(i);
            yearComboBox.getItems().add(s);
        }
        yearComboBox.setValue("2016");

        // filling month combo box
        monthComboBox.getItems().clear();
        Month months[] = Month.values();
        for (Month m : months) {
            monthComboBox.getItems().add(m.toString());
        }
        monthComboBox.setValue(Month.JANUARY.toString());

        // filling number combobox
        dayComboBox.getItems().clear();
        for (int i = 1; i <= 31; i++) {
            String s = Integer.toString(i);
            dayComboBox.getItems().add(s);
        }
        dayComboBox.setValue("1");



        // authentication
        nameField.textProperty().addListener((e, oldValue, newVale) -> {
            try {
                Checker.validName(newVale);
                errorNameLabel.setText("");
            } catch (IllegalNameException ex) {
                errorNameLabel.setText(ex.getMessage());
            }
        });
        surnameField.textProperty().addListener((e, oldValue, newValue) -> {
            try {
                Checker.validSurname(newValue);
                errorSurnameLabel.setText("");
            } catch (IllegalSurnameException ex) {
                errorSurnameLabel.setText(ex.getMessage());
            }
        });
        usernameField.textProperty().addListener((e, oldValue, newValue) -> {
            try {
                Checker.validUsername(newValue);
                errorUsernameLabel.setText("");
            } catch (IllegalUsernameException ex) {
                errorUsernameLabel.setText(ex.getMessage());
            }
        });
        passwordField.textProperty().addListener((e, oldVale, newValue) -> {
            try {
                Checker.validPassword(newValue);
                errorPasswordLabel.setText("");
            } catch (IllegalPasswordException ex) {
                errorPasswordLabel.setText(ex.getMessage());
            }
        });
        repeatPasswordField.textProperty().addListener((e, oldValue, newValue) -> {
            try {
                Checker.validPassword(newValue);
                if (repeatPasswordField.getText().equals(passwordField.getText())) {
                    errorRepeatPasswordLabel.setText("");
                } else {
                    errorRepeatPasswordLabel.setText("Wrong Password!");
                }
            } catch (IllegalPasswordException ex) {
                errorRepeatPasswordLabel.setText(ex.getMessage());
            }
        });
        mailField.textProperty().addListener((e, oldValue, newValue) -> {
            try {
                Checker.validEmail(newValue);
                errorMailLabel.setText("");
            } catch (IllegalEmailException ex) {
                errorMailLabel.setText(ex.getMessage());
            }
        });
        numberField.textProperty().addListener((e, oldValue, newValue) -> {
            try {
                Checker.validNumber(newValue);
                errorNamberLabel.setText("");
            } catch (IllegalNumberException ex) {
                errorNamberLabel.setText(ex.getMessage());
            }
        });

    }

    public void actionOnRegisterButton() {
        if (!errorMailLabel.getText().equals("")
                || !errorNamberLabel.getText().equals("")
                || !errorNameLabel.getText().equals("")
                || !errorPasswordLabel.getText().equals("")
                || !errorRepeatPasswordLabel.getText().equals("")
                || !errorSurnameLabel.getText().equals("")
                || !errorUsernameLabel.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("!");
            alert.showAndWait();
        } else if (nameField.getText().equals("")
                || surnameField.getText().equals("")
                || usernameField.getText().equals("")
                || passwordField.getText().equals("")
                || repeatPasswordField.getText().equals("")
                || mailField.getText().equals("")
                || numberField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("!");
            alert.showAndWait();
        } else {
            String name = nameField.getText();
            String mail = mailField.getText();
            String number = numberField.getText();
            String password = Integer.toString(passwordField.getText().hashCode());
            String surname = surnameField.getText();
            String username = usernameField.getText();
            String year = yearComboBox.getValue();
            int y = Integer.parseInt(year);
            String month = monthComboBox.getValue();
            int m = 0;
            Month[] months = Month.values();
            for (int i = 0; i < months.length; i++) {
                if (months[i].toString().equals(month)) {
                    m = i;
                }
            }
            String day = dayComboBox.getValue();
            int d = Integer.parseInt(day);
            Date date = new Date(y, m, d);
            String gender = genderComboBox.getValue();
            Gender g = Gender.MALE;
            if (gender.equals("Female")) {
                g = Gender.FEMALE;
            }

            User user = new User(name, surname, username, password, mail, number, g, date);
            Registration.register(user);
        }
    }

}
