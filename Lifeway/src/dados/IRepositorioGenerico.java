package dados;

import java.util.List;

import excecoes.ObjetoJaExisteException;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ObjetoJaExisteException;
    void remover(T obj);
    //void removerPorID(String id);
    T buscar(T obj);
    //T buscarPorID(String id);
    List<T> listar();
    
    
}
