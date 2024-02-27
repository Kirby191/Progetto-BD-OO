package Model;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type Trofeo.
 */
public class Trofeo {
    private String nomeTrofeo;
    private Date annoTrofeo;
    private boolean isSquadra;
    private ArrayList<Giocatore> giocatori = new ArrayList<>();
    private Squadra squadra;

    /**
     * Instantiates a new Trofeo.
     *
     * @param nomeTrofeo the nome trofeo
     * @param annoTrofeo the anno trofeo
     * @param isSquadra  the is squadra
     */
    public Trofeo(String nomeTrofeo, Date annoTrofeo, boolean isSquadra) {
        this.nomeTrofeo = nomeTrofeo;
        this.annoTrofeo = annoTrofeo;
        this.isSquadra = isSquadra;
    }

    /**
     * Sets vincita trofeo.
     *
     * @param g the g
     */
    public void setVincitaTrofeo(Giocatore g) {
        if(isSquadra)
            return;
        giocatori.add(g);
        g.getTrofei_vinti().add(this);
    }

    /**
     * Sets vincita trofeo.
     *
     * @param s the s
     */
    public void setVincitaTrofeo(Squadra s) {
        if(!isSquadra)
            return;
        squadra = s;
        s.getTrofei().add(this);
    }

    /**
     * Set nome trofeo.
     *
     * @param nomeTrofeo the nome trofeo
     */
    public void setNomeTrofeo(String nomeTrofeo){
        this.nomeTrofeo = nomeTrofeo;
    }

    /**
     * Set anno trofeo.
     *
     * @param annoTrofeo the anno trofeo
     */
    public void setAnnoTrofeo(Date annoTrofeo){
        this.annoTrofeo = annoTrofeo;
    }

    /**
     * Set is squadra.
     *
     * @param isSquadra the is squadra
     */
    public void setIsSquadra(Boolean isSquadra){
        this.isSquadra = isSquadra;
    }

    /**
     * Get nome trofeo string.
     *
     * @return the string
     */
    public String getNomeTrofeo(){
        return nomeTrofeo;
    }

    /**
     * Gets anno trofeo.
     *
     * @return the anno trofeo
     */
    public Date getAnnoTrofeo() {
        return annoTrofeo;
    }

    /**
     * Is squadra boolean.
     *
     * @return the boolean
     */
    public boolean isSquadra() {
        return isSquadra;
    }
}
