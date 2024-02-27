package GUI;

import Model.Giocatore;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;

/**
 * The type Creazione dirigente.
 */
public class CreazioneDirigente {
    private JButton confermaButton;
    private JButton cancellaButton;
    private JPanel panel699;
    private JLabel SicuroLabel;
    private JFrame frame9;

    /**
     * Instantiates a new Creazione dirigente.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     * @param g              the g
     */
    public CreazioneDirigente(JFrame frameChiamante, Controller controller, Giocatore g) {
        frame9 = new JFrame("Creazione Dirigente");
        frame9.setContentPane(this.panel699);
        frame9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame9.setVisible(true);
        frameChiamante.setVisible(false);

        SicuroLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        frame9.setSize(750, 450);

        cancellaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame9.dispose();
                frameChiamante.dispose();
                Home.getFrame().setVisible(true);
            }
        });
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    controller.InserireDirigente(controller.CreateDirigente(null, g.getNome(), g.getCognome(), g.getSesso(), g.getSSN(), Date.valueOf(LocalDate.now()), null), g);
                    frame9.dispose();
                    frameChiamante.dispose();
                    Home.getFrame().setVisible(true);
                } catch (RuntimeException v) {
                    JOptionPane.showMessageDialog(null, v.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
