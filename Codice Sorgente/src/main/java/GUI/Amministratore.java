package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Amministratore.
 */
public class Amministratore {
    private JPanel panel3;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton indietroButton;
    private JButton confermaButton;

    private JFrame frame3;

    /**
     * Instantiates a new Amministratore.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public Amministratore(JFrame frameChiamante, Controller controller) {
        frame3 = new JFrame("Amministratore");
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
                if (controller.getAmministratoreDAO().getGeneraleDAO().ControlloCredenziali(usernameTextField.getText(), new String(passwordPasswordField.getPassword()), 3)) {
                    JOptionPane.showMessageDialog(frame3, "Benvenuto " + usernameTextField.getText() + "!");
                    AmministratoreGui amministratoreGui = new AmministratoreGui(frame3, controller);
                }

            }
        });
    }

}
