package Battle;

import actions.Action;
import actions.ActionUtil;
import characters.Character;
import characters.Party;
import java.util.Random;


public class BattleAI {

    Party party;
    Random random;


    public BattleAI(Party p){
        this.party = p;
        random = new Random();

    }

    // change bound on 'choice' as more choices are added
    public Action takeAction(int i){
        int choice = random.nextInt(1);
        Character c = party.getPartyMemberList().get(i);
        ActionUtil actionUtil = new ActionUtil();
        Action action;

        switch (choice){
            case 0:  action = actionUtil.skipTurn(c);
            break;
            default: action = actionUtil.skipTurn(c);
        }
        return action;
    }
}
