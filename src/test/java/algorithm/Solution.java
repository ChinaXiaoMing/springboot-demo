package algorithm;

public class Solution {

    public int maxArea(int[] height ) {
        //水面积
        int area = 0;
        //临时变量，用于保留最大面积
        int temp  = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //获取所有面积
                area = Math.min(height[i], height[j]) * (j - i);
                //保留最大面积
                if (area >= temp) {
                    temp = area;
                }
            }

        }
        return temp;
    }

    public static void main(String[] args) {

        int[] height = {2,3,4,5,18,17,6};
        Solution solution = new Solution();
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);

    }

}
