package negocio.controle;

import java.time.LocalDate;
import java.util.Random;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
import negocio.beans.Usuario;

public class ControladorRO {

    private static ControladorRO instance;
    

    private IRepositorioGenerico<RegistroDeOcorrencia> repositorioRO;

    private ControladorRO() {
        repositorioRO = new RepositorioGenerico<>();
    }

    public static ControladorRO getInstance() {
        if(instance == null) {
            instance = new ControladorRO();
        }
        return instance;
    }

    public void criarNovaOcorrencia(String assunto, String mensagem, Empresa empresa, Usuario cliente, LocalDate data, Endereco endereco) {
        
        Random rng = new Random();

        RegistroDeOcorrencia novaOcorrencia = new RegistroDeOcorrencia("P"+rng.nextInt(1000)+rng.nextInt(1000), assunto, mensagem, empresa, cliente, data, endereco);
        try {
            repositorioRO.inserir(novaOcorrencia);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        
    }

    public void resolverOcorrencia(RegistroDeOcorrencia ocorrencia) {
        for (RegistroDeOcorrencia registroDeOcorrencia : repositorioRO.listar()) {
            if(ocorrencia.equals(registroDeOcorrencia)) {
                registroDeOcorrencia.setResolvido(true);
                break;
            }
        }
    }

}
