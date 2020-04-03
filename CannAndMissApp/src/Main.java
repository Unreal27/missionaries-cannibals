import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        SolutionClass sc = new SolutionClass();
        State s = new State("Root", 3, 3, false, 0);
        State g = new State("Goal", 0, 0, true, 99999);

        ArrayList solutions = sc.solution(s, g);
        print(solutions);

    }

    public static void print(ArrayList sols) {
        for (int k = 0; k < sols.size(); k++) {
            State solution = (State) sols.get(k);
            solution.path();
            System.out.println();
        }
    }

}