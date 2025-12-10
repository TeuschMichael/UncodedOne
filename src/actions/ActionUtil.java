package actions;

import characters.Character;

public class ActionUtil {

    public Action skipTurn(Character c){
        return () -> c.doNothing();
    }

    public Action attack(Character origin, Character target){
        return () -> origin.dealDamage(origin, target);
    }

}
