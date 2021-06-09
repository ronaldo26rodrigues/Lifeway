package negocio.beans;

import java.util.Set;

public abstract class Identificável {
    private String id;

    public Identificável(String id){
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
}
