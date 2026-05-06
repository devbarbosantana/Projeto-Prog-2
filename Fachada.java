package sigaa;

public class Fachada {
    private static Fachada instancia;

    // Cadastros hipotéticos dos seus colegas
    private CadastroDepartamento cadastroDepartamento;
    private CadastroCurso cadastroCurso;
    private CadastroProfessor cadastroProfessor;
    private CadastroAluno cadastroAluno;
    private CadastroCadeira cadastroCadeira;
    private CadastroSala cadastroSala;
    private CadastroTurma cadastroTurma;

    private Fachada() {
        // Inicialização dos cadastros 
        // Ex: this.cadastroTurma = new CadastroTurma(new RepositorioTurmasArray(100));
    }

    public static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public void lancarNotaTurma(int idTurma, String cpfAluno, int unidade, double nota) throws Exception {
        Turma turma = cadastroTurma.buscarTurma(idTurma);
        turma.lancarNota(cpfAluno, unidade, nota);
        cadastroTurma.atualizar(turma);
    }

    public void registrarFaltaTurma(int idTurma, String cpfAluno) throws Exception {
        Turma turma = cadastroTurma.buscarTurma(idTurma);
        turma.registrarFalta(cpfAluno);
        cadastroTurma.atualizar(turma);
    }
    
    public void matricularAlunoNaTurma(int idTurma, String cpf) throws Exception {
        // Aluno aluno = cadastroAluno.buscar(cpf);
        // Turma turma = cadastroTurma.buscarTurma(idTurma);
        // turma.matricularAluno(aluno);
        // cadastroTurma.atualizar(turma);
    }
}
