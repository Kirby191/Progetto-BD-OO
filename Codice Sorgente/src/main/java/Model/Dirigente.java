package Model;
import java.util.ArrayList;
import java.sql.Date;

/**
 * The type Dirigente.
 */
public class Dirigente {
    private String nome;
    private String cognome;
    private char sesso;
    private String SSN;
    private Date inizioD;
    private Date fineD;
    private String ruoloDirigente;
    private Giocatore giocatore;
    private ArrayList<Squadra> squadreDirette = new ArrayList<>();

    /**
     * Instantiates a new Dirigente.
     *
     * @param s       the s
     * @param nome    the nome
     * @param cognome the cognome
     * @param sesso   the sesso
     * @param SSN     the ssn
     * @param inizioD the inizio d
     * @param fineD   the fine d
     */
    public Dirigente(Squadra s, String nome, String cognome, char sesso, String SSN, Date inizioD, Date fineD) {
        squadreDirette.add(s);
        s.addDirigente(this);
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.SSN = SSN;
        this.inizioD = inizioD;
        this.fineD = fineD;
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
        this.inizioD = inizioA;
    }

    /**
     * Set fine a.
     *
     * @param fineA the fine a
     */
    public void setFineA(Date fineA){
        this.fineD = fineA;
    }

    /**
     * Set ruolo dirigente.
     *
     * @param ruoloDirigente the ruolo dirigente
     */
    public void setRuoloDirigente(String ruoloDirigente){
        this.ruoloDirigente = ruoloDirigente;
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
     * Get inizio d date.
     *
     * @return the date
     */
    public Date getInizioD(){
        return inizioD;
    }

    /**
     * Get fine d date.
     *
     * @return the date
     */
    public Date getFineD(){
        return fineD;
    }

    /**
     * Get ruolo dirigente string.
     *
     * @return the string
     */
    public String getRuoloDirigente(){
        return ruoloDirigente;
    }

    /**
     * Set giocatore.
     *
     * @param g the g
     */
    public void setGiocatore(Giocatore g){
        giocatore = g;
    }

    /**
     * Get giocatore giocatore.
     *
     * @return the giocatore
     */
    public Giocatore getGiocatore(){
        return giocatore;
    }

    public void setSquadraDiretta(Squadra s){
        squadreDirette.add(s);
    }
}