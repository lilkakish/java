package com.company;

import java.util.Random;

public class PR1 {

    public static Integer[] generateArray(){
        int quantity_random = new Random().nextInt(10)+1;
        Integer[] auto_array = new Integer[quantity_random];
        for (int i = 0; i<quantity_random; i++)
            auto_array[i] = new Random().nextInt(201)-100;
        return auto_array;
    }

    public static int task1(Integer[] mas){
        int quantity = 0;
        for (Integer number:mas) {
            if(number <0)
                quantity++;
        }
        return quantity;
    }

    public static int task2(Integer[] array){
        int min = array[0], min_i = 0, sum=0;
        for (int i=0; i<array.length; i++)
        {
            if(Math.abs(array[i]) < Math.abs(min)){
                min = array[i];
                min_i = i;}
        }

        for(int i = min_i+1; i< array.length; i++)
            sum += array[i];
        return sum;
    }
    public static int task3(Integer[] array){
        int max = array[0], min = array[0], min_i = 0,max_i = 0;
        int i = 0;
        while(i< array.length)
        {
            if(array[i] < min){
                min = array[i];
                min_i = i;
            }
            else if(array[i] > max){
                max = array[i];
                max_i = i;
            }
            else{ }
            i++;
        }
        return (max_i+min_i)/2;
    }
}
