package Java.calculator;

public class Operation {
    public static String calculateResult(String condition, ConditionCheck conditionChecker) {
        String result = "неверные данные";
        String[] values = conditionChecker.getArrayOFValues(condition);
        if (conditionChecker.isConditionRight(condition)) {
            if (conditionChecker.isArabic(condition)) {
                result = Calculator.calculate(values);
            } else {
                values[0] = String.valueOf(Convertor.romanToArab(values[0]));
                values[2] = String.valueOf(Convertor.romanToArab(values[2]));
                result = Convertor.arabToRoman(Integer.parseInt(Calculator.calculate(values)));
            }
        }
        return result;
    }
}
