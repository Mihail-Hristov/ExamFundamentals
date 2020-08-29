import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split(" ");
        List<String> startSequence = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++) {
            startSequence.add(sequence[i]);
        }

        int numberOfMoving = 0;
        boolean youWon = false;

        String input = scanner.nextLine();
        while (!"end".equals(input)){
            String[] token = input.split(" ");
            numberOfMoving ++;
            int firstIndex = Integer.parseInt(token[0]);
            int secondIndex = Integer.parseInt(token[1]);

            if (checkForValidIndexes(startSequence, firstIndex, secondIndex)){

                invalidIndexes(startSequence, numberOfMoving);

            } else if (startSequence.get(firstIndex).equals(startSequence.get(secondIndex))){

                removeElements(startSequence, firstIndex, secondIndex);

            }else if(!startSequence.get(firstIndex).equals(startSequence.get(secondIndex))){
                System.out.println("Try again!");
            }

            if (startSequence.size() < 1){
                System.out.println(String.format("You have won in %d turns!", numberOfMoving));
                youWon = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (!youWon){
            System.out.println("Sorry you lose :(");
            System.out.println(startSequence.toString().replaceAll("[\\[\\],]", ""));
        }

    }

    public static boolean checkForValidIndexes(List<String> sequence, int firstIndex, int secondIndex){
        boolean isNotValid = false;
        if (firstIndex == secondIndex){
            isNotValid = true;
        }else if (firstIndex < 0 || firstIndex >= sequence.size()){
            isNotValid = true;
        }else if (secondIndex < 0 || secondIndex >= sequence.size()){
            isNotValid = true;
        }

        return isNotValid;

    }

    public static void invalidIndexes (List<String> sequence, int numberOfMoving){
        String elementForAdding = "-" + numberOfMoving + "a";
        int indexForAdding = sequence.size() / 2;
        sequence.add(indexForAdding, elementForAdding);
        sequence.add(indexForAdding, elementForAdding);
        System.out.println("Invalid input! Adding additional elements to the board");
    }

    public static void removeElements(List<String> sequence, int firstIndex, int secondIndex){
        String elementForRemoving = sequence.get(firstIndex);
        int firstIndexForRemoving = Math.max(firstIndex, secondIndex);
        int secondIndexForRemoving = Math.min(firstIndex, secondIndex);
        sequence.remove(firstIndexForRemoving);
        sequence.remove(secondIndexForRemoving);
        System.out.println(String.format("Congrats! You have found matching elements - %s!", elementForRemoving));
    }
}
