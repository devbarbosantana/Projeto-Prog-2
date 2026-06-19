package pacoteGUI;

import pacoteNegocios.Fachada;
import pacoteEntidades.Aluno;
import pacoteEntidades.Departamento;
import pacoteEntidades.Sala;
import pacoteEntidades.Cadeira;
import pacoteEntidades.Cadeira.TipoDisciplina;
import pacoteEntidades.Turma;
import pacoteEntidades.Professor;

import java.util.Scanner;

    public class Programa {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Fachada sistema = Fachada.getInstance();
            boolean rodando = true;

            System.out.println("=========================================");
            System.out.println("       BEM-VINDO AO SIGAA 2.0");
            System.out.println("=========================================");

            while (rodando) {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1 - Preencher Dados de Teste (Mock Automático)");
                System.out.println("2 - Cadastrar Novo Aluno");
                System.out.println("3 - Matricular Aluno na Turma de Teste");
                System.out.println("4 - Imprimir Diário de Classe (Relatório da Turma)");
                System.out.println("5 - Rodar ProgramaTeste.java (Teste Geral da Equipe)");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                try {
                    switch (opcao) {
                        case 1:
                            System.out.println("\nInjetando dados no banco de dados...");
                            // Cria dependências
                            System.out.println("\nInjetando dados no banco de dados...");

                            // 1 Departamento
                            sistema.cadastrarDepartamento("Informatica", "Sede");

                            // 2 Professor
                            sistema.cadastrarProfessor("Guanabara", "111", "Banco de Dados");

                            // 3 Sala
                            sistema.cadastrarSala(232, "Bloco B", 30);

                            // 4 Cadeira (Passa a String no formato 100% maiúsculo "OBRIGATORIA"
                            sistema.cadastrarCadeira(50, "Banco de Dados 1", "SQL", 60, "OBRIGATORIA");

                            // 5. Turma (Passa o ID e a capacidade direto, sem precisar consultar da sala)
                            sistema.cadastrarTurma(1001, 30);

                            System.out.println(" Dados criados! Turma 1001 pronta para receber alunos.");
                            break;

                        case 2:
                            System.out.print("Nome do Aluno: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Matrícula (Número): ");
                            int mat = scanner.nextInt();

                            // O sistema só recebe os dados brutos. O 'new' acontece lá no CadastroAluno!
                            sistema.cadastrarAluno(nome, cpf, mat);
                            System.out.println("✅ Aluno cadastrado com sucesso!");
                            break;

                        case 3:
                            System.out.println("Atenção: Cadastre o aluno (Opção 2) e a Turma (Opção 1) antes!");
                            System.out.print("Digite o ID da Turma: ");
                            int idTurmaMat = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Digite o CPF do Aluno: ");
                            String cpfMat = scanner.nextLine();

                            // A interface pede para o sistema buscar o aluno de verdade dentro do banco de dados
                            Aluno alunoReal = sistema.buscarAluno(cpfMat);

                            //Valida se o aluno existe antes de tentar matricular
                            if (alunoReal != null) {
                                sistema.matricularAlunoNaTurma(idTurmaMat, alunoReal);
                                System.out.println(" Aluno matriculado com sucesso na turma " + idTurmaMat + "!");
                            } else {
                                System.out.println(" Erro: Aluno com CPF " + cpfMat + " não encontrado. Tente novamente.");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o ID da Turma (Ex: 1001): ");
                            int idTurma = scanner.nextInt();
                            System.out.println(sistema.obterRelatorioTurma(idTurma));
                            break;

                        case 5:
                            System.out.println("\n--- INICIANDO TESTE DA EQUIPE ---");
                            Programa.main(args);
                            break;

                        case 0:
                            System.out.println("Encerrando o SIGAA 2.0... Até logo!");
                            rodando = false;
                            break;

                        default:
                            System.out.println(" X Opção inválida!");
                    }
                } catch (Exception e) {
                    System.out.println(" ERRO: " + e.getMessage());
                }
            }
            scanner.close();
        }
    }

