package Controller;

import DAO.AmministratoreDAO;
import DAO.GeneraleDAO;
import DAO.GiocatoreDAO;
import DAO.UtenteDAO;
import Database.ConnessioneDatabase;
import ImplementazioneDAO.ImpDAOAmministratore;
import ImplementazioneDAO.ImpDAOGiocatori;
import ImplementazioneDAO.ImpDAOUtente;
import ImplementazioneDAO.ImplementazioneGeneraleDAO;
import Model.*;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Classe Controller
 * Questa classe è il controller del programma, si occupa di gestire le richieste dell'utente e di comunicare con il database
 */
public class Controller {
    /**
     * Costruttore vuoto
     */
    public Controller() {
    }
    private static JFrame currentFrame;

    /**
     * Create giocatore giocatore.
     *
     * @param nome          the nome
     * @param cognome       the cognome
     * @param SSN           the ssn
     * @param nazionalita   the nazionalita
     * @param dataNascita   the data nascita
     * @param sesso         the sesso
     * @param piede         the piede
     * @param altezza       the altezza
     * @param peso          the peso
     * @param ruolo         the ruolo
     * @param ritirato      the ritirato
     * @param abilita       the abilita
     * @param tipoGiocatore the tipo giocatore
     * @return the giocatore
     */
    public Giocatore CreateGiocatore(String nome, String cognome, String SSN, String nazionalita, Date dataNascita,
                                     char sesso, char piede, float altezza, float peso,
                                     String ruolo, Boolean ritirato, String abilita, char tipoGiocatore) {
        return new Giocatore(nome, cognome, SSN, nazionalita, dataNascita,
                sesso, piede, altezza, peso, ruolo, ritirato, abilita, tipoGiocatore);
    }

    /**
     * Create squadra.
     *
     * @param a              the a
     * @param d              the d
     * @param nomeSquadra    the nome squadra
     * @param nazionalita    the nazionalita
     * @param dataFondazione the data fondazione
     * @return the squadra
     */
    public Squadra CreateSquadra(Allenatore a, Dirigente d,
                              String nomeSquadra, String nazionalita, Date dataFondazione) {
        return new Squadra(a, d, nomeSquadra, nazionalita, dataFondazione);
    }

    /**
     * Create allenatore.
     *
     * @param s       the s
     * @param nome    the nome
     * @param cognome the cognome
     * @param sesso   the sesso
     * @param SSN     the ssn
     * @param inizioA the inizio a
     * @param fineA   the fine a
     * @return the allenatore
     */
    public Allenatore CreateAllenatore(String nome, String cognome, char sesso,
                                 String SSN, Date inizioA, Date fineA, Squadra s) {
        return new Allenatore(nome, cognome, sesso, SSN, inizioA, fineA, s);
    }

    /**
     * Create dirigente dirigente.
     *
     * @param s       the s
     * @param nome    the nome
     * @param cognome the cognome
     * @param sesso   the sesso
     * @param SSN     the ssn
     * @param inizioD the inizio d
     * @param fineD   the fine d
     * @return the dirigente
     */
    public Dirigente CreateDirigente(Squadra s, String nome, String cognome, char sesso,
                                String SSN, Date inizioD, Date fineD) {
        return new Dirigente(s, nome, cognome, sesso, SSN, inizioD, fineD);
    }

    /**
     * Create militanza.
     *
     * @param g                the g
     * @param s                the s
     * @param dataInizio       the data inizio
     * @param dataFine         the data fine
     * @param partiteGiocate   the partite giocate
     * @param goalSegnati      the goal segnati
     * @param cartelliniGialli the cartellini gialli
     * @param cartelliniRossi  the cartellini rossi
     * @param assist           the assist
     * @return the militanza
     */
    public Militanza CreateMilitanza(Giocatore g, Squadra s, Date dataInizio, Date dataFine, int partiteGiocate,
                                int goalSegnati, int cartelliniGialli, int cartelliniRossi, int assist) {
        return new Militanza(g, s, dataInizio, dataFine,
                partiteGiocate, goalSegnati, cartelliniGialli, cartelliniRossi, assist);
    }

