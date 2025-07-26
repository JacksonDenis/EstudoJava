package BatalhaNaval;

import java.util.Random;

public class BattleshipGame {
    public static void main(String[] args) {
        Tabuleiro t = new Tabuleiro();
        // Exemplo de frota mínima
        t.posicionar(new Navio(5, Navio.Orientacao.HORIZONTAL, 0, 0));
        t.posicionar(new Navio(4, Navio.Orientacao.VERTICAL,   2, 3));
        // ...

        Random rnd = new Random();
        int disparos = 0;
        while (!t.acabou()) {
            int x = rnd.nextInt(10), y = rnd.nextInt(10);
            if (t.atacar(x, y)) ;               // feedback opcional
            disparos++;
            System.out.printf("Tiro %d em (%d,%d)%n", disparos, x, y);
            t.mostrar(false);
            System.out.println();
        }
        System.out.printf("Todos os navios afundados em %d disparos.%n", disparos);
    }
}

