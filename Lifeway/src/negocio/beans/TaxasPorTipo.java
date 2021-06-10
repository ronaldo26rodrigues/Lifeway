package negocio.beans;

import java.util.Map;
import java.util.Map.Entry;

public class TaxasPorTipo {
    
    private TipoConsumidor tipo;
    private double fixa;
    private Map<ValoresDeAte, Double>  adicional;

    public TaxasPorTipo(TipoConsumidor tipo){
        this.tipo = tipo;
    }

    public TaxasPorTipo(TipoConsumidor tipo, double valorFixo){
        this.tipo = tipo;
        this.fixa = valorFixo;
    }

    /**
     * @return the adicional
     */
    public Map<ValoresDeAte, Double> getAdicional() {
        return adicional;
    }
    /**
     * @return the fixa
     */
    public double getFixa() {
        return fixa;
    }
    /**
     * @return the tipo
     */
    public TipoConsumidor getTipo() {
        return tipo;
    }

    /**
     * @param adicional the adicional to set
     */
    public void setAdicional(Map<ValoresDeAte, Double> adicional) {
        this.adicional = adicional;
    }
    /**
     * @param fixa the fixa to set
     */
    public void setFixa(double fixa) {
        this.fixa = fixa;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoConsumidor tipo) {
        this.tipo = tipo;
    }

    public void adicionarAdicional(double de, double ate, double valor){
        adicional.put(new ValoresDeAte(de, ate) , valor);
    }
    
    
}

