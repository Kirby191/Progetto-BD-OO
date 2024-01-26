package BD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class Ricerca {
    protected JTextField nomeTextField;
    protected JTextField cognomeTextField;
    protected JTextField SSNTextField;
    protected JButton cercaButton;

    protected JButton indietroButton;
    private JPanel panel10;
    private JFrame frame10;

    public Ricerca(JFrame frameChiamante, Connection conn) {
        frame10 = new JFrame("Ricerca");
        frame10.setContentPane(panel10);
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame10.pack();
        frameChiamante.setVisible(false);
        frame10.setVisible(true);

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame10.dispose();
                frameChiamante.setVisible(true);
            }
        });

        cercaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Statement st = conn.createStatement();
                    // Inizializza la query di base
                    StringBuilder query = new StringBuilder("SELECT * FROM giocatore WHERE 1 = 1");

                    // Aggiungi le clausole WHERE solo per i parametri non nulli o non vuoti
                    if (!nomeTextField.getText().isEmpty()) {
                        query.append(" AND nome = '").append(nomeTextField.getText()).append("'");
                    }

                    if (!cognomeTextField.getText().isEmpty()) {
                        query.append(" AND cognome = '").append(cognomeTextField.getText()).append("'");
                    }

                    if (!SSNTextField.getText().isEmpty()) {
                        query.append(" AND ssn = '").append(SSNTextField.getText()).append("'");
                    }
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
                    ResultTabella result = new ResultTabella(frame10, colonne, dati);
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame10, ex.getMessage());
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
        panel10 = new JPanel();
        panel10.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel10.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cognomeTextField = new JTextField();
        panel10.add(cognomeTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        SSNTextField = new JTextField();
        panel10.add(SSNTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Nome");
        panel10.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Cognome");
        panel10.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("SSN");
        panel10.add(label3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nomeTextField = new JTextField();
        panel10.add(nomeTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cercaButton = new JButton();
        cercaButton.setText("Cerca");
        panel10.add(cercaButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        indietroButton = new JButton();
        indietroButton.setText("Indietro");
        panel10.add(indietroButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label1.setLabelFor(nomeTextField);
        label2.setLabelFor(cognomeTextField);
        label3.setLabelFor(SSNTextField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel10;
    }
}