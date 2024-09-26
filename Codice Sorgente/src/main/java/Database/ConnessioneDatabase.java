package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connessione database.
 */
public class ConnessioneDatabase {
    private static ConnessioneDatabase instance;
    /**
     * The Connection.
     */
    public Connection connection = null;
    private String nome;
    private String password;
    private String url = "jdbc:postgresql://localhost:5432/calciatoridb";
    private String driver = "org.postgresql.Driver";

    private ConnessioneDatabase(int permesso) {
        try {
            switch (permesso) {
                case 1:
                    nome = "utente";
                    password = " ";
                    break;
                case 2:
                    nome = "giocatore";
                    password = "giocatore";
                    break;
                case 3:
                    nome = "amministratore";
                    password = "amministratore";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Errore di autenticazione");
            }
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.url, this.nome, this.password);
        } catch (ClassNotFoundException var2) {
            System.out.println("Database Connection Creation Failed : " + var2.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sono qui");
        }
    }

    /**
     * Gets instance.
     *
     * @param permesso the permesso
     * @return the instance
     * @throws SQLException the sql exception
     */
    public static ConnessioneDatabase getInstance(int permesso) throws SQLException {
        if(instance == null)
        {
            instance = new ConnessioneDatabase(permesso);

        } else if(instance.connection.isClosed())
        {
            instance = new ConnessioneDatabase(permesso);
        } else {
            instance.connection.close();
            instance = new ConnessioneDatabase(permesso);
        }
        return instance;
    }

}