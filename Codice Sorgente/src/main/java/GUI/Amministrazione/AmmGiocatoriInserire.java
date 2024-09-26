package GUI.Amministrazione;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

/**
 * The type Amm giocatori inserire.
 */
public class AmmGiocatoriInserire {
    private JTextField cognomeTextField;
    private JTextField nomeTextField;
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
    private JPanel panel54;
    private JTextField SSNTextField;
    private final JFrame frame54;

    /**
     * Instantiates a new Amm giocatori inserire.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public AmmGiocatoriInserire(JFrame frameChiamante, Controller controller) {
        frame54 = new JFrame("Giocatori - Inserire");
        frame54.setContentPane(panel54);
        frame54.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamante.setVisible(false);
        frame54.setVisible(true);

        controller.fillBaseValues(piedeComboBox, sessoComboBox, ruoloComboBox, ritiratoComboBox, tipoGiocatoreComboBox);

        frame54.pack();

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame54.dispose();
                frameChiamante.setVisible(true);
            }
        });
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (controller.ControlloSSN(SSNTextField.getText())) {

                    try {
                        if (controller.isEmpty(nomeTextField) || controller.isEmpty(cognomeTextField) || controller.isEmpty(nazionalitaTextField)) {
                            throw new IllegalArgumentException();
                        }
                        controller.InserireGiocatore(
                                controller.CreateGiocatore(
                                        nomeTextField.getText(),
                                        cognomeTextField.getText(),
                                        SSNTextField.getText(),
                                        nazionalitaTextField.getText(),
                                        Date.valueOf(dataNascitaTextField.getText()),
                                        (char) sessoComboBox.getSelectedItem(),
                                        (char) piedeComboBox.getSelectedItem(),
                                        Float.parseFloat(altezzaTextField.getText()),
                                        Float.parseFloat(pesoTextField.getText()),
                                        ruoloComboBox.getSelectedItem().toString(),
                                        Boolean.parseBoolean(ritiratoComboBox.getSelectedItem().toString()),
                                        abilitàTextField.getText(),
                                        (char) tipoGiocatoreComboBox.getSelectedItem()
                                ));
                        JOptionPane.showMessageDialog(null, "Giocatore inserito correttamente", "Successo", JOptionPane.INFORMATION_MESSAGE);
                        frame54.dispose();
                        frameChiamante.setVisible(true);
                    } catch (IllegalArgumentException c) {
                        JOptionPane.showMessageDialog(null, "Dati non inseriti correttamente", "Errore", JOptionPane.ERROR_MESSAGE);
                    } catch (RuntimeException c) {
                        JOptionPane.showMessageDialog(null, "Giocatore non inserito", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Giocatore non inserito", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
