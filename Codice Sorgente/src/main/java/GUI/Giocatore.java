package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Giocatore.
 */
public class Giocatore {
    private JPanel panel3;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton indietroButton;
    private JButton confermaButton;
    private JButton registratiButton;
    private JFrame frame3;

    /**
     * Instantiates a new Giocatore.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public Giocatore(JFrame frameChiamante, Controller controller) {
        frame3 = new JFrame("Giocatore");
        frame3.setContentPane(panel3);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame3.setVisible(true);
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame3.dispose();
                frameChiamante.setVisible(true);
            }
        });
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (controller.getGiocatoreDAO().getGeneraleDAO().ControlloCredenziali(usernameTextField.getText(),
                        new String(passwordPasswordField.getPassword()),
                        2)) {
                    GiocatoreAcc giocatoreAcc = new GiocatoreAcc(frame3, controller, usernameTextField.getText());
                }
            }
        });
        registratiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RegistrazioneG registrazioneG = new RegistrazioneG(frame3, controller);
            }
        });
    }

}
