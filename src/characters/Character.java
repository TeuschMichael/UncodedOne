package characters;

import actions.Action;

public abstract class Character {

    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void skipTurn() {
        System.out.println( name + " did nothing");
    }

    public void performAction(Action action, Character target) {
        action.execute(this, target);
    }

}
