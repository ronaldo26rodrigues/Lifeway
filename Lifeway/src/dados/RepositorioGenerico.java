package dados;

import java.util.ArrayList;
import java.util.List;

import excecoes.ElementoJaExisteException;
import excecoes.ElementoNaoExisteException;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T> {

    private List<T> objetos;
    private String fileName;

    @SuppressWarnings("unchecked")
    public RepositorioGenerico(String fileName) {
        objetos = new ArrayList<>();
        this.fileName = fileName;

        Object listaObjetos = RepositorioFileUtil.lerDoArquivo(this.fileName);
        if(listaObjetos != null && listaObjetos instanceof List<?>) {
            this.objetos = (List<T>) listaObjetos;
        }
    }

    @Override
    public void inserir(T obj) throws ElementoJaExisteException {
        if (!objetos.contains(obj)) {
            objetos.add(obj);
        } else {
            throw new ElementoJaExisteException(obj.toString());
        }
        RepositorioFileUtil.salvarArquivo(objetos, this.fileName);
    }

    

    @Override
    public void remover(T obj) {
        objetos.remove(obj);
        RepositorioFileUtil.salvarArquivo(objetos, this.fileName);
    }

    @Override
    public T buscar(T obj) {
        for (T t : objetos) {
            if (t.equals(obj))
                return t;
        }
        return null;
    }

    @Override
    public List<T> listar() {
        return objetos;
    }

    @Override
    public void salvar() {
        RepositorioFileUtil.salvarArquivo(objetos, this.fileName);
    }

    @Override
    public void atualizar(T newObj) throws ElementoNaoExisteException {
        if(objetos.contains(newObj)) {
            int indice = this.objetos.indexOf(newObj);
            this.objetos.set(indice, newObj);
        } else {
            throw new ElementoNaoExisteException(newObj.toString());
        }


        RepositorioFileUtil.salvarArquivo(objetos, this.fileName);

    }

}
