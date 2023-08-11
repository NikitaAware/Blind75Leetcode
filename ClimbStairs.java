// 70. Climbing Stairs
// Easy
// 19.3K
// 624
// Companies
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

import java.util.HashSet;

public class ClimbStairs {
    int n;
    HashSet<String> res;
    // it has a map solution check it whenever you have time
    ClimbStairs(int n) {
        this.res = new HashSet<String>();
        this.n = n;
    }

    public void climb(int tot, String curr) {
        if (tot == n) {
           // System.out.println(curr);
            res.add(curr);
            return;
        }
        if (tot > n) {
            return;
        }
        climb(tot + 1, curr + "->" + 1); // climb 1 steps
        climb(tot + 2, curr + "->" + 2); // climb 2 steps
    }
    public void climbStairs() {
        climb(1, "1");
        climb(2, "2");
        System.out.println(res);
    }
}