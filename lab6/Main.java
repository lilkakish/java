package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        boolean loop2 = true;
        List<Temperature> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (loop2){
            System.out.print("[1] - Ввести метерологічні спостереження,\n"+
                             "[2] - Продивитись таблицю,\n"+
                             "[3] - Вернутись в меню -> ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    addToMassive(temperatures);
                    break;
                case "2":
                    outputTask1(temperatures);
                    break;
                case "3":
                    loop2 = false;
                    break;
                default:
                    System.out.println("Незрозуміла команда");
                    break;
            }
        }

    }
    public static void addToMassive(List<Temperature> temperatures){
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.println("Введіть дату");
        String date = scanner.next();
        if (!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",date)){
            throw new MyClassError();
        }
        System.out.println("Введіть температуру");
        String temperature = scanner.next();
        System.out.println("Введіть тиск");
        String pressure = scanner.next();
            temperatures.add(new Temperature(date, Float.parseFloat(temperature), Float.parseFloat(pressure)));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Помилка спробуйте ще раз");
        }
    }
    public static int outputTask1(List<Temperature> temperatures){
        double ser_zn;
        float i=0;
        int xxxx=0;
        if (temperatures.isEmpty()){
            System.out.println("Список пустий, введіть дані");
        }
        else {
            for (Temperature x:temperatures) {
                i = x.temperature + i;
            }
            ser_zn = i/temperatures.size();
            System.out.println("Всі дні: \n");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      Дата        ~  Температура  ~  Тиск  |");

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            for (Temperature t:temperatures) {
                System.out.println("|   " + formatter.format(t.date) + "     ~     " + t.temperature + "      ~   " + t.pressure + "  |");
            }
            System.out.println("Дні, температура яких є більшою від середнього значення температури: \n");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      Дата        ~  Температура  ~  Тиск  |");
            xxxx = (int) ser_zn;
            for (Temperature t:temperatures) {
//                System.out.println("|   "+formatter.format(t.date)+"     ~     "+t.temperature+"      ~   "+t.pressure+"  |");

                    if(t.temperature>ser_zn){
                        System.out.println("|   "+formatter.format(t.date)+"     ~     "+t.temperature+"      ~   "+t.pressure+"  |");
                    }
            }
        }
        if(xxxx!=0) return xxxx;
        else return 0;
    }
    public static void task2(){
        boolean loop2 = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву бази даних");
        String file_name = scanner.next();
        Database db = new Database(file_name);
        while (loop2){
            System.out.print(
                    "[1] - Додати запис,\n"+
                    "[2] - Редагувати запис,\n"+
                    "[3] - Видалити запис,\n"+
                    "[4] - Вивести всю інформацію з файла,\n"+
                    "[5] - Пошук,\n"+
                    "[6] - Сортування,\n"+
                    "[0] - Вернутись в меню -> ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    try {
                        System.out.println("Введіть назву пункту");
                        String name = scanner.next();
                        System.out.println("Введіть час відправлення");
                        String timeOut = scanner.next();
                        if (!Pattern.matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$",timeOut)){
                            throw new MyClassError();
                        }
                        System.out.println("Введіть дату відправлення");
                        String dateOut = scanner.next();
                        if (!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",dateOut)){
                            throw new MyClassError();
                        }
                        System.out.println("Введіть час прибуття");
                        String timeIn = scanner.next();
                        if (!Pattern.matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$",timeIn)){
                            throw new MyClassError();
                        }
                        System.out.println("Введіть дату прибуття");
                        String dateIn = scanner.next();
                        if (!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",dateIn)){
                            throw new MyClassError();
                        }
                        System.out.println("Введіть ціну квитка");
                        String price = scanner.next();
                        float price_ = Float.parseFloat(price);
//                        db.Add(name, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateOut+" "+timeOut),
//                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateIn+" "+timeIn), price_);
                        db.Add(name, dateOut , timeOut, dateIn, timeIn, price_);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("Введіть номер рядка, який повинні змінити");
                    String index_e = scanner.next();
                    db.Edit(Integer.parseInt(index_e)-1);
                    System.out.println("Рядок змінено");
                    break;
                case "3":
                    System.out.println("Введіть номер рядка");
                    String index = scanner.next();
                    db.Delete(Integer.parseInt(index)-1);
                    System.out.println("Рядок видалено");
                    break;
                case "4":
                    db.Ouput();
                    break;
                case "5":
                    System.out.println("Введіть пункт призначення");
                    String query = scanner.next();
                    db.Search(query);
                    break;
                case "6":
                    db.Sort();
                    break;
                case "0":
                    loop2 = false;
                    break;
                default:
                    System.out.println("Незрозуміла команда");
                    break;
            }
        }
    }
}