    /**
     * Create trofeo.
     *
     * @param nomeTrofeo the nome trofeo
     * @param annoTrofeo the anno trofeo
     * @param isSquadra  the is squadra
     * @return the trofeo
     */
    public Trofeo CreateTrofeo(String nomeTrofeo, Date annoTrofeo, boolean isSquadra) {
        return new Trofeo(nomeTrofeo, annoTrofeo, isSquadra);
    }

    /**
     * Create militanza portiere.
     *
     * @param g                the g
     * @param s                the s
     * @param dataInizio       the data inizio
     * @param dataFine         the data fine
     * @param partiteGiocate   the partite giocate
     * @param goalSegnati      the goal segnati
     * @param cartelliniGialli the cartellini gialli
     * @param cartelliniRossi  the cartellini rossi
     * @param assist           the assist
     * @param goalSubiti       the goal subiti
     * @return the militanza portiere
     */
    public MilitanzaPortiere CreateMilitanzaPortiere(Giocatore g, Squadra s, Date dataInizio, Date dataFine,
                                        int partiteGiocate, int goalSegnati, int cartelliniGialli,
                                        int cartelliniRossi, int assist, int goalSubiti) {
        return new Model.MilitanzaPortiere(g, s, dataInizio, dataFine, partiteGiocate,
                goalSegnati, cartelliniGialli, cartelliniRossi, assist, goalSubiti);
    }

