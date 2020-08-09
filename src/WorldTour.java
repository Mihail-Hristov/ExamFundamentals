import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String tripStops = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Travel".equals(input)){
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command){
                case "Add Stop":
                    int indexForAdd = Integer.parseInt(tokens[1]);
                    String stringForAdd = tokens[2];
                    if (chekForValidIndex(tripStops, indexForAdd)){
                        tripStops = addCurrentString(tripStops, indexForAdd, stringForAdd);
                    }
                    System.out.println(tripStops);

                    break;
                case "Remove Stop":
                    int startIndexForRemoving = Integer.parseInt(tokens[1]);
                    int endIndexForRemoving = Integer.parseInt(tokens[2]);
                    if (chekForValidIndex(tripStops, startIndexForRemoving) && chekForValidIndex(tripStops, endIndexForRemoving)){
                        tripStops = removeCurrentString(tripStops, startIndexForRemoving, endIndexForRemoving);
                    }
                    System.out.println(tripStops);

                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    tripStops = switchCurrentString(tripStops, oldString, newString);
                    System.out.println(tripStops);

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("Ready for world tour! Planned stops: %s",tripStops));
    }

    public static boolean chekForValidIndex(String tripStops, int index){
        if (index >= 0 && index < tripStops.length()){
            return true;
        }else {
            return false;
        }
    }

    public static String addCurrentString(String tripStops, int index, String string){
        tripStops = tripStops.substring(0,index) + string + tripStops.substring(index);
        return  tripStops;
    }

    public static String removeCurrentString(String tripStops, int startIndex, int endIndex){
        tripStops = tripStops.substring(0, startIndex) + tripStops.substring(endIndex +1);
        return tripStops;
    }

    public static String switchCurrentString(String tripStops, String oldString, String newString){
        if (tripStops.contains(oldString)){
            tripStops = tripStops.replaceAll(oldString, newString);
        }
        return tripStops;


    }
}
