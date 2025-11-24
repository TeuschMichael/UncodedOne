import characters.Party;

public class Battle {
    private Party playerParty;
    private Party enemyParty;

    public Battle(Party p, Party e){
        this.playerParty = p;
        this.enemyParty = e;
    }

    public void execute() {
        int turn = 0;
        // nrOfTurns decides the numbers of turns based ont the biggest party size.
        int nrOfTurns = 0
                ;
        if (playerParty.getPartyMemberList().size() > enemyParty.getPartyMemberList().size()){
            nrOfTurns = playerParty.getPartyMemberList().size();
        } else {
            nrOfTurns = enemyParty.getPartyMemberList().size();
        }

        //hard sets nrOFTurns to 5 for test
        nrOfTurns = 5;

        // it outputs 'String' before the second skeletons name but I have no idea why
        while (turn < nrOfTurns){
            for (int i = 0; i < playerParty.getPartyMemberList().size(); i++){

                System.out.println("It's " + playerParty.getPartyMemberList().get(i).getName() + " turn...");
                playerParty.getPartyMemberList().get(i).skipTurn();
                System.out.println();
                System.out.println("It's " + enemyParty.getPartyMemberList().get(i).getName() + " turn...");
                enemyParty.getPartyMemberList().get(i).skipTurn();
                System.out.println();
                try {
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println("Thread Exception");
                }
            }
            turn++;
        }
    }

}
