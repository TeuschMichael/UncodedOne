package characters;

import java.util.Random;

public class Skeleton extends Character {
    Random random = new Random();
    int baseDamage = random.nextInt(2);

    public Skeleton(String name){
        super(name);
    }

    public void standardAttack(Character target){
        System.out.println(this.getName() + " used BONE CRUNCH on " + target.getName());
    }
}
