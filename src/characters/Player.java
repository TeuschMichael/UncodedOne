package characters;

public class Player extends Character {

    private int baseDamage = 10;

    public Player(String name){
        super(name);
    }

    public void standardAttack(Character target){
        System.out.println(this.getName() + " used PUNCH on " + target.getName());
    }

}
