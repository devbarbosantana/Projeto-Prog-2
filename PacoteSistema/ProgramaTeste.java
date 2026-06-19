package PacoteSistema;
//Importando claasses de negocios e exceções
import pacoteNegocios.CadastroCurso;
import pacoteDados.Excecoes.CursoException;

import pacoteNegocios.CadastroDepartamento;
import pacoteDados.Excecoes.DepartamentoException;

import pacoteNegocios.CadastroProfessor;
import pacoteDados.Excecoes.ProfessorException;

import pacoteNegocios.CadastroAluno;
import pacoteEntidades.Aluno;

import pacoteNegocios.CadastroSala;
import pacoteDados.Excecoes.SalaException;

import pacoteNegocios.CadastroCadeira;
import pacoteDados.Excecoes.CadeiraException;

import pacoteNegocios.CadastroTurma;

public class ProgramaTeste {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   INICIANDO TESTES GERAIS DO SISTEMA ");
        System.out.println("======================================\n");

        //INSTANCIANDO OS CADASTROS
        CadastroDepartamento cadDep = new CadastroDepartamento();
        CadastroCurso cadCurso = new CadastroCurso();
        CadastroProfessor cadProf = new CadastroProfessor();
        CadastroSala cadSala = new CadastroSala();
        CadastroCadeira cadCadeira = new CadastroCadeira();
        CadastroAluno cadAluno = new CadastroAluno();
        CadastroTurma cadTurma = new CadastroTurma();

        //BLOCO DE TESTES
        try {

            // TESTANDO DEPARTAMENTO
            System.out.println(">> TESTE 1: Departamento");
            // Passando os dados soltos para verificar as funções
            cadDep.cadastrar("Departamento de Computacao", "Campus Sede");
            System.out.println(cadDep.emitirRelatorio());

            // TESTANDO CURSO
            System.out.println(">> TESTE 2: Curso");
            cadCurso.cadastrar("Licenciatura em Computacao", 40);
            System.out.println(cadCurso.emitirRelatorio());

            // TESTANDO PROFESSOR
            System.out.println(">> TESTE 3: Professor");
            cadProf.cadastrar("Paulo Anselmo", "111.222.333-44", "Pesk");
            System.out.println(cadProf.emitirRelatorio());

            // TESTANDO SALA
            System.out.println(">> TESTE 4: Sala");
            cadSala.cadastrar(101, "Bloco A", 40);
            System.out.println(cadSala.emitirRelatorio());

            // TESTANDO Cadeira
            System.out.println(">> TESTE 5: Cadeira (Disciplina)");
            cadCadeira.cadastrar(10, "Introducao a Programacao 2", "Java e POO", 60, "OBRIGATORIA");
            System.out.println(cadCadeira.emitirRelatorio());

            // TESTANDO ALUNO
            System.out.println("\n>> TESTE Aluno e Rendimento");
            cadAluno.cadastrar("Francisco Cisco", "999.888.777-66", 2026100);

            // Buscando uma informação já no banco
            Aluno alunoFrancisco = cadAluno.buscar("999.888.777-66");
            if(alunoFrancisco != null) {
                alunoFrancisco.getBoletim().adicionarNota(7.5);
                alunoFrancisco.getBoletim().adicionarNota(9.0);
                alunoFrancisco.getBoletim().adicionarNota(8.0);
            }

            cadAluno.atualizarRendimento("999.888.777-66");
            System.out.println(cadAluno.gerarRelatorioHistorico("999.888.777-66"));

            // TESTANDO TURMA
            System.out.println("\n>> TESTE DA TURMA:");

            cadTurma.cadastrar(1001, 30);
            // Matriculando o aluno resgatado do banco nessa turma
            cadTurma.matricularAlunoNaTurma(1001, alunoFrancisco);
            // Emitindo o Diário de Classe para ver se funcionou
            System.out.println(cadTurma.obterRelatorioTurma(1001));


            // TESTANDO AS EXCEÇÕES
            System.out.println("\n>> TESTE 6: Exceções");
            // Utilizando o ID 10 pra dar erro
            cadCadeira.cadastrar(10, "Cadeira Fake", "Ementa fake", 30, "OPTATIVA");

            System.out.println("Falha na exceção.");

        } catch (DepartamentoException | CursoException | ProfessorException | SalaException | CadeiraException e) {
            // As exceções irão retornar nesse ponto
            System.out.println("ERRO ENCONTRADO: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("\nERRO FATAL INESPERADO: " + e.getMessage());
        }

        System.out.println("\n======================================");
        System.out.println("        TESTES FINALIZADOS            ");
        System.out.println("======================================");
    }
}