package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoggedInController {

    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
        refresh();
    }

    @FXML
    private TextField yourBankTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField balanceTextField;

    @FXML
    private TextField loginTextField;

    public void onDepositCashButton(ActionEvent actionEvent) {
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Deposit.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Deposit");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            DepositController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error occured");
        }
        refresh();

     }

    public void onBankTransferButton(ActionEvent actionEvent) {
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("BankTransfer.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Bank Transfer");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            TransferController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error occured");
        }
        refresh();

    }

    public void onChangePINButton(ActionEvent actionEvent) {
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("ChangePIN.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Change PIN");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            ChangePinController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error occured");
        }
        refresh();
    }


    public void onWithdrawCashButton(ActionEvent actionEvent) {
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Withdrawal.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Withdrawal");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            WithdrawalController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error occured");
        }
        refresh();

    }



public void onTransactionHistoryButton(ActionEvent actionEvent) {
        bankomat.downloadUserTransactionHistory(bankomat.getCurrentUserLogin());
}

public void onLogoutButton(ActionEvent actionEvent) {
        bankomat.wyloguj();
        System.out.println("User logged out");
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("SignIn_Up.fxml"));


            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Sign In/Up");
            stag.setScene(new Scene(loader.load(), 600,400)); // Set the size of the new window

            SignIn_UpController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error occured");
        }
}

private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

void refresh() {
    yourBankTextField.setText(bankomat.getBank());
    locationTextField.setText(bankomat.getLocation());
    balanceTextField.setText(Double.toString(bankomat.getUserSaldo()));
    loginTextField.setText(bankomat.getCurrentUserLogin());
}
}

