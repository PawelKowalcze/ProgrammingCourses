package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePinController {
    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }

    @FXML
    private TextField oldPinTextField;

    @FXML
    private TextField newPinTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void onConfirmButton(ActionEvent actionEvent) {
        int oldPin = Integer.parseInt(oldPinTextField.getText());
        int newPin = Integer.parseInt(newPinTextField.getText());
        String login = bankomat.getCurrentUserLogin();
        System.out.println("Changing pin..."+ login  + oldPin + newPin);

        if (bankomat.changePin(login, newPin, oldPin)) {
            System.out.println("Pin has been changed.");
            try {
                // Load the second scene's FXML file
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoggedIn.fxml"));


                // Create a new stage (window)
                Stage stag = new Stage();
                stag.setTitle("Logged In");
                stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

                LoggedInController controller = loader.getController();
                controller.setBankomat(bankomat);

                // Show the new window
                stag.show();

                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();

            } catch (Exception e) {
                showAlert("Error", "Input data is invalid!");
                e.printStackTrace();
            }
        } else {
            showAlert("Error", "Input data is invalid!");
            System.out.println("Change failed.");
        }


    }

    public void onCancelButton(ActionEvent actionEvent) {
        System.out.println("Change canceled.");
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoggedIn.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Logged In");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            LoggedInController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
