package negocio.beans;

public class ValoresDeAte {

    private Double de;
    private Double ate;

    public ValoresDeAte(Double de, Double ate) {
        this.de = de;
        this.de = ate;
    }

    public Double getAte() {
        return ate;
    }

    public Double getDe() {
        return de;
    }

    public void setAte(Double ate) {
        this.ate = ate;
    }

    public void setDe(Double de) {
        this.de = de;
    }

}