    /**
     * Controllo ssndb boolean.
     *
     * @param SSN the ssn
     * @return the boolean
     */
    public boolean ControlloSSNDB(String SSN) {
        if (SSN.length() == 11) {
            // Verifica il formato del SSN
            for (int i = 0; i < 11; i++) {
                // Se l'indice è un trattino, controlla se è nella posizione corretta
                if (i == 3 || i == 7) {
                    if (SSN.charAt(i) != '-') {
                        JOptionPane.showMessageDialog(null, "Formato SSN non corretto!");
                        return false;
                    }
                } else {
                    // Altrimenti, controlla se è un numero
                    if (!Character.isDigit(SSN.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Formato SSN non corretto!");
                        return false;
                    }
                }
            }
            //Se trovo l'SSN nel database, ritorno true
            if (getGiocatoreDAO().ControlloSSNEsistente(SSN)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "SSN non presente nel Database");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "SSN ha una lunghezza non valida");
        return false;
    }

    /**
     * Gets amministratore dao.
     *
     * @return the amministratore dao
     */
    public AmministratoreDAO getAmministratoreDAO() {
        return new ImpDAOAmministratore();
    }

    /**
     * Gets giocatore dao.
     *
     * @return the giocatore dao
     */
    public GiocatoreDAO getGiocatoreDAO() {
        return new ImpDAOGiocatori();
    }

    /**
     * Gets utente dao.
     *
     * @return the utente dao
     */
    public UtenteDAO getUtenteDAO() {
        return new ImpDAOUtente();
    }

    /**
     * Gets postgres dao.
     *
     * @param permesso the permesso
     * @return the postgres dao
     */
    public GeneraleDAO getGeneraleDAO(int permesso) {
        try {
            return new ImplementazioneGeneraleDAO(ConnessioneDatabase.getInstance(permesso).connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserisci valori giocatore from us string.
     *
     * @param nomeTextField         the nome text field
     * @param cognomeTextField      the cognome text field
     * @param nazionalitàTextField  the nazionalità text field
     * @param dataNascitaTextField  the data nascita text field
     * @param piedeComboBox         the piede combo box
     * @param altezzaTextField      the altezza text field
     * @param pesoTextField         the peso text field
     * @param ruoloComboBox         the ruolo combo box
     * @param ritiratoComboBox      the ritirato combo box
     * @param abilitàTextField      the abilità text field
     * @param tipoGiocatoreComboBox the tipo giocatore combo box
     * @param sessoComboBox         the sesso combo box
     * @param username              the username
     * @return the string
     */
    public String InserisciValoriGiocatoreFromUs(JTextField nomeTextField, JTextField cognomeTextField, JTextField nazionalitàTextField, JTextField dataNascitaTextField,
                                                 JComboBox piedeComboBox, JTextField altezzaTextField, JTextField pesoTextField, JComboBox ruoloComboBox, JComboBox ritiratoComboBox,
                                                 JTextField abilitàTextField, JComboBox tipoGiocatoreComboBox, JComboBox sessoComboBox, String username) {
        Giocatore g = getGiocatoreDAO().getGiocatoreFromUsername(username);

        piedeComboBox.addItem('D');
        piedeComboBox.addItem('S');
        piedeComboBox.setSelectedItem(g.getPiede());

        String[] ruoli = {"Portiere", "DifensoreCentrale", "TerzinoSinistro", "TerzinoDestro", "CentrocampistaDifensivo", "CentrocampistaCentrale", "EsternoSinistro", "EsternoDestro", "CentrocampistaOffensivo", "AlaSinistra", "AlaDestra", "Trequartista", "Punta"};
        for (String ruolod : ruoli) {
            ruoloComboBox.addItem(ruolod);
        }

        ruoloComboBox.setSelectedItem(g.getRuolo());

        sessoComboBox.addItem('M');
        sessoComboBox.addItem('F');

        sessoComboBox.setSelectedItem(g.getSesso());

        tipoGiocatoreComboBox.addItem('M');
        tipoGiocatoreComboBox.addItem('P');
        tipoGiocatoreComboBox.setSelectedItem(g.getTipoGiocatore());

        ritiratoComboBox.addItem("True");
        ritiratoComboBox.addItem("False");
        ritiratoComboBox.setSelectedItem(g.isRitirato() ? "True" : "False");
        nomeTextField.setText(g.getNome());
        cognomeTextField.setText(g.getCognome());
        nazionalitàTextField.setText(g.getNazionalita());
        dataNascitaTextField.setText(g.getDataNascita().toString());
        altezzaTextField.setText(String.valueOf(g.getAltezza()));
        pesoTextField.setText(String.valueOf(g.getPeso()));
        abilitàTextField.setText(g.getAbilita());

        return g.getSSN();
    }

    /**
     * Modifica giocatore.
     *
     * @param nomeTextField         the nome text field
     * @param cognomeTextField      the cognome text field
     * @param nazionalitaTextField  the nazionalita text field
     * @param dataNascitaTextField  the data nascita text field
     * @param piedeComboBox         the piede combo box
     * @param altezzaTextField      the altezza text field
     * @param pesoTextField         the peso text field
     * @param ruoloComboBox         the ruolo combo box
     * @param ritiratoComboBox      the ritirato combo box
     * @param abilitàTextField      the abilità text field
     * @param tipoGiocatoreComboBox the tipo giocatore combo box
     * @param sessoComboBox         the sesso combo box
     * @param SSN                   the ssn
     * @param permesso              the permesso
     */
    public void ModificaGiocatore(JTextField nomeTextField, JTextField cognomeTextField, JTextField nazionalitaTextField, JTextField dataNascitaTextField,
                                  JComboBox piedeComboBox, JTextField altezzaTextField, JTextField pesoTextField, JComboBox ruoloComboBox, JComboBox ritiratoComboBox,
                                  JTextField abilitàTextField, JComboBox tipoGiocatoreComboBox, JComboBox sessoComboBox, String SSN, int permesso) {
        String ritirato = (String) ritiratoComboBox.getSelectedItem();

        getGeneraleDAO(permesso).UpdateGiocatore(
                nomeTextField.getText(),
                cognomeTextField.getText(),
                nazionalitaTextField.getText(),
                Date.valueOf(dataNascitaTextField.getText()),
                (char) sessoComboBox.getSelectedItem(),
                (char) piedeComboBox.getSelectedItem(),
                Float.parseFloat(altezzaTextField.getText()),
                Float.parseFloat(pesoTextField.getText()),
                (String) ruoloComboBox.getSelectedItem(),
                ritirato.equals("True") ? true : false,
                abilitàTextField.getText(),
                (char) tipoGiocatoreComboBox.getSelectedItem(),
                SSN
        );
    }

    /**
     * Ricerca giocatore.
     *
     * @param nomeTextField        the nome text field
     * @param cognomeTextField     the cognome text field
     * @param annoNascitaTextField the anno nascita text field
     * @param piedeComboBox        the piede combo box
     * @param ruoloComboBox        the ruolo combo box
     * @param sessoComboBox        the sesso combo box
     * @param etàComboBox          the età combo box
     */
    public void RicercaGiocatore(JTextField nomeTextField, JTextField cognomeTextField, JTextField annoNascitaTextField, JComboBox piedeComboBox, JComboBox ruoloComboBox, JComboBox sessoComboBox, JComboBox etàComboBox) {
        Date dataNascita = null;
        if (!annoNascitaTextField.getText().isEmpty())
            dataNascita = Date.valueOf(annoNascitaTextField.getText());


        getUtenteDAO().CarFisicheRicercaGiocatore(
                nomeTextField.getText(),
                cognomeTextField.getText(),
                dataNascita,
                piedeComboBox.getSelectedItem().toString(),
                ruoloComboBox.getSelectedItem().toString(),
                sessoComboBox.getSelectedItem().toString(),
                etàComboBox.getSelectedItem().toString());
    }

    /**
     * Sets current frame.
     *
     * @param frame the frame
     */
    public void setCurrentFrame(JFrame frame) {
        currentFrame = frame;
    }

    /**
     * Gets current frame.
     *
     * @return the current frame
     */
    public static JFrame getCurrentFrame() {
        return currentFrame;
    }

    /**
     * Fill base values.
     *
     * @param piedeComboBox the piede combo box
     * @param sessoComboBox the sesso combo box
     * @param ruoloComboBox the ruolo combo box
     */
    public void fillBaseValues(JComboBox piedeComboBox, JComboBox sessoComboBox, JComboBox ruoloComboBox) {
        piedeComboBox.addItem(' ');
        piedeComboBox.addItem('D');
        piedeComboBox.addItem('S');

        sessoComboBox.addItem(' ');
        sessoComboBox.addItem('M');
        sessoComboBox.addItem('F');

        String[] ruoli = {" ", "Portiere", "DifensoreCentrale", "TerzinoSinistro", "TerzinoDestro", "CentrocampistaDifensivo", "CentrocampistaCentrale", "EsternoSinistro", "EsternoDestro", "CentrocampistaOffensivo", "AlaSinistra", "AlaDestra", "Trequartista", "Punta"};
        for (String ruolod : ruoli) {
            ruoloComboBox.addItem(ruolod);
        }
    }

    /**
     * Elimina giocatore.
     *
     * @param SSN the ssn
     */
    public void EliminaGiocatore(String SSN) {
        getAmministratoreDAO().EliminaGiocatore(SSN);
    }

    /**
     * Inserisci valori giocatore from ssn.
     *
     * @param nomeTextField         the nome text field
     * @param cognomeTextField      the cognome text field
     * @param nazionalitàTextField  the nazionalità text field
     * @param dataNascitaTextField  the data nascita text field
     * @param piedeComboBox         the piede combo box
     * @param altezzaTextField      the altezza text field
     * @param pesoTextField         the peso text field
     * @param ruoloComboBox         the ruolo combo box
     * @param ritiratoComboBox      the ritirato combo box
     * @param abilitàTextField      the abilità text field
     * @param tipoGiocatoreComboBox the tipo giocatore combo box
     * @param sessoComboBox         the sesso combo box
     * @param SSN                   the ssn
     */
    public void InserisciValoriGiocatoreFromSSN(JTextField nomeTextField, JTextField cognomeTextField, JTextField nazionalitàTextField, JTextField dataNascitaTextField,
                                                JComboBox piedeComboBox, JTextField altezzaTextField, JTextField pesoTextField, JComboBox ruoloComboBox, JComboBox ritiratoComboBox,
                                                JTextField abilitàTextField, JComboBox tipoGiocatoreComboBox, JComboBox sessoComboBox, String SSN) {
        Giocatore g = getAmministratoreDAO().OttieniGiocatore(SSN);

        piedeComboBox.addItem('D');
        piedeComboBox.addItem('S');
        piedeComboBox.setSelectedItem(g.getPiede());

        String[] ruoli = {"Portiere", "DifensoreCentrale", "TerzinoSinistro", "TerzinoDestro", "CentrocampistaDifensivo", "CentrocampistaCentrale", "EsternoSinistro", "EsternoDestro", "CentrocampistaOffensivo", "AlaSinistra", "AlaDestra", "Trequartista", "Punta"};
        for (String ruolod : ruoli) {
            ruoloComboBox.addItem(ruolod);
        }

        ruoloComboBox.setSelectedItem(g.getRuolo());

        sessoComboBox.addItem('M');
        sessoComboBox.addItem('F');

        sessoComboBox.setSelectedItem(g.getSesso());

        tipoGiocatoreComboBox.addItem('M');
        tipoGiocatoreComboBox.addItem('P');
        tipoGiocatoreComboBox.setSelectedItem(g.getTipoGiocatore());

        ritiratoComboBox.addItem("True");
        ritiratoComboBox.addItem("False");
        ritiratoComboBox.setSelectedItem(g.isRitirato() ? "True" : "False");
        nomeTextField.setText(g.getNome());
        cognomeTextField.setText(g.getCognome());
        nazionalitàTextField.setText(g.getNazionalita());
        dataNascitaTextField.setText(g.getDataNascita().toString());
        altezzaTextField.setText(String.valueOf(g.getAltezza()));
        pesoTextField.setText(String.valueOf(g.getPeso()));
        abilitàTextField.setText(g.getAbilita());
    }

    /**
     * Fill base values.
     *
     * @param piedeComboBox         the piede combo box
     * @param sessoComboBox         the sesso combo box
     * @param ruoloComboBox         the ruolo combo box
     * @param ritiratoComboBox      the ritirato combo box
     * @param tipoGiocatoreComboBox the tipo giocatore combo box
     */
//Overloading
    public void fillBaseValues(JComboBox piedeComboBox, JComboBox sessoComboBox, JComboBox ruoloComboBox, JComboBox ritiratoComboBox, JComboBox tipoGiocatoreComboBox) {
        piedeComboBox.addItem(' ');
        piedeComboBox.addItem('D');
        piedeComboBox.addItem('S');

        sessoComboBox.addItem(' ');
        sessoComboBox.addItem('M');
        sessoComboBox.addItem('F');

        String[] ruoli = {" ", "Portiere", "DifensoreCentrale", "TerzinoSinistro", "TerzinoDestro", "CentrocampistaDifensivo", "CentrocampistaCentrale", "EsternoSinistro", "EsternoDestro", "CentrocampistaOffensivo", "AlaSinistra", "AlaDestra", "Trequartista", "Punta"};
        for (String ruolod : ruoli) {
            ruoloComboBox.addItem(ruolod);
        }

        ritiratoComboBox.addItem(" ");
        ritiratoComboBox.addItem("True");
        ritiratoComboBox.addItem("False");

        tipoGiocatoreComboBox.addItem(" ");
        tipoGiocatoreComboBox.addItem('M');
        tipoGiocatoreComboBox.addItem('P');
    }

    /**
     * Inserire giocatore.
     *
     * @param g the g
     */
    public void InserireGiocatore(Giocatore g) {
        getAmministratoreDAO().InserireGiocatore(g);
    }

    /**
     * Controllo ssn boolean.
     *
     * @param SSN the ssn
     * @return the boolean
     */
    public boolean ControlloSSN(String SSN) {
        if (SSN.length() == 11) {
            // Verifica il formato del SSN
            for (int i = 0; i < 11; i++) {
                // Se l'indice è un trattino, controlla se è nella posizione corretta
                if (i == 3 || i == 7) {
                    if (SSN.charAt(i) != '-') {
                        JOptionPane.showMessageDialog(null, "Formato SSN non corretto!");
                        return false;
                    }
                } else {
                    // Altrimenti, controlla se è un numero
                    if (!Character.isDigit(SSN.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Formato SSN non corretto!");
                        return false;
                    }
                }
            }
            return true;
        }
        JOptionPane.showMessageDialog(null, "SSN ha una lunghezza non valida");
        return false;
    }

    /**
     * Is empty boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        } else if (obj instanceof JTextField) {
            return ((JTextField) obj).getText().isEmpty();
        } else if (obj instanceof JComboBox) {
            return ((JComboBox) obj).getSelectedItem().toString().isEmpty();
        }
        return false;
    }

    /**
     * Inserire allenatore.
     *
     * @param a the a
     */
    public void InserireAllenatore(Allenatore a, Giocatore g) {
        a.setExgiocatore(g);
        a.getExgiocatore().ExGiocatoreA(a);
        getGiocatoreDAO().InserireAllenatore(a);
    }

    /**
     * Inserire dirigente.
     *
     * @param d the d
     */
    public void InserireDirigente(Dirigente d, Giocatore g) {
        d.setGiocatore(g);
        d.getGiocatore().ExGiocatoreD(d);
        getGiocatoreDAO().InserireDirigente(d);
    }

}