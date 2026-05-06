public class Turma {
    private int idTurma;
    private Curso curso;
    private Professor professor;
    
    // Arrays para notas e faltas (relacionados aos alunos)
    // Para simplificar no array puro, podemos usar arrays paralelos onde o índice representa um aluno matriculado
    private Aluno[] alunosMatriculados;
    private double[][] notas; // Ex: notas[indiceAluno][numeroDaNota]
    private int[] faltas;     // Ex: faltas[indiceAluno]
    
    private int quantidadeAlunos;
    private final int CAPACIDADE_MAXIMA = 50; // Limite padrão

    public Turma(int idTurma, Cadeira cadeira, Sala sala, Professor professor) {
        this.idTurma = idTurma;
        this.cadeira = cadeira;
        this.sala = sala;
        this.professor = professor;
        
        this.alunosMatriculados = new Aluno[CAPACIDADE_MAXIMA];
        this.notas = new double[CAPACIDADE_MAXIMA][3]; // Supondo 3 notas por aluno
        this.faltas = new int[CAPACIDADE_MAXIMA];
        this.quantidadeAlunos = 0;
    }

    // Métodos para matricular aluno, lançar nota e registrar falta viriam aqui...
    // Getters e Setters...
}
