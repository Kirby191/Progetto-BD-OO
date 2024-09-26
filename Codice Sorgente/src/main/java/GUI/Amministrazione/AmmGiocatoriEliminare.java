package GUI.Amministrazione;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * The type Amm giocatori eliminare.
 */
public class AmmGiocatoriEliminare {

    private JButton eliminaButton;
    private JButton indietroButton;
    private JTextField SSNTextField;
    private JPanel panel51;
    private final JFrame frame51;

    /**
     * Instantiates a new Amm giocatori eliminare.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public AmmGiocatoriEliminare(JFrame frameChiamante, Controller controller) {
        frame51 = new JFrame("Giocatori - Eliminare");
        frame51.setContentPane(panel51);
        frame51.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame51.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame51.setVisible(true);
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame51.dispose();
                frameChiamante.setVisible(true);
            }
        });
        eliminaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (controller.ControlloSSNDB(SSNTextField.getText())) {
                    controller.EliminaGiocatore(SSNTextField.getText());
                    frame51.dispose();
                    frameChiamante.setVisible(true);
                }
            }
        });
    }

}