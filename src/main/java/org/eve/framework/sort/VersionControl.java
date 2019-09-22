package org.eve.framework.sort;

/**
 * @author jc
 * @date 2019/9/19 23:11
 */
public class VersionControl {
    public static int first_error_version = 0;

    boolean isBadVersion(int version) {
        return version >= first_error_version;
    }
}
