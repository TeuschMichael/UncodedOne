package Battle;

import actions.Action;
import characters.Party;

public class Battle {
    private Party playerParty;
    private Party enemyParty;
    private BattleAI playerAI;
    private BattleAI enemyAi;

    public Battle(Party p, Party e){
        this.playerParty = p;
        this.enemyParty = e;
        this.playerAI = new BattleAI(p);
        this.enemyAi = new BattleAI(e);
    }


    public void execute() {

        while (!playerParty.getPartyMemberList().isEmpty() || !enemyParty.getPartyMemberList().isEmpty()){
            for (int i = 0; i < playerParty.getPartyMemberList().size(); i++){
                System.out.println("It's " + playerParty.getPartyMemberList().get(i).getName() + " turn...");
                playerAI.takeAction(i).execute();

                System.out.println();

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
