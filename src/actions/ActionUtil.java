package actions;

import characters.Character;

public class ActionUtil {

    public Action skipTurn(Character c){
        return () -> c.doNothing();
    }

}
