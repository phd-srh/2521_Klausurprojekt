package DAO;

import model.Fachgebiet;
import model.Kurs;

import java.util.List;

public interface KursDAO {

    boolean insertKurs(int id, Kurs kurs);      // Create
    Kurs getKurs(int id);                       // Read
    List<Kurs> getAllKurse();                   // Read Spezial
    boolean updateKurs(int id, Kurs kurs);      // Update
    void deleteKurs(int id);                    // Delete
    int getLastKursID();

    boolean insertFachgebiet(int id, Fachgebiet fachgebiet);
    Fachgebiet getFachgebietByID(int id);
    Fachgebiet getFachgebietByName(String name);
    List<Fachgebiet> getAllFachgebiete();
    boolean updateFachgebiet(int id, Fachgebiet fachgebiet);
    void deleteFachgebiet(int id);
    int getLastFachgebietID();

}
