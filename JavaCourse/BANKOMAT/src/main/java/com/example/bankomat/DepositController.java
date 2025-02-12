package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class DepositController {

    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }

    @FXML
    private TextField depositTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void onConfirmButton(ActionEvent actionEvent) {
        double depositAmount = Double.parseDouble(depositTextField.getText());
        if (bankomat.makeWplata(depositAmount)) {
            bankomat.logTransaction(bankomat.getCurrentUserLogin(), "Deposit", bankomat.getCurrentUserLogin(), depositAmount);
            System.out.println("Deposited: " + depositAmount);
            System.out.println("Balance: " + bankomat.getUserSaldo());
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
            System.out.println("Deposit failed.");
        }


    }

    public void onCancelButton(ActionEvent actionEvent) {
        System.out.println("Deposit canceled.");
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