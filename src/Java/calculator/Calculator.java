package Java.calculator;

public class Calculator {
    public static String calculate(String[] condition) {
        int first = Integer.parseInt(condition[0]);
        int second = Integer.parseInt(condition[2]);
        char operaion = condition[1].charAt(0);
        int result = 0;
        switch (operaion) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
            default:
                return "Введён неверный знак";

        }
        return String.valueOf(result);
    }
}
