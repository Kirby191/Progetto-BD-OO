package ImplementazioneDAO;

import DAO.AmministratoreDAO;
import DAO.GeneraleDAO;
import Database.ConnessioneDatabase;
import Model.Giocatore;

import javax.swing.*;
import java.sql.*;

/**
 * The type Imp dao amministratore.
 */
public class ImpDAOAmministratore implements AmministratoreDAO {
    private static Connection conn;

    /**
     * Instantiates a new Imp dao amministratore.
     */
    public ImpDAOAmministratore() {
        try {
            conn = ConnessioneDatabase.getInstance(3).connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public GeneraleDAO getGeneraleDAO() {
        try {
            return new ImplementazioneGeneraleDAO(ConnessioneDatabase.getInstance(3).connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public void EliminaGiocatore(String SSN) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM Giocatore WHERE SSN = ?");
            st.setString(1, SSN);
            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Giocatore OttieniGiocatore(String SSN) {
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery("SELECT * FROM Giocatore WHERE SSN = " + "'" + SSN + "'")) {
                    if (rs.next()) {
                        return new Giocatore(rs.getString("Nome"), rs.getString("Cognome"), rs.getString("SSN"),
                                rs.getString("Nazionalita"), rs.getDate("Datadinascita"), rs.getString("Sesso").charAt(0),
                                rs.getString("Piede").charAt(0), rs.getFloat("Altezza"), rs.getFloat("Peso"),
                                rs.getString("Ruolo"), rs.getBoolean("Ritirato"), rs.getString("Abilita"), rs.getString("TipoGiocatore").charAt(0));
                    }
                } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return null;
        }

    public void InserireGiocatore(Giocatore g) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO giocatore VALUES " +
                    "('" +
                    g.getNome() + "', '" +
                    g.getCognome() + "', '" +
                    g.getSSN() + "', '" +
                    g.getNazionalita() + "', '" +
                    g.getDataNascita() + "', '" +
                    g.getSesso() + "', '" +
                    g.getPiede() + "', " +
                    g.getAltezza() + ", " +
                    g.getPeso() + ", '" +
                    g.getRuolo() + "', " +
                    g.isRitirato() + ", '" +
                    g.getAbilita() + "', '" +
                    g.getTipoGiocatore() + "')");
        } catch (SQLException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new RuntimeException(e);
        }
    }

}