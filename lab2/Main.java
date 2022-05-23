package com.company;

import java.util.Random;
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
    public static void task1()
    {
        while(true){
            try{
                int x = new Random().nextInt(201)-100;
                int z = new Random().nextInt(201)-100;
                if(x<0 || z<0){
                    throw new NullPointerException("Помилка, x = "+x+" або z = "+z+" не можуть бути від'ємним");
                }
                System.out.println("x = "+x);
                System.out.println("z = "+z);
                double y = (Math.sqrt(x)+2*Math.sqrt(x*z))/(Math.sqrt(x)-2*Math.sqrt(x*z));
                System.out.println("y = "+y);
                break;
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void task2()
    {
        System.out.println("Цикл for");
        int sum=1;
        for(int i=20;i<=80; i++) {
            if(i%5==0){
                sum=sum*i;
            }
        }
            System.out.println("Добуток всіх чисел, кратних 5, у діапазоні [20;80]: "+sum);
        System.out.println("Цикл while");
        sum=1;
        int i=20;
        while(i<=80) {
            if(i%5==0){
                sum=sum*i;
            }
            i++;
        }
            System.out.println("Добуток всіх чисел, кратних 5, у діапазоні [20;80]: "+sum);
        System.out.println("Цикл do while");
        sum=1;
        i=20;
        do{
            if(i%5==0){
                sum=sum*i;
            }
            i++;
        }while(i<=80);
            System.out.println("Добуток всіх чисел, кратних 5, у діапазоні [20;80]: "+sum);
    }
    public static void task3()
    {
        int sum = 0;
        System.out.print("Введіть х -> ");
        int x = Integer.parseInt(scanner.next());
        System.out.print("Введіть n -> ");
        int n = Integer.parseInt(scanner.next());
        for(int i =1; i<n;i++){
            for (int j=2;j<n;j++){
                sum += x+j;
            }
        }
        System.out.println("Сума = "+sum);
    }
    public static void task4()
    {
        System.out.println("----X----Y----");
        for (double a = -6, b = 3 , x = 0,y;a<=b; a+=0.75, x++){
            y = (int) Math.pow(x,3);
            System.out.println(x+"      "+y);
        }

    }
}
