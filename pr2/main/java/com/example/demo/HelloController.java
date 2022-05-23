package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class HelloController {
    @FXML
    private Label id_a;
    @FXML
    private Label id_b;
    @FXML
    private Label id_c;
    @FXML
    private TextField text_a;
    @FXML
    private TextField text_b;
    @FXML
    private TextField text_c;
    @FXML
    private Label output;



    @FXML
    protected void onSolveButtonClick() {
        String minimal_value;
        try {
            minimal_value = "Мінімальне число: "+ solve_minimum(Integer.parseInt(text_a.getText()),
                    Integer.parseInt(text_b.getText()), Integer.parseInt(text_c.getText()));
        }
        catch (Exception e){
            minimal_value = "Сталася помилка, невірно введені данні";
        }
        output.setText(minimal_value);
    }
    private int solve_minimum(int a, int b, int c){
        int result;
        if (a<=b && a<=c){
            result = a;
        }
        else if (b<=a && b<=c){
            result = b;
        }
        else{
            result = c;
        }
        return result;
    }
}