package org.eve.framework.sort;

/**
 * 第一个错误的版本
 * 1,2,3,4,5
 * 3
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 *
 * @author jc
 * @date 2019/9/19 23:10
 */
public class FirstBadVersion_v2 extends VersionControl {
    public static void main(String[] args) {
        first_error_version = 1;
        System.out.println(new FirstBadVersion_v2().firstBadVersion(4));
    }

    public int firstBadVersion(int n) {
        int left = 0, right = n, v;
        while (left < right) {
            v = left + (right - left) / 2;
            if (isBadVersion(v)) {
                right = v;
            } else {
                left = v + 1;
            }
        }
        return left;
    }
}
