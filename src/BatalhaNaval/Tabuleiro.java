package BatalhaNaval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tabuleiro {
    private static final int N = 10;
    private final Celula[][] grade = new Celula[N][N];
    private final List<Navio> frota = new ArrayList<>();

    public Tabuleiro() { for (var linha : grade) Arrays.fill(linha, Celula.AGUA); }

    public boolean posicionar(Navio n) {
        var coords = coordenadas(n);
        if (coords.stream().anyMatch(c -> fora(c.x,c.y) || grade[c.x][c.y] != Celula.AGUA))
            return false;                                    // colisão
        coords.forEach(c -> grade[c.x][c.y] = Celula.NAVIO);
        frota.add(n);
        return true;
    }

    /** Retorna true se foi acerto. */
    public boolean atacar(int x, int y) {
        if (fora(x,y)) throw new IllegalArgumentException();
        switch (grade[x][y]) {
            case NAVIO -> { grade[x][y] = Celula.ACERTO; return true; }
            case AGUA  -> grade[x][y] = Celula.TIRO;
        }
        return false;
    }

    public void mostrar(boolean revelar) {
        System.out.print("  ");
        for (int c=0;c<N;c++) System.out.print(c+" ");
        System.out.println();
        for (int r=0;r<N;r++) {
            System.out.print(r+" ");
            for (int c=0;c<N;c++) {
                Celula cel = grade[r][c];
                char out = switch (cel) {
                    case NAVIO -> revelar ? cel.simbolo : Celula.AGUA.simbolo;
                    default    -> cel.simbolo;
                };
                System.out.print(out+" ");
            }
            System.out.println();
        }
    }

    public boolean acabou() {
        return Arrays.stream(grade)
                .flatMap(Arrays::stream)
                .noneMatch(c -> c == Celula.NAVIO);
    }

    /* ---------- helpers ---------- */
    private record P(int x,int y){}
    private static List<P> coordenadas(Navio n) {
        List<P> list = new ArrayList<>();
        for (int i=0;i<n.tamanho;i++) {
            int x = n.linha + (n.orientacao==Navio.Orientacao.VERTICAL? i : 0);
            int y = n.coluna + (n.orientacao==Navio.Orientacao.HORIZONTAL? i : 0);
            list.add(new P(x,y));
        }
        return list;
    }
    private static boolean fora(int x,int y){ return x<0||x>=N||y<0||y>=N; }
}

