package com.company;

import java.util.Random;
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
        int m = 4, n = 3, min=0, max=0, max_i = 0, min_i = 0;
        int[][] matrix = {
            {3,-2,4,9},
            {0,3,10,3},
            {5,-4,-6,1}
        };
        int[] b = new int[m * 2];
        for (int r = 0, tmp = 0; r < matrix[0].length; r++) {
            min = matrix[0][0];
            max = matrix[0][0];
            for (int s = 0; s < matrix.length; s++) {//пошук мінімального максимального індекса
                if(matrix[s][r] >= max){
                    max = matrix[s][r];
                    max_i = s;
                }
                if(matrix[s][r] < min){
                    min = matrix[s][r];
                    min_i = s;
                }
            }
            System.out.println("max = "+max_i);
            System.out.println("min = "+min_i); //робочий код

            min = matrix[min_i][0] * matrix[min_i][1] * matrix[min_i][2] *matrix[min_i][3];
            max = matrix[max_i][0] * matrix[max_i][1] * matrix[max_i][2] *matrix[max_i][3];

            b[(matrix[0].length - r)*2-1] = min;
            b[(matrix[0].length - r)*2-2] = max;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.print("b[i] = {");
        for (int value:b) {
            System.out.print(value +", ");
        }
        System.out.println("}");
    }

    public static void task2(){
        int number, temp;
        int rn = new Random().nextInt(5)+1;
        int sm = new Random().nextInt(5)+1;
        int[][] matrix = new int[sm][rn];

        for (int r = 0; r < matrix[0].length; r++) {
            for (int s = 0; s < matrix.length; s++) {
                number = new Random().nextInt(201)-100;
                matrix[s][r] = number;
            }
        }
        for (int r = 0; r < matrix[0].length; r++) {
            for (int s = 0; s < matrix.length; s++) {
                System.out.print(matrix[s][r]+" ");
            }
            System.out.print("\n");
        }
        int ryadok = matrix[0].length;
        int stovpchik = matrix.length;
        System.out.println("----------------------------------------------------");
        System.out.println("рядків - " +ryadok+"  стовпців - "+stovpchik);
        for (int s = 0; s < stovpchik; s++) {
            boolean needIteration = true;
            while (needIteration){
                needIteration = false;
                for (int r = 0; r< ryadok-1; r++) {
                        if (matrix[s][r] > matrix[s][r + 1]) {
                            temp = matrix[s][r];
                            matrix[s][r] = matrix[s][r + 1];
                            matrix[s][r + 1] = temp;
                            needIteration = true;
                        }
                }
            }
        }
        for (int r = 0; r < matrix[0].length; r++) {
            for (int s = 0; s < matrix.length; s++) {
                System.out.print(matrix[s][r]+" ");
            }
            System.out.print("\n");
        }
    }
}
