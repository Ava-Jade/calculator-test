public class SimpleCalculatorFactory {
    private Arithmetical calculator;

    public void factory(String line) {
        String romeRegex = "(I{1,3}|I?V|VI{0,3}|I?X|X)\\s[+\\-*/]\\s(I{1,3}|I?V|VI{0,3}|I?X|X)";
        String arabicRegex = "([1-9]|10)\\s[+\\-*/]\\s([1-9]|10)";

        String[] args = lineParsing(line);

        if (line.matches(romeRegex)) {
            calculator = new RomeCalculator();

        } else if (line.matches(arabicRegex)) {
            calculator = new ArabicCalculator();

        } else {
            throw new CalculatorArgumentException("Wrong arguments! Try again please");
        }

        switch (args[1]) {
            case "+":
                System.out.println(calculator.summarize(args[0], args[2]));
                break;

            case "-":
                System.out.println(calculator.subtract(args[0], args[2]));
                break;

            case "*":
                System.out.println(calculator.multiplication(args[0], args[2]));
                break;

            case "/":
                System.out.println(calculator.division(args[0], args[2]));
                break;
        }
    }

    private String[] lineParsing(String line) {
        return line.split(" ");
    }

}
