import java.util.Scanner;

public class TheLimitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        StringBuilder newMessage = new StringBuilder();
        newMessage.append(encryptedMessage);

        String input = scanner.nextLine();

        while (!"Decode".equals(input)){
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command){
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    newMessage = moveCommand(newMessage, numberOfLetters);

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];

                    newMessage = insertValue(newMessage, index, value);

                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String newValue = tokens[2];

                    newMessage = changeAll(newMessage, substring, newValue);

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("The decrypted message is: %s", newMessage));

    }

    public static StringBuilder moveCommand(StringBuilder message, int numberOfLetters){

        StringBuilder newMessage = new StringBuilder();
        newMessage.append(message.substring(numberOfLetters));
        newMessage.append(message.substring(0, numberOfLetters));

        return newMessage;
    }

    public static StringBuilder insertValue(StringBuilder message, int index, String value){
        String firstSubstring = message.substring(0, index);
        String secondSubstring = message.substring(index);
        StringBuilder newMessage = new StringBuilder();

        newMessage.append(firstSubstring).append(value).append(secondSubstring);

        return newMessage;
    }

    public static StringBuilder changeAll(StringBuilder message, String substring, String newValue){
        String currentMessage = message.toString();
        while (currentMessage.contains(substring)){
            currentMessage = currentMessage.replace(substring, newValue);
        }

        StringBuilder newMessage = new StringBuilder();
        newMessage.append(currentMessage);
        return newMessage;
    }
}
