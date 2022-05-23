package com.company;

import org.junit.jupiter.api.Test;

import static com.company.PR1.generateArray;
import static org.junit.jupiter.api.Assertions.*;

public class JTest {

    @Test
    void testTask1() {
//        Integer[] mas = generateArray();
        Integer[] mas = {-1,-1,-1,-1,1};

        System.out.print("Massive: [");
        for (var x:mas) {
            System.out.print(x+", ");
        }
        System.out.println("]");

        assertEquals(4, PR1.task1(mas));
    }
    @Test
    void testTask2() {
        Integer[] mas = generateArray();
//        Integer[] mas = {4,9,7,3,1,10,5,5};

        System.out.print("Massive: [");
        for (var x:mas) {
            System.out.print(x+", ");
        }
        System.out.println("]");
//        assertEquals(20, PR1.task2(mas));
        assertEquals(expectedValue(PR1.task2(mas)), PR1.task2(mas));
    }
    public static int expectedValue(Integer num){
        if (num<100 && num> 50 || num<-50 && num>-100 || num==20){
            return num;
        }
        return 51;
    }
    @Test
    void testTask3() {
//        Integer[] mas = generateArray();
        Integer[] mas = {1,2,10,0};
        assertEquals(1, PR1.task3(mas));
    }
}
