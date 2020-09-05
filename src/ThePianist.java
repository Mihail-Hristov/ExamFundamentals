import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, String> piecesAndComposer = new TreeMap<>();
        Map<String, String> piecesAndKey = new HashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String pieces =  input[0];
            String composer = input[1];
            String key = input[2];

            piecesAndComposer.putIfAbsent(pieces, composer);
            piecesAndKey.putIfAbsent(pieces,key);
        }

        String inputCommand = scanner.nextLine();
        while (!"Stop".equals(inputCommand)){
            String[] tokens = inputCommand.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];

            switch (command){
                case "Add":
                    String composerForAdding = tokens[2];
                    String keyForAdding = tokens[3];
                    if (piecesAndComposer.containsKey(piece)){
                        System.out.println(String.format("%s is already in the collection!", piece));
                    }else {
                        piecesAndComposer.putIfAbsent(piece, composerForAdding);
                        piecesAndKey.putIfAbsent(piece, keyForAdding);
                        System.out.println(String.format("%s by %s in %s added to the collection!", piece, composerForAdding, keyForAdding));
                    }

                    break;
                case "Remove":
                    if (piecesAndComposer.containsKey(piece)){
                        piecesAndComposer.remove(piece);
                        piecesAndKey.remove(piece);
                        System.out.println(String.format("Successfully removed %s!", piece));
                    }else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }

                    break;
                case "ChangeKey":
                    String neyKey = tokens[2];
                    if (piecesAndComposer.containsKey(piece)){
                        piecesAndKey.put(piece, neyKey);
                        System.out.println(String.format("Changed the key of %s to %s!", piece, neyKey));
                    }else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }

                    break;
            }

            inputCommand = scanner.nextLine();
        }

        piecesAndComposer
                .entrySet()
                .forEach(p -> {
                    System.out.print(String.format("%s -> Composer: %s", p.getKey(), p.getValue()));
                    String keyForPrint = piecesAndKey.get(p.getKey());
                    System.out.println(String.format(", Key: %s", keyForPrint));
                });

    }
}
