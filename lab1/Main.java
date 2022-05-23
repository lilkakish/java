package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	boolean loop = true;
        Scanner scanner = new Scanner(System.in);
    while (loop){
        System.out.print("Виберіть завдання [1],[2],[3],[4] -> ");
        String choice = scanner.next();
        switch (choice){
            case "1":
                task1();
                break;
            case "2":
                task2();
                break;
            case "3":
                task3();
                break;
            case "4":
                task4();
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
        try{
            double x;
            double z;
            int[] y  = {-8, 10, 2};
            System.out.print("Введіть Z: ");

            z = Double.parseDouble(scanner.next());

        System.out.println("--------------------------\nБлок if...if");
        if((Math.sqrt(3 * y[0]/(z-2*y[0]))-y[0]*z) - (y[1]/2+15*z) == 0 && (y[2]*z-7*z) - (10/2+15*z) == 0){
            x = (Math.sqrt(3 * y[0]/(z-2*y[0]))-y[0]*z);
            System.out.println("x = "+x);
        }
        if((Math.sqrt(3 * y[0]/(z-2*y[0]))-y[0]*z) - (y[1]/2+15*z) != 0 && (y[2]*z-7*z) - (10/2+15*z) != 0){
            System.out.println("Значення x не знайдено.");
            }
        System.out.println("--------------------------\nБлок if...else");
        if((Math.sqrt(3 * y[0]/(z-2*y[0]))-y[0]*z) - (y[1]/2+15*z) == 0 && (y[2]*z-7*z) - (10/2+15*z) == 0){
                x = (Math.sqrt(3 * y[0]/(z-2*y[0]))-y[0]*z);
                System.out.println("x = "+x);
            }
        else{
                System.out.println("Значення x не знайдено.");
            }
        }
        catch (java.lang.NumberFormatException e) {
            System.out.println ("Помилка введено не числове значення");
        }

    }
    public static void task2(){
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.print("Введіть 3 довільних числа (через ';') -> ");
        String numbers = scanner.next();
        String[] words = numbers.split(";");
        for (String number: words)
        {
            temp.add(Integer.parseInt(number));
        }

        if (temp.get(0) > temp.get(1)&& temp.get(1) > temp.get(1)){
            System.out.println("Числа утворюють спадну послідовність. Числа, протилежного знаку до початкових:");
            for (int number:temp) {
                System.out.println(-number);
            }
        }
        else {
            System.out.println("Числа не утворюють спадну послідовність. Сума квадратів чисел:");
            double sum=0;
            for (int number:temp) {
                sum+=Math.pow(number,2);
            }
            System.out.println(sum);
        }

    }
    public static void task3(){
//        легкий варіант
//        int quantity_floor = 9;
//        int quantity_kvar = 5;
//        System.out.print("Введіть номер квартири: ");
//        String choice = scanner.next();
//        double x = Math.ceil(Double.parseDouble(choice)/quantity_kvar);
//        System.out.println("Ваш поверх: "+Math.round(x));

        System.out.print("Введіть номер квартири: ");
        String number = scanner.next();
        int quantity_floor = 9;
        int quantity_kvar = 5;
        double choice = Math.ceil(Double.parseDouble(number)/quantity_kvar);
        switch ((int) Math.round(choice)){
            case 1:
                System.out.println("Ви на 1 поверсі");
                break;
            case 2:
                System.out.println("Ви на 2 поверсі");
                break;
            case 3:
                System.out.println("Ви на 3 поверсі");
                break;
            case 4:
                System.out.println("Ви на 4 поверсі");
                break;
            case 5:
                System.out.println("Ви на 5 поверсі");
                break;
            case 6:
                System.out.println("Ви на 6 поверсі");
                break;
            case 7:
                System.out.println("Ви на 7 поверсі");
                break;
            case 8:
                System.out.println("Ви на 8 поверсі");
                break;
            case 9:
                System.out.println("Ви на 9 поверсі");
                break;
            default:
                System.out.println("Такого поверху не існує");
                break;
        }

    }
    public static void task4(){
        try {


        int x,y;
        System.out.print("Введіть x: ");
        x = Integer.parseInt(scanner.next());
        System.out.print("Введіть y: ");
        y = Integer.parseInt(scanner.next());
        double result = (1+y)*((x+(y/(Math.pow(x,2)+4)))/(Math.pow(Math.E, -x-2)+1/(Math.pow(x,2)+4)));
        System.out.println("a = "+result);}
        catch (java.lang.Exception e){
            System.out.println("для заданих значень y та x у обчислюваному виразі виконується ділення на 0");
        }
    }

}
