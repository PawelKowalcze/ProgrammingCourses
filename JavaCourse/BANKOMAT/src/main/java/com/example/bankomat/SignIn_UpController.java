package com.example.bankomat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class SignIn_UpController {
    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
        refresh();
    }

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField bankTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField signUpLoginTextField;

    @FXML
    private TextField signUpPINTextField;

    @FXML
    private TextField signInLoginTextField;

    @FXML
    private TextField signInPINTextField;



    void refresh (){
        bankTextField.setText(bankomat.getBank());
        locationTextField.setText(bankomat.getLocation());
    }

   public void onSignUpButton(ActionEvent actionEvent) {
    try {
        String newLogin = signUpLoginTextField.getText();
        int newPIN = Integer.parseInt(signUpPINTextField.getText());

        if(!bankomat.loginExist(newLogin)){
            bankomat.addUser(new UserAdmin(newLogin, bankomat), newPIN);
            System.out.println("User added: " + newLogin);
            signUpLoginTextField.clear();
            signUpPINTextField.clear();
            refresh();
       } else {
            showAlert("Error", "User with this login already exists!");
        }
    } catch(Exception e) {
        showAlert("Error", "Input data is invalid!");
    }
}

    public void onSignInButton(ActionEvent actionEvent) {
    try {
        String login = signInLoginTextField.getText();
        int pin = Integer.parseInt(signInPINTextField.getText());

        if (bankomat.zaloguj(login, pin)) {
            System.out.println("User logged in: " + login);
            try {
                // Load the second scene's FXML file
                if(!login.equals("admin")){
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoggedIn.fxml"));

                // Create a new stage (window)
                Stage stag = new Stage();
                stag.setTitle("Logged In");
                stag.setScene(new Scene(loader.load(), 600, 400)); // Set the size of the new window

                LoggedInController controller = loader.getController();
                controller.setBankomat(bankomat);

                // Show the new window
                stag.show();

                // Close the old window
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();
                }
                else{
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("UI_admin.fxml"));

                    // Create a new stage (window)
                    Stage stag = new Stage();
                    stag.setTitle("Admin panel");
                    stag.setScene(new Scene(loader.load(), 400, 269)); // Set the size of the new window

                    UI_adminController controller = loader.getController();
                    controller.setBankomat(this.bankomat);

                    // Show the new window
                    stag.show();

                    // Close the old window
                    Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    currentStage.close();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Error", "Input data is invalid or user blocked!");
        }
    }catch (Exception e) {
        showAlert("Error", "Input data is invalid!");
    }

        signInLoginTextField.clear();
        signInPINTextField.clear();
        refresh();
    }



    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



