package ImplementazioneDAO;

import DAO.GiocatoreDAO;
import DAO.GeneraleDAO;
import Database.ConnessioneDatabase;
import Model.Allenatore;
import Model.Dirigente;
import Model.Giocatore;

import javax.swing.*;
import java.sql.*;

/**
 * The type Imp dao giocatori.
 */
public class ImpDAOGiocatori implements GiocatoreDAO{
    private Connection conn;

    /**
     * Instantiates a new Imp dao giocatori.
     */
    public ImpDAOGiocatori() {
        try {
            conn = ConnessioneDatabase.getInstance(2).connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void RegistrazioneGiocatore(String SSN, String username, String password) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO Credenziali VALUES(?, ?, ?, ?)")) {
            Statement st2 = conn.createStatement();
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, "Giocatore");
            st.setString(4, SSN);
            ResultSet rs = st2.executeQuery("SELECT * FROM Credenziali WHERE SSN = " + "'" + SSN + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "L'utente è già registrato!");
            } else {
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo");
            }
            rs.close();
            st2.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean ControlloSSNEsistente(String SSNGiocatore) {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Giocatore WHERE SSN = " + "'" + SSNGiocatore + "'")) {
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    public Giocatore getGiocatoreFromUsername(String username) {
        try(PreparedStatement st = conn.prepareStatement("SELECT * FROM Credenziali WHERE Username = ?")) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String SSN = rs.getString("SSN");
                try (Statement st2 = conn.createStatement();
                     ResultSet rs2 = st2.executeQuery("SELECT * FROM Giocatore WHERE SSN = " + "'" + SSN + "'")) {
                    if (rs2.next()) {
                        return new Giocatore(rs2.getString("Nome"), rs2.getString("Cognome"), rs2.getString("SSN"),
                                rs2.getString("Nazionalita"), rs2.getDate("Datadinascita"), rs2.getString("Sesso").charAt(0),
                                rs2.getString("Piede").charAt(0), rs2.getFloat("Altezza"), rs2.getFloat("Peso"),
                                rs2.getString("Ruolo"), rs2.getBoolean("Ritirato"), rs2.getString("Abilita"), rs2.getString("TipoGiocatore").charAt(0));
                    }
                }
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public GeneraleDAO getGeneraleDAO() {
        try {
            return new ImplementazioneGeneraleDAO(ConnessioneDatabase.getInstance(2).connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public void InserireAllenatore(Allenatore a)
    {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO allenatore VALUES " +
                    "('" +
                    a.getNome() + "', '" +
                    a.getCognome() + "', '" +
                    a.getSesso() + "', '" +
                    a.getSSN() + "', '" +
                    (a.getInizioA() != null ? a.getInizioA() + "'" : "NULL") + ", " +
                    (a.getFineA() != null ? "'" + a.getFineA() + "'" : "NULL") + ")");

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void InserireDirigente(Dirigente d)
    {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO dirigente VALUES " +
                    "('" +
                    d.getNome() + "', '" +
                    d.getCognome() + "', '" +
                    d.getSesso() + "', '" +
                    d.getSSN() + "', " +
                    "NULL" + ", " +
                    (d.getInizioD() != null ? "'" + d.getInizioD() + "'" : "NULL") + ", " +
                    (d.getFineD() != null ? "'" + d.getFineD() + "'" : "NULL") + ")");

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
