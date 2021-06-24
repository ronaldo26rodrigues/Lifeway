package dados;

import java.util.List;

import Excecoes.ElementoJaExisteException;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ElementoJaExisteException;
    void remover(T obj);
    //void removerPorID(String id);
    T buscar(T obj);
    //T buscarPorID(String id);
    List<T> listar();
    
    
}
