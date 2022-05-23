package com.company;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JTest {
    @Test
     void testTask1() {
//        Integer[] mas = generateArray();
        Integer[] mas = {-1,-1,-1,-1,1};
        List tem = new ArrayList<>();
        tem.add(new Temperature("22/22/2022", 12.5f, 12.0f));
        tem.add(new Temperature("22/22/2022", 50.0f, 12.0f));
        assertEquals(func(Main.outputTask1(tem)), Main.outputTask1(tem));
    }
    String func(int temperature){
        if(temperature>30){
            return "Спекотно";
        }
        else {
            return "Температура нормальна";
        }
    }
}
