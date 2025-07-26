package BatalhaNaval;

public class Navio {
    public enum Orientacao {
        HORIZONTAL,
        VERTICAL
    }
    public final int tamanho;
    public final Orientacao orientacao;
    public final int linha, coluna;

    public Navio(int tamanho, Orientacao orientacao, int linha, int coluna) {
        this.tamanho = tamanho;
        this.orientacao = orientacao;
        this.linha = linha;
        this.coluna = coluna;
    }


}
