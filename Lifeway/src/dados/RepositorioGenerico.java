package dados;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T> {

    private List<T> objetos;

    public RepositorioGenerico(){
        objetos = new ArrayList<>();
    }

    @Override
    public void inserir(T obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remover(T obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T buscar(T obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> listar() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
