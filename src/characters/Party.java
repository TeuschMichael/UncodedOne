package characters;

import java.util.List;

public class Party {
    private List<Character> partyMemberList;

    public Party(List<Character> characterList){
        this.partyMemberList = characterList;
    }

    public List<Character> getPartyMemberList(){
        return partyMemberList;
    }
}
