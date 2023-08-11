// 322. Coin Change
// Medium
// 17.1K
// 385
// Companies
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CoinChange {
    int[] coins;
    int amount;
    CoinChange(int[] coins, int amount) {
        this.coins = coins;
        Arrays.sort(coins);
        this.amount = amount;
      
    }

    public void coinCnt() {
        // can be solved using recursion and memoization or this is a queue based solution
        if (amount == 0) {
            System.out.println(amount);
            return;
        }
        List<Integer> queue = new ArrayList<Integer>();
        for (int i = 0; i < coins.length; i++) {
            // the array is sorted no need to consider the elements that are greater than
            // the desired amount
            if (coins[i] > amount) {
                break;
            }
            queue.add(coins[i]);
        }
        // add separator to the queue
        queue.add(-1);
        int cnt = 1;
        //create a HashSet to memorize the visited amount, if the amount is visited in the earlier steps no need to visit that again to avoid TLE
        HashSet<Integer> visAmount = new HashSet<Integer>();
        while (!queue.isEmpty()) {
            int first = queue.remove(0);
            // separator, increase the count by one i.e one level checked
            if (first == -1) {
                cnt++;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(-1);
            } else {
                // remaining amount
                int remAmount = amount - first;
                if (visAmount.contains(remAmount)) {
                    //no need to traverse this path again if it was traversed using lesser steps
                    continue;
                }
                // if not visited now add to the visited amount
                visAmount.add(remAmount);
                if (remAmount == 0) {
                    System.out.println(cnt);
                    return;
                }
                for (int i = 0; i < coins.length; i++) {
                    // the array is sorted no need to consider the elements that are greater than
                    // the remaining amount
                    if (coins[i] > remAmount) {
                        break;
                    }
                    // first point where you found the exact combination of coins that sum up to the
                    // required amount
                    if (coins[i] == remAmount) {
                        System.out.println(cnt + 1);
                        return;
                    }
                    // add total amount covered
                    queue.add(first + coins[i]);
                }
            }
        }
        // out of queue i.e no combinations found that could sum up to the amount
        System.out.println(-1);
    }
}
