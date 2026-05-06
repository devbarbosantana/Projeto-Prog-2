public class RepositorioTurmasArray implements RepositorioTurmas {
    private Turma[] turmas;
    private int proxima;

    public RepositorioTurmasArray(int tamanho) {
        this.turmas = new Turma[tamanho];
        this.proxima = 0;
    }

    @Override
    public void inserir(Turma turma) {
        if (proxima < turmas.length) {
            turmas[proxima] = turma;
            proxima++;
        } else {
            // Lógica para dobrar o array ou lançar Exceção
        }
    }

    @Override
    public Turma buscar(int idTurma) {
        // Lógica de busca com laço for
        return null; 
    }

    @Override
    public void remover(int idTurma) {
        // Lógica de remoção e realocação do array
    }

    @Override
    public String listar() {
        // Retornar dados das turmas
        return "";
    }
}
