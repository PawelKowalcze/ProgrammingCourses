package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AtmDepositController {
    private Bankomat bankomat;
    private UI_adminController adminController;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }
    public void setAdminController(UI_adminController adminController){
        this.adminController = adminController;
    }

    @FXML private TextField amount;

    public void onDeposit(ActionEvent actionEvent){
        try {
            double money = Double.parseDouble(amount.getText());
            if(!bankomat.makeWplataAtm(money)){
               showAlert("Error", "Range exceeded");
            }else{
                bankomat.logTransaction("admin", "deposit", "ATM", money);
                adminController.refresh();
            }

        } catch (Exception e) {
            showAlert("Deposit Error", "Invalid amount entered. Please enter a valid number.");
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