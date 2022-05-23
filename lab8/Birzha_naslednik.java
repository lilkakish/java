package com.company;

public class Birzha_naslednik extends Birzha{
    private String date;
    private float kursVidkrut;
    private float kursZakruttya;

    protected Birzha_naslednik(String date, float kursVidkrut, float kursZakruttya){
        this.date = date;
        this.kursVidkrut = kursVidkrut;
        this.kursZakruttya = kursZakruttya;
    }

    @Override
    public int quantityDays() {
        return 0;
    }

    @Override
    public String DaysBig(int z) {
        return super.DaysBig(z);
    }

    @Override
    public float serQuan() {
        return super.serQuan();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getKursVidkrut() {
        return kursVidkrut;
    }

    public void setKursVidkrut(float kursVidkrut) {
        this.kursVidkrut = kursVidkrut;
    }

    public float getKursZakruttya() {
        return kursZakruttya;
    }

    public void setKursZakruttya(float kursZakruttya) {
        this.kursZakruttya = kursZakruttya;
    }
}
