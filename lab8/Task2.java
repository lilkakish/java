package com.company;

public interface Task2 {
    void Add(String nameCompany, int Code, String date, float cursV, float cursZ);
    void Delete(int index);
    void Edit(int index);
    abstract void Output();
    abstract float serQuan();
    int quantityDays();
    String DaysBig(int z);
}
