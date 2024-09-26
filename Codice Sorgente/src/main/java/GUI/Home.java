package GUI;

import Database.ConnessioneDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import Controller.*;

/**
 * The type Home.
 */
public class Home {
    private JPanel panel1;
    private JButton utenteButton;
    private JButton giocatoreButton;
    private JButton amministratoreButton;
    private JButton uscitaButton;
    private JLabel BenvenutoLabel;
    private static JFrame frame;

    /**
     * The Controller.
     */
    public Controller controller = new Controller();

    /**
     * Instantiates a new Home.
     */
    public Home() {

        BenvenutoLabel.setFont(new Font("Arial", Font.BOLD, 15));

        utenteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Utente utente = new Utente(frame, controller);
            }
        });
        giocatoreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Giocatore giocatore = new Giocatore(frame, controller);
            }
        });
        amministratoreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Amministratore amministratore = new Amministratore(frame, controller);
            }
        });
        uscitaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws SQLException {
        frame = new JFrame("Home");
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public static JFrame getFrame() {
        return frame;
    }


}
