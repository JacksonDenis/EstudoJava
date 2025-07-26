package metodosClasses;

public class ConversorTemperatura {
    public ConversorTemperatura() {
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }
}
