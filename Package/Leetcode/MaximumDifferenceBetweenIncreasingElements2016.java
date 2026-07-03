package Leetcode;

public class MaximumDifferenceBetweenIncreasingElements2016 {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454, 449, 438, 425, 403, 368, 345, 327, 287, 285, 270, 263, 255, 248, 235, 234, 224, 221, 201, 189, 187, 183, 179, 168, 155, 153, 150, 144, 107, 102, 102, 87, 80, 57, 55, 49, 48, 45, 26, 26, 23, 15, 30}));
    }

    public static int maximumDifference(int[] nums) {
        int result = -1;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > previous) {
                result = Math.max(result, nums[i] - previous);
            } else {
                previous = nums[i];
            }
        }
        return result;
    }
}
