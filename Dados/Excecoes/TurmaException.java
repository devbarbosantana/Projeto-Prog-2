package pacoteDados.Excecoes;

public class TurmaException extends RuntimeException {
    public TurmaException(String message, int indice) {
        super(message);
    }
}
