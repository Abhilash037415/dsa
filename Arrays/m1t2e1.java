import java.util.*;

class State {
    int[][] pawns;
    int g, h;
    State parent;

    State(int[][] pawns, int g, int h, State parent) {
        this.pawns = new int[pawns.length][2];
        for (int i = 0; i < pawns.length; i++) {
            this.pawns[i][0] = pawns[i][0];
            this.pawns[i][1] = pawns[i][1];
        }
        this.g = g;
        this.h = h;
        this.parent = parent;
    }

    int f() { return g + h; }
    String encode() {
        String sb = "";
        for (int[] p : pawns) sb+= p[0] + "," + p[1] + ";";
        return sb;
    }
}

class Chessboard {
    int n;

    Chessboard(int n) { this.n = n; }

    int heuristic(int[][] pawns) {
        int h = 0;
        for (int i = 0; i < pawns.length; i++) {
            h += Math.abs(pawns[i][0] - (n-i)) + Math.abs(pawns[i][1] - n);
        }
        return h;
    }

    boolean isGoal(int[][] pawns) {
        for (int i = 0; i < pawns.length; i++) {
            int goalX = n - i, goalY = n;
            if (pawns[i][0] != goalX || pawns[i][1] != goalY) return false;
        }
        return true;
    }

    List<State> getNeighbors(State s) {
        List<State> neighbors = new ArrayList<>();
        int[][] moves = {{0,1},{0,-1},{1,0},{-1,0},{0,0}};
        for (int i = 0; i < s.pawns.length; i++) {
            for (int[] mv : moves) {
                int[][] newPawns = new int[s.pawns.length][2];
                for (int k = 0; k < s.pawns.length; k++) {
                    newPawns[k][0] = s.pawns[k][0];
                    newPawns[k][1] = s.pawns[k][1];
                }
                newPawns[i][0] += mv[0];
                newPawns[i][1] += mv[1];
                if (isValid(newPawns)) {
                    neighbors.add(new State(newPawns, s.g + 1, heuristic(newPawns), s));
                }
            }
        }
        return neighbors;
    }

    boolean isValid(int[][] pawns) {
        Set<String> seen = new HashSet<>();
        for (int[] p : pawns) {
            if (p[0] < 1 || p[0] > n || p[1] < 1 || p[1] > n) return false;
            String key = p[0] + "," + p[1];
            if (!seen.add(key)) return false;
        }
        return true;
    }

    void solve() {
        int[][] start = new int[n][2];
        for (int i = 0; i < n; i++) {
            start[i][0] = i + 1;
            start[i][1] = 1;
        }

        PriorityQueue<State> open = new PriorityQueue<>(Comparator.comparingInt(State::f));
        Set<String> closed = new HashSet<>();

        State startState = new State(start, 0, heuristic(start), null);
        open.add(startState);

        while (!open.isEmpty()) {
            State curr = open.poll();
            if (isGoal(curr.pawns)) {
                printSolution(curr);
                return;
            }
            if (!closed.add(curr.encode())) continue;
            for (State next : getNeighbors(curr)) {
                if (!closed.contains(next.encode())) open.add(next);
            }
        }
        System.out.println("No solution found.");
    }

    void printSolution(State goal) {
        List<State> path = new ArrayList<>();
        while (goal != null) {
            path.add(goal);
            goal = goal.parent;
        }
        Collections.reverse(path);
        int step = 0;
        for (State s : path) {
            System.out.println("Step " + step++);
            for (int[] p : s.pawns) {
                System.out.print("(" + p[0] + "," + p[1] + ") ");
            }
            System.out.println("\n");
        }
    }
}

public class m1t2e1 { //main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        Chessboard cb = new Chessboard(n);
        cb.solve();
    }
}