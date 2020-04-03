import java.util.ArrayList;

public class SolutionClass {
    private ArrayList searchArray = new ArrayList();

    public SolutionClass() {

    }

    public void createState(String name, State parent,int cannibals,int missionaries) {

       int boat;

       //If parent is on one side, the kid will be on the other side
        if (parent.side == true) {
            boat = 1;
        } else {
            boat=-1;
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

    public void expand(State currentState) {
        int numberOfCannibals = 0;
        int numberOfMissionaries = 0;
        int stateName = 1;

        for(int i = 0; i <= 2; i++) {
            for(int k = 0 ; k <= 2 ; k++) {
                if(i==0 && k==0)
                    continue;
                if(i + k > 2) //if missionaries + cannibals exceed capacity of boat
                    break;
                numberOfCannibals=k;
                numberOfMissionaries=i;
                createState("_" + stateName++, currentState,numberOfCannibals,numberOfMissionaries);
            }

        }


    }


    public ArrayList solution(State s, State g) {
        int levelOfOptimalSolution = 0;
        boolean firstSol = false;
        boolean allSol = false;

        ArrayList solutions = new ArrayList();

        checkAndAddState(s); // add start state in our array

        for(int j = 0; j<searchArray.size();j++) {

            while(!allSol) {
                State currentState=(State)searchArray.get(0); //Begin our search with the root
                searchArray.remove(0);//remove the root from our search array since we will deal with it now

                if(currentState.equals(g)) {
                    if(firstSol == false) { //if this is our first solution
                        firstSol = true;
                        levelOfOptimalSolution=currentState.getStateLevel();
                        solutions.add(currentState);
                    } else { //if this is NOT the first solution found, check the level and compare it with the optimal solution
                        if(currentState.getStateLevel() < levelOfOptimalSolution) {
                            solutions.add(currentState);
                        } else {
                            allSol = true;
                        }
                    }
                } else //if the root is not the solution {
                expand(currentState);

            }

        }

        return solutions;

    }



}
