package Model;

import java.util.ArrayList;
import java.sql.Date;

/**
 * The type Squadra.
 */
public class Squadra {
    private String nomeSquadra;
    private String nazionalita;
    private Date dataFondazione;

    private ArrayList<Militanza> militanze = new ArrayList<>();
    private ArrayList<Giocatore> giocatori = new ArrayList<>();
    private ArrayList<Trofeo> trofei = new ArrayList<>();
    private Allenatore allenatore;
    private ArrayList<Dirigente> dirigenti = new ArrayList<>();

    /**
     * Instantiates a new Squadra.
     *
     * @param a              the a
     * @param d              the d
     * @param nomeSquadra    the nome squadra
     * @param nazionalita    the nazionalita
     * @param dataFondazione the data fondazione
     */
    public Squadra(Allenatore a, Dirigente d, String nomeSquadra, String nazionalita, Date dataFondazione) {
            allenatore = a;
            dirigenti.add(d);
            d.setSquadraDiretta(this);
            this.nomeSquadra = nomeSquadra;
            this.nazionalita = nazionalita;
            this.dataFondazione = dataFondazione;
    }

    /**
     * Gets giocatori.
     *
     * @return the giocatori
     */
    public ArrayList<Giocatore> getGiocatori() {
        return giocatori;
    }

    /**
     * Gets militanze.
     *
     * @return the militanze
     */
    public ArrayList<Militanza> getMilitanze() {
        return militanze;
    }

    /**
     * Gets trofei.
     *
     * @return the trofei
     */
    public ArrayList<Trofeo> getTrofei() {
        return trofei;
    }

    /**
     * Set nome squadra.
     *
     * @param nomeSquadra the nome squadra
     */
    public void setNomeSquadra(String nomeSquadra){
        this.nomeSquadra = nomeSquadra;
    }

    /**
     * Set nazionalita.
     *
     * @param nazionalita the nazionalita
     */
    public void setNazionalita(String nazionalita){
        this.nazionalita = nazionalita;
    }

    /**
     * Set data fondazione.
     *
     * @param dataFondazione the data fondazione
     */
    public void setDataFondazione(Date dataFondazione){
        this.dataFondazione = dataFondazione;
    }

    /**
     * Get nome squadra string.
     *
     * @return the string
     */
    public String getNomeSquadra(){
        return nomeSquadra;
    }

    /**
     * Get nazionalita string.
     *
     * @return the string
     */
    public String getNazionalita(){
        return nazionalita;
    }

    /**
     * Get data fondazione date.
     *
     * @return the date
     */
    public Date getDataFondazione(){
        return dataFondazione;
    }

    public void setAllenatore(Allenatore a){
        allenatore = a;
    }

    public Allenatore getAllenatore(){
        return allenatore;
    }

    public void addDirigente(Dirigente d){
        dirigenti.add(d);
    }

    public ArrayList<Dirigente> getDirigenti(){
        return dirigenti;
    }

    public void addGiocatore(Giocatore g){
        giocatori.add(g);
    }

    public void addMilitanza(Militanza m){
        militanze.add(m);
    }

    public void addTrofeo(Trofeo t){
        trofei.add(t);
    }
}