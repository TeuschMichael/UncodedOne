package Battle;

import actions.Action;
import actions.ActionUtil;
import characters.Character;
import characters.Party;
import characters.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Battle{
    private Party playerParty;
    private Party enemyParty;
    private BattleAI playerAI;
    private BattleAI enemyAi;
    private int gameMode;
    protected ActionUtil actionUtil = new ActionUtil();
    private boolean isDead;


    public Battle(Party p, Party e, int gameMode){
        this.playerParty = p;
        this.enemyParty = e;
        this.playerAI = new BattleAI(p, e);
        this.enemyAi = new BattleAI(e, p);
        this.gameMode = gameMode;
    }


    public void executeBattle() {

        List<Character> orderList = orderOfBattle();

        while (shouldContinue()){
            for (Character c : orderList){

                isDead = deathCheck();
                if (!shouldContinue()) return;

                System.out.println("It's " + c.getName() + "'s " + " turn...");

                modeSelector(c);

                System.out.println();
                sleep();

            }
        }
    }

    public Action playerChoice(Character character, Character enemy, Party targetParty){
        Scanner input = new Scanner(System.in);

        System.out.println("Please choose an Action: ");
        System.out.println("1: Skip turn.");
        System.out.println("2: Attack.");

        //TODO still have to implement check for right input
        int inputNum = input.nextInt();

        Action action;

        switch (inputNum){
            case 1:  action = actionUtil.skipTurn(character);
                break;
            case 2: action = actionUtil.attack(character, enemy, targetParty);
                break;
            default: action = actionUtil.skipTurn(character);
        }
        return action;
    }

    public void sleep(){
        try {
            Thread.sleep(500);
        } catch (Exception e){
            System.out.println("Thread Exception");
        }
    }


    public boolean deathCheck(){

        if(playerParty.getPartyMemberList().isEmpty()) {
            System.out.println("The adventurers have been defeated.");
            return true;
            }

        if (enemyParty.getPartyMemberList().isEmpty()){
            System.out.println("The enemy party has been defeated!!");
            return true;
        }
        return false;
    }

    public boolean shouldContinue(){
        if (isDead == true){
            return false;
        }
        return true;
    }

    public void modeSelector(Character c){
        if(gameMode == 2 && c instanceof Player){
            playerAI.takeAction(c).execute();
        } else if (c instanceof Player){
            playerChoice(c, enemyParty.getPartyMemberList().get(0), enemyParty).execute();
        } else if (gameMode == 3 && !(c instanceof Player)) {
            playerChoice(c, playerParty.getPartyMemberList().get(0), playerParty).execute();
        } else if (!(c instanceof Player)){
            enemyAi.takeAction(c).execute();
        }
    }

    public List<Character> orderOfBattle() {
        List<Character> battleList = new ArrayList<>();
        Iterator<Character> playerIT = playerParty.getPartyMemberList().iterator();
        Iterator<Character> enemyIT = enemyParty.getPartyMemberList().iterator();

        while (playerIT.hasNext() || enemyIT.hasNext()){
            if (playerIT.hasNext()) battleList.add(playerIT.next());
            if (enemyIT.hasNext()) battleList.add(enemyIT.next());
        }
        return battleList;
    }
}
