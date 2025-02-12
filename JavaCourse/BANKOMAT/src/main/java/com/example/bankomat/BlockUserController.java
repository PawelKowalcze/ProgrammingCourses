package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class BlockUserController {
    private Bankomat bankomat;
    public void setBankomat(Bankomat bankomat) {
        this.bankomat = bankomat;
    }

    @FXML private TextField login;

    public void onBlock(ActionEvent actionEvent){
        try{
               String log = login.getText();
               if(bankomat.loginExist(log) && !log.equals("admin")){
                    bankomat.blockAccount(log);
                    showAlert("Alert", "User Successfully Blocked");
               }else{
                   showAlert("Error", "User does not exist");
               }
        }catch (Exception e){
            showAlert("Error", "Invalid username");
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