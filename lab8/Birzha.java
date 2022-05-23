package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Birzha implements Task2{
    private String NameCompany;
    private int Code;
    private String filename = "zav2";

    protected Birzha(String NameCompany, int Code){
        this.NameCompany = NameCompany;
        this.Code = Code;
        serQuan();
        quantityDays();
        DaysBig(0);
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    protected Birzha(){
        this.NameCompany = "NONE";
        this.Code = 0;
        serQuan();
        quantityDays();
        DaysBig(0);
    }
    @Override
    public void Add(String nameCompany, int Code, String date, float cursV, float cursZ) {
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            writer.write("Акція компанії на біржі : "+nameCompany+"; Код на біржі : "+Code+"; Дата : "+date+"," +
                    "; Курс відкриття : "+cursV+"; Курс закриття : "+cursZ+"\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Delete(int index) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        String fileToWrite = "fileToWrite.txt";
        File sourceFile = new File(filename+".txt");
        File outputFile = new File(fileToWrite);
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            writer = new PrintWriter(new FileWriter(fileToWrite));
            int current = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (current != index) {
                    writer.println(line);
                }
                current++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            boolean isDelete = sourceFile.delete();
            boolean isRename = outputFile.renameTo(sourceFile);
        }
    }

    @Override
    public void Edit(int index) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = null;
        PrintWriter writer = null;
        String fileToWrite = "fileToWrite.txt";
        File sourceFile = new File(filename+".txt");
        File outputFile = new File(fileToWrite);
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            writer = new PrintWriter(new FileWriter(fileToWrite));
            int current = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (current == index) {
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
                        line = "Акція компанії на біржі : "+nameCompany+"; Код на біржі : "+Code+"; Дата : "+date+"," +
                                "; Курс відкриття : "+cursV+"; Курс закриття : "+cursZ+"\n";
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    writer.println(line);
                }
                if (current != index) {
                    writer.println(line);
                }
                current++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            boolean isDelete = sourceFile.delete();
            boolean isRename = outputFile.renameTo(sourceFile);
        }
    }

    @Override
    public void Output() {
        try(FileReader reader = new FileReader(filename+".txt"))
        {
            char[] buffer = new char[8096];

            int chars = reader.read(buffer);


            if (chars == -1){
                System.out.println("\nФайл пустий\n");
            }
            while (chars != -1) {
                System.out.println(String.valueOf(buffer, 0, chars));
                chars = reader.read(buffer);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public float serQuan() {
        BufferedReader reader = null;
        float kurs_v = 0f;
        float kurs_z= 0f;
        float serKurs =0f;
        int count = 1;
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith(" Курс відкриття : ")){
                        kurs_v = Float.parseFloat(x.split(":")[1]);
                    }
                    if(x.startsWith(" Курс закриття : ")){
                        kurs_z = Float.parseFloat(x.split(":")[1]);}
                    serKurs =Math.abs(kurs_v - kurs_z);
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return serKurs/count;
    }

    @Override
    public int quantityDays() {
        BufferedReader reader = null;
        float kurs_v = 0f;
        float kurs_z = 0f;
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith(" Курс відкриття : ")){
                        kurs_v = Float.parseFloat(x.split(":")[1]);
                    }
                    if(x.startsWith(" Курс закриття : ")){
                        kurs_z = Float.parseFloat(x.split(":")[1]);
                    }
                    if(kurs_v<kurs_z){
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return count;
    }

    @Override
    public String DaysBig(int z) {
        BufferedReader reader = null;
        float kurs_v = 0f;
        float kurs_z = 0f;
        float serznach = 0f;
        String data= "";
        String result = "";
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                List<String> temp2 = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith(" Курс відкриття : ")){
                        kurs_v = Float.parseFloat(x.split(":")[1]);
                    }
                    if(x.startsWith(" Курс закриття : ")){
                        kurs_z = Float.parseFloat(x.split(":")[1]);
                    }
                    if(x.startsWith(" Дата : ")){
                        data = x.split(":")[1];
                    }
                    serznach = kurs_z - kurs_v;
                    if(serznach>z){
                        temp2.add(data);
                    }
                }
                for (String x:temp2) {
                    result = result + x;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String nameCompany) {
        NameCompany = nameCompany;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}
