package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindGreatesSumOfArray {

    int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};

    public List<Integer> getTwoSumOfArray() {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length ==0) {
            return null;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                list.add(sum);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        FindGreatesSumOfArray findGreatesSumOfArray = new FindGreatesSumOfArray();
        findGreatesSumOfArray.getTwoSumOfArray().stream().forEach(x -> System.out.print(x + " "));

    }

}
