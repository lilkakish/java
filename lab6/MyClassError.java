package com.company;

public class MyClassError extends Exception{
    public String toString()
    {
        return "Помилка! Ви неправильно ввели дату. Введіть в форматі дд/мм/рррр";
    }
}
