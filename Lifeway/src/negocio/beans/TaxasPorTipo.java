package negocio.beans;

import java.util.HashMap;
import java.util.Map;

public class TaxasPorTipo {
    
    private TipoPropriedade tipo;
    private Map<ValoresDeAte, Double>  faixa;

    public TaxasPorTipo(TipoPropriedade tipo){
        this.tipo = tipo;
        faixa = new HashMap<>();
    }


    /**
     * @return the adicional
     */
    public Map<ValoresDeAte, Double> getAdicional() {
        return faixa;
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
        this.faixa = adicional;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPropriedade tipo) {
        this.tipo = tipo;
    }

    public void adicionarAdicional(double de, double ate, double valor){
        faixa.put(new ValoresDeAte(de, ate) , valor);
    }
    
    
}

