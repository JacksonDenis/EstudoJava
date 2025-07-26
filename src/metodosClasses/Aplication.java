package metodosClasses;

public class Aplication {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5, 10);
        System.out.println(retangulo);

        ConversorTemperatura temperatura = new ConversorTemperatura();
        double celsius = 25;
        double fahrenheit = temperatura.celsiusToFahrenheit(celsius);
        System.out.printf("%.2f graus Celsius é igual a %.2f graus Fahrenheit\n", celsius, fahrenheit);

        Relogio relogio = new Relogio(23, 59, 59);
        relogio.tic();
        relogio.tic();
        relogio.tic();
        System.out.println("Relógio inicial: " + relogio);
        relogio.tic();
        relogio.tic();
        relogio.tic();
        System.out.println("Relógio inicial: " + relogio);

        Login login = new Login( "senha123");
        if (login.autenticar( "senha123")) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha no login.");
        }


    }
}
