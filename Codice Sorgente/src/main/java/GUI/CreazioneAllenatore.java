package GUI;

import Controller.Controller;
import Model.Giocatore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;

/**
 * The type Creazione allenatore.
 */
public class CreazioneAllenatore {

    private JButton confermaButton;
    private JButton cancellaButton;
    private JPanel panel701;
    private JLabel SicuroLabel;
    private JFrame frame8;

    /**
     * Instantiates a new Creazione allenatore.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param g              the g
     */
    public CreazioneAllenatore(JFrame frameChiamante, Controller controller, Giocatore g) {
        frame8 = new JFrame("CreazioneAllenatore");
        frame8.setContentPane(panel701);
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame8.setVisible(true);
        frameChiamante.setVisible(false);
        SicuroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame8.setSize(750, 450);

        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    controller.InserireAllenatore(controller.CreateAllenatore(g.getNome(), g.getCognome(), g.getSesso(), g.getSSN(), Date.valueOf(LocalDate.now()), null, null), g);
                    frame8.dispose();
                    frameChiamante.dispose();
                    Home.getFrame().setVisible(true);
                } catch (RuntimeException v) {
                    JOptionPane.showMessageDialog(null, v.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancellaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame8.dispose();
                frameChiamante.dispose();
                Home.getFrame().setVisible(true);
            }
        });
    }

}
