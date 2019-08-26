package sort;

/**
 * 选择排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思路：一个数与另外的数分别比较，前面的数大于后面的数则交换两数位置，
 * 每循环一次获取一个最小值，依次获取最小值组成排序数组
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param nums 待排序数组
     */
    public void selectionSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 测试用例
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {43, 23, 4, 66, 7, 5, 44};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

}
