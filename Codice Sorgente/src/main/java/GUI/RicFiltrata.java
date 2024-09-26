package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Ric filtrata.
 */
public class RicFiltrata {

    private JPanel panel10;
    private JButton caratteristicheFisicheButton;
    private JButton carrieraButton;
    private JButton indietroButton;
    private JLabel CercaLabel;
    private JFrame frame10;

    /**
     * Instantiates a new Ric filtrata.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public RicFiltrata(JFrame frameChiamante, Controller controller) {
        frame10 = new JFrame("Ricerca filtrata");
        frame10.setContentPane(panel10);
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame10.setSize(450, 200);
        frameChiamante.setVisible(false);
        frame10.setVisible(true);
        CercaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        caratteristicheFisicheButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RicCaratteristicheFisiche ricCaratteristicheFisiche = new RicCaratteristicheFisiche(frame10, controller);
            }
        });
        carrieraButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RicCarriera ricCarriera = new RicCarriera(frame10, controller);
            }
        });
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame10.dispose();
                frameChiamante.setVisible(true);
            }
        });
    }

}
