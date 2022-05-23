package com.company;

import java.beans.ExceptionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Temperature {
    Date date;
    Float temperature;
    Float pressure;
    Temperature(String d, Float t, Float p) {
        boolean ok = Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",d);
        if (ok){
            Date format = null;
            try {
                format = new SimpleDateFormat("dd/MM/yyyy").parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(ok);
            temperature = t;
            pressure = p;
            date = format;
        }
//        else {
//            temperature = 0f;
//            pressure = 0f;
//            date = new Date();
//        }
    }
}
