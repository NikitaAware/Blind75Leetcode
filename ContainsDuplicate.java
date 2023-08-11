import java.util.HashSet;

public class ContainsDuplicate {
    int[] nums;

    ContainsDuplicate(int[] nums) {
        this.nums = nums;
    }

    public void containsDuplicate() {
        HashSet<Integer> vis = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (vis.contains(nums[i])) {
                System.out.println("Duplicates exist");
                return;
            } else {
                vis.add(nums[i]);
            }
        }
        System.out.println("Duplicates do not exist");
    }
}
