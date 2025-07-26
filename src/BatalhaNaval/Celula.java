package BatalhaNaval;

public enum Celula {
    AGUA('~'),
    NAVIO('N'),
    TIRO('X'),
    ACERTO('A');

    public final char simbolo;
    Celula(char simbolo) { this.simbolo = simbolo; }
}
