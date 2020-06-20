package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description 快速排序实现
 * @Author xiaoming
 * 思路：从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @Date 2020-03-19 22:13:52
 * @Version 1.0
 **/
public class QuickSort {

    public void quickSort(int[] nums) {
        int index = partition(nums, 1, nums.length);
    }

    public int partition(int[] nums, int left, int right) {
        int index = nums[left];
        return index;
    }

    @Test
    public void quickSortTest() {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        quickSort(nums);
        Assert.assertArrayEquals(new int[]{4, 5, 7, 23, 43, 44, 66}, nums);
    }

}
