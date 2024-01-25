package BD.CaratteristicheF;

import BD.ResultTabella;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class RicercaFiltrata {

    private JPanel panel10;
    private JTextField cognomeTextField;
    private JTextField nomeTextField;
    private JButton cercaButton;
    private JButton indietroButton;
    private JComboBox piediniAnimeComboBox;
    private JComboBox ruoloSessoComboBox;
    private JComboBox sessoSessoComboBox;
    private JComboBox etàComboBox;
    private JTextField AnnoNascitaTextField;

    private JFrame frame15;

    public RicercaFiltrata(JFrame frameChiamante, Connection conn) {
        frame15 = new JFrame("Ricerca");
        frame15.setContentPane(panel10);
        frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame15.pack();
        frame15.setVisible(true);
        frameChiamante.setVisible(false);
        sessoSessoComboBox.addItem("");
        sessoSessoComboBox.addItem("M");
        sessoSessoComboBox.addItem("F");

        piediniAnimeComboBox.addItem("");
        piediniAnimeComboBox.addItem("D");
        piediniAnimeComboBox.addItem("S");

        etàComboBox.addItem("");
        etàComboBox.addItem("Crescente");
        etàComboBox.addItem("Decrescente");

        String[] ruoli = {"", "Portiere", "DifensoreCentrale", "TerzinoSinistro", "TerzinoDestro", "CentrocampistaDifensivo", "CentrocampistaCentrale", "EsternoSinistro", "EsternoDestro", "CentrocampistaOffensivo", "AlaSinistra", "AlaDestra", "Trequartista", "Punta"};
        for (String ruolo : ruoli) {
            ruoloSessoComboBox.addItem(ruolo);
        }

        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame15.dispose();
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

                    if (!piediniAnimeComboBox.getSelectedItem().toString().isEmpty()) {
                        query.append(" AND piede = '").append(piediniAnimeComboBox.getSelectedItem().toString()).append("'");
                    }

                    if (!ruoloSessoComboBox.getSelectedItem().toString().isEmpty()) {
                        query.append(" AND ruolo = '").append(ruoloSessoComboBox.getSelectedItem().toString()).append("'");
                    }

                    if (!sessoSessoComboBox.getSelectedItem().toString().isEmpty()) {
                        query.append(" AND sesso = '").append(sessoSessoComboBox.getSelectedItem().toString()).append("'");
                    }
                    if (!AnnoNascitaTextField.getText().isEmpty()) {
                        query.append(" AND EXTRACT(YEAR FROM datadinascita) = ").append(AnnoNascitaTextField.getText());
                    }
                    if (!etàComboBox.getSelectedItem().toString().isEmpty()) {
                        if (etàComboBox.getSelectedItem().toString().equals("Crescente")) {
                            query.append(" ORDER BY datadinascita ASC");
                        } else {
                            query.append(" ORDER BY datadinascita DESC");
                        }
                    }
                    if (query.toString().equals("SELECT * FROM giocatore WHERE 1 = 1")) {
                        JOptionPane.showMessageDialog(frame15, "Inserire almeno un parametro di ricerca");
                    } else {
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
                        ResultTabella result = new ResultTabella(frame15, colonne, dati);
                        rs.close();
                    }
                    st.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame15, ex.getMessage());
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel10 = new JPanel();
        panel10.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel10, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel10.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Nome");
        panel10.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Cognome");
        panel10.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nomeTextField = new JTextField();
        panel10.add(nomeTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cercaButton = new JButton();
        cercaButton.setText("Cerca");
        panel10.add(cercaButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        indietroButton = new JButton();
        indietroButton.setText("Indietro");
        panel10.add(indietroButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cognomeTextField = new JTextField();
        panel10.add(cognomeTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        piediniAnimeComboBox = new JComboBox();
        panel10.add(piediniAnimeComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Piede");
        panel10.add(label3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ruoloSessoComboBox = new JComboBox();
        panel10.add(ruoloSessoComboBox, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Ruolo");
        panel10.add(label4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sessoSessoComboBox = new JComboBox();
        panel10.add(sessoSessoComboBox, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Sesso");
        panel10.add(label5, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        etàComboBox = new JComboBox();
        panel10.add(etàComboBox, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Età");
        panel10.add(label6, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AnnoNascitaTextField = new JTextField();
        panel10.add(AnnoNascitaTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("AnnoNascita");
        panel10.add(label7, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        label1.setLabelFor(nomeTextField);
        label2.setLabelFor(cognomeTextField);
        label3.setLabelFor(piediniAnimeComboBox);
        label4.setLabelFor(ruoloSessoComboBox);
        label5.setLabelFor(sessoSessoComboBox);
        label6.setLabelFor(etàComboBox);
    }
}
