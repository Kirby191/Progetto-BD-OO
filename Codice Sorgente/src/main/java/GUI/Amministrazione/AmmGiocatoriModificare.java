package GUI.Amministrazione;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Amm giocatori modificare.
 */
public class AmmGiocatoriModificare {
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
    private JPanel panel52;

    private JFrame frame52;

    /**
     * Instantiates a new Amm giocatori modificare.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param SSN            the ssn
     */
    public AmmGiocatoriModificare(JFrame frameChiamante, Controller controller, String SSN) {
        frame52 = new JFrame("Giocatori - Modificare");
        frame52.setContentPane(panel52);
        frame52.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamante.setVisible(false);
        frame52.setVisible(true);

        controller.InserisciValoriGiocatoreFromSSN(nomeTextField, cognomeTextField, nazionalitaTextField, dataNascitaTextField,
                piedeComboBox, altezzaTextField, pesoTextField, ruoloComboBox, ritiratoComboBox,
                abilitàTextField, tipoGiocatoreComboBox, sessoComboBox, SSN);

        frame52.pack();


        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame52.dispose();
                frameChiamante.setVisible(true);
            }
        });
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.ModificaGiocatore(nomeTextField, cognomeTextField, nazionalitaTextField, dataNascitaTextField,
                        piedeComboBox, altezzaTextField, pesoTextField, ruoloComboBox, ritiratoComboBox,
                        abilitàTextField, tipoGiocatoreComboBox, sessoComboBox, SSN, 3);
            }
        });
    }

}
