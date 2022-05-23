package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Database {
    final String filename;
    private String name;
    private Date dateOut;
    private Date timeOut;
    private Date timeIn;
    private Date dateIn;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    Database(String file_name){
        filename = file_name;
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    Database(){
        filename = "file_name";
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    Database(String file_name,String name, String dateOut,String timeOut,
             String dateIn,String timeIn, float price) throws ParseException {
        filename = file_name;
        this.name = name;
        this.dateOut = new SimpleDateFormat("dd/MM/yyyy").parse(dateOut);
        this.timeOut = new SimpleDateFormat("HH:mm").parse(timeOut);
        this.dateIn = new SimpleDateFormat("dd/MM/yyyy").parse(dateIn);
        this.timeIn = new SimpleDateFormat("HH:mm").parse(timeIn);
        this.price = price;
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
//    public void Add(String name, Date dateOut,
//    Date dateIn, float price){
    public void Add(String name, String dateOut,String timeOut,
                    String dateIn,String timeIn, float price){

        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            //
//            DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
//            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//            String inputText = "2012-11-17T00:00:00.000-05:00";
//            Date date = inputFormat.parse(inputText);
//            String outputText = outputFormat.format(date);
            //
            writer.write("Назву пункту : "+name+"; Час відправлення : "+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(timeOut))
                    +"; Дата відправлення : "+new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateOut))+"," +
                    "; Час прибуття : "+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(timeIn))+"; Дата прибуття : "
                    +new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateIn))+"; Ціна квитка : "+price+" грн.\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    };
    public void Edit(int index){
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
                    System.out.println("Рядок який ви намагаєтесь змінити виглядає так:\n"+line);
                    System.out.println("Введіть назву пункту");
                    String name = scanner.next();
                    System.out.println("Введіть час відправлення");
                    String timeOut = scanner.next();
                    if (!Pattern.matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$",timeOut)){
                        throw new MyClassError();
                    }
                    System.out.println("Введіть дату відправлення");
                    String dateOut = scanner.next();
                    if (!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",dateOut)){
                        throw new MyClassError();
                    }
                    System.out.println("Введіть час прибуття");
                    String timeIn = scanner.next();
                    if (!Pattern.matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$",timeIn)){
                        throw new MyClassError();
                    }
                    System.out.println("Введіть дату прибуття");
                    String dateIn = scanner.next();
                    if (!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$",dateIn)){
                        throw new MyClassError();
                    }
                    System.out.println("Введіть ціну квитка");
                    String price = scanner.next();
                    float price_ = Float.parseFloat(price);
                    try {
                        line = "Назву пункту : "+name+"; Час відправлення : "+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(timeOut))
                                +"; Дата відправлення : "+new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateOut))+"," +
                                "; Час прибуття : "+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(timeIn))+"; Дата прибуття : "
                                +new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dateIn))+"; Ціна квитка : "+price+" грн.\n";
                    } catch (ParseException e) {
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
        } catch (MyClassError e) {
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
    };
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
    };
    public void Ouput(){
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
    };
    public void Search(String query){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            System.out.println("Результати пошуку:");
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith("Назву пункту : " + query)){
                        System.out.println(line+"\n");
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
    };
    public void Sort(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            System.out.println("Результати сортування:");
            HashMap<String,String> listDate = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith(" Час відправлення :")){
                        listDate.put(x,line);
                    }
                }
            }
            TreeMap<String, String> sortedMap = new TreeMap<>();
            sortedMap.putAll(listDate);
            for (String x: sortedMap.values()) {
                System.out.println(x);
            }
            System.out.println("\n");
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
    };
}
