import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([#\\|])(?<item>[A-Za-z\\s+]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);

        int howManyDays = 0;
        int calories = 0;

        Matcher matcherForCalories = pattern.matcher(input);

        while (matcherForCalories.find()){
            calories += Integer.parseInt(matcherForCalories.group("calories"));
        }

        howManyDays = calories / 2000;

        System.out.println(String.format("You have food to last you for: %d days!", howManyDays));

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String itemName = matcher.group("item");
            String date = matcher.group("date");
            int calories2 = Integer.parseInt(matcher.group("calories"));

            System.out.println(String.format("Item: %s, Best before: %s, Nutrition: %d", itemName, date, calories2));
        }


    }
}
