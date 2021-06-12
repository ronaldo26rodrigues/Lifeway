package negocio.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TaxasPorTipo {
    
    private TipoPropriedade tipo;
    private TaxaFixa fixa;
    private Map<ValoresDeAte, Double>  adicional;

    public TaxasPorTipo(TipoPropriedade tipo){
        this.tipo = tipo;
        adicional = new HashMap<>();
    }

    public TaxasPorTipo(TipoPropriedade tipo, TaxaFixa valorFixo){
        this.tipo = tipo;
        this.fixa = valorFixo;
        adicional = new HashMap<>();
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
    public TaxaFixa getFixa() {
        return fixa;
    }
    /**
     * @return the tipo
     */
    public TipoPropriedade getTipo() {
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
    public void setFixa(TaxaFixa fixa) {
        this.fixa = fixa;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPropriedade tipo) {
        this.tipo = tipo;
    }

    public void adicionarAdicional(double de, double ate, double valor){
        adicional.put(new ValoresDeAte(de, ate) , valor);
    }
    
    
}

