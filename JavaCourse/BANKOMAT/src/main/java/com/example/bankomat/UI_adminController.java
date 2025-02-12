package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public class UI_adminController {
    private Bankomat bankomat;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
        refresh();
    }

    @FXML
    private TextField userinfo;

    @FXML
    private TextField atmbalance;

    @FXML
    private TextField lasttransaction;

    @FXML
    private void initialize(){
        userinfo.setText("admin");
    }

    @FXML
    public void onDeposit(ActionEvent actionEvent){
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AtmDeposit.fxml"));

            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Deposit");
            stag.setScene(new Scene(loader.load(), 400,269)); // Set the size of the new window

            AtmDepositController controller = loader.getController();
            controller.setBankomat(bankomat);
            controller.setAdminController(this);

            // Show the new window
            stag.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onWithdrawal(ActionEvent actionEvent){
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AtmWithdrawal.fxml"));

            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("Withdrawal");
            stag.setScene(new Scene(loader.load(), 400,269)); // Set the size of the new window

            AtmWithdrawalController controller = loader.getController();
            controller.setBankomat(bankomat);
            controller.setAdminController(this);

            // Show the new window
            stag.show();

        } catch (IOException e) {
            showAlert("Error", "Error");
        }
    }

    public void onBlock(ActionEvent actionEvent) {
        try {
            // Load the second scene's FXML file
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("BlockUser.fxml"));

            // Create a new stage (window)
            Stage stag = new Stage();
            stag.setTitle("User Blocking");
            stag.setScene(new Scene(loader.load(), 400, 269)); // Set the size of the new window

            BlockUserController controller = loader.getController();
            controller.setBankomat(bankomat);

            // Show the new window
            stag.show();

        } catch (IOException e) {
            showAlert("Error", "Error");
        }
    }

    public void onLogOut(ActionEvent actionEvent){
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
            bankomat.wyloguj();

            // Close the previous stage
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            showAlert("Error", "Error");
        }
    }

    public void onDownload(ActionEvent actionEvent){
        bankomat.downloadTransactionHistory();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void refresh(){
        atmbalance.setText(String.valueOf(this.bankomat.getBalance()));

        String last = bankomat.getLastTransaction();
        if(!last.equals("null")){
            lasttransaction.setText(last + "zł");
        }
    }
}