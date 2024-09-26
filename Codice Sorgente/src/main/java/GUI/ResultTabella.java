package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Result tabella.
 */
public class ResultTabella {
    private JTable table1;
    private JButton indietroButton;

    private JFrame frame22;

    /**
     * Instantiates a new Result tabella.
     *
     * @param frameChiamante the frame chiamante
     * @param colonne        the colonne
     * @param dati           the dati
     */
    public ResultTabella(JFrame frameChiamante, String[] colonne, String[][] dati) {
        frame22 = new JFrame("Risultati");
        frame22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table1 = new JTable(dati, colonne);
        table1.setFillsViewportHeight(true);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);
        table1.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table1);
        frame22.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame22.getContentPane().add(indietroButton, BorderLayout.SOUTH);

        frame22.setSize(1269, 350);
        frameChiamante.setVisible(false);
        frame22.setVisible(true);
        indietroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame22.dispose();
                frameChiamante.setVisible(true);
            }
        });
    }


}
