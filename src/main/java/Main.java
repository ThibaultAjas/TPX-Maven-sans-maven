
import bowling.MultiPlayerGame;

/**
 *
 * @author Thibault Ajas
 */
public class Main {

    public static void main(String[] args) {
        String[] players = {"John", "Paul", "Georges", "Ringo"};
        MultiPlayerGame game = new MonImplementation();
        try {
        System.out.println(game.startNewGame(players));
        System.out.println(game.lancer(10)); // Strike for John
        System.out.println(game.lancer(3));
        System.out.println(game.lancer(7)); // Spare for Paul
        System.out.println(game.lancer(0));
        System.out.println(game.lancer(0)); // 0 for Georges
        System.out.println(game.lancer(0));
        System.out.println(game.lancer(0)); // 0 for Ringo
        System.out.println(game.lancer(6));
        System.out.println(game.lancer(3)); // 9 for john, + strike bonus
        System.out.println(game.lancer(5));
        System.out.println(game.lancer(0)); // 5 for Paul, + spare bonus
        for (String playerName : players)
            System.out.printf("Player: %s, score: %d %n",
                    playerName,
                    game.scoreFor(playerName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
