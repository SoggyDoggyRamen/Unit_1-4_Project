import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointSimulator pointGame = new PointSimulator();
        boolean game = true;

        System.out.println("HELLO WELCOME TO POINT SIMULATOR! \nThe goal of the game is to earn as many points as you can. \nPress enter to earn points! \nTo view all commands, enter /cmds ");

        while (game) {
            String result = pointGame.getCmd(scanner.nextLine());
            if (result.equals("ENDGAME")) {
                game = false;
            }
            else {
                System.out.println(result);
            }
        }

    }
}
