package DAO;

import java.sql.Date;

/**
 * The interface Generale dao.
 * Interfaccia per la gestione dei metodi comuni a tutti i DAO.
 */
public interface GeneraleDAO {
    /**
     * Tabella da query.
     *
     * @param query   the query
     * @param colonne the colonne
     */
    void TabellaDaQuery(String query, String[] colonne);

    /**
     * Query is not null boolean.
     *
     * @param query the query
     * @return the boolean
     */
    boolean QueryIsNotNull(String query);

    /**
     * Controllo credenziali boolean.
     *
     * @param username the username
     * @param password the password
     * @param permesso the permesso
     * @return the boolean
     */
    public boolean ControlloCredenziali(String username, String password, int permesso);

    /**
     * Update giocatore.
     *
     * @param nome          the nome
     * @param cognome       the cognome
     * @param nazionalita   the nazionalita
     * @param dataNascita   the data nascita
     * @param sesso         the sesso
     * @param piede         the piede
     * @param altezza       the altezza
     * @param peso          the peso
     * @param ruolo         the ruolo
     * @param ritirato      the ritirato
     * @param abilita       the abilita
     * @param TipoGiocatore the tipo giocatore
     * @param SSN           the ssn
     */
    void UpdateGiocatore(String nome, String cognome, String nazionalita, Date dataNascita,
                         char sesso, char piede, float altezza, float peso,
                         String ruolo, Boolean ritirato, String abilita, char TipoGiocatore, String SSN);
}
