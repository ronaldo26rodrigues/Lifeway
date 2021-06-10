package negocio.beans;

public class ValoresDeAte {
    private Double de;
    private Double ate;

    public ValoresDeAte(Double de, Double ate){
        this.de = de;
        this.de = ate;
    }

    /**
     * @return the ate
     */
    public Double getAte() {
        return ate;
    }
    /**
     * @return the de
     */
    public Double getDe() {
        return de;
    }
    /**
     * @param ate the ate to set
     */
    public void setAte(Double ate) {
        this.ate = ate;
    }
    /**
     * @param de the de to set
     */
    public void setDe(Double de) {
        this.de = de;
    }
    
}
