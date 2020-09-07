import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String regexForDigit = "^-?[0-9]+$";
        Pattern patternForDigit = Pattern.compile(regexForDigit);

        String regexForFloating = "^-?[0-9]+\\.[0-9]+$";
        Pattern patternForFloating = Pattern.compile(regexForFloating);

        String regexForChar = "^[^0-9]$";
        Pattern patternForChar = Pattern.compile(regexForChar);

        while (!"END".equals(input)){
            Matcher matcherForDigit = patternForDigit.matcher(input);
            Matcher matcherForFloating = patternForFloating.matcher(input);
            Matcher matcherForChar = patternForChar.matcher(input);
            String lowerInput = input.toLowerCase();
            if (matcherForDigit.find()){
                System.out.println(String.format("%s is integer type", input));
            }else if (matcherForFloating.find()){
                System.out.println(String.format("%s is floating point type", input));
            } else if (matcherForChar.find()){
                System.out.println(String.format("%s is character type", input));
            } else if ("true".equals(lowerInput) || "false".equals(lowerInput)) {
                System.out.println(String.format("%s is boolean type", input));
            } else {
                System.out.println(String.format("%s is string type", input));
            }

            input = scanner.nextLine();
        }
    }
}
