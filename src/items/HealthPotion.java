package items;

import characters.Character;

public class HealthPotion implements Item{
    private final int amountHealed;

    public HealthPotion(){
        this.amountHealed = 10;
    }

    @Override
    public void use(Character c){
       c.heal(amountHealed);
    }
}
