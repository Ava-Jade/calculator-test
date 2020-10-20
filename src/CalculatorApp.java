import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args){

        try (Scanner scanner = new Scanner(System.in))  {
            while (true) {
                String line = scanner.nextLine();

                if (line.equals("!exit")) {
                    return;
                }

                SimpleCalculatorFactory simpleCalculatorFactory = new SimpleCalculatorFactory();
                simpleCalculatorFactory.factory(line);
            }
        }
    }
}
