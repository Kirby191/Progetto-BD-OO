package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;


/**
 * The type Registrazione g.
 */
public class RegistrazioneG {
    private JPanel panel24;
    private JTextField SSNTextField;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JPasswordField confermaPasswordPasswordField;
    private JButton indietroButton;
    private JButton confermaButton;
    private JFrame frame24;

    /**
     * Instantiates a new Registrazione g.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public RegistrazioneG(JFrame frameChiamante, Controller controller) {
        frame24 = new JFrame("Registrazione Giocatore");
        frame24.setContentPane(panel24);
        frame24.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame24.setSize(450, 300);
        frameChiamante.setVisible(false);
        frame24.setVisible(true);

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame24.dispose();
                frameChiamante.setVisible(true);
            }
        });
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Arrays.toString(passwordPasswordField.getPassword()).equals(Arrays.toString(confermaPasswordPasswordField.getPassword()))) {
                    if (controller.ControlloSSNDB(SSNTextField.getText())) {
                        controller.getGiocatoreDAO().RegistrazioneGiocatore(SSNTextField.getText(), usernameTextField.getText(), new String(passwordPasswordField.getPassword()));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Le password non corrispondono");
                }
            }
        });
    }

}
