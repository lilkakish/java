package com.company;

public interface Task1 {
    String SortAuthor();
    int QuantityBook(String publisher);
    void Add(String author, String nameBook, String publisher, int year);
    void Delete(int index);
    void Edit(int index);
    void Output();

}
