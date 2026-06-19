package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Negocios.Fachada; // Ajuste o import caso o nome do seu pacote seja diferente

public class CursoController {

    // Componentes visuais vinculados à sua CursoTela.fxml
    @FXML private TextField txtNome;
    @FXML private TextField txtVagas;

    @FXML
    public void salvarCurso() {
        try {
            // Pega o nome digitado
            String nome = txtNome.getText();

            // Converte o texto das vagas para um número inteiro (int)
            int vagas = Integer.parseInt(txtVagas.getText());

            // Envia os dados para a Fachada salvar no sistema
            Fachada.getInstancia().cadastrarCurso(nome, vagas);

            // Alerta verde de sucesso
            mostrarAlerta(AlertType.INFORMATION, "Sucesso", "Curso cadastrado com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            // Tratamento específico caso o usuário digite letras no campo de vagas
            mostrarAlerta(AlertType.ERROR, "Erro de Validação", "O campo Vagas deve ser um número inteiro válido.");
        } catch (Exception e) {
            // Alerta vermelho de erro geral do sistema
            mostrarAlerta(AlertType.ERROR, "Erro no Cadastro", e.getMessage());
        }
    }

    // Método auxiliar padrão para os alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Limpa a tela após salvar
    private void limparCampos() {
        txtNome.clear();
        txtVagas.clear();
    }
}