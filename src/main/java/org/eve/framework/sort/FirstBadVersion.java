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
public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        first_error_version = 1;


        System.out.println(new FirstBadVersion().firstBadVersion(4));
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, v = left + (right - left) / 2, fev = 0;
        while (left <= v && v <= right) {
            if (isBadVersion(v)) {
                right = v;
                fev = v;
                if (left == right) {
                    break;
                }
                v = left + (right - left) / 2;
            } else {
                left = v;
                if (right - left == 1) {
                    left = right;
                    v = right;
                } else {
                    v = left + (right - left) / 2;
                }
            }
        }
        return fev;
    }
}
