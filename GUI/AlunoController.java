package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Negocios.Fachada; // Import da sua Fachada (ajuste se o pacote tiver outro nome)

public class AlunoController {

    // Componentes visuais vinculados ao FXML
    @FXML private TextField txtNome;
    @FXML private TextField txtCPF;
    @FXML private TextField txtMatricula;

    @FXML
    public void salvarAluno() {
        try {
            // Pega os textos digitados pelo usuário
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();

            // Converte a matrícula para int, como pede o roteiro
            int matricula = Integer.parseInt(txtMatricula.getText());

            // Envia os dados para a Fachada cadastrar no sistema
            Fachada.getInstancia().cadastrarAluno(nome, cpf, matricula);

            // Se der certo, mostra o Alerta verdinho de sucesso!
            mostrarAlerta(AlertType.INFORMATION, "Sucesso", "Aluno cadastrado com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            // Tratamento caso o usuário digite letras na matrícula
            mostrarAlerta(AlertType.ERROR, "Erro de Validação", "O campo Matrícula deve conter apenas números inteiros.");
        } catch (Exception e) {
            // Se a Fachada estourar qualquer exceção, mostra a janelinha vermelha com o erro
            mostrarAlerta(AlertType.ERROR, "Erro no Cadastro", e.getMessage());
        }
    }

    // Método auxiliar para criar os alertas (Alert do JavaFX)
    private void mostrarAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Limpa a tela após um cadastro bem-sucedido
    private void limparCampos() {
        txtNome.clear();
        txtCPF.clear();
        txtMatricula.clear();
    }
}