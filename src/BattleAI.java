import actions.Action;
import actions.DoNothing;
import characters.Party;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BattleAI {

    Party party;
    DoNothing doNothing = new DoNothing();

    List<Action> actionList = new ArrayList<>();

    public BattleAI(Party party){
        this.party = party;
        this.actionList = listBuilder();

    }
    //TODO keep adding new Action types to AI
    //TODO maybe make an enum with references to the action classes so i can use a loop?
    private List<Action> listBuilder(){
        List<Action> tempList = new ArrayList<>();
        tempList.add(doNothing);
        return tempList;
    }

    // at this moment the AI chooses a random action, changes will be added later
    public Action execute(int i){
        List<Action> templist = actionList;
        Collections.shuffle(templist);
        party.getPartyMemberList().get(i).performAction(doNothing, party.getPartyMemberList().get(i));
        return templist.get(0);
    }
}
