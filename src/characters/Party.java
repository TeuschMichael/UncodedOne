package characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Party {
    private List<Character> partyMemberList;

    public Party(List<Character> characterList){
        this.partyMemberList = characterList;
    }

    public Party(Character... characterList){
        partyMemberList = new ArrayList<>();
        partyMemberList.addAll(Arrays.asList(characterList));
    }

    public List<Character> getPartyMemberList(){
        return partyMemberList;
    }
}
