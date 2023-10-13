package controller;

import DAO.KursDAO;
import DAO.TempKursDAO;
import model.Kurs;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {
    private KursDAO kursDB;
    private MainView mainView;

    public MainController(KursDAO kursDB, MainView mainView) {
        this.kursDB = kursDB;
        this.mainView = mainView;

        mainView.setAbfrageButtonListener( this::performAbfragen );
    }

    private void performAbfragen(ActionEvent e) {
        int id = mainView.getID();
        Kurs kurs = kursDB.getKurs(id);
        if (kurs != null) {
            mainView.setBezeichnung(kurs.getBezeichnung());
            mainView.setFachgebiet(kurs.getFachgebiet().getName());
            mainView.setKursart(kurs.getKursart());
        }
    }

    public static void main(String[] args) {
        new MainController(new TempKursDAO(), new MainView());
    }
}
