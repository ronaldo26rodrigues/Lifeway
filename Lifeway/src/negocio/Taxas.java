package negocio;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Taxas {
    
    private List<TaxasPorTipo> taxasPorTipo;
    private Map<String, Double> tarifas;
    private Bandeira bandeira;

    public Taxas(){
        this.taxasPorTipo = new ArrayList<>();
        this.tarifas = new HashMap<>(); 
    }

    public Taxas(Bandeira bandeira, float valorBandeira){
        this.taxasPorTipo = new ArrayList<>();
        this.tarifas = new HashMap<>();
        this.bandeira = bandeira;
        bandeira.setValor(valorBandeira);
    }

    /**
     * @param taxasPorTipo set taxasPorTipo
     */
    public void setTaxasPorTipo(List<TaxasPorTipo> taxasPorTipo) {
        this.taxasPorTipo = taxasPorTipo;
    }
    /**
     * @param tarifas set tarifas
     */
    public void setTarifas(Map<String, Double> tarifas) {
        this.tarifas = tarifas;
    }
}
