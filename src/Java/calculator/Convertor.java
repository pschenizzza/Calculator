package Java.calculator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Convertor {
    public static String arabToRoman(int arab) {
        Map<String, Integer> roman = new LinkedHashMap<String, Integer>();
        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("D", 500);
        roman.put("CD", 400);
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : roman.entrySet()) {
            int matches = arab / entry.getValue();
            res.append(repeat(entry.getKey(), matches));
            arab = arab % entry.getValue();
        }
        return res.toString();
    }

    private static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s.repeat(Math.max(0, n)));
        return sb.toString();
    }

    public static int convertRomanToArab(String roman) {
        if (roman.isEmpty()) return 0;
        if (roman.startsWith("M")) return 1000 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("CM")) return 900 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("D")) return 500 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("CD")) return 400 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("C")) return 100 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("XC")) return 90 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("L")) return 50 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("XL")) return 40 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("X")) return 10 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("IX")) return 9 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("V")) return 5 + convertRomanToArab(roman.substring(1));
        else if (roman.startsWith("IV")) return 4 + convertRomanToArab(roman.substring(2));
        else if (roman.startsWith("I")) return 1 + convertRomanToArab(roman.substring(1));
        throw new IllegalArgumentException("Не существующее римское число");
    }

    static int romanToArab(String s) {
        if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            return -1;
        }
        return convertRomanToArab(s);
    }
}
