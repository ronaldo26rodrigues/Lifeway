package dados;

import java.util.List;

import excecoes.ElementoJaExisteException;
import excecoes.ElementoNaoExisteException;

public interface IRepositorioGenerico<T> {

    void inserir(T obj) throws ElementoJaExisteException;

    void remover(T obj);

    // void removerPorID(String id);
    T buscar(T obj);

    // T buscarPorID(String id);
    List<T> listar();

    void salvar();

    void atualizar(T newObj)  throws ElementoNaoExisteException;

}
