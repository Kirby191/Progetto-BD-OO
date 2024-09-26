package GUI.Amministrazione;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Amm giocatori.
 */
public class AmmGiocatori {
    private JButton eliminareButton1;
    private JButton modificareButton;
    private JButton inserireButton;
    private JButton indietroButton;
    private JPanel panel50;
    private final JFrame frame50;

    /**
     * Instantiates a new Amm giocatori.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public AmmGiocatori(JFrame frameChiamante, Controller controller) {
        frame50 = new JFrame("Amministratore - Giocatori");
        frame50.setContentPane(panel50);
        frame50.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame50.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame50.setVisible(true);

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame50.dispose();
                frameChiamante.setVisible(true);
            }
        });
        eliminareButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AmmGiocatoriEliminare ammGiocatoriEliminare = new AmmGiocatoriEliminare(frame50, controller);
            }
        });
        modificareButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AmmGiocatoriSSNRic ammGiocatoriSSNRic = new AmmGiocatoriSSNRic(frame50, controller);
            }
        });
        inserireButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AmmGiocatoriInserire ammGiocatoriInserire = new AmmGiocatoriInserire(frame50, controller);
            }
        });
    }

}
