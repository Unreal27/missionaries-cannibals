import java.util.ArrayList;

public class SolutionClass {
    private ArrayList searchArray = new ArrayList();

    public SolutionClass() {

    }

    public void createState(String name, State parent,int cannibals,int missionaries) {

       int boat;

       //If parent is on one side, the kid will be on the other side
        if (parent.side == true) {
            boat = -1;
        } else {
            boat=1;
        }

        String stateName=parent.getName() + name;

        State newState=new State(stateName,parent.numberOfMissionaries + missionaries * boat,parent.numberOfCannibals + cannibals * boat,!parent.side,parent,parent.getStateLevel()+1);

        checkAndAddState(newState);
    }




    //If the state is valid, add it in the array
    public void checkAndAddState(State state) {
        if(state.invalidState() == true) {
            return;
        } else {
            searchArray.add(state);
        }
    }



}
