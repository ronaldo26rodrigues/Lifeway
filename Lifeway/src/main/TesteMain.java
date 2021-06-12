package main;

import java.time.LocalDate;

import negocio.Controlador;
import negocio.IControlador;
import negocio.beans.Bandeira;
import negocio.beans.Usuario;
import negocio.beans.Propriedade;
import negocio.beans.Conta;
import negocio.beans.Endereco;
import negocio.beans.RelatorioDeOcorrencia;
import negocio.beans.TaxaFixa;
import negocio.beans.TipoPropriedade;

public class TesteMain {
    public static void main(String[] args) { 
        IControlador controlador = Controlador.getInstance();

        controlador.criarEmpresa("emp1", "Compesa", "agua");

        controlador.adicionarTaxaDoTipoNaEmpresa("emp1", TipoPropriedade.RESIDENCIAL);

        controlador.adicionarTaxaFixaPorTipoNaEmpresa("emp1", TipoPropriedade.RESIDENCIAL, new TaxaFixa(1000, 10));
        controlador.adicionarTaxaAdicionalPorTipoNaEmpresa("emp1", TipoPropriedade.RESIDENCIAL, 1000, 2000, 0.2);
        controlador.adicionarTarifaNaEmpresa("emp1", "Esgoto", 2.0);
        controlador.definirBandeiraDaEmpresa("emp1", Bandeira.AMARELA, 0.025f);

        controlador.criarCliente("Ronaldo", "1234567890", LocalDate.of(2021, 8, 26));

        controlador.adicionarConsumidorAoCliente("1234567890", "emp1", "med1", TipoPropriedade.RESIDENCIAL, new Endereco("rua das orquideas", 20));

        controlador.acessarCliente("1234567890");

        controlador.adicionarContaAoConsumidor("conta1", "emp1", "med1", LocalDate.of(2021, 3, 26), 900);

        for (Usuario cliente : controlador.listarClientes()) {
            System.out.println(cliente);
            System.out.println("--------------");
        }

        for (Propriedade consumidor : controlador.listarConsumidoresDoCliente("1234567890")) {
            System.out.println(consumidor);
            System.out.println("=========");
        }

        controlador.listarContas("med1");

        for (Conta conta : controlador.listarContasPendentes("med1")) {
            System.out.println(conta);
        }

        controlador.pagarContaDoMes("conta1", "med1", 3);

        System.out.println("Contas pendentes depois de paga");
        for (Conta conta : controlador.listarContasPendentes("med1")) {
            System.out.println(conta);
        }

        controlador.reportarProblema("ptc1", "vazamento", "cano furado na calçada", "emp1", LocalDate.now(), new Endereco("rua da lagoa", 14));
        System.out.println("\nProblemas reportados:");
        for (RelatorioDeOcorrencia report : controlador.listarProblemas("emp1")) {
            System.out.println(report);
        }

        controlador.resolverProblema("emp1", "ptc1");

        System.out.println("\nProblemas pendentes:");
        for (RelatorioDeOcorrencia report : controlador.listarProblemasPendentes("emp1")) {
            System.out.println(report);
        }


        
    }
}
