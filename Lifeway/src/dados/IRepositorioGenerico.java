package dados;

import java.util.List;

import excecoes.ObjetoJaExisteException;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ObjetoJaExisteException;
    void remover(T obj);
    T buscar(T obj);
    List<T> listar();
    
    
}
