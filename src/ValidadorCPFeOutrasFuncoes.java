import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidadorCPFeOutrasFuncoes {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<String> HISTORICO = new ArrayList<>();
    
    public static void main(String[] args) {
        int opc;
        do {
            exibirMenuMultifunçoes();
            opc = EntradaDeDados.lerInteiroSafely("Escolha uma opção: ");
            switch (opc) {
                case 1 -> validarCPF();
                case 2 -> converterSegundos();
                case 3 -> tabuadaFormatada();
                case 4 -> relatorioVendas();
                case 5 -> EntradaDeDados.encerrarAplicacao(HISTORICO);
                default -> System.out.println("Opção inválida\n");
            }
        } while (opc != 5);
    }

    private static void relatorioVendas() {
    }

    private static void tabuadaFormatada() {
        System.out.println("Entre com um numero de 1 a 10 para ver a tabuada:");
        int numero = EntradaDeDados.lerInteiroSafely("Número: ");
        if (numero < 1 || numero > 10) {
            System.out.println("Número inválido. Deve ser entre 1 e 10.\n");
            return;
        }
        System.out.printf("Tabuada de %d%n", numero);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d x %2d = %3d%n", numero, i, numero * i);
        }
        
    }

    private static void converterSegundos() {
        System.out.println("Digite o número de segundos: ");
        int segundos = EntradaDeDados.lerInteiroSafely("Número de segundos: ");
        if (segundos < 0) {
            System.out.println("Número de segundos não pode ser negativo.\n");
            return;
        }
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int restanteSegundos = segundos % 60;
        System.out.printf("%d segundos equivalem a %d horas, %d minutos e %d segundos.%n%n",
                segundos, horas, minutos, restanteSegundos);
    }

    private static void validarCPF() {
        System.out.println("Digite seu CPF: ");
        String cpf = SCANNER.nextLine().replaceAll("[^0-9]", "");
        if (!cpf.matches("\\d{11}")) {
            System.out.println("CPF Inválido. Digite exatamente 11 dígitos.\n");
            return;
        }
        if (cpf.chars().distinct().count() == 1) {
            System.out.println("CPF inválido. Todos os dígitos são iguais.\n");
            return;
        }

        int soma = 0;

        for(int i = 0, peso = 10 ; i < 9 ; i++, peso--) {
            soma = soma + Character.getNumericValue(cpf.charAt(i)) * peso;
        }

        int resto = soma % 11;
        int digitoEsperado = resto < 2 ? 0 : 11 - resto;

        System.out.printf("1º dígito calculado: %d – %s%n",
                digitoEsperado,
                digitoEsperado == Character.getNumericValue(cpf.charAt(9)) ? "VÁLIDO" : "INVÁLIDO");

    }

    private static void exibirMenuMultifunçoes() {
        System.out.println("===== Ferramenta que valida CPF, Converte segundos, Tabuada e Relatorio =====");
        System.out.println("1. Validar CPF");
        System.out.println("2. Converter segundos");
        System.out.println("3. Tabuada");
        System.out.println("4. Gerar relatório de vendas");
        System.out.println("5. Sair e mostrar histórico");
        System.out.println("============================================================================");
    }
}
