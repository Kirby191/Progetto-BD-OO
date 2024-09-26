package GUI;

import javax.swing.*;
import Controller.Controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Ric caratteristiche fisiche.
 */
public class RicCaratteristicheFisiche {
    private JPanel panel20;
    private JTextField nomeTextField;
    private JButton cercaButton;
    private JButton indietroButton;
    private JTextField cognomeTextField;
    private JComboBox piedeComboBox;
    private JComboBox ruoloComboBox;
    private JComboBox sessoComboBox;
    private JComboBox etàComboBox;
    private JTextField AnnoNascitaTextField;
    private JFrame frame20;

    /**
     * Instantiates a new Ric caratteristiche fisiche.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public RicCaratteristicheFisiche(JFrame frameChiamante, Controller controller) {
        frame20 = new JFrame("Ricerca Caratteristiche Fisiche");
        frame20.setContentPane(panel20);
        frame20.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamante.setVisible(false);
        frame20.setVisible(true);

        controller.fillBaseValues(piedeComboBox, sessoComboBox, ruoloComboBox);
        etàComboBox.addItem(" ");
        etàComboBox.addItem("ASC");
        etàComboBox.addItem("DESC");
        frame20.pack();

        cercaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.setCurrentFrame(frame20);
                controller.RicercaGiocatore(nomeTextField, cognomeTextField, AnnoNascitaTextField, piedeComboBox, ruoloComboBox, sessoComboBox, etàComboBox);
            }
        });
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame20.dispose();
                frameChiamante.setVisible(true);
            }
        });
    }

}
