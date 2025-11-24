import characters.Character;
import characters.Party;
import characters.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Game {

    Battle battle;
    Party playerParty;
    Party enemyParty;
    private int turn;

    public Game(){
        this.playerParty = partyBuilder("Skeleton One");
        this.enemyParty = partyBuilder("String Skeleton Two");
        this.turn = 1;

    }
    //TODO change later to accept either player or enemy depending on choice.
    public Party partyBuilder(String name){
        List<Character> partyList = new ArrayList<>();
        Character c = new Skeleton(name);
        partyList.add(c);
        Party party = new Party(partyList);
        return party;
    }

    public void start(){
        gameLoop();
    }

    public void gameLoop(){
        System.out.println("Game turn: " + turn);
        //Demo battle for the assignment
        Battle battle1 = new Battle(playerParty , enemyParty);
        battle1.execute();

    }
}
