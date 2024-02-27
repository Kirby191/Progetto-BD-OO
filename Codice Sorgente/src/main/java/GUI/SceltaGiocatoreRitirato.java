package GUI;

import Model.Giocatore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.Controller;

/**
 * The type Scelta giocatore ritirato.
 */
public class SceltaGiocatoreRitirato {
    private JButton noButton;
    private JButton siButton;
    private JPanel panel7;
    private JLabel SceltaLabel;

    private JFrame frame7;

    /**
     * Instantiates a new Scelta giocatore ritirato.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param g              the g
     */
    public SceltaGiocatoreRitirato(JFrame frameChiamante, Controller controller, Giocatore g) {
        frame7 = new JFrame("SceltaGiocatoreRitirato");
        frame7.setContentPane(panel7);
        frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame7.setVisible(true);
        frameChiamante.setVisible(false);
        SceltaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        frame7.setSize(800, 250);

        noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(frame7, "La carriera del giocatore è terminata. Grazie per aver giocato!");
                frame7.dispose();
                frameChiamante.dispose();
                Home.getFrame().setVisible(true);
            }
        });
        siButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SceltaAllDir sceltaAllDir = new SceltaAllDir(frame7, controller, g);
            }
        });
    }

}
