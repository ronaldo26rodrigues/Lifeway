package main;

import java.time.LocalDate;

import negocio.Controlador;
import negocio.beans.Endereco;
import negocio.beans.TaxaFixa;
import negocio.beans.TipoConsumidor;

public class TesteMain {
    public static void main(String[] args) { 
        Controlador controlador = Controlador.getInstance();

        controlador.criarEmpresa("emp1", "Compesa", "agua");

        controlador.adicionarTaxaDoTipoNaEmpresa("emp1", TipoConsumidor.RESIDENCIAL);

        controlador.adicionarTaxaFixaPorTipoNaEmpresa("emp1", TipoConsumidor.RESIDENCIAL, new TaxaFixa(1000, 10));

        controlador.criarCliente("Ronaldo", "1234567890", LocalDate.of(2021, 8, 26));

        controlador.adicionarConsumidorAoCliente("1234567890", "emp1", "med1", TipoConsumidor.RESIDENCIAL, new Endereco("rua das orquideas", 20));
    }
}
