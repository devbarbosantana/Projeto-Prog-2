import java.util.Scanner;

// Lembre-se de importar a sua Fachada de acordo com o pacote onde ela estiver.
// Exemplo: import PacoteTurma.Fachada; 

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fachada sistema = Fachada.getInstance();
        boolean rodando = true;

        System.out.println("==================================================");
        System.out.println("  SISTEMA INTEGRADO DE GESTÃO ACADÊMICA 2.0");
        System.out.println("==================================================");

        // Sistema de login 
        System.out.print("Login: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Autenticação simples
        if (usuario.equals("admin") && senha.equals("admin")) {
            System.out.println("\n✅ Login realizado com sucesso!\n");
            
            while (rodando) {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1 - Lançar Notas no Diário");
                System.out.println("2 - Registrar Falta no Diário");
                System.out.println("3 - Gerenciar Alunos (Cadastrar/Matricular)");
                System.out.println("4 - Gerenciar Professores/Cursos");
                System.out.println("0 - Sair");
                System.out.print("Sua opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpeza do buffer

                try {
                    switch (opcao) {
                        case 1:
                            System.out.print("Informe o ID da Turma: ");
                            int idTurma = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("Informe o CPF do Aluno: ");
                            String cpf = scanner.nextLine();
                            
                            System.out.print("Unidade (1 a 3): ");
                            int unidade = scanner.nextInt();
                            
                            System.out.print("Nota: ");
                            double nota = scanner.nextDouble();
                            
                            sistema.lancarNotaTurma(idTurma, cpf, unidade, nota);
                            System.out.println("✅ Nota lançada com sucesso!");
                            break;
                            
                        case 2:
                            System.out.print("Informe o ID da Turma: ");
                            int idTurmaFalta = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("Informe o CPF do Aluno: ");
                            String cpfFalta = scanner.nextLine();
                            
                            sistema.registrarFaltaTurma(idTurmaFalta, cpfFalta);
                            System.out.println("✅ Falta registrada com sucesso!");
                            break;
                            
                        case 3:
                            System.out.println("Chamando métodos de Aluno via Fachada...");
                            // Exemplo: sistema.matricularAlunoNaTurma(...);
                            break;
                            
                        case 4:
                            System.out.println("Chamando métodos de Professor/Curso via Fachada...");
                            break;

                        case 0:
                            System.out.println("Encerrando o SIGAA 2.0... Até logo!");
                            rodando = false;
                            break;
                            
                        default:
                            System.out.println("❌ Opção inválida! Tente novamente.");
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ ERRO: " + e.getMessage());
                }
            }
        } else {
            System.out.println("❌ Acesso Negado. Credenciais incorretas.");
        }
        
        scanner.close();
    }

}
