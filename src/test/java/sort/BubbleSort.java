package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 冒泡排序
 * 平均时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思路：比较相邻两元素，前面的数大约后面的数，则交换
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param nums 待排序数组
     */
    public void bubbleSort(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 测试用例
     */
    @Test
    public void bubbleSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        bubbleSort(nums);
        Assert.assertArrayEquals(new int[]{4, 5, 7, 23, 43, 44, 66}, nums);
    }

}
