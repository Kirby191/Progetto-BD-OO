package ImplementazioneDAO;

import Controller.Controller;
import DAO.GeneraleDAO;
import GUI.ResultTabella;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * The type Implementazione generale dao.
 */
public class ImplementazioneGeneraleDAO implements GeneraleDAO {
    private static Connection conn;

    /**
     * Instantiates a new Implementazione generale dao.
     *
     * @param connIn the conn in
     */
    public ImplementazioneGeneraleDAO(Connection connIn) {
        conn = connIn;
    }
    public void TabellaDaQuery(String query, String[] colonne) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            ArrayList<String[]> datiList = new ArrayList<>();
            while (rs.next()) {
                String[] riga = new String[colonne.length];
                for (int i = 0; i < colonne.length; i++) {
                    riga[i] = rs.getString(colonne[i]);
                }
                datiList.add(riga);
            }

            String[][] dati = new String[datiList.size()][colonne.length];
            for (int i = 0; i < datiList.size(); i++) {
                dati[i] = datiList.get(i);
            }

            ResultTabella result = new ResultTabella(Controller.getCurrentFrame(), colonne, dati);

            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean QueryIsNotNull(String query) {
          try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    rs.close();
                    st.close();
                    return true;
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return false;
    }

    public boolean ControlloCredenziali(String username, String password, int permesso) {
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM Credenziali WHERE Username = ? AND Password = ? AND Ruolo = ?")) {
            st.setString(1, username);
            st.setString(2, password);
            switch(permesso) {
                case 2:
                    st.setString(3, "Giocatore");
                    break;
                case 3:
                    st.setString(3, "Amministratore");
                    break;
            }

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }

            if (username.isEmpty()) {
                if(password.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Inserire un username e una password");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inserire un username");
                }
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Inserire una password");
            }

            rs.close();
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public void UpdateGiocatore(String nome, String cognome, String nazionalita, Date dataNascita,
                                char sesso, char piede, float altezza, float peso,
                                String ruolo, Boolean ritirato, String abilita, char TipoGiocatore, String SSN) {
        try (PreparedStatement st = conn.prepareStatement("UPDATE Giocatore SET Nome = ?, Cognome = ?, Nazionalita = ?, Datadinascita = ?," +
                " Sesso = ?, Piede = ?, Altezza = ?, Peso = ?, Ruolo = ?, Ritirato = ?, Abilita = ?, TipoGiocatore = ? WHERE SSN = ?")) {
            st.setString(1, nome);
            st.setString(2, cognome);
            st.setString(3, nazionalita);
            st.setDate(4,  dataNascita);
            st.setString(5, String.valueOf(sesso));
            st.setString(6, String.valueOf(piede));
            st.setFloat(7, altezza);
            st.setFloat(8, peso);
            st.setString(9, ruolo);
            st.setBoolean(10, ritirato);
            st.setString(11, abilita);
            st.setString(12, String.valueOf(TipoGiocatore));
            st.setString(13, SSN);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
