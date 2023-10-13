package DAO;

import model.Fachgebiet;
import model.Kurs;
import model.Kursart;

import java.util.ArrayList;
import java.util.List;

public class TempKursDAO implements KursDAO {
    // interner Speicher
    private List<Kurs> kursList = new ArrayList<>();
    private List<Fachgebiet> fachgebietList = new ArrayList<>();

    public TempKursDAO() {
        // initialer Datenbestand
        Fachgebiet informatik = new Fachgebiet(1, "Informatik");
        Fachgebiet wirtschaftslehre = new Fachgebiet(2, "Wirtschaftslehre");
        Fachgebiet fremdsprachen = new Fachgebiet(3, "Fremdsprachen");

        insertFachgebiet(informatik.getId(), informatik);
        insertFachgebiet(wirtschaftslehre.getId(), wirtschaftslehre);
        insertFachgebiet(fremdsprachen.getId(), fremdsprachen);

        insertKurs(1, new Kurs(1, "Datenbanken", informatik, Kursart.PRÄSENZ) );
        insertKurs(2, new Kurs(2, "BWL", wirtschaftslehre, Kursart.SELBSTSTUDIUM) );
        insertKurs(3, new Kurs(3, "Englisch", fremdsprachen, Kursart.ONLINE) );
        insertKurs(4, new Kurs(4, "Mandarin", fremdsprachen, Kursart.PRÄSENZ) );
        insertKurs(5, new Kurs(5, "JAVA", informatik, Kursart.SELBSTSTUDIUM) );
    }

    @Override
    public boolean insertKurs(int id, Kurs kurs) {
        if (getKurs(id) == null) {
            kursList.add( kurs.clone() );
            return true;
        }
        else
            return false;
    }

    @Override
    public Kurs getKurs(int id) {
        for (Kurs kurs : kursList) {
            if (kurs.getId() == id)
                return kurs.clone();
        }
        return null;
    }

    @Override
    public List<Kurs> getAllKurse() {
        List<Kurs> copyListe = new ArrayList<>();
        for (Kurs kurs : this.kursList) {
            copyListe.add( kurs.clone() );
        }
        return copyListe;
    }

    @Override
    public boolean updateKurs(int id, Kurs kurs) {
        deleteKurs(id);
        return insertKurs(id, kurs);
    }

    @Override
    public void deleteKurs(int id) {
        for (int i=0; i<kursList.size(); i++) {
            if (kursList.get(i).getId() == id) {
                kursList.remove(i);
                break;
            }
        }
    }

    @Override
    public int getLastKursID() {
        int lastID = 0;
        for (Kurs kurs : kursList) {
            if (kurs.getId() > lastID)
                lastID = kurs.getId();
        }
        return lastID;
    }

    @Override
    public boolean insertFachgebiet(int id, Fachgebiet fachgebiet) {
        if (getFachgebietByID(id) == null) {
            fachgebietList.add( fachgebiet.clone() );
            return true;
        }
        else
            return false;
    }

    @Override
    public Fachgebiet getFachgebietByID(int id) {
        for (Fachgebiet fachgebiet : fachgebietList) {
            if (fachgebiet.getId() == id)
                return fachgebiet.clone();
        }
        return null;
    }

    @Override
    public Fachgebiet getFachgebietByName(String name) {
        for (Fachgebiet fachgebiet : fachgebietList) {
            if (fachgebiet.getName().equals(name))
                return fachgebiet.clone();
        }
        return null;
    }

    @Override
    public List<Fachgebiet> getAllFachgebiete() {
        List<Fachgebiet> copyListe = new ArrayList<>();
        for (Fachgebiet fachgebiet : this.fachgebietList) {
            copyListe.add( fachgebiet.clone() );
        }
        return copyListe;
    }

    @Override
    public boolean updateFachgebiet(int id, Fachgebiet fachgebiet) {
        deleteFachgebiet(id);
        return insertFachgebiet(id, fachgebiet);
    }

    @Override
    public void deleteFachgebiet(int id) {
        for (int i=0; i<fachgebietList.size(); i++) {
            if (fachgebietList.get(i).getId() == id) {
                fachgebietList.remove(i);
                break;
            }
        }
    }

    @Override
    public int getLastFachgebietID() {
        int lastID = 0;
        for (Fachgebiet fachgebiet : fachgebietList) {
            if (fachgebiet.getId() > lastID)
                lastID = fachgebiet.getId();
        }
        return lastID;
    }
}
