package model;

public class Kurs {
    private int id;
    private String bezeichnung;
    private Fachgebiet fachgebiet;
    private Kursart kursart;

    public Kurs(int id, String bezeichnung, Fachgebiet fachgebiet, Kursart kursart) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.fachgebiet = fachgebiet;
        this.kursart = kursart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Fachgebiet getFachgebiet() {
        return fachgebiet;
    }

    public void setFachgebiet(Fachgebiet fachgebiet) {
        this.fachgebiet = fachgebiet;
    }

    public Kursart getKursart() {
        return kursart;
    }

    public void setKursart(Kursart kursart) {
        this.kursart = kursart;
    }

    public Kurs clone() {
        return new Kurs(id, bezeichnung, fachgebiet, kursart);
    }
}
