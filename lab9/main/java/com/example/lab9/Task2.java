package com.example.lab9;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Task2 {
    public TextField text_floor;

    @FXML
    protected void onClickButtonTask2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Завдання 2 switch");
        alert.setHeaderText(null);
        String number = text_floor.getText();
        int quantity_floor = 9;
        int quantity_kvar = 5;
        double choice = Math.ceil(Double.parseDouble(number)/quantity_kvar);
        switch ((int) Math.round(choice)) {
            case 1 -> alert.setContentText("Ви на 1 поверсі");
            case 2 -> alert.setContentText("Ви на 2 поверсі");
            case 3 -> alert.setContentText("Ви на 3 поверсі");
            case 4 -> alert.setContentText("Ви на 4 поверсі");
            case 5 -> alert.setContentText("Ви на 5 поверсі");
            case 6 -> alert.setContentText("Ви на 6 поверсі");
            case 7 -> alert.setContentText("Ви на 7 поверсі");
            case 8 -> alert.setContentText("Ви на 8 поверсі");
            case 9 -> alert.setContentText("Ви на 9 поверсі");
            default -> alert.setContentText("Такого поверху не існує");
        }
        alert.showAndWait();
    }
}
