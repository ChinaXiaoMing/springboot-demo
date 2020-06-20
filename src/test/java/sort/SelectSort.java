package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 选择排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思路：一个数与另外的数分别比较，前面的数大于后面的数则交换两数位置，
 * 每循环一次获取一个最小值，依次获取最小值组成排序数组
 */
public class SelectSort {

    /**
     * 选择排序
     * @param nums 待排序数组
     */
    public void selectionSort(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    /**
     * 选择排序测试用例
     */
    @Test
    public void selectSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        selectionSort(nums);
        Assert.assertArrayEquals(new int[]{4, 5, 7, 23, 43, 44, 66}, nums);
    }

}
