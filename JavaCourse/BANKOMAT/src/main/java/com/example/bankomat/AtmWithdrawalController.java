package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AtmWithdrawalController {
    private Bankomat bankomat;
    private UI_adminController adminController;

    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }
    public void setAdminController(UI_adminController adminController){
        this.adminController = adminController;
    }

    @FXML private TextField amount;

    public void onWithdrawal(ActionEvent actionEvent){
        try {
            double money = Double.parseDouble(amount.getText());
            if(!bankomat.makeWyplataAtm(money)){
               showAlert("Error", "Range exceeded");
            }else{
                bankomat.logTransaction("admin", "withdrawal", "ATM", money);
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