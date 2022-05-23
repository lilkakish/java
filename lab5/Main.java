package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.print("Виберіть завдання [1],[2] -> ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    task1();
                    break;
                case "2":
                    task2();
                    break;
                default:
                    System.out.println("Незрозуміла команда");
                    break;
                case "0":
                    loop = false;
                    break;
            }
        }
    }
    public static void task1(){
        System.out.print("Введіть будь яку фразу -> ");
        String input = new Scanner(System.in).nextLine();
        System.out.println("-------------------------");
        System.out.println("Слово: "+ input);

        String[] ary = input.split(" ");
        ArrayList<String> array = new ArrayList<>();
        for (String s:ary) {
            if(s.toCharArray()[0]!=s.toCharArray()[s.toCharArray().length-1] || s.toCharArray().length ==1){
                array.add(s);
            }
        }
        System.out.print("Новий масив: ");
        for (String s:array) {
            System.out.print(s+" ");
        }
        System.out.print("\n");
        int count = 0;
        //якщо введене хоча б одне слово
        if(input.length() != 0){
            count++;
            //перевірка чи символ не пробіл
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == ' '){
                    //якщо пробіл - збільшуєм число на 1
                    count++;
                }
            }

        }
        System.out.println("Кількість слів у рядку: "+ count);
        try {
            List<String> lines = Files.readAllLines(Paths.get("words.txt"), StandardCharsets.UTF_8);
            for(String line: lines){
                System.out.println("Кількість символів у рядку : "+ line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void task2() {

        try(FileWriter writer = new FileWriter("sport.txt", true))
        {

            writer.write("Член жюрі : Добрий Олег Степанович\n");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get("sport.txt"), StandardCharsets.UTF_8);
            for(String line: lines){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

