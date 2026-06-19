package pacoteDados.Excecoes;

public class LimiteAtingException extends Exception {
    private int indice;

    public LimiteAtingException(String mensagem, int indice) {
        super(mensagem);
        this.indice = this.indice;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}