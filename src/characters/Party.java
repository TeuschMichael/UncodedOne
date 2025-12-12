package characters;

import items.Item;
import java.util.List;

public class Party {
    private List<Character> partyMemberList;
    private List<Item> partyItemList;

    public Party(List<Character> characterList, List<Item> itemList){
        this.partyMemberList = characterList;
        this.partyItemList = itemList;
    }

    public List<Character> getPartyMemberList(){
        return partyMemberList;
    }

    public List<Item> getPartyItemList(){
        return partyItemList;
    }
}
