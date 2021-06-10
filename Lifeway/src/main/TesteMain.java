package main;

import java.time.LocalDate;

import negocio.Controlador;
import negocio.beans.Bandeira;
import negocio.beans.Cliente;
import negocio.beans.Consumidor;
import negocio.beans.Conta;
import negocio.beans.Endereco;
import negocio.beans.TaxaFixa;
import negocio.beans.TipoConsumidor;

public class TesteMain {
    public static void main(String[] args) { 
        Controlador controlador = Controlador.getInstance();

        controlador.criarEmpresa("emp1", "Compesa", "agua");

        controlador.adicionarTaxaDoTipoNaEmpresa("emp1", TipoConsumidor.RESIDENCIAL);

        controlador.adicionarTaxaFixaPorTipoNaEmpresa("emp1", TipoConsumidor.RESIDENCIAL, new TaxaFixa(1000, 10));
        controlador.adicionarTaxaAdicionalPorTipoNaEmpresa("emp1", TipoConsumidor.RESIDENCIAL, 1000, 2000, 0.2);
        controlador.adicionarTarifaNaEmpresa("emp1", "Esgoto", 2.0);
        controlador.definirBandeiraDaEmpresa("emp1", Bandeira.AMARELA, 0.025f);

        controlador.criarCliente("Ronaldo", "1234567890", LocalDate.of(2021, 8, 26));

        controlador.adicionarConsumidorAoCliente("1234567890", "emp1", "med1", TipoConsumidor.RESIDENCIAL, new Endereco("rua das orquideas", 20));

        controlador.acessarCliente("1234567890");

        controlador.adicionarContaAoConsumidor("conta1", "emp1", "med1", LocalDate.of(2021, 3, 26), 1500);

        for (Cliente cliente : controlador.listarClientes()) {
            System.out.println(cliente);
        }

        for (Consumidor consumidor : controlador.listarConsumidoresDoCliente("1234567890")) {
            System.out.println(consumidor);
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


        
    }
}
