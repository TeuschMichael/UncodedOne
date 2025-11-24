package actions;
import characters.Character;

public abstract class Action {
   public abstract void execute(Character c, Character target);
}
