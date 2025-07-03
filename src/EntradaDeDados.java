import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EntradaDeDados {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int lerInteiroSafely(String s) {
        while (true) {
            try {
                System.out.print(s);
                return SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                SCANNER.nextLine(); // descarta entrada inválida
            }
        }
    }

    public static double lerDoubleSafely(String s) {
        while (true) {
            try {
                System.out.print(s);
                return SCANNER.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                SCANNER.nextLine(); // descarta entrada inválida
            }
        }
    }

    public static String lerStringSafely(String s) {
        System.out.print(s);
        return SCANNER.nextLine();
    }

    public static void encerrarAplicacao(List<String> HISTORICO) {
        System.out.println("Encerrando a aplicação...");
        if (!HISTORICO.isEmpty()) {
            System.out.println("Histórico de cálculos:");
            for (String registro : HISTORICO) {
                System.out.println(registro);
            }
        } else {
            System.out.println("Nenhum cálculo foi realizado.");
        }
        SCANNER.close();
        System.exit(0);
    }
}
