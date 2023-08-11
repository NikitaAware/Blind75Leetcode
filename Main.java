import java.util.ArrayList;
import java.util.List;

import Graph.AlienDictionary;
import Graph.CourseSchedule;
import Graph.GraphValidTree;
import Graph.PacificAtlanticOcean;
import Heap.TopKFrequentElements;
import Intervals.InsertInterval;
import Intervals.MeetingRoomsII;
import Intervals.NonOverlappingIntervals;
import StringProblems.LongestSubstringWithoutRepeatingCharacter;

public class Main {
    public static void main(String[] args) {
        /*
         * List<String> crossword = new ArrayList<String>();
         * crossword.add("++++++++++");
         * crossword.add("+------+++");
         * crossword.add("+++-++++++");
         * crossword.add("+++-++++++");
         * crossword.add("+++-----++");
         * crossword.add("+++-++-+++");
         * crossword.add("++++++-+++");
         * crossword.add("++++++-+++");
         * crossword.add("++++++-+++");
         * crossword.add("++++++++++");
         * String words = "POLAND;LHASA;SPAIN;INDIA";
         * CrosswordPuzzle crosswordPuzzle = new CrosswordPuzzle(crossword, words);
         * crosswordPuzzle.result();
         */

        // VirusSpread virusSpread = new VirusSpread(new int[] { 3, 5 }, 6);
        // virusSpread.spread();

        // KMostFrequent kMostFrequent = new KMostFrequent(new int[] {1,1,1,2,2,3}, 2);
        // kMostFrequent.printKMostFrequent();
        // KMostFrequent kMostFrequent2 = new KMostFrequent(new int[] {1},1);
        // kMostFrequent2.printKMostFrequent();

        // ValidParenthesisWithWildcard validParenthesisWithWildcard = new
        // ValidParenthesisWithWildcard(
        // "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        // validParenthesisWithWildcard.validParenthesisWithWildcard();
        // TwoSum twoSum = new TwoSum(new int[] {3, 3}, 6);
        // twoSum.twoSum();
        // BestTimeToBuySellStocks bestTimeToBuySellStocks = new
        // BestTimeToBuySellStocks(new int[] { 7, 1, 5, 3, 6, 4 });
        // bestTimeToBuySellStocks.maxProfit();
        // BestTimeToBuySellStocks bestTimeToBuySellStocks1 = new
        // BestTimeToBuySellStocks(new int[] { 7, 6, 4, 3, 1 });
        // // bestTimeToBuySellStocks1.maxProfit();
        // ContainsDuplicate containsDuplicate = new ContainsDuplicate(new int[] {1, 2,
        // 4, 5});
        // containsDuplicate.containsDuplicate();

        // ContainsDuplicate containsDuplicate1 = new ContainsDuplicate(new int[] {1, 2,
        // 4, 5, 8, 6, 5});
        // containsDuplicate1.containsDuplicate();
        // ProductOfArrayExceptSelf productOfArrayExceptSelf = new
        // ProductOfArrayExceptSelf(new int[] {-1, 1, 0, -3, 3});
        // productOfArrayExceptSelf.productExceptSelf();
        // MaximumSubArray maxSubArray = new MaximumSubArray(new int[] {5,4,-1,7,8});
        // maxSubArray.maxSubarray();

        // MaximumProductSubArray maximumProductSubArray = new
        // MaximumProductSubArray(new int[] { -2, 3, -4 });
        // // maximumProductSubArray.maxProductSubArray();
        // FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new
        // FindMinimumInRotatedSortedArray(new int[] {4,5,6,7,0,1,2});
        // findMinimumInRotatedSortedArray.findMin();
        // SearchInRotatedSortedArray searchInRotatedSortedArray = new
        // SearchInRotatedSortedArray(new int[]{4,5,6,7,0,1,2}, 0);
        // // searchInRotatedSortedArray.search();

        // ThreeSum threeSum = new ThreeSum(new int[] {0, 0, 0});
        // threeSum.threeSumCombinations();

        // ContainerWithMostWater containerWithMostWater = new
        // ContainerWithMostWater(new int[] {1,8,6,2,5,4,8,3,7});
        // containerWithMostWater.findContainerWithMostWater();

        // ClimbStairs climb = new ClimbStairs(3);
        // climb.climbStairs();

        // CoinChange coinChange = new CoinChange(new int[] { 1, 2 }, 1000);
        // coinChange.coinCnt();

        // LongestIncreasingSubsequence longestIncreasingSubsequence = new
        // LongestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18});
        // longestIncreasingSubsequence.longestSubSeqLen();
        // CourseSchedule courseSchedule = new CourseSchedule(new int[][]{{1, 0},{0,
        // 1}}, 2);
        // courseSchedule.isPossible();

        // PacificAtlanticOcean pacificAtlanticOcean = new PacificAtlanticOcean(new
        // int[][] {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4} });
        // pacificAtlanticOcean.reachable();

        // AlienDictionary alienDictionary = new AlienDictionary(new String[] { "wrt",
        // "wrf", "er", "ett", "rftt" });
        // alienDictionary.order();
        // GraphValidTree graph = new GraphValidTree(new int[][] {{0, 1}, {1, 2}, {2,
        // 3}, {1, 3}, {1, 4}}, 5);
        // graph.isValidTree();

        // InsertInterval insertInterval = new InsertInterval(new int[][]{{1, 2}, {3,
        // 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        // insertInterval.insert();

        // TopKFrequentElements topKFrequentElements = new TopKFrequentElements(new
        // int[] {1, 1, 1, 2, 2, 3}, 2);
        // topKFrequentElements.topKFrequent();

        // LongestSubstringWithoutRepeatingCharacter
        // longestSubstringWithoutRepeatingCharacter = new
        // LongestSubstringWithoutRepeatingCharacter();
        // longestSubstringWithoutRepeatingCharacter.printLongestSubstringWithoutRepeatingCharacter("pwwkew");

        MeetingRoomsII meetingRoomsII = new MeetingRoomsII(new int[][]{{7,10}, {2, 4}});
        meetingRoomsII.requiredRooms();
    }
}
