package com.example.lab9;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public ToggleGroup TasksGroup;
    public RadioButton radiobutton1;
    public RadioButton radiobutton2;

    @FXML
    private ToggleGroup chooseTask;

    @FXML
    protected void onChooseTaskMenu() {
        try{
            if(radiobutton1.isSelected()){
                task1();
            }
            if(radiobutton2.isSelected()){
                task2();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void task1() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("task1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Завдання 1");
        stage.setScene(scene);
        stage.show();
    }

    protected void task2() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("task2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Завдання 2");
        stage.setScene(scene);
        stage.show();}
}