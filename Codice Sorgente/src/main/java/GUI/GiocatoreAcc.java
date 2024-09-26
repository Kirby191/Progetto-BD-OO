package GUI;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Giocatore acc.
 */
public class GiocatoreAcc {
    private JButton indietroButton;
    private JButton modificaValoriButton1;
    private JPanel panel4;
    private JLabel benvenutoLabel;
    private JLabel opzione;
    private JFrame frame4;

    /**
     * Instantiates a new Giocatore acc.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param username       the username
     */
    public GiocatoreAcc(JFrame frameChiamante, Controller controller, String username) {
        frame4 = new JFrame("Giocatore");
        frame4.setContentPane(panel4);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame4.setVisible(true);
        benvenutoLabel.setText("Benvenuto, " + username + "!");
        benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        opzione.setFont(new Font("Arial", Font.BOLD, 15));

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame4.dispose();
                frameChiamante.setVisible(true);
            }
        });

        modificaValoriButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                GiocatoreModificaValori giocatoreModificaValori = new GiocatoreModificaValori(frame4, controller, username);
            }
        });
    }

}
