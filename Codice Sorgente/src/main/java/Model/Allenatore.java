package Model;
import java.util.ArrayList;
import java.sql.Date;

/**
 * The type Allenatore.
 */
public class Allenatore {
    private String nome;
    private String cognome;
    private char sesso;
    private String SSN;
    private Date inizioA;
    private Date fineA;
    private Giocatore Exgiocatore;
    private ArrayList<Squadra> squadreAllenate = new ArrayList<>();

    /**
     * Instantiates a new Allenatore.
     *
     * @param nome    the nome
     * @param cognome the cognome
     * @param sesso   the sesso
     * @param SSN     the ssn
     * @param inizioA the inizio a
     * @param fineA   the fine a
     * @param s       the s
     */
    public Allenatore(String nome, String cognome, char sesso, String SSN, Date inizioA, Date fineA, Squadra s) {
        squadreAllenate.add(s);
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.SSN = SSN;
        this.inizioA = inizioA;
        this.fineA = fineA;
    }

    /**
     * Get giocatore giocatore.
     *
     * @return the giocatore
     */
    public Giocatore getExgiocatore(){
        return Exgiocatore;
    }

    /**
     * Set giocatore.
     *
     * @param g the g
     */
    public void setExgiocatore(Giocatore g){
        Exgiocatore = g;
    }

    /**
     * Set nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Set cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    /**
     * Set sesso.
     *
     * @param sesso the sesso
     */
    public void setSesso(char sesso){
        this.sesso = sesso;
    }

    /**
     * Set ssn.
     *
     * @param SSN the ssn
     */
    public void setSSN(String SSN){
        this.SSN = SSN;
    }

    /**
     * Set inizio a.
     *
     * @param inizioA the inizio a
     */
    public void setInizioA(Date inizioA){
        this.inizioA = inizioA;
    }

    /**
     * Set fine a.
     *
     * @param fineA the fine a
     */
    public void setFineA(Date fineA){
        this.fineA = fineA;
    }

    /**
     * Get nome string.
     *
     * @return the string
     */
    public String getNome(){
        return nome;
    }

    /**
     * Get cognome string.
     *
     * @return the string
     */
    public String getCognome(){
        return cognome;
    }

    /**
     * Gets sesso.
     *
     * @return the sesso
     */
    public char getSesso() {
        return sesso;
    }

    /**
     * Get ssn string.
     *
     * @return the string
     */
    public String getSSN(){
        return SSN;
    }

    /**
     * Get inizio a date.
     *
     * @return the date
     */
    public Date getInizioA(){
        return inizioA;
    }

    /**
     * Get fine a date.
     *
     * @return the date
     */
    public Date getFineA(){
        return fineA;
    }

    /**
     * Gets squadre allenate.
     *
     * @return the squadre allenate
     */

    public ArrayList<Squadra> getSquadreAllenate() {
        return squadreAllenate;
    }

    /**
     * Add squadre allenate.
     *
     * @param s the s
     */

    public void addSquadreAllenate(Squadra s) {
        squadreAllenate.add(s);
    }
}