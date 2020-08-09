import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([=\\/]{1})(?<place>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        List<String> locations = new ArrayList<>();

        int travelPoints = 0;

        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            String currentLocation = matcher.group("place");
            locations.add(currentLocation);
            int currentPoints = currentLocation.length();

            travelPoints += currentPoints;
        }

        System.out.print("Destinations: ");
        System.out.println(locations.toString().replaceAll("[\\[\\]]",""));

        System.out.println(String.format("Travel Points: %d", travelPoints));

    }
}
