package com.example.bankomat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class TransferController {
    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }

    @FXML
    private TextField receiverTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField PINTextField;

    @FXML
    private Button acceptButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void onAcceptButton(ActionEvent actionEvent) {
        String receiver = receiverTextField.getText();
        double amount = Double.parseDouble(amountTextField.getText());
        int PIN = Integer.parseInt(PINTextField.getText());

        if (bankomat.transfer(receiver, amount, PIN)){
            bankomat.logTransaction(bankomat.getCurrentUserLogin(), "Transfer", receiver, amount);
            System.out.println("Transfered: " + amount + " to " + receiver);
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
            System.out.println("Transfer failed.");
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

