package Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.function;

public class CombineFunction {
    public static void main(String[] args) {
        Meteo meteo = new Meteo(10);

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d / 5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

        System.out.println("Meteo is F " + readFahrenheit.apply(meteo));


    }
}
