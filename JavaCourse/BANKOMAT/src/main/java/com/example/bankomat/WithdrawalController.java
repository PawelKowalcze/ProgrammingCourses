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

import java.io.IOException;

public class WithdrawalController {
    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }


    @FXML
    private Button acceptButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField amountTextField;

    @FXML
    public void onAcceptButton(ActionEvent actionEvent){
        double withdrawAmount = Double.parseDouble(amountTextField.getText());
        if (bankomat.makeWyplata(withdrawAmount)) {
            bankomat.logTransaction(bankomat.getCurrentUserLogin(), "Withdrawal", bankomat.getCurrentUserLogin(), withdrawAmount);
            System.out.println("withdrawed: " + withdrawAmount);
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
            System.out.println("withdraw failed.");
        }
    }

    public void onCancelButton(ActionEvent actionEvent) {
        System.out.println("Transfer canceled.");
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