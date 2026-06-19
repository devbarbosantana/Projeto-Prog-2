package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Negocios.Fachada; // Ajuste conforme o nome do seu pacote de negócios

public class ProfessorController {

    // Componentes visuais (coloque estes mesmos nomes no fx:id do Scene Builder)
    @FXML private TextField txtNome;
    @FXML private TextField txtCPF;
    @FXML private TextField txtDepartamento;

    @FXML
    public void salvarProfessor() {
        try {
            // Pega os dados dos campos de texto
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String departamento = txtDepartamento.getText();

            // Manda para a fachada salvar [cite: 48]
            Fachada.getInstancia().cadastrarProfessor(nome, cpf, departamento);

            // Alerta verde de sucesso! [cite: 65]
            mostrarAlerta(AlertType.INFORMATION, "Sucesso", "Professor cadastrado com sucesso!");
            limparCampos();

        } catch (Exception e) {
            // Alerta vermelho de erro se a Fachada estourar uma exceção [cite: 64]
            mostrarAlerta(AlertType.ERROR, "Erro no Cadastro", e.getMessage());
        }
    }

    private void mostrarAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtNome.clear();
        txtCPF.clear();
        txtDepartamento.clear();
    }
}
