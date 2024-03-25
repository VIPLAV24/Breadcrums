import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/*
    DOUBT ON LINE 74
 * Inorder traversal -> complete left from root then last wale se ek upar then right if element 
                        else back to root and then right in BST
    preorder traversal -> u note the parent node then keep going left and without jumping to your main parent node u go right node of the root node after this u again note the root node and then go to parent root node
 */
public class questions_stacks {
    // https://leetcode.com/problems/palindrome-linked-list/?envType=daily-question&envId=2024-03-22
    @Test
    public void testisPalindrome() {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        if (head1 == null || head1.next == null) {
            assertTrue(true);
        }
        Stack<Integer> stack = new Stack();
        ListNode current = head1;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        current = head1;
        while (!stack.isEmpty()) {
            if (current.val != stack.pop()) {
                assertFalse(false);
            }
            current = current.next;
        }
        assertTrue(true);
    }

    // https://leetcode.com/problems/valid-parentheses/
    @Test
    public void testValidParentheses() {
        String s = "(){}[]";
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isValidPair(stack.peek(), ch)) {
                    assertFalse(false);
                    return;
                }
                stack.pop();
            }
        }
        assertTrue(stack.isEmpty());
    }

    public boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    /*
     * // https://leetcode.com/problems/binary-tree-inorder-traversal/
     * 
     * @Test
     * public void testBinaryTreeInorderTraversal() {
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * 
     * TreeNode() {
     * // root = null;
     * }
     * 
     * TreeNode(int val) {
     * this.val = val;
     * }
     * 
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     * TreeNode root = new TreeNode(1);
     * root.right = new TreeNode(2);
     * root.right.left = new TreeNode(3);
     * if (root == null) {
     * assertNull(root);
     * }
     * Deque<TreeNode> deque = new ArrayDeque<>();
     * TreeNode current = root;
     * 
     * while (current != null || !deque.isEmpty()) {
     * while (current != null) {
     * deque.push(current);
     * current = current.left;
     * }
     * current = deque.pop();
     * System.out.print(current.val + " ");
     * current = current.right;
     * }
     * }
     * //code i did on leetcode using recursion
     * class Solution {
     * public List<Integer> inorderTraversal(TreeNode root) {
     * List<Integer> result = new ArrayList<>();
     * if (root != null) {
     * result.addAll(inorderTraversal(root.left));
     * result.add(root.val);
     * result.addAll(inorderTraversal(root.right));
     * }
     * return result;
     * }
     * }
     */
    // https://leetcode.com/problems/binary-tree-postorder-traversal/
    /*
     * @Test
     * public void testPostordrTraversal(){
     * class Solution {
     * public List<Integer> postorderTraversal(TreeNode root) {
     * List<Integer> result = new ArrayList<>();
     * if (root != null) {
     * result.addAll(postorderTraversal(root.left));
     * result.addAll(postorderTraversal(root.right));
     * result.add(root.val);
     * }
     * return result;
     * }
     * }
     * }
     */
    // https://leetcode.com/problems/binary-tree-preorder-traversal/description/
    /*
     * @Test
     * public void testPostordrTraversal(){
     * class Solution {
     * public List<Integer> preorderTraversal(TreeNode root)
     * {
     * List<Integer> result = new ArrayList<>();
     * if (root != null) {
     * result.add(root.val);
     * result.addAll(preorderTraversal(root.left));
     * result.addAll(preorderTraversal(root.right));
     * }
     * return result;
     * }
     * }
     * }
     */
    // https://leetcode.com/problems/next-greater-element-i/description/
    @Test
    public void testNextGreaterElement() {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] expected = { -1, 3, -1 };
        int[] nextGreater = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nextGreater.length; i++) {
            nextGreater[i] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }
        assertArrayEquals(result, expected);
    }

    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
    /*
     * @Test
     * public void testNaryPreOrderTraversal(){
     * class Solution {
     * public List<Integer> preorder(Node root) {
     * List<Integer> result = new ArrayList<>();
     * if (root != null) {
     * preorderHelper(root, result);
     * }
     * return result;
     * }
     * private void preorderHelper(Node node, List<Integer> result) {
     * result.add(node.val);
     * for (Node child : node.children) {
     * preorderHelper(child, result);
     * }
     * }
     * }
     * }
     */
    // https://leetcode.com/problems/baseball-game/
    @Test
    public void testBaseballGame() {
        String[] operations = { "5", "2", "C", "D", "+" };
        int expected = 30;
        Deque<Integer> stack = new LinkedList<>();
        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int top = stack.pop();
                int newTop = stack.peek() + top;
                stack.push(top);
                stack.push(newTop);
            } else {
                stack.push(Integer.parseInt(op)); // parseInt to convert string to int
            }
        }
        int sum = 0;
        for (int score : stack) {
            sum = sum + score;
        }
        assertEquals(sum, expected);
    }

    // https://leetcode.com/problems/backspace-string-compare/
    @Test
    public void testBackspaceStringCompare() {

        String str = "ab#c";
        String expected = "ac";
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                deque.push(c);
            } else if (!deque.isEmpty()) {
                deque.pop();
            }
        }
        StringBuilder finalString = new StringBuilder();
        while (!deque.isEmpty()) {
            finalString.append(deque.pop());
        }
        assertEquals(finalString.reverse().toString(), expected);
    }

    /*
     * //https://leetcode.com/problems/increasing-order-search-tree/
     * 
     * @Test
     * public void testIncreasingOrderSearchTree(){
     * class Solution {
     * TreeNode prev;
     * TreeNode newRoot;
     * public TreeNode increasingBST(TreeNode root) {
     * prev = null;
     * newRoot = null;
     * inOrderTraversal(root);
     * return newRoot;
     * }
     * private void inOrderTraversal(TreeNode node) {
     * if (node == null) {
     * return;
     * }
     * inOrderTraversal(node.left);
     * if (prev == null) {
     * newRoot = node;
     * } else {
     * prev.left = null;
     * prev.right = node;
     * }
     * prev = node;
     * inOrderTraversal(node.right);
     * }
     * }
     * }
     */
    // https://leetcode.com/problems/remove-outermost-parentheses/description/
    @Test
    public void testRemoveParanthesis() {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        String str = "(()())(())(()(()))";
        String expected = "()()()()(())";
        for (char c : str.toCharArray()) {
            if (c == '(') { // idea : all left ( = right )
                balance++; // open pe +
                if (balance > 1) {
                    result.append(c);
                }
            } else {
                balance--; // closed pe -
                if (balance != 0) {
                    result.append(c);
                }
            }
        }
        assertEquals(result.toString(), expected);
    }

    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/1211044920/
    @Test
    public void testRemoveDuplicated() {
        String str = "abbaca";
        String expected = "ca"; 
        Deque<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        assertEquals(result.reverse().toString(), expected);
    }
}
