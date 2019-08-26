package sort;

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
        int temp, index = 0;
        //
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    index = j;
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                nums[index] = nums[i];
            }
        }
    }

    /**
     * 测试用例
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

}
