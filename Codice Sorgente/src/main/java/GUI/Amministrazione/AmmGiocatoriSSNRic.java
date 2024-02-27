package GUI.Amministrazione;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Amm giocatori ssn ric.
 */
public class AmmGiocatoriSSNRic {
    private JButton ricercaButton;
    private JButton indietroButton;
    private JTextField SSNTextField;
    private JPanel panel53;
    private JFrame frame53;

    /**
     * Instantiates a new Amm giocatori ssn ric.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public AmmGiocatoriSSNRic(JFrame frameChiamante, Controller controller) {
        frame53 = new JFrame("Giocatori - SSN Ric");
        frame53.setContentPane(panel53);
        frame53.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame53.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame53.setVisible(true);

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame53.dispose();
                frameChiamante.setVisible(true);
            }
        });
        ricercaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (controller.ControlloSSNDB(SSNTextField.getText())) {
                    JOptionPane.showMessageDialog(frame53, "Giocatore trovato");
                    AmmGiocatoriModificare ammGiocatoriModificare = new AmmGiocatoriModificare(frame53, controller, SSNTextField.getText());
                }
            }
        });
    }

}
