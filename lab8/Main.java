package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.print("Виберіть завдання [1],[2] -> ");
            String choice = scanner.next();
            switch (choice) {
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
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print(
                "[1] - Додати запис,\n"+
                        "[2] - Редагувати запис,\n"+
                        "[3] - Видалити запис,\n"+
                        "[4] - Вивести всю інформацію з файла,\n"+
                        "[5] - Кількість книг від кожного видавництва,\n"+
                        "[6] - Сортування,\n"+
                        "[0] - Вернутись в меню -> ");
            String choice = scanner.next();
        switch (choice){
            case "1":
                System.out.println("Введіть автора");
                String author = scanner.next();
                System.out.println("Введіть назву книги");
                String nameBook = scanner.next();
                System.out.println("Введіть видавництво");
                String publisher = scanner.next();
                System.out.println("Введіть рiк видання");
                try {
                    String year = scanner.next();
                    lib.Add(author,nameBook,publisher,Integer.parseInt(year));
                }catch (Exception e){
                    loop = false;
                }
               break;
            case "2":
                System.out.println("Введіть номер рядка, який повинні змінити");
                String index_e = scanner.next();
                lib.Edit(Integer.parseInt(index_e)-1);
                System.out.println("Рядок змінено");
                break;
            case "3":
                System.out.println("Введіть номер рядка");
                String index = scanner.next();
                lib.Delete(Integer.parseInt(index)-1);
                System.out.println("Рядок видалено");
                break;
            case "4":
                lib.Output();
                break;
            case "5":
                System.out.println("Кількість книг від видавництва \"Старого Лева\": "+lib.QuantityBook("Видавництво Старого Лева"));
                System.out.println("Кількість книг від видавництва \"КСД\": "+lib.QuantityBook("КСД"));
                System.out.println("Кількість книг від видавництва \"Бастіон\": "+lib.QuantityBook("Бастіон"));
                break;
            case "6":
                System.out.println(lib.SortAuthor());
            case "0":
                loop = false;
                break;
            }
        }
    }
    public static void task2(){
        Birzha birzh = new Birzha();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print(
                    "[1] - Додати запис,\n"+
                            "[2] - Редагувати запис,\n"+
                            "[3] - Видалити запис,\n"+
                            "[4] - Вивести всю інформацію з файла,\n"+
                            "[5] - Завдання,\n"+
                            "[0] - Вернутись в меню -> ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    System.out.println("Введіть назву компанії");
                    String nameCompany = scanner.next();
                    System.out.println("Введіть дату курсу на біржі");
                    String date = scanner.next();
                    try {
                        System.out.println("Введіть код на біржі");
                        String Code = scanner.next();
                        System.out.println("Введіть курс відкриття");
                        String cursV = scanner.next();
                        System.out.println("Введіть курс закриття");
                        String cursZ = scanner.next();
                        birzh.Add(nameCompany,Integer.parseInt(Code), date, Float.parseFloat(cursV),Float.parseFloat(cursZ));
                        Birzha_naslednik bi = new Birzha_naslednik(date,Float.parseFloat(cursV),Float.parseFloat(cursZ));
                    }catch (Exception e){
                        loop = false;
                    }
                    break;
                case "2":
                    System.out.println("Введіть номер рядка, який повинні змінити");
                    String index_e = scanner.next();
                    birzh.Edit(Integer.parseInt(index_e)-1);
                    System.out.println("Рядок змінено");
                    break;
                case "3":
                    System.out.println("Введіть номер рядка");
                    String index = scanner.next();
                    birzh.Delete(Integer.parseInt(index)-1);
                    System.out.println("Рядок видалено");
                    break;
                case "4":
                    birzh.Output();
                    break;
                case "5":
                    System.out.println("Середня вартість акцій по закриттю за період "+birzh.quantityDays());
                    System.out.println("Кількість днів, коли курс зростав протягом дня "+birzh.serQuan());
                    System.out.println("Дні, коли зміна курсу за день перевищувала задане значення " + birzh.DaysBig(0));
                    break;
                case "0":
                    loop = false;
                    break;
            }
        }
    }
}