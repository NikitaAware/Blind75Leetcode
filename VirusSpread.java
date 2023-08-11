// question:
// There are n houses in a row numbered from 1 to n. An array infected_houses contains the houses the houses which are infected with a virus. In one step, the virus can spread to only it adjacent houses. Return the total number of unique ways the infection can spread.

// Example 1:
// n = 5, infected_houses = [1,5]
// Possible ways of infection spreading:
// 2->4->3
// 4->2->3

// Answer 2

// Example 2:
// n = 6, infected_houses = [3,5]
// Possible ways of infection spreading:
// 2->4->6->1
// 2->6->4->1
// 4->6->2->1
// 4->2->6->1
// 6->4->2->1
// 6->4->2->1

// Answer 6

import java.util.HashSet;

public class VirusSpread {
    int[] infectedHouses;
    int housesCount;
    HashSet<String> infectedSequences;

    VirusSpread(int[] infectedHouses, int housesCount) {
        this.housesCount = housesCount;
        this.infectedHouses = infectedHouses;
        this.infectedSequences = new HashSet<String>();

    }

    void spreadHelper(HashSet<Integer> infected, String currString) {
        if (infected.size() == housesCount) {
            infectedSequences.add(currString);
            return;
        }
        HashSet<Integer> newInfected = (HashSet<Integer>) infected.clone();
        for (int i : infected) {
            if (i + 1 <= housesCount && !infected.contains(i + 1)) {
                newInfected.add(i + 1);
                String newString = "" + (i + 1);
                if (currString.length() != 0) {
                    newString = currString + "->" + (i + 1);
                }
                spreadHelper(newInfected, newString);
                newInfected.remove(i + 1);
            }
            if (i - 1 > 0 && !newInfected.contains(i - 1)) {
                newInfected.add(i - 1);
                String newString = "" + (i - 1);
                if (currString.length() != 0) {
                    newString = currString + "->" + (i - 1);
                }
                spreadHelper(newInfected, newString);
                newInfected.remove(i - 1);
            }

        }
    }

    public void spread() {
        HashSet<Integer> infected = new HashSet<Integer>();
        for (int i = 0; i < infectedHouses.length; i++) {
            infected.add(infectedHouses[i]);
        }
        spreadHelper(infected, "");
        System.out.println(infectedSequences);
        System.out.println(infectedSequences.size());
    }

}
