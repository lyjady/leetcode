package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linyongjin
 * @date 2019/11/6 14:13
 */
public class MainTest {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 来源：力扣（LeetCode）
     */
    @Test
    public int[] twoSum(int[] nums, int target) {
        int[] targetArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int number2 = target - number;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (number2 == nums[j]) {
                        targetArr[0] = j;
                        targetArr[1] = i;
                    }
                }
            }
        }
        return targetArr;
    }


    /**
     * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 
     * 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
     *
     * 示例 1:
     *
     * 输入:"-1/2+1/2"
     * 输出: "0/1"
     *  示例 2:
     *
     * 输入:"-1/2+1/2+1/3"
     * 输出: "1/3"
     * 示例 3:
     *
     * 输入:"1/3-1/2"
     * 输出: "-1/6"
     * 示例 4:
     *
     * 输入:"5/3+1/3"
     * 输出: "2/1"
     * 说明:
     *
     * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
     * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
     * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
     * 输入的分数个数范围是 [1,10]。
     * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fraction-addition-and-subtraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void fractionAddition() {
        String espression = "-1/2+1/2+1/3";
        boolean isPlus = true;
        List<Integer> molecularList = new ArrayList<Integer>();
        List<Integer> denominatorList = new ArrayList<Integer>();
        if (espression.indexOf("+") > 0) {
            String[] arr = espression.split("\\+");
            for (int i = 0; i < arr.length; i++) {
                String[] split = arr[i].split("/");
                molecularList.add(Integer.parseInt(split[0].trim()));
                denominatorList.add(Integer.parseInt(split[1].trim()));
            }
        }
        if (espression.indexOf("-") > 0) {
            isPlus = false;
            String[] arr = espression.split("-");
            for (int i = 0; i < arr.length; i++) {
                String[] split = arr[i].split("/");
                molecularList.add(Integer.parseInt(split[0].trim()));
                denominatorList.add(Integer.parseInt(split[1].trim()));
            }
        }
        int molecular = 0;
        int denominator = denominatorList.get(0);
        for (int i = 0; i < molecularList.size(); i++) {
            for (int j = 0; j < denominatorList.size(); j++) {
                if (i != j) {
                    if (isPlus) {
                        molecular += molecularList.get(i) * denominatorList.get(j);
                    } else {
                        molecular -= molecularList.get(i) * denominatorList.get(j);
                        if (i == 0) {
                            molecular *= -1;
                        }
                    }
                }
            }
            if (i < molecularList.size() - 1) {
                denominator *= denominatorList.get(i + 1);
            }
        }
        String result = null;
        result = molecular + "/" + denominator;
        if (molecular == 0) {
            result = "0/1";
        }
        System.out.println(result);
    }
}
