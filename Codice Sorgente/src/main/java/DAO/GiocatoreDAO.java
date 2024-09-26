package DAO;

import Model.Allenatore;
import Model.Dirigente;
import Model.Giocatore;

/**
 * The interface Giocatore dao.
 */
public interface GiocatoreDAO {
    /**
     * Registrazione giocatore.
     *
     * @param SSN      the ssn
     * @param username the username
     * @param password the password
     */
    void RegistrazioneGiocatore(String SSN, String username, String password);

    /**
     * Controllo ssn esistente boolean.
     *
     * @param SSN the ssn
     * @return the boolean
     */
    boolean ControlloSSNEsistente(String SSN);

    /**
     * Gets giocatore from username.
     *
     * @param username the username
     * @return the giocatore from username
     */
    Giocatore getGiocatoreFromUsername(String username);

    /**
     * Gets postgres dao.
     *
     * @return the postgres dao
     */
    GeneraleDAO getGeneraleDAO();

    /**
     * Inserire allenatore.
     *
     * @param a the a
     */
    void InserireAllenatore(Allenatore a);

    /**
     * Inserire dirigente.
     *
     * @param d the d
     */
    void InserireDirigente(Dirigente d);

}
