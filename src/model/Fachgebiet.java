package model;

public class Fachgebiet {
    private int id;
    private String name;

    public Fachgebiet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fachgebiet clone() {
        return new Fachgebiet(id, name);
    }
}
