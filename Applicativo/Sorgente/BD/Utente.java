package BD;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Utente {
    private JButton ricercaButton;
    private JButton indietroButton;
    private JButton elencoButton;
    private JPanel panel12;

    private JFrame frame12;


    public Utente(JFrame frameChiamante, Connection conn) {
        frame12 = new JFrame("Utente");
        frame12.setContentPane(panel12);
        frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame12.pack();
        frameChiamante.setVisible(false);
        frame12.setVisible(true);

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame12.dispose();
                frameChiamante.setVisible(true);
            }
        });
        ricercaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RicercaG ricercaG = new RicercaG(frame12, conn);
            }
        });
        elencoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Statement st = conn.createStatement();
                    StringBuilder query = new StringBuilder("SELECT * FROM giocatore WHERE 1 = 1");
                    ResultSet rs = st.executeQuery(query.toString());
                    String[] colonne = {"Nome", "Cognome", "SSN", "Nazionalità", "Data di nascita", "Sesso", "Altezza", "Peso", "Ruolo", "Ritirato", "Abilità", "Piede", "Tipo di giocatore"};
                    ArrayList<String[]> datiList = new ArrayList<>();
                    while (rs.next()) {
                        String[] riga = new String[13];
                        riga[0] = rs.getString("nome");
                        riga[1] = rs.getString("cognome");
                        riga[2] = rs.getString("ssn");
                        riga[3] = rs.getString("nazionalita");
                        riga[4] = rs.getString("datadinascita");
                        riga[5] = rs.getString("sesso");
                        riga[6] = rs.getString("altezza");
                        riga[7] = rs.getString("peso");
                        riga[8] = rs.getString("ruolo");
                        riga[9] = rs.getString("ritirato");
                        riga[10] = rs.getString("abilita");
                        riga[11] = rs.getString("piede");
                        riga[12] = rs.getString("tipogiocatore");

                        datiList.add(riga);
                    }
                    String[][] dati = new String[datiList.size()][13];
                    for (int i = 0; i < datiList.size(); i++) {
                        dati[i] = datiList.get(i);
                    }
                    ResultTabella result = new ResultTabella(frame12, colonne, dati);
                    rs.close();
                    st.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame12, ex.getMessage());
                }

            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel12 = new JPanel();
        panel12.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        elencoButton = new JButton();
        elencoButton.setText("Elenco");
        panel12.add(elencoButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        indietroButton = new JButton();
        indietroButton.setText("Indietro");
        panel12.add(indietroButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 3, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel12.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel12.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        ricercaButton = new JButton();
        ricercaButton.setText("Ricerca");
        panel12.add(ricercaButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel12.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel12.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel12;
    }
}
