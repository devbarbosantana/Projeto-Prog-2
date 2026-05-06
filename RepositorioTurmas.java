package PacoteTurma;

public interface RepositorioTurmas {
    void inserir(Turma turma);
    Turma buscar(int idTurma);
    void remover(int idTurma);
    String listar();
}
