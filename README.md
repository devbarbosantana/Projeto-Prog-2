# Sigaa 2.0 Simplificado - Sistema de Gestão Acadêmica
Este é um Sistema de Gestão Acadêmica desenvolvido em Java para aplicar e consolidar os principais conceitos de Programação Orientada a Objetos (POO), como Herança, Polimorfismo, Encapsulamento e Padrões de Projeto. O sistema simula o controle real de um ambiente universitário, gerenciando departamentos, professores, alunos, disciplinas e turmas.
O projeto foi desenvolvido como parte da disciplina de Introdução à Programação 2 (IP2) da UFRPE.
## Arquitetura do Projeto
O sistema foi rigorosamente dividido em camadas para garantir a segurança dos dados e a separação de responsabilidades (padrão MVC adaptado). A estrutura de pacotes é a seguinte:
### 1. pacoteEntidades (A Base)
Contém as classes de modelo que representam os objetos do mundo real. É aqui que os dados nascem.
 * *Classes principais:* Pessoa (Superclasse), Aluno, Professor, Departamento, Curso, Sala, Cadeira, Turma, Boletim e Historico.
 * *Destaque:* Utilização de Herança (Pessoa para Aluno e Professor) e Composição (Aluno tem um Boletim).
### 2. pacoteDados (O Armazenamento)
Responsável por guardar os objetos em memória e realizar as operações de CRUD (Criar, Ler, Atualizar, Deletar).
 * *Estrutura:* Implementação de uma interface genérica IRepositorio<T, ID>.
 * *Tecnologia:* Os dados são armazenados utilizando arrays puros em classes como RepositorioAlunoArray, RepositorioTurmasArray, etc.
 * *Destaque:* Aplicação do padrão *Singleton* para garantir que exista apenas uma instância de cada "banco de dados" rodando.
### 3. pacoteNegocios (As Regras)
É o cérebro do sistema. Nenhuma entidade entra no repositório sem passar pelas validações rigorosas dessa camada.
 * *Cadastros:* Classes como CadastroAluno e CadastroTurma, que validam se um CPF já existe, se a turma está lotada ou se os dados estão nulos.
 * *Tratamento de Erros:* Lançamento de Exceções personalizadas (AlunoException, TurmaException, etc.) para proteger o sistema de entradas inválidas.
 * *Destaque - A Fachada:* A classe Fachada utiliza o padrão *Facade* para centralizar todas as operações. É o único ponto de comunicação entre o sistema visual e as regras de negócio.
### 4. pacoteGUI (A Interface)
A camada visual do sistema, construída para ser totalmente independente das lógicas de validação.
 * A interface gráfica apenas coleta os dados digitados pelo usuário (Strings e inteiros) e os envia de forma limpa para a Fachada processar. Nenhuma regra matemática ou criação de entidades (new Aluno()) acontece nesta camada.
## Como executar
 1. Clone este repositório.
 2. Abra o projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse, etc.).
 3. Navegue até o pacoteGUI e execute a classe Main.
