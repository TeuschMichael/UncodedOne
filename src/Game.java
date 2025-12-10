import Battle.Battle;
import characters.Party;
import characters.Player;
import characters.Skeleton;

import java.util.Scanner;

public class Game {

    Battle battle;
    Party playerParty;
    Party enemyParty;
    private int turn;

    Scanner input = new Scanner(System.in);

    public Game(){
        //this.playerParty = partyBuilder(input.nextLine());
        String playerName = AskFor.line("Player, please enter your name: ");
        this.playerParty = new Party(new Player(playerName));
        this.enemyParty = new Party(new Skeleton("Skeleton One"));
        this.turn = 1;

    }

    public void start(){

        gameLoop();
    }

    public void gameLoop(){
        System.out.println("Game turn: " + turn);
        //Demo battle for the assignment
        battle = new Battle(playerParty , enemyParty);
        battle.executeBattle();

    }
}
