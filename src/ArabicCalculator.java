public class ArabicCalculator implements Arithmetical {

    @Override
    public String summarize(String digitA, String digitB) {
        return String.valueOf(Integer.parseInt(digitA) + Integer.parseInt(digitB));
    }

    @Override
    public String subtract(String digitA, String digitB) {
        return String.valueOf(Integer.parseInt(digitA) - Integer.parseInt(digitB));
    }

    @Override
    public String multiplication(String digitA, String digitB) {
        return String.valueOf(Integer.parseInt(digitA) * Integer.parseInt(digitB));
    }

    @Override
    public String division(String digitA, String digitB) {
        //no reason for check division by zero
        int result = Integer.parseInt(digitA) / Integer.parseInt(digitB);

        return String.valueOf(result);
    }
}
