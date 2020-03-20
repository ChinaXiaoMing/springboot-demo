package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description 快速排序实现
 * @Author xiaoming
 * @Date 2020-03-19 22:13:52
 * @Version 1.0
 **/
public class QuickSort {

    public void quickSort(int[] nums) {
        int index = partition(nums, 1, nums.length);
    }

    public int partition(int[] nums, int left, int right) {
        int temp,index = 0;
        for (int i = left; i < right; i++) {
            if (nums[index] > nums[i]) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return index;
    }

    @Test
    public void quickSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        quickSort(nums);
        Assert.assertArrayEquals(new int[]{4, 5, 7, 23, 43, 44, 66}, nums);
    }

}
