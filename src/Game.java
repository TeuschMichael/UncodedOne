import battle.Battle;
import characters.Character;
import characters.Party;
import characters.Player;
import characters.Skeleton;
import characters.UncodedOne;
import items.HealthPotion;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Battle battle;
    Party playerParty;
    Party enemyParty;
    int gameMode;
    List<Item> playerItemList;
    List<Item> enemyItemList;
    List<Character> playerList = new ArrayList<>();
    List<Character> enemyList = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public Game(){
        this.gameMode = setGameMode();
        String playerName = AskFor.line("Player, please enter your name: ");

        playerList.add(new Player(playerName));
        playerItemList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            playerItemList.add(new HealthPotion());
        }


        enemyList.add(new Skeleton("SKELETON"));
        enemyItemList = new ArrayList<>();
        enemyItemList.add(new HealthPotion());

        this.playerParty = new Party(playerList, playerItemList);
        this.enemyParty = new Party(enemyList, enemyItemList);
    }

    public void start(){
        gameLoop();
    }

    public void gameLoop(){

        battle = new Battle(playerParty , enemyParty, gameMode);
        battle.executeBattle();


        enemyList = new ArrayList<>();
        enemyList.add(new Skeleton("SKELETON ONE"));
        enemyList.add(new Skeleton("SKELETON TWO"));

        enemyParty = new Party(enemyList, enemyItemList);

        battle = new Battle(playerParty, enemyParty, gameMode);
        battle.executeBattle();

        enemyList = new ArrayList<>();
        enemyList.add(new UncodedOne());

        enemyParty = new Party(enemyList, enemyItemList);

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
