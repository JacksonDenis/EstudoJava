import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FerramentadeConversao {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<String> HISTORICO = new ArrayList<>();

    public static void main(String[] args) {
        int opc;
        do {
            exibirMenu();
            opc = lerInteiroSafely("Escolha uma opção: ");
            switch (opc) {
                case 1 -> executarConversaoTemperatura();
                case 2 -> executarIMC();
                case 3 -> executarBhaskara();
                case 4 -> executarAreaTriangulo();
                case 5 -> encerrarAplicacao();
                default -> System.out.println("Opção inválida\n");
            }
        } while (opc != 5);
    }

    private static void encerrarAplicacao() {
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

    private static void executarAreaTriangulo() {
        System.out.println("Vamos calcular a área do triângulo: base × altura / 2");
        double base = lerDoubleSafely("Entre com o valor da base: ");
        double altura = lerDoubleSafely("Entre com o valor da altura: ");
        double area = (base * altura) / 2;
        System.out.printf("A área do triângulo é: %.2f\n\n", area);
        HISTORICO.add(String.format("Área do triângulo: %.2f", area));
    }

    private static void executarBhaskara() {
        System.out.println("Vamos resolver a equação do segundo grau: ax² + bx + c = 0");
        double a = lerDoubleSafely("Entre com o valor de a: ");
        double b = lerDoubleSafely("Entre com o valor de b: ");
        double c = lerDoubleSafely("Entre com o valor de c: ");

        if (a == 0) {
            System.out.println("O valor de 'a' não pode ser zero. Tente novamente.\n");
            return;
        }
        double delta = b * b - 4 * a * c;
        System.out.println("Valor de Delta: " + delta);
        if (delta < 0) {
            System.out.println("A equação não possui raízes reais.\n");
        } else if (delta == 0) {
            double raiz = -b / (2 * a);
            System.out.printf("A equação possui uma raiz real: %.2f\n\n", raiz);
            HISTORICO.add(String.format("Raiz única: %.2f", raiz));
        } else {
            double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("A equação possui duas raízes reais: %.2f e %.2f\n\n", raiz1, raiz2);
            HISTORICO.add(String.format("Raízes: %.2f e %.2f", raiz1, raiz2));
        }
    }

    private static void executarIMC() {
        double peso = lerDoubleSafely("Peso: ");
        double altura = lerDoubleSafely("Altura: ");
        double imc = peso / (altura * altura);

        String Status = classificarIMC(imc);

        System.out.printf("Seu IMC: %.2f\nE você esta: %S\n\n", imc, Status);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidade grau I";
        if (imc < 40) return "Obesidade grau II";
        return "Obesidade grau III";
    }

    private static void executarConversaoTemperatura() {
        System.out.println("Digite 1 para F -> C ou 2 para C -> F :");
        int opc = lerInteiroSafely("Sua Escolha: ");
        switch (opc) {
            case 1 -> executarConversaoTemperaturaFC();
            case 2 -> executarConversaoTemperaturaCF();
            default -> System.out.println("Tipo de conversão inválido.\n");
        }
    }

    private static void executarConversaoTemperaturaFC() {
        System.out.println("Entre com a temperatura do F: ");
        double tempF = lerDoubleSafely("F : ");
        double tempC = (tempF - 32.0) * 5.0 / 9.0;
        System.out.printf("Temperatura: %.2f °F → %.2f °C.\n\n", tempF, tempC);
        HISTORICO.add(String.format("Temperatura: %.2f °F → %.2f °C", tempF, tempC));
    }

    private static void executarConversaoTemperaturaCF() {
        System.out.println("Entre com a temperatura do C: ");
        double tempC = lerDoubleSafely("C : ");
        double tempF = tempC * 9.0 / 5.0 + 32.0;
        System.out.printf("Temperatura: %.2f °C → %.2f °F.\n\n", tempC, tempF);
        HISTORICO.add(String.format("Temperatura: %.2f °C → %.2f °F", tempC, tempF));

    }

    private static int lerInteiroSafely(String s) {
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

    private static double lerDoubleSafely(String s) {
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

    private static void exibirMenu() {
        System.out.println("================ Ferramenta Conversora ================");
        System.out.println("1. Temperatura – converter °C ⇄ °F");
        System.out.println("2. IMC – calcular Índice de Massa Corporal");
        System.out.println("3. Bhaskara – resolver ax² + bx + c = 0");
        System.out.println("4. Área do Triângulo – base × altura / 2");
        System.out.println("5. Sair e exibir histórico");
        System.out.println("========================================================");
    }
}