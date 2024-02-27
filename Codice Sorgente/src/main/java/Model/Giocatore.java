package Model;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type Giocatore.
 */
public class Giocatore {
    private String nome;
    private String cognome;
    private String SSN;
    private String nazionalita;
    private Date dataNascita;
    private char sesso;
    private char piede;
    private float altezza;
    private float peso;
    private String ruolo;
    private boolean ritirato;
    private String abilita;

    private char tipoGiocatore;
    private ArrayList<Militanza> storico_militanze = new ArrayList<>();
    private ArrayList <Squadra> storico_squadre = new ArrayList<>();
    private ArrayList <Trofeo> trofei_vinti = new ArrayList<>();
    private Allenatore allenatore;
    private Dirigente dirigente;

    /**
     * Instantiates a new Giocatore.
     *
     * @param nome          the nome
     * @param cognome       the cognome
     * @param SSN           the ssn
     * @param nazionalita   the nazionalita
     * @param dataNascita   the data nascita
     * @param sesso         the sesso
     * @param piede         the piede
     * @param altezza       the altezza
     * @param peso          the peso
     * @param ruolo         the ruolo
     * @param ritirato      the ritirato
     * @param abilita       the abilita
     * @param tipoGiocatore the tipo giocatore
     */
    public Giocatore(String nome, String cognome, String SSN, String nazionalita, Date dataNascita,
                     char sesso, char piede, float altezza, float peso, String ruolo, Boolean ritirato, String abilita, char tipoGiocatore) {
        this.nome = nome;
        this.cognome = cognome;
        this.SSN = SSN;
        this.nazionalita = nazionalita;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.piede = piede;
        this.altezza = altezza;
        this.peso = peso;
        this.ruolo = ruolo;
        this.ritirato = ritirato;
        this.abilita = abilita;
        this.tipoGiocatore = tipoGiocatore;
    }

    /**
     * Ex giocatore a.
     *
     * @param a the a
     */
    public void ExGiocatoreA(Allenatore a) {
        // Giocatore deve essere ritirato
        allenatore = a;
        a.setExgiocatore(this);
    }

    /**
     * Ex giocatore d.
     *
     * @param d the d
     */
    public void ExGiocatoreD(Dirigente d) {
        // Giocatore deve essere ritirato
        dirigente = d;
        d.setGiocatore(this);
    }

    /**
     * Add trofeo.
     *
     * @param t the t
     */
    public void addTrofeo(Trofeo t) {
        trofei_vinti.add(t);
    }

    /**
     * Add squadra.
     *
     * @param s the s
     */
    public void addSquadra(Squadra s) {
        storico_squadre.add(s);
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Sets ssn.
     *
     * @param SSN the ssn
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     * Sets nazionalita.
     *
     * @param nazionalita the nazionalita
     */
    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    /**
     * Sets data nascita.
     *
     * @param dataNascita the data nascita
     */
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * Sets piede.
     *
     * @param piede the piede
     */
    public void setPiede(char piede) {
        this.piede = piede;
    }

    /**
     * Sets altezza.
     *
     * @param altezza the altezza
     */
    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    /**
     * Sets peso.
     *
     * @param peso the peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Sets ruolo.
     *
     * @param ruolo the ruolo
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * Sets sesso.
     *
     * @param sesso the sesso
     */
    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    /**
     * Sets ritirato.
     *
     * @param ritirato the ritirato
     */
    public void setRitirato(boolean ritirato) {
        this.ritirato = ritirato;
    }

    /**
     * Sets abilita.
     *
     * @param abilita the abilita
     */
    public void setAbilita(String abilita) {
        this.abilita = abilita;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Gets ssn.
     *
     * @return the ssn
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * Gets nazionalita.
     *
     * @return the nazionalita
     */
    public String getNazionalita() {
        return nazionalita;
    }

    /**
     * Gets data nascita.
     *
     * @return the data nascita
     */
    public Date getDataNascita() {
        return dataNascita;
    }

    /**
     * Gets piede.
     *
     * @return the piede
     */
    public char getPiede() {
        return piede;
    }

    /**
     * Gets altezza.
     *
     * @return the altezza
     */
    public float getAltezza() {
        return altezza;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Gets ruolo.
     *
     * @return the ruolo
     */
    public String getRuolo() {
        return ruolo;
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
     * Is ritirato boolean.
     *
     * @return the boolean
     */
    public boolean isRitirato() {
        return ritirato;
    }

    /**
     * Gets abilita.
     *
     * @return the abilita
     */
    public String getAbilita() {
        return abilita;
    }

    /**
     * Gets tipo giocatore.
     *
     * @return the tipo giocatore
     */
    public char getTipoGiocatore() {
        return tipoGiocatore;
    }

    /**
     * Sets tipo giocatore.
     *
     * @param tipoGiocatore the tipo giocatore
     */
    public void setTipoGiocatore(char tipoGiocatore) {
        this.tipoGiocatore = tipoGiocatore;
    }

    /**
     * Gets allenatore.
     *
     * @return the allenatore
     */
    public Allenatore getAllenatore() {
        return allenatore;
    }

    /**
     * Gets dirigente.
     *
     * @return the dirigente
     */
    public Dirigente getDirigente() {
        return dirigente;
    }

    /**
     * Gets trofei vinti.
     *
     * @return the trofei vinti
     */
    public ArrayList<Trofeo> getTrofei_vinti() {
        return trofei_vinti;
    }

    /**
     * Gets storico squadre.
     *
     * @return the storico squadre
     */
    public ArrayList<Squadra> getStorico_squadre() {
        return storico_squadre;
    }

    /**
     * Gets storico militanze.
     *
     * @return the storico militanze
     */
    public ArrayList<Militanza> getStorico_militanze() {
        return storico_militanze;
    }

    /**
     * Aggiunti militanza.
     *
     * @param m the m
     */
    public void aggiungiMilitanza(Militanza m) {
        storico_militanze.add(m);
    }
}