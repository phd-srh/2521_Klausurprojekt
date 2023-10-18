package view;

import model.Kursart;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private MainView mainView;
    private JTextField idTextfeld, bezeichnungTextfeld, fachgebietTextfeld;
    private JButton abfrageButton, ändernButton;
    private JRadioButton onlineRadioButton, präsenzRadioButton, selbsstudiumRadioButton;

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
        JPanel centerPanel = new JPanel(new GridLayout(6, 2));
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
        onlineRadioButton = new JRadioButton("Online");
        präsenzRadioButton = new JRadioButton("Präsenz");
        selbsstudiumRadioButton = new JRadioButton("Selbststudium");
        centerPanel.add(new JLabel("Kursart:"));
        centerPanel.add(onlineRadioButton);
        centerPanel.add( new JLabel("") );
        centerPanel.add(präsenzRadioButton);
        centerPanel.add( new JLabel("") );
        centerPanel.add(selbsstudiumRadioButton);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onlineRadioButton);
        buttonGroup.add(präsenzRadioButton);
        buttonGroup.add(selbsstudiumRadioButton);
        onlineRadioButton.setSelected(true);

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
        if ( onlineRadioButton.isSelected() )
            return Kursart.ONLINE;
        if ( präsenzRadioButton.isSelected() )
            return Kursart.PRÄSENZ;
        return Kursart.SELBSTSTUDIUM;
    }

    public void setKursart(Kursart kursart) {
        switch (kursart) {
            case ONLINE:
                onlineRadioButton.setSelected(true);
                break;
            case PRÄSENZ:
                präsenzRadioButton.setSelected(true);
                break;
            default:
                selbsstudiumRadioButton.setSelected(true);
        }
    }

    public void setAbfrageButtonListener(ActionListener listener) {
        abfrageButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
