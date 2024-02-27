package GUI;

import javax.swing.*;
import Controller.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Ric carriera.
 */
public class RicCarriera {
    private JPanel panel21;
    private JButton cercaButton;
    private JButton indietroButton;
    private JTextField SSNTextField;
    private JFrame frame21;

    /**
     * Instantiates a new Ric carriera.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public RicCarriera(JFrame frameChiamante, Controller controller) {
        frame21 = new JFrame("Ricerca Carriera");
        frame21.setContentPane(panel21);
        frame21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame21.pack();
        frameChiamante.setVisible(false);
        frame21.setVisible(true);

        controller.setCurrentFrame(frame21);
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame21.dispose();
                frameChiamante.setVisible(true);
            }
        });
        cercaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (controller.ControlloSSNDB(SSNTextField.getText())) {
                    if (controller.getUtenteDAO().getGeneraleDAO().QueryIsNotNull("SELECT * FROM carriera_giocatore('" + SSNTextField.getText() + "')" + "WHERE inizio_carr IS NOT NULL")) {
                        controller.getUtenteDAO().getGeneraleDAO().TabellaDaQuery("SELECT * FROM carriera_giocatore('" + SSNTextField.getText() + "')",
                                new String[]{
                                        "Inizio_Carr",
                                        "s_part_gioc",
                                        "s_goal_segn",
                                        "s_goal_sub",
                                        "s_cart_g",
                                        "s_cart_r",
                                        "s_assist",
                                        "Fine_Carr"});
                    } else {
                        JOptionPane.showMessageDialog(frame21, "Il giocatore non ha intrapreso una carriera.");
                    }
                }
            }
        });
    }

}
