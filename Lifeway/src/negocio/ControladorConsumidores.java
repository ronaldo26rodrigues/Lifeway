package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Cliente;
import negocio.beans.Consumidor;
import negocio.beans.Conta;
import negocio.beans.Empresa;
import negocio.beans.ValoresDeAte;

public class ControladorConsumidores {
    
    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    private static ControladorConsumidores instance;

    private ControladorConsumidores() {
        this.repositorioConsumidores = new RepositorioGenerico<>();
    }

    private ControladorConsumidores(String idCliente){
        Cliente clienteSelecionado = ControladorClientes.getInstance().getRepositorioClientes().buscarPorID(idCliente);
        this.repositorioConsumidores = clienteSelecionado.getRepositorioConsumidores();
    }

    public ControladorConsumidores getInstance() {
        if (instance == null) {
            instance = new ControladorConsumidores();
        }
        return instance;
    }

    public ControladorConsumidores getInstance(String idCliente){
        if(instance == null){
            instance = new ControladorConsumidores(idCliente);
        }
        return instance;
    }

    public void acessarCliente(String idCliente){
        Cliente clienteSelecionado = ControladorClientes.getInstance().getRepositorioClientes().buscarPorID(idCliente);
        this.repositorioConsumidores = clienteSelecionado.getRepositorioConsumidores();
    }

    /**
     * @return the repositorioConsumidores
     */
    public IRepositorioGenerico<Consumidor> getRepositorioConsumidores() {
        return repositorioConsumidores;
    }

    private Consumidor selecionarConsumidor(String numMedidor){
        return repositorioConsumidores.buscarPorID(numMedidor);
    }

    private double calcularValorConta(Consumidor consumidor, double consumo){
        double valor = 0;
        Empresa empresaSelecionada = ControladorEmpresas.getInstance().getRepositorioEmpresas().buscarPorID(consumidor.getIdEmpresa());

        valor += empresaSelecionada.getTaxas().getTaxasDoTipo(consumidor.getTipo()).getFixa().getValorFixo();

        Map<ValoresDeAte, Double> adicionais = empresaSelecionada.getTaxas().getTaxasDoTipo(consumidor.getTipo()).getAdicional();

        for (Map.Entry<ValoresDeAte, Double> a : adicionais.entrySet()) {
            if(consumo > ((ValoresDeAte) a.getKey()).getDe() && consumo < ((ValoresDeAte) a.getKey()).getAte()){
                valor += a.getValue() * (consumo-empresaSelecionada.getTaxas().getTaxasDoTipo(consumidor.getTipo()).getFixa().getMaximo());
            }
        }

        Map<String, Double> tarifas = empresaSelecionada.getTaxas().getTarifas();

        for (Map.Entry<String, Double> t : tarifas.entrySet()) {
            valor += t.getValue();
        }

        valor += empresaSelecionada.getTaxas().getBandeira().getValor();

        return valor;
    }

    public void adicionarContaAoConsumidor(String idConta, String idEmpresa, String numMedidor, LocalDate data, double consumo){
        Consumidor consumidorSelecionado = selecionarConsumidor(numMedidor);

        double valor = calcularValorConta(consumidorSelecionado, consumo);

        Conta novaConta = new Conta(idConta, data, consumo, valor);

        try {
            consumidorSelecionado.getRepositorioContas().inserir(novaConta);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void pagarContaDoMes(String idConta, String numMedidor, int mes){
        selecionarConsumidor(numMedidor).getRepositorioContas().buscarPorID(idConta).setPaga(true);
    }

    public List<Conta> listarContasPendentes(String numMedidor){
        List<Conta> contasPendentes = new ArrayList<>();
        
        for (Conta conta : selecionarConsumidor(numMedidor).getRepositorioContas().listar()) {
            if(conta.getPaga()==false){
                contasPendentes.add(conta);
            }
        }

        return contasPendentes;
    }

    public List<Conta> listarContas(String numMedidor){
        return selecionarConsumidor(numMedidor).getRepositorioContas().listar();
    }
}
