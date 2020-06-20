package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/5/19 22:49
 * @Version 1.0
 **/
public class CountSort {

    /**
     * 计数排序
     * 时间复杂度O(m + n)
     * 空间复杂度（n）
     * @param nums
     * @return
     */
    public int[] countSort(int[] nums) {
        int maxValue = getMaxValue(nums);
        int index = 0;
        int[] countArray = new int[maxValue + 1];
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                countArray[i]--;
                nums[index++] = i;
            }
        }
        return nums;
    }

    private int getMaxValue(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    @Test
    public void countSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        int[] sort = new CountSort().countSort(nums);
        Arrays.stream(sort).forEach(x -> System.out.print(x + " "));
    }

}
