package Heap;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    int[] nums;
    int k;
    public TopKFrequentElements(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }
    public int[] topKFrequent() {
        PriorityQueue<int[]> frequencies = new PriorityQueue<int[]>((n1, n2) -> n1[1] - n2[1]);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i: map.keySet()) {
            frequencies.add(new int[]{i, map.get(i)});
            if (frequencies.size() > k) {
                frequencies.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!frequencies.isEmpty()) {
            int[] curr = frequencies.poll();
            res[index] = curr[0];
            System.out.println(res[index]);
            index ++;
        }
        return res;
    }
}