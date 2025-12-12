package battle;

import actions.Action;
import actions.ActionUtil;
import characters.Character;
import characters.Party;
import java.util.Random;


public class BattleAI {

    Party party;
    Party targetParty;
    Random random;


    public BattleAI(Party p, Party t){
        this.party = p;
        this.targetParty = t;
        random = new Random();

    }

    // change bound on 'choice' as more choices are added
    public Action takeAction(Character c){
        int choice = random.nextInt(2);
        Character enemy = targetParty.getPartyMemberList().get(0);
        ActionUtil actionUtil = new ActionUtil();
        Action action;

        if(c.getCurrentHP() < c.getMaxHP() / 2 && random.nextInt(3) == 2){
            action = actionUtil.useItem(c, party);
        } else {
            switch (choice) {
                case 0:
                    action = actionUtil.skipTurn(c);
                    break;
                case 1:
                    action = actionUtil.attack(c, enemy, targetParty);
                    break;
                case 2:
                    action = actionUtil.useItem(c, party);
                    break;
                default:
                    action = actionUtil.skipTurn(c);
            }
        }
        return action;
    }
}
