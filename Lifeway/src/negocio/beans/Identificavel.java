package negocio.beans;


public abstract class Identificavel {
    private String id;

    public Identificavel(String id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public abstract boolean validar();

    @Override
    public String toString() {
        return "ID: " +  this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Identificavel) obj).getId());
    }
}
