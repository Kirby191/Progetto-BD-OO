package ImplementazioneDAO;
import DAO.GeneraleDAO;
import DAO.UtenteDAO;
import Database.ConnessioneDatabase;

import javax.swing.*;
import java.sql.*;

/**
 * The type Imp dao utente.
 */
public class ImpDAOUtente implements UtenteDAO {
    private Connection conn;

    /**
     * Instantiates a new Imp dao utente.
     */
    public ImpDAOUtente() {
        try {
            conn = ConnessioneDatabase.getInstance(1).connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void CarFisicheRicercaGiocatore(String nome, String cognome, Date dataNascita, String piede, String ruolo, String sesso, String ordineNascite)
    {
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM giocatore WHERE 1 = 1");

            // Aggiungi le clausole WHERE solo per i parametri non nulli o non vuoti
            if (!nome.isEmpty()) {
                query.append(" AND nome = '").append(nome).append("'");
            }

            if (!cognome.isEmpty()) {
                query.append(" AND cognome = '").append(cognome).append("'");
            }

            if (!(piede.equals(" "))) {
                query.append(" AND piede = '").append(piede).append("'");
            }

            if (!ruolo.equals(" ")) {
                query.append(" AND ruolo = '").append(ruolo).append("'");
            }

            if (!sesso.equals(" ")) {
                query.append(" AND sesso = '").append(sesso).append("'");
            }
            if (!(dataNascita == null)) {
                query.append(" AND EXTRACT(YEAR FROM datadinascita) = ").append(dataNascita);
            }
            if (!ordineNascite.equals(" ")) {
                query.append(" ORDER BY datadinascita ").append(ordineNascite);
            }
            if (query.toString().equals("SELECT * FROM giocatore WHERE 1 = 1")) {
                JOptionPane.showMessageDialog(null, "Inserire almeno un parametro di ricerca");
            } else {
                String[] colonne = {"Nome", "Cognome", "SSN", "Nazionalita", "DataDiNascita", "Sesso", "Altezza", "Peso", "Ruolo", "Ritirato", "Abilita", "Piede", "TipoGiocatore"};
                getGeneraleDAO().TabellaDaQuery(query.toString(), colonne);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public GeneraleDAO getGeneraleDAO() {
        try {
            return new ImplementazioneGeneraleDAO(ConnessioneDatabase.getInstance(1).connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
