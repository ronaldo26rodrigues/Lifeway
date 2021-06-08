package dados;

import java.util.List;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj);
    void remover(T obj);
    T buscar(T obj);
    List<T> listar();
    
}
