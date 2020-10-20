import java.util.HashMap;
import java.util.Map;

public class RomeCalculator implements Arithmetical {
    private final static Map<String, Integer> romeDigits;

    static {
        romeDigits = new HashMap<>();

        romeDigits.put("I", 1);
        romeDigits.put("II", 2);
        romeDigits.put("III", 3);
        romeDigits.put("IV", 4);
        romeDigits.put("V", 5);
        romeDigits.put("VI", 6);
        romeDigits.put("VII", 7);
        romeDigits.put("VIII", 8);
        romeDigits.put("IX", 9);
        romeDigits.put("X", 10);
    }

    @Override
    public String summarize(String digitA, String digitB) {
        int result = romeDigits.get(digitA) + romeDigits.get(digitB);
        return romeDigitsTransformer(result);
    }

    @Override
    public String subtract(String digitA, String digitB) {
        int result = romeDigits.get(digitA) - romeDigits.get(digitB);
        return romeDigitsTransformer(result);
    }

    @Override
    public String multiplication(String digitA, String digitB) {
        int result = romeDigits.get(digitA) * romeDigits.get(digitB);
        return romeDigitsTransformer(result);
    }

    @Override
    public String division(String digitA, String digitB) {
        //no reason for check division by zero
        int result = romeDigits.get(digitA) / romeDigits.get(digitB);
        // Rome guys don't have zero, sorry
        if(result == 0) {
            return "¯\\_(ツ)_/¯";
        }

        return romeDigitsTransformer(result);
    }

    private String romeDigitsTransformer(int arabicDigits) {
        StringBuilder stringBuilder = new StringBuilder();

        if (arabicDigits == 100) {
            return "C";
        }

        if(arabicDigits < 100 && arabicDigits >= 90) {
            return stringBuilder.append("XC").append(getRomeDigitKey(arabicDigits % 10)).toString();

        }

        if (arabicDigits < 90 && arabicDigits >= 50) {
            stringBuilder.append("L");

            stringBuilder.append("X".repeat((arabicDigits - 50) / 10));

            return stringBuilder.append(getRomeDigitKey(arabicDigits % 10)).toString();

        }

        if (arabicDigits < 50 && arabicDigits >= 40) {
            return stringBuilder.append("XL").append(getRomeDigitKey(arabicDigits % 10)).toString();
        }

        if (arabicDigits < 40 && arabicDigits > 10) {
            return stringBuilder.append("X".repeat(arabicDigits / 10))
                    .append(getRomeDigitKey(arabicDigits % 10)).toString();
        }

        if (arabicDigits <= 10) {
            return getRomeDigitKey(arabicDigits);
        }

        return stringBuilder.toString();
    }

    private String getRomeDigitKey(Integer value) {
        String key = "";

        for(Map.Entry<String,Integer> entry : romeDigits.entrySet()) {

            if(value == entry.getValue()) {
                key = entry.getKey();
            }

        }
        return key;
    }

}
