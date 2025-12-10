package actions;

import characters.Character;
import characters.Party;

public class ActionUtil {

    public Action skipTurn(Character c){
        return () -> c.doNothing();
    }

    public Action attack(Character origin, Character target, Party targetParty){
        return () -> origin.dealDamage(origin, target, targetParty);
    }

}
