package com.example.bankomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button acceptButton;

    @FXML
    private ChoiceBox<String> locationChoiceBox;

    @FXML
    private ChoiceBox<String> bankChoiceBox;


    @FXML
    public void onAcceptButton(ActionEvent actionEvent){
        createBankomatInstance();
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

            // Close the previous stage
            Stage currentStage = (Stage) acceptButton.getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String selectedLocation;
    private String selectedBank;
    private Bankomat bankomat;

    public void initialize() {
        System.out.println("HelloController initialized");
        locationChoiceBox.getItems().addAll("Kraków");
        locationChoiceBox.setValue("Kraków");
        selectedLocation = "Kraków"; // Default value

        bankChoiceBox.getItems().addAll("PKO", "Millenium", "ING", "Santander", "mBank", "Alior", "Getin", "Pekao", "Credit Agricole", "Deutsche Bank");
        bankChoiceBox.setValue("PKO");
        selectedBank = "PKO"; // Default value

        locationChoiceBox.setOnAction(event -> {
            selectedLocation = locationChoiceBox.getValue();
        });

        bankChoiceBox.setOnAction(event -> {
            selectedBank = bankChoiceBox.getValue();
        });
    }

    private void createBankomatInstance() {
        if (selectedLocation != null && selectedBank != null) {
            bankomat = new Bankomat(selectedBank, selectedLocation, 100000.0);
            System.out.println("Bankomat created with bank: " + selectedBank + " and location: " + selectedLocation);
            bankomat.addUser(new UserAdmin("admin", bankomat), 5555);
        }
    }

    public Bankomat getBankomat() {
        return bankomat;
    }
}
