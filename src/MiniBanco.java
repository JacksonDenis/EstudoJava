import java.util.ArrayList;
import java.util.List;

public class MiniBanco {
    String senha = "1234"; // A senha teste para rodar aplicacao
    Integer tentativasMaximas = 3; // Limite de tentativas

    private double saldo = 0.0; // Saldo inicial do banco

    private final List<String> HISTORICO = new ArrayList<>(); // Histórico de transações

    public static void main(String[] args) {
        MiniBanco app = new MiniBanco();
        if(!app.autenticar()) return;
        app.menu();
}

    private void menu() {
        boolean executar = true;
        while (executar) {
            System.out.println("\n===== MINI-BANCO =====");
            System.out.println("1) Depositar");
            System.out.println("2) Sacar");
            System.out.println("3) Extrato");
            System.out.println("4) Sair");
            System.out.print("Opção: ");

            int opcao = EntradaDeDados.lerInteiroSafely("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> depositar();
                case 2 -> sacar();
                case 3 -> extrato();
                case 4 -> {
                    System.out.println("Saindo…");
                    executar = false;
                }
                default -> System.out.println("Opção inválida.");
            }

        }
    }

    private void extrato() {
        if (HISTORICO.isEmpty()) {
            System.out.println("Nenhuma transação realizada ainda.");
        } else {
            System.out.println("\n===== EXTRATO =====");
            for (String transacao : HISTORICO) {
                System.out.println(transacao);
            }
            System.out.printf("Saldo atual: R$ %.2f\n", saldo);
        }
    }

    private void sacar() {
        double valor = EntradaDeDados.lerDoubleSafely("Digite o valor a ser sacado:");
        if (valor <= 0) {
            System.out.println("Valor inválido. O saque deve ser maior que zero.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        saldo -= valor;
        HISTORICO.add("Saque: R$ " + valor);
        System.out.printf("Saque realizado com sucesso! Saldo atual: R$ %.2f\n", saldo);
    }

    private void depositar() {
        double valor = EntradaDeDados.lerDoubleSafely("Digite o valor a ser depositado: ");
        if (valor <= 0) {
            System.out.println("Valor inválido. O depósito deve ser maior que zero.");
            return;
        }
        saldo += valor;
        HISTORICO.add("Depósito: R$ " + valor);
        System.out.printf("Depósito realizado com sucesso! Saldo atual: R$ %.2f\n", saldo);
    }

    private boolean autenticar() {
        for (int i = 0; i <= tentativasMaximas; i++) {
            String senhaDigitada = EntradaDeDados.lerStringSafely("Digite a senha: ");
            if (senhaDigitada.equals(senha)) {
                System.out.println("Senha correta! Acesso concedido.");
                return true; // Autenticação bem-sucedida
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
                if (i == tentativasMaximas) {
                    System.out.println("Número máximo de tentativas atingido. Encerrando o programa.");
                    return false; // Autenticação falhou
                }
            }
        }
        return false;
    }
}
