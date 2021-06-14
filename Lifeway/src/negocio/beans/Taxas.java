package negocio.beans;

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
    /**
     * @return the taxasPorTipo
     */
    public List<TaxasPorTipo> getTaxasPorTipo() {
        return taxasPorTipo;
    }
    public TaxasPorTipo getTaxasDoTipo(TipoPropriedade tipo){
        TaxasPorTipo taxaDoTipo = null;
        for (TaxasPorTipo t : taxasPorTipo) {
            if(t.getTipo().equals(tipo)){
                taxaDoTipo = t;
            }
        }
        return taxaDoTipo;
    }
    /**
     * @return the bandeira
     */
    public Bandeira getBandeira() {
        return bandeira;
    }
    /**
     * @return the tarifas
     */
    public Map<String, Double> getTarifas() {
        return tarifas;
    }

    public void adicionarTarifa(String nome, Double valor){
        this.tarifas.put(nome, valor);
    }

    public void definirBandeira(Bandeira bandeira, float valor){
        this.bandeira = bandeira;
        this.bandeira.setValor(valor);
    }

    public void criarTaxaDoTipo(TipoPropriedade tipo){
        this.taxasPorTipo.add(new TaxasPorTipo(tipo));
    }
}
