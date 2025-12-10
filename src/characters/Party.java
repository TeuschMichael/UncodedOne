package characters;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Character> partyMemberList;

    public Party(List<Character> characterList){
        this.partyMemberList = characterList;
    }

    public Party(Character c){
        partyMemberList = new ArrayList<>();
        partyMemberList.add(c);
    }

    public List<Character> getPartyMemberList(){
        return partyMemberList;
    }
}
