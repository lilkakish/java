package com.example.lab9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Task1 {
    public TextField text_a;
    public TextField text_b;
    public Label sa;
    public Label sg;

    @FXML
    protected void onClickButtonTask1() {
        try{
        Integer a = Integer.parseInt(text_a.getText());
        Integer b = Integer.parseInt(text_b.getText());
        int ser_a = (a+b)/2;
        double ser_g = Math.sqrt(a*b);
        sa.setText("Середнє арифметичне: "+Integer.toString(ser_a));
        sg.setText("Середнє геометричне: "+Double.toString(ser_g));
        }
        catch (Exception e){
            sa.setTextFill(Paint.valueOf("red"));
            sa.setText("Невірно введені значення або поля пусті");
            sa.setTextFill(Paint.valueOf("black"));
            sg.setText("");
        }
    }
}
