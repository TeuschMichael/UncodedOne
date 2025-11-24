package actions;

import characters.Character;

public class DoNothing extends Action {
    Character character;

    public void execute(Character a, Character target){
        System.out.println(a.getName() + " did nothing");
    }
}
