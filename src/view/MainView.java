package view;

import model.Kursart;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private MainView mainView;
    private JTextField idTextfeld, bezeichnungTextfeld,
            fachgebietTextfeld, kursartTextfeld;
    private JButton abfrageButton, ändernButton;

    public MainView() {
        this.mainView = this;
        setSize(400, 200);
        setTitle("Kurverwaltung (Klasurversion)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponents();
        setVisible(true);
        pack();
    }

    private void addComponents() {
        // Hauptfenster
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel( new FlowLayout() );
        JPanel centerPanel = new JPanel(new GridLayout(4, 2));
        JPanel bottomPanel = new JPanel(new FlowLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // topPanel
        topPanel.add(new JLabel("Kursverwaltung"));

        // centerPanel
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        centerPanel.add(new JLabel("Kursnummer:"));
        idTextfeld = new JTextField();
        centerPanel.add(idTextfeld);
        centerPanel.add(new JLabel("Kursbezeichnung:"));
        bezeichnungTextfeld = new JTextField();
        centerPanel.add(bezeichnungTextfeld);
        centerPanel.add(new JLabel("Fachgebiet:"));
        fachgebietTextfeld = new JTextField();
        centerPanel.add(fachgebietTextfeld);
        kursartTextfeld = new JTextField();
        centerPanel.add(new JLabel("Kursart:"));
        centerPanel.add(kursartTextfeld);

        // bottomPanel
        abfrageButton = new JButton("Abfrage");
        ändernButton = new JButton("Ändern");
        bottomPanel.add(abfrageButton);
        bottomPanel.add(ändernButton);
    }

    public int getID() {
        return Integer.parseInt( idTextfeld.getText() );
    }

    public void setID(int id) {
        idTextfeld.setText( String.valueOf(id) );
    }

    public String getBezeichnung() {
        return bezeichnungTextfeld.getText();
    }

    public void setBezeichnung(String bezeichnung) {
        bezeichnungTextfeld.setText(bezeichnung);
    }

    public String getFachgebiet() {
        return fachgebietTextfeld.getText();
    }

    public void setFachgebiet(String fachgebiet) {
        fachgebietTextfeld.setText(fachgebiet);
    }

    public Kursart getKursart() {
        String kursart = kursartTextfeld.getText();
        if (kursart.equals(Kursart.PRÄSENZ.toString()))
            return Kursart.PRÄSENZ;
        if (kursart.equals(Kursart.ONLINE.toString()))
            return Kursart.ONLINE;
        return Kursart.SELBSTSTUDIUM;
    }

    public void setKursart(Kursart kursart) {
        kursartTextfeld.setText(kursart.toString());
    }

    public void setAbfrageButtonListener(ActionListener listener) {
        abfrageButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
