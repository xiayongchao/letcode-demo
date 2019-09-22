package org.eve.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eve.framework.list.ListNode;
import org.eve.framework.tree.TreeNode;

import java.io.IOException;
import java.util.List;

/**
 * @author xiayc
 * @date 2018/7/12
 */
public class Utils {
    /**
     * 广度优先
     *
     * @param root
     */
    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    public static TreeNode buildTree(Integer... array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        buildTree(root, 0, array);
        return root;
    }

    private static void buildTree(TreeNode node, int i, Integer... array) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < array.length) {
            node.left = array[l] == null ? null : new TreeNode(array[l]);
            if (node.left != null) {
                buildTree(node.left, l, array);
            }
        }
        if (r < array.length) {
            node.right = array[r] == null ? null : new TreeNode(array[r]);
            if (node.right != null) {
                buildTree(node.right, r, array);
            }
        }
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode convertArrayToListNode(int... arr) {
        ListNode head = null, node = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new ListNode(arr[i]);
                node = head;
            } else {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
        }
        return head;
    }

    public static ListNode convertListToListNode(List<Integer> list) {
        ListNode head = null, node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == list.size() - 1) {
                head = new ListNode(list.get(i));
                node = head;
            } else {
                node.next = new ListNode(list.get(i));
                node = node.next;
            }
        }
        return head;
    }

    public static void print(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] newIntArray(int... array) {
        return array;
    }

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> valueType) {
        try {
            return JSON_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(List<Character> list) {
        return null;
    }
}
