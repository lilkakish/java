package com.company;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
        System.out.println("Введіть масив з 10 цифр");
        Integer[] old_array = new Integer[10];
        int i = 0;
        while(i< old_array.length)
        {
            try
            {
                int number = Integer.parseInt(scanner.next());
                old_array[i] = number;
                i++;
            }
            catch (java.lang.NumberFormatException e)
            {
                System.out.println("Введено не число!!!");
            }
        }
        System.out.print("Старий масив: [");
        for (int n= 0; n<10; n++) {
            System.out.print(old_array[n]+" ");
        }
        System.out.println("]");
        int max = old_array[0], min = old_array[0], min_i = 0,max_i = 0;
        i = 0;
        while(i< old_array.length)
        {
            if(old_array[i] < min){
                min = old_array[i];
                min_i = i;
                }
            else if(old_array[i] > max){
                    max = old_array[i];
                    max_i = i;
                    }
            else{ }
                i++;
        }
        System.out.println("max = "+max+"\nmin = "+min);
        System.out.println("max_i = "+max_i+"\nmin_i = "+min_i);
        if(min_i>max_i) //якщо мінімальний індекс числа більший ніж максимального
            for(i = max_i; i<= min_i;i++) //удаляєм тобто заповнюєм значення null
                old_array[i] = null;

        else
            for(i = min_i; i<= max_i;i++) //удаляєм тобто заповнюєм значення null
                old_array[i] = null;

        int q=0;//лічильник
        for(int i1 = 0; i1<10;i1++) //перевіряєм скільки є чисел які нам потрібні
            if(old_array[i1]!=null)
                q++;

        Integer[] new_array = new Integer[q];
//        for(int i1 = 0; i1<new_array.length;i1++)//записуєм їх в новий масив
//            if(old_array[i1]!=null){
//                System.out.println("old_array[i1] = "+old_array[i1] +"i1 = "+i1); ТУТ БУЛА ПОМИЛКА
//                new_array[i1] = old_array[i1];
//            }
        int i1 = 0;
        for (Integer value:old_array) {
            if(value!=null){
                new_array[i1] = value;
                i1++;
            }
        }

        System.out.print("Новий масив: [");
        for(int n= 0; n<new_array.length; n++) {
            System.out.print(new_array[n]+" ");
        }
        System.out.println("]");
    }
    public static void task2(){
        int quantity_random = new Random().nextInt(11);
        Integer[] auto_array = new Integer[quantity_random];
        for (int i = 0; i<quantity_random; i++)
            auto_array[i] = new Random().nextInt(201)-100;

        System.out.println("Введіть масив з 10 цифр");
        Integer[] hand_array = new Integer[10];
        int i = 0;
        while(i< hand_array.length)
        {
            try
            {
                int number = Integer.parseInt(scanner.next());
                hand_array[i] = number;
                i++;
            }
            catch (java.lang.NumberFormatException e)
            {
                System.out.println("Введено не число!!!");
            }
        }
        System.out.print("Масив введений вручну: [");
        for (int n= 0; n<10; n++) {
            System.out.print(hand_array[n]+" ");
        }
        System.out.println("]");
        System.out.println("Добуток елементів масиву з парними номерами: "+task2_1(hand_array)+
                "\nСума елементів масиву, " +
                "розташованих до максимального за модулем елемента: "+task2_2(hand_array));

        System.out.print("Масив згенерований автоматично: [");
        for (int n= 0; n<quantity_random; n++) {
            System.out.print(auto_array[n]+" ");
        }
        System.out.println("]");
        try{
            if(auto_array.length==0)
                throw new NullPointerException();

            System.out.println("Добуток елементів масиву з парними номерами: "+task2_1(auto_array)+
                    "\nСума елементів масиву, " +
                    "розташованих до максимального за модулем елемента: "+task2_2(auto_array));
        }
        catch (NullPointerException e){
            System.out.println("Список згенеровано пустий");
        }

    }
    public static int task2_1(Integer[] array){
        int sum =1;
        for(int i = 0;i<array.length; i++)
            if(i%2==0)
                sum = sum * array[i];
        return sum;
    }
    public static int task2_2(Integer[] array){
        int max=array[0], max_i = 0, sum=0;
        for (int i=0; i<array.length; i++)
        {
            if(Math.abs(array[i]) > Math.abs(max)){
                max = array[i];
                max_i = i;}

        }

        for(int i = 0;i<max_i; i++)
            sum += array[i];
        return sum;
    }
}
