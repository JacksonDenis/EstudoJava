package metodosClasses;

public class Retangulo {
    private final double base;
    private final double altura;

    public Retangulo(double base, double altura) {
        if ( base <= 0 || altura <= 0 ) {
            throw new IllegalArgumentException("Base e altura devem ser maiores que zero.");
        }
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    };
    public double perimetro() {
        return 2 * (base + altura);
    }
    public double diagonal() {
        return Math.sqrt(base * base + altura * altura);
    }

    @Override
    public String toString() {
        return String.format("Retângulo [base=%.2f, altura=%.2f, área=%.2f, perímetro=%.2f, diagonal=%.2f]",
                base, altura, area(), perimetro(), diagonal());
    }
}
