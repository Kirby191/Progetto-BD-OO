package DAO;

import Model.Giocatore;

/**
 * The interface Amministratore dao.
 */
public interface AmministratoreDAO {
    /**
     * Gets postgres dao.
     *
     * @return the postgres dao
     */
    GeneraleDAO getGeneraleDAO();

    /**
     * Elimina giocatore.
     *
     * @param SSN the ssn
     */
    void EliminaGiocatore(String SSN);

    /**
     * Ottieni giocatore giocatore.
     *
     * @param SSN the ssn
     * @return the giocatore
     */
    Giocatore OttieniGiocatore(String SSN);

    /**
     * Inserire giocatore.
     *
     * @param g the g
     */
    void InserireGiocatore(Giocatore g);
}
