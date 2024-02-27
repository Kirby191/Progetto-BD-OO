package GUI;

import GUI.Amministrazione.AmmGiocatori;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Amministratore gui.
 */
public class AmministratoreGui {
    private JButton giocatoriButton;
    private JPanel panel8;
    private JButton indietroButton;
    private JFrame frame8;

    /**
     * Instantiates a new Amministratore gui.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public AmministratoreGui(JFrame frameChiamante, Controller controller) {
        frame8 = new JFrame("Amministratore - Macroaree");
        frame8.setContentPane(panel8);
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame8.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame8.setVisible(true);
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame8.dispose();
                frameChiamante.setVisible(true);
            }
        });
        giocatoriButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AmmGiocatori ammGiocatori = new AmmGiocatori(frame8, controller);
            }
        });
    }

}
