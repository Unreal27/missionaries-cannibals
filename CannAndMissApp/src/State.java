public class State {

    public int numberOfMissionaries;
    public int numberOfCannibals;
    public boolean side;
    private String name;
    private State prev;
    private int stateLevel=0;


    public State(String name, int numberOfMissionaries, int numberOfCannibals, boolean side,
                 State prev, int stateLevel)
    {
        //Assign parameters to local instance fields
        this.name = name;
        this.numberOfMissionaries = numberOfMissionaries;
        this.numberOfCannibals = numberOfCannibals;
        this.side = side;
        this.prev = prev;
        this.stateLevel = stateLevel;
    }

    public int getNumberOfMissionaries() {
        return numberOfMissionaries;
    }

    public void setNumberOfMissionaries(int numberOfMissionaries) {
        this.numberOfMissionaries = numberOfMissionaries;
    }

    public int getNumberOfCannibals() {
        return numberOfCannibals;
    }

    public void setNumberOfCannibals(int numberOfCannibals) {
        this.numberOfCannibals = numberOfCannibals;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getPrev() {
        return prev;
    }

    public void setPrev(State prev) {
        this.prev = prev;
    }

    public int getStateLevel() {
        return stateLevel;
    }

    public void setStateLevel(int stateLevel) {
        this.stateLevel = stateLevel;
    }


    //Method that checks if a state is invalid. Returns true if state is invalid, false if state is valid.
    public boolean invalidState() {

        //first we check that we have valid numbers of missionaries and cannibals
        if(numberOfCannibals < 0 || numberOfCannibals > 3 || numberOfMissionaries < 0 || numberOfMissionaries > 3)
            return true;

        //then we must check that missionaries are not outnumbered by cannibals on each side

        //For the current side
        if(numberOfCannibals>numberOfMissionaries)
            return true;

        //For the other side
        if((3 - numberOfCannibals > 3 - numberOfMissionaries))
            return true;

        //If nothing of the above is true, then the state is valid.

        return false;


    }

    public void path() {
        String temp;
        if(prev != null) {
            prev.path();
        }

        if(side == false) {
            temp="<-Boat is on the left";
        } else {
            temp="Boat is on the right->";
        }

        System.out.print(numberOfMissionaries + "M" + " " + numberOfCannibals + "C" + " " + temp + (3 - numberOfMissionaries)+ "M" + " " +(3- numberOfCannibals) + "C");



    }


}
