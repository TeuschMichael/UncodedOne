package Battle;

import characters.Character;
import characters.Party;

public class Battle {
    private Party playerParty;
    private Party enemyParty;
    private BattleAI playerAI;
    private BattleAI enemyAi;

    public Battle(Party p, Party e){
        this.playerParty = p;
        this.enemyParty = e;
        this.playerAI = new BattleAI(p, e);
        this.enemyAi = new BattleAI(e, p);
    }


    public void executeBattle() {

        outerloop:
        while (!playerParty.getPartyMemberList().isEmpty() || !enemyParty.getPartyMemberList().isEmpty()){
            for (int i = 0; i < playerParty.getPartyMemberList().size(); i++){
                if(playerParty.getPartyMemberList().isEmpty()) {
                    System.out.println("The player party has been defeated.");
                    break outerloop;
                }
                System.out.println("It's " + playerParty.getPartyMemberList().get(i).getName() + " turn...");
                playerAI.takeAction(i).execute();

                System.out.println();

                if(enemyParty.getPartyMemberList().isEmpty()) {
                    System.out.println("The enemy party has been defeated!!");
                    break outerloop;
                }

                System.out.println("It's " + enemyParty.getPartyMemberList().get(i).getName() + " turn...");
                enemyAi.takeAction(i).execute();

                System.out.println();

                try {
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println("Thread Exception");
                }
            }
        }
    }
}
