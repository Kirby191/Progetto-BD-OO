package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

/**
 * The type Giocatore modifica valori.
 */
public class GiocatoreModificaValori {
    private JPanel panel5;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JTextField nazionalitaTextField;
    private JTextField dataNascitaTextField;
    private JTextField altezzaTextField;
    private JTextField pesoTextField;
    private JTextField abilitàTextField;
    private JButton confermaButton;
    private JButton indietroButton;
    private JComboBox piedeComboBox;
    private JComboBox sessoComboBox;
    private JComboBox tipoGiocatoreComboBox;
    private JComboBox ritiratoComboBox;
    private JComboBox ruoloComboBox;

    private JFrame frame5;

    /**
     * Instantiates a new Giocatore modifica valori.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param username       the username
     */
    public GiocatoreModificaValori(JFrame frameChiamante, Controller controller, String username) {
        frame5 = new JFrame("GiocatoreModificaValori");
        frame5.setContentPane(panel5);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamante.setVisible(false);
        frame5.setVisible(true);
        String SSN = controller.InserisciValoriGiocatoreFromUs(nomeTextField, cognomeTextField, nazionalitaTextField, dataNascitaTextField, piedeComboBox,
                altezzaTextField, pesoTextField, ruoloComboBox, ritiratoComboBox, abilitàTextField, tipoGiocatoreComboBox, sessoComboBox, username);
        frame5.pack();

        if (ritiratoComboBox.getSelectedItem().equals("True")) {
            frame5.setVisible(false);
            JOptionPane.showMessageDialog(frame5, "Sei ritirato, non puoi modificare i tuoi dati", "Errore", JOptionPane.ERROR_MESSAGE);
            frame5.dispose();
            frameChiamante.setVisible(true);
        }


        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.ModificaGiocatore(nomeTextField, cognomeTextField, nazionalitaTextField, dataNascitaTextField, piedeComboBox,
                        altezzaTextField, pesoTextField, ruoloComboBox, ritiratoComboBox, abilitàTextField, tipoGiocatoreComboBox, sessoComboBox, SSN, 2);

                if (ritiratoComboBox.getSelectedItem().equals("True")) {
                    SceltaGiocatoreRitirato sceltaGiocatoreRitirato = new SceltaGiocatoreRitirato(frame5, controller,
                            controller.CreateGiocatore(
                                    nomeTextField.getText(),
                                    cognomeTextField.getText(),
                                    SSN,
                                    nazionalitaTextField.getText(),
                                    Date.valueOf(dataNascitaTextField.getText()),
                                    (char) sessoComboBox.getSelectedItem(),
                                    (char) piedeComboBox.getSelectedItem(),
                                    Float.parseFloat(altezzaTextField.getText()),
                                    Float.parseFloat(pesoTextField.getText()),
                                    (String) ruoloComboBox.getSelectedItem(),
                                    Boolean.parseBoolean(ritiratoComboBox.getSelectedItem().toString()),
                                    abilitàTextField.getText(),
                                    (char) tipoGiocatoreComboBox.getSelectedItem()
                            ));
                }
            }
        });
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame5.dispose();
                frameChiamante.setVisible(true);
            }
        });
    }

}
