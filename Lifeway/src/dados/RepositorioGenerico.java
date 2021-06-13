package dados;

import java.util.ArrayList;
import java.util.List;

import excecoes.ObjetoJaExisteException;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T> {

    private List<T> objetos;

    public RepositorioGenerico(){
        objetos = new ArrayList<>();
    }

    @Override
    public void inserir(T obj) throws ObjetoJaExisteException {
        if(!objetos.contains(obj)){
            objetos.add(obj);
        } else {
            throw new ObjetoJaExisteException(obj.toString());
        }
    }

    @Override
    public void remover(T obj) {
        objetos.remove(obj);
    }


    @Override
    public T buscar(T obj) {
        for (T t : objetos) {
            if(t.equals(obj))  return t;
        }
        return null;
    }

    @Override
    public List<T> listar() {
        return objetos;
    }

}
