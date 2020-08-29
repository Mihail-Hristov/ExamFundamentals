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

            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex >= startSequence.size() || secondIndex < 0 || secondIndex >= startSequence.size()){
                String elementForAdding = "-" + numberOfMoving + "a";
                int indexForAdding = startSequence.size() / 2;
                startSequence.add(indexForAdding, elementForAdding);
                startSequence.add(indexForAdding, elementForAdding);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (startSequence.get(firstIndex).equals(startSequence.get(secondIndex))){
                String elementForRemoving = startSequence.get(firstIndex);
                int firstIndexForRemoving = Math.max(firstIndex, secondIndex);
                int secondIndexForRemoving = Math.min(firstIndex, secondIndex);
                startSequence.remove(firstIndexForRemoving);
                startSequence.remove(secondIndexForRemoving);
                System.out.println(String.format("Congrats! You have found matching elements - %s!", elementForRemoving));
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
}
