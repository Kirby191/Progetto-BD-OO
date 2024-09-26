package Model;

import java.util.Date;

/**
 * The type Militanza portiere.
 */
public class MilitanzaPortiere extends Militanza{
    private int goalSubiti = 0;

    /**
     * Instantiates a new Militanza portiere.
     *
     * @param g                the g
     * @param s                the s
     * @param dataInizio       the data inizio
     * @param dataFine         the data fine
     * @param partiteGiocate   the partite giocate
     * @param goalSegnati      the goal segnati
     * @param cartelliniGialli the cartellini gialli
     * @param cartelliniRossi  the cartellini rossi
     * @param assist           the assist
     * @param goalSubiti       the goal subiti
     */
    public MilitanzaPortiere(Giocatore g, Squadra s, Date dataInizio, Date dataFine,
                             int partiteGiocate, int goalSegnati, int cartelliniGialli,
                             int cartelliniRossi, int assist, int goalSubiti) {
        super(g, s, dataInizio, dataFine, partiteGiocate, goalSegnati, cartelliniGialli, cartelliniRossi, assist);
        this.goalSubiti = goalSubiti;
    }

    /**
     * Set goal subiti.
     *
     * @param goalSubiti the goal subiti
     */
    public void setGoalSubiti(int goalSubiti){
        this.goalSubiti = goalSubiti;
    }

    /**
     * Get goal subiti int.
     *
     * @return the int
     */
    public int getGoalSubiti(){
        return goalSubiti;
    }
}
