package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Library implements Task1{
    private String filename = "zav1";
    protected Library(String author, String nameBook, String publisher, int year) {
        this.author = author;
        this.nameBook = nameBook;
        this.publisher = publisher;
        this.year = year;
    }

    public Library (){
        this.author = "NONE";
        this.nameBook = "NONE";
        this.publisher = "NONE";
        this.year = 0;
    }

    @Override
    public void Add(String author, String nameBook, String publisher, int year){
        try(FileWriter writer = new FileWriter(filename+".txt", true))
        {
            writer.write("Автор : "+author+"; Назва книги : "+nameBook+"; Видавництво : "+publisher+"," +
                    "; Рік видання : "+year+"\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void Delete(int index){
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
                    System.out.println("Введіть автора");
                    String author = scanner.next();
                    System.out.println("Введіть назву книги");
                    String nameBook = scanner.next();
                    System.out.println("Введіть видавництво");
                    String publisher = scanner.next();
                    System.out.println("Введіть рiк видання");
                    try {
                        String year = scanner.next();
                        line = "Автор : "+author+"; Назва книги : "+nameBook+"; Видавництво : "+publisher+"," +
                                "; Рік видання : "+year+"\n";
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
    public void Output(){
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
    public String SortAuthor() {
        String list = "";
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
                    if(x.startsWith("Автор :")){
                        listDate.put(x,line);
                    }
                }
            }
            TreeMap<String, String> sortedMap = new TreeMap<>();
            sortedMap.putAll(listDate);
            for (String x: sortedMap.values()) {
                list = list + x + "\n";
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
        return list;
    }

    @Override
    public int QuantityBook(String publisher) {
        BufferedReader reader = null;
        int quantity_book = 0;
        try {
            reader = new BufferedReader(new FileReader(filename+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                temp = Arrays.asList(line.split(";"));
                for (String x:temp) {
                    if(x.startsWith(" Видавництво : " + publisher)){
                        quantity_book++;
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
        return quantity_book;
    }

    private String author;
    private String nameBook;
    private String publisher;
    private int year;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
