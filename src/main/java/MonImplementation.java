
import bowling.MultiPlayerGame;
import bowling.SinglePlayerGame;
import java.util.ArrayList;

/**
 *
 * @author Thibault Ajas
 */
public class MonImplementation implements MultiPlayerGame {

    private ArrayList<SinglePlayerGame> players;
    private int it;

    public MonImplementation() {
        this.players = new ArrayList();
        this.it = 0;
    }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if (playerName.equals(null) || playerName.length == 0)
            throw new Exception("Tableau de joueurs vide ou null.");
        for (String pn : playerName)
            this.players.add(new SinglePlayerGame(pn));
        final SinglePlayerGame currentP = this.players.get(it);
        return String.format("Prochain tir : joueur %s, tour n° %d, boule n° %d",
                currentP,
                currentP.getFrameNumber(),
                currentP.getNextBallNumber());
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if (this.players.equals(null) || this.players.size() == 0)
            throw new Exception("La partie n'est pas démarrée.");
        final SinglePlayerGame currentP = this.players.get(it);
        currentP.lancer(nombreDeQuillesAbattues);
        if (currentP.hasCompletedFrame())
            this.it++;
        if (this.players.get(this.players.size() - 1).isFinished())
            return "Partie terminée.";
        return String.format("Prochain tir : joueur %s, tour n° %d, boule n° %d",
                currentP,
                currentP.getFrameNumber(),
                currentP.getNextBallNumber());
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        if (!isPlayerInDaGame(playerName))
            throw new Exception("Ce joueur n'existe pas.");
        for (SinglePlayerGame g : this.players)
            if (g.getPlayerName().equals(playerName))
                return g.score();
        return 0;
    }

    private boolean isPlayerInDaGame(String pn) {
        boolean tmp = false;
        for (SinglePlayerGame g : this.players)
            if (g.getPlayerName().equals(pn))
                tmp = true;
        return tmp;
    }
}
