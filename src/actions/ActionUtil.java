package actions;

import characters.Character;
import characters.Party;
import items.HealthPotion;
import items.Item;

public class ActionUtil {

    public Action skipTurn(Character c){
        return () -> c.doNothing();
    }

    public Action attack(Character origin, Character target, Party targetParty){
        return () -> origin.dealDamage(origin, target, targetParty);
    }

    public Action useItem(Character c, Party p){
        return () -> {
            var items = p.getPartyItemList();

            if (!items.isEmpty()) {
                Item item = items.remove(0);
                item.use(c);
            } else {
                System.out.println("No Healing potions left!");
            }
        };
    }
}


