package Model;
import java.util.Date;

/**
 * The type Militanza.
 */
public class Militanza {
    private Date dataInizio;
    private Date dataFine;
    private int partiteGiocate;
    private int golSegnati;
    private int cartelliniGialli;
    private int cartelliniRossi;
    private int assist;

    private Giocatore proprietario;
    private Squadra squadra;

    /**
     * Instantiates a new Militanza.
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
     */
    public Militanza(Giocatore g, Squadra s, Date dataInizio, Date dataFine, int partiteGiocate,
                     int goalSegnati, int cartelliniGialli, int cartelliniRossi, int assist) {
        proprietario = g;
        squadra = s;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.partiteGiocate = partiteGiocate;
        this.golSegnati = goalSegnati;
        this.cartelliniGialli = cartelliniGialli;
        this.cartelliniRossi = cartelliniRossi;
        this.assist = assist;

        s.getMilitanze().add(this);
        g.getStorico_militanze().add(this);
        g.getStorico_squadre().add(squadra);
    }

    /**
     * Gets squadra.
     *
     * @return the squadra
     */
    public Squadra getSquadra() {
        return squadra;
    }

    /**
     * Gets proprietario.
     *
     * @return the proprietario
     */
    public Giocatore getProprietario() {
        return proprietario;
    }

    /**
     * Sets proprietario.
     *
     * @param g the g
     */
    public void setProprietario(Giocatore g) {
        proprietario = g;
    }

    /**
     * Set data inizio.
     *
     * @param dataInizio the data inizio
     */
    public void setDataInizio(Date dataInizio){
        this.dataInizio = dataInizio;
    }

    /**
     * Set data fine.
     *
     * @param dataFine the data fine
     */
    public void setDataFine(Date dataFine){
        this.dataFine = dataFine;
    }

    /**
     * Set partite giocate.
     *
     * @param partiteGiocate the partite giocate
     */
    public void setPartiteGiocate(int partiteGiocate){
        this.partiteGiocate = partiteGiocate;
    }

    /**
     * Set gol segnati.
     *
     * @param golSegnati the gol segnati
     */
    public void setGolSegnati(int golSegnati){
        this.golSegnati = golSegnati;
    }

    /**
     * Set cartellini gialli.
     *
     * @param cartelliniGialli the cartellini gialli
     */
    public void setCartelliniGialli(int cartelliniGialli){
        this.cartelliniGialli = cartelliniGialli;
    }

    /**
     * Set cartellini rossi.
     *
     * @param cartelliniRossi the cartellini rossi
     */
    public void setCartelliniRossi(int cartelliniRossi){
        this.cartelliniRossi = cartelliniRossi;
    }

    /**
     * Set assist.
     *
     * @param assist the assist
     */
    public void setAssist(int assist){
        this.assist = assist;
    }

    /**
     * Get data inizio date.
     *
     * @return the date
     */
    public Date getDataInizio(){
        return dataInizio;
    }

    /**
     * Get data fine date.
     *
     * @return the date
     */
    public Date getDataFine(){
        return dataFine;
    }

    /**
     * Get partite giocate int.
     *
     * @return the int
     */
    public int getPartiteGiocate(){
        return partiteGiocate;
    }

    /**
     * Get gol segnati int.
     *
     * @return the int
     */
    public int getGolSegnati(){
        return golSegnati;
    }

    /**
     * Get cartellini gialli int.
     *
     * @return the int
     */
    public int getCartelliniGialli(){
        return cartelliniGialli;
    }

    /**
     * Get cartellini rossi int.
     *
     * @return the int
     */
    public int getCartelliniRossi(){
        return cartelliniRossi;
    }

    /**
     * Get assist int.
     *
     * @return the int
     */
    public int getAssist(){
        return assist;
    }
}
