package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Utente.
 */
public class Utente {
    private JButton filtrataButton;
    private JButton elencoButton;
    private JButton indietroButton;
    private JPanel panel2;
    private JLabel LabelRicerca;
    private JFrame frame1;

    /**
     * Instantiates a new Utente.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public Utente(JFrame frameChiamante, Controller controller) {
        frame1 = new JFrame("Utente");
        frame1.setContentPane(panel2);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(450, 200);
        frameChiamante.setVisible(false);
        frame1.setVisible(true);
        LabelRicerca.setFont(new Font("Arial", Font.BOLD, 15));

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame1.dispose();
                frameChiamante.setVisible(true);
            }
        });
        filtrataButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new RicFiltrata(frame1, controller);
            }
        });
        elencoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.setCurrentFrame(frame1);
                String[] colonne = {"Nome", "Cognome", "SSN", "Nazionalita", "DataDiNascita", "Sesso", "Altezza", "Peso", "Ruolo", "Ritirato", "Abilita", "Piede", "TipoGiocatore"};
                controller.getUtenteDAO().getGeneraleDAO().TabellaDaQuery("SELECT * FROM Giocatore WHERE 1 = 1", colonne);
            }
        });
    }

}
