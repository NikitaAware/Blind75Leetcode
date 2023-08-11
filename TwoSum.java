import java.util.HashMap;

public class TwoSum {
    int[] nums;
    int k;

    TwoSum(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }

    public void twoSum() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                System.out.println(map.get(k - nums[i]));
                System.out.println(i);
                return;
            }
            map.put(nums[i], i);
        }
    }
}
