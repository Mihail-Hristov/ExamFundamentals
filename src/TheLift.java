import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        String[] liftToString = scanner.nextLine().split(" ");
        int[] lift = new int[liftToString.length];

        for (int i = 0; i < liftToString.length; i++) {
            lift[i] = Integer.parseInt(liftToString[i]);
        }

        boolean noMoreWaitingPeople = false;

        for (int i = 0; i < lift.length; i++) {
            for (int j = lift[i]; j < 4; j++) {
                waitingPeople --;
                lift[i] ++;
                if (waitingPeople == 0){
                    noMoreWaitingPeople = true;
                    break;
                }
            }
            if (noMoreWaitingPeople){
                break;
            }
        }

        boolean isNotFull = false;

        for ( int state : lift) {
            if (state < 4){
                isNotFull = true;
            }
        }

        if (waitingPeople > 0){
            System.out.println(String.format("There isn't enough space! %d people in a queue!", waitingPeople));
        }else if (noMoreWaitingPeople && isNotFull ){
            System.out.println("The lift has empty spots!");
        }

        for (int i = 0; i < lift.length; i++) {
            System.out.print(lift[i] + " ");
        }
    }
}
