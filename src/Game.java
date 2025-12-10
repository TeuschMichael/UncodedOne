import Battle.Battle;
import characters.Party;
import characters.Player;
import characters.Skeleton;
import characters.UncodedOne;

import java.util.Scanner;

public class Game {

    Battle battle;
    Party playerParty;
    Party enemyParty;
    int gameMode;

    Scanner input = new Scanner(System.in);

    public Game(){
        this.gameMode = setGameMode();
        String playerName = AskFor.line("Player, please enter your name: ");
        this.playerParty = new Party(new Player(playerName));
        this.enemyParty = new Party(new Skeleton("Skeleton One"));
    }

    public void start(){
        gameLoop();
    }

    public void gameLoop(){

        battle = new Battle(playerParty , enemyParty, gameMode);
        battle.executeBattle();

        enemyParty = new Party(new Skeleton("SKELETON ONE"), new Skeleton("SKELETON TWO"));
        battle = new Battle(playerParty, enemyParty, gameMode);
        battle.executeBattle();

        enemyParty = new Party(new UncodedOne());

        battle = new Battle(playerParty, enemyParty, gameMode);
        battle.executeBattle();
    }

    public int setGameMode(){
        System.out.println("Please choose your Game Mode: ");
        System.out.println("1: Player vs. Computer.");
        System.out.println("2: Computer vs. Computer");
        System.out.println("3: Player vs. Player.");

        //TODO still have to implement check for right input
        return input.nextInt();
    }

    public int getGameMode(){
        return gameMode;
    }
}
