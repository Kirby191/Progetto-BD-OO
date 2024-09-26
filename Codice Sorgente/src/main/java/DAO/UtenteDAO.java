package DAO;
import java.sql.Date;

/**
 * The interface Utente dao.
 */
public interface UtenteDAO {
    /**
     * Car fisiche ricerca giocatore.
     *
     * @param nome          the nome
     * @param cognome       the cognome
     * @param dataNascita   the data nascita
     * @param piede         the piede
     * @param ruolo         the ruolo
     * @param sesso         the sesso
     * @param ordineNascite the ordine nascite
     */
    void CarFisicheRicercaGiocatore(String nome, String cognome, Date dataNascita, String piede, String ruolo, String sesso, String ordineNascite);

    /**
     * Gets postgres dao.
     *
     * @return the postgres dao
     */
    GeneraleDAO getGeneraleDAO();
}
