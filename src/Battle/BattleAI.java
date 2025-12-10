package Battle;

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
    public Action takeAction(int i){
        int choice = random.nextInt(2);
        Character character = party.getPartyMemberList().get(i);
        Character enemy = targetParty.getPartyMemberList().get(i);
        ActionUtil actionUtil = new ActionUtil();
        Action action;

        switch (choice){
            case 0:  action = actionUtil.skipTurn(character);
            break;
            case 1: action = actionUtil.attack(character, enemy);
            break;
            default: action = actionUtil.skipTurn(character);
        }
        return action;
    }
}
