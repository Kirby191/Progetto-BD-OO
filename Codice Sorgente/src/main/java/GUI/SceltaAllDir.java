package GUI;

import Model.Giocatore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.Controller;

/**
 * The type Scelta all dir.
 */
public class SceltaAllDir {
    private JButton allenatoreButton;
    private JButton dirigenteButton;
    private JPanel panel700;
    private JLabel SceltaLabel;

    private final JFrame frame7;

    /**
     * Instantiates a new Scelta all dir.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param g              the g
     */
    public SceltaAllDir(JFrame frameChiamante, Controller controller, Giocatore g) {
        frame7 = new JFrame("SceltaAllDir");
        frame7.setContentPane(panel700);
        frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame7.setSize(450, 300);
        frame7.setVisible(true);
        frameChiamante.setVisible(false);
        SceltaLabel.setFont(new Font("Arial", Font.BOLD, 15));

        allenatoreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CreazioneAllenatore creazioneAllenatore = new CreazioneAllenatore(frame7, controller, g);
            }
        });
        dirigenteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CreazioneDirigente creazioneDirigente = new CreazioneDirigente(frame7, controller, g);
            }
        });
    }

}
