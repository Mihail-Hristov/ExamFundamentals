import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsInformation = new HashMap<>();
        Map<String, List<Double>> plantsRating = new HashMap<>();


        for (int i = 0; i < numberOfLines; i++) {
            String inputPlantInformation = scanner.nextLine();
            String[] tokens = inputPlantInformation.split("<->");
            String currentPlant = tokens[0];
            int currentRarity = Integer.parseInt(tokens[1]);

            plantsInformation.putIfAbsent(currentPlant, 0);
            plantsInformation.put(currentPlant, currentRarity);

        }

        String input = scanner.nextLine();

        while (!"Exhibition".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];

            switch (command) {
                case "Rate":
                    String[] tokensForRate = tokens[1].split(" - ");
                    String plantForRate = tokensForRate[0];
                    double rating = Integer.parseInt(tokensForRate[1]);

                    if (plantsInformation.containsKey(plantForRate)) {
                        plantsRating.putIfAbsent(plantForRate, new ArrayList<>());
                        plantsRating.get(plantForRate).add(rating);
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "Update":
                    String[] tokensForUpdate = tokens[1].split(" - ");
                    String plantForUpdate = tokensForUpdate[0];
                    Integer newRarity = Integer.parseInt(tokensForUpdate[1]);

                    if (plantsInformation.containsKey(plantForUpdate)) {
                        plantsInformation.put(plantForUpdate, newRarity);
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "Reset":
                    String plantForReset = tokens[1];

                    if ((plantsInformation.containsKey(plantForReset))) {
                        plantsRating.put(plantForReset, new ArrayList<>());
                    }else {
                        System.out.println("error");
                    }

                    break;
                default:
                    System.out.println("error");
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantsInformation
                .entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(p ->{
                    System.out.print(String.format("- %s; ",p.getKey()));
                    System.out.print(String.format("Rarity: %d; ",p.getValue()));
                    if(plantsRating.containsKey(p.getKey())) {
                        double d = plantsRating
                                .get(p.getKey())
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0);
                        System.out.println(String.format("Rating: %.2f", d));
                    }else {
                        System.out.println("Rating: 0.00");
                    }

                        });
    }
}
