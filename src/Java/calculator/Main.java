package Java.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор запущен");
        System.out.println("Введите через пробел римские или арабские цифры от одного до десяти");
        Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine();
        ConditionCheck conditionChecker = new ConditionCheck(condition);
        String result = Operation.calculateResult(condition,conditionChecker);
        System.out.println(result);
    }



}
