package Java.calculator;

public class ConditionCheck {
    private String condition;

    public String getCondition() {
        return condition;
    }

    public ConditionCheck(String condition) {
        this.condition = condition;

    }

    public String[] getArrayOFValues(String condition) {
        return condition.split(" ");
    }

    public boolean isArabic(String condition) {
        String[] values = getArrayOFValues(condition);
        try {
            int first = Integer.parseInt(values[0]);
            int second = Integer.parseInt(values[2]);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isConditionRight(String condition) {
        String[] values = getArrayOFValues(condition);
        if (values.length != 3) {
            System.out.println("Данные должны быть введены в одну строку через пробел");
            System.out.println("Пример 1 + 3");
            return false;
        }
        if (!isArabic(condition)) {
            try {
                for (int i = 0; i <= values.length; i = i + 2) {
                    if (Convertor.romanToArab(values[i]) <= 0 || Convertor.romanToArab(values[i]) > 10) {
                        System.out.println("Даныне должны быть больше нуля, но меньше десяти");
                        return false;
                    }
                }
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else {
            for (int i = 0; i <= values.length; i = i + 2) {
                if (Integer.parseInt(values[i]) <= 0 || Integer.parseInt(values[i]) > 10) {
                    System.out.println("Даныне должны быть больше нуля, но меньше десяти");
                    return false;
                }
            }
        }
        return true;
    }

}
