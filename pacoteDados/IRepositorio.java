package pacoteDados;

//Interface geral abordando todos os métodos
public interface IRepositorio<T, ID> {
    void inserir(T obj) throws Exception;
    T buscar(ID id);
    void remover(ID id) throws Exception;
    void atualizar(T obj);
    T[] listar();
    int getTotal();
}