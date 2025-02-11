package slidingwindow;

public class BestStockTime {

    public static int maxProfit(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    continue;
                }
                max = Math.max(nums[j] - nums[i], max);
            }
        }
        return max;
    }

    public static int maxProfitSlide(int[] nums) {
        int left = 0;
        int max = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] < nums[right]) {
                max = Math.max(max, nums[right] - nums[left]);
            } else {
                left = right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitSlide(new int[]{10, 1, 5, 6, 7, 1}));
    }
}
