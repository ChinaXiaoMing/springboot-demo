package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思路：第一个数作为已排序数组，下一个数从后往前依次比较插入已排序数组组成排序数组
 */
public class InsertionSort {

    /**
     * 插入排序
     * @param nums 待排序数组
     */
    public void insertionSort(int[] nums) {
        int temp = 0;
        //待插入循环
        for (int i = 1; i < nums.length; i++) {
            //已排序数组
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    @Test
    public void insertionSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        insertionSort(nums);
        Assert.assertArrayEquals(new int[]{4, 5, 7, 23, 43, 44, 66}, nums);
    }

}
