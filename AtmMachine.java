import java.util.HashMap;
import java.util.Scanner;

public class currency {

    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        // Step 1: Allow the user to choose the base and target currencies
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Step 2: Fetch real-time exchange rates (mock rates for demonstration)
        fetchExchangeRates();

        // Step 3: Take input from the user for the amount to convert
        System.out.print("Enter the amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Step 4: Convert the amount
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = convertCurrency(amount, exchangeRate);

        // Step 5: Display the result
        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
    }

    private static void fetchExchangeRates() {
        // Mock exchange rates for demonstration purposes
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 103.95);
        // You would replace this with actual code to fetch real-time rates from an API
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        Double baseRate = exchangeRates.get(baseCurrency);
        Double targetRate = exchangeRates.get(targetCurrency);

        if (baseRate == null || targetRate == null) {
            System.out.println("Error: Exchange rates not available for the specified currencies.");
            System.exit(1);  // Exit the program due to an error
        }

        return targetRate / baseRate;
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
