import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.TreeNode;

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
        Deque<Integer> deque = new LinkedList<>();
        ListNode current = head1;
        while (current != null) {
            deque.addLast(current.val);
            current = current.next;
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                assertFalse(false);
            }
        }
        assertTrue(true);
    }

    // https://leetcode.com/problems/valid-parentheses/
    @Test
    public void testValidParentheses() {
        String s = "(){}[]"; // modify to check multiple outputs
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else {
                if (deque.isEmpty() || !isValidPair(deque.peek(), ch)) {
                    assertFalse(false);
                }
                deque.pop();
            }
        }
        assertTrue(deque.isEmpty());
    }

    public boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

 /*    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    @Test
    public void testBinaryTreeInorderTraversal() {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
               // root = null;
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        if (root == null) {
            assertNull(root);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.push(current);
                current = current.left;
            }
            current = deque.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
    //code i did on leetcode using recursion
    class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
    */
    //https://leetcode.com/problems/binary-tree-postorder-traversal/
/*  @Test
    public void testPostordrTraversal(){
        class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
}
    }*/
    //https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/*    @Test
    public void testPostordrTraversal(){
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) 
            {
                List<Integer> result = new ArrayList<>();
                if (root != null) {
                    result.add(root.val);
                    result.addAll(preorderTraversal(root.left));
                    result.addAll(preorderTraversal(root.right));
                }
                return result;
            }
        }
    }
*/
    //https://leetcode.com/problems/next-greater-element-i/description/
    @Test
    public void testNextGreaterElement(){
        int[] nums1 = {4,1,2,8,3,5,6,7};
        int[] nums2 = {1,3,2,4,8,5,7,6};
        int[] expected={8,3,4,-1,4,7,-1,-1};
        int[] nextGreater = new int[nums2.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nextGreater.length; i++) {   // -1 se issley kiya kyuki jiska koi greater ni hai uska direct -1 uth jayega
            nextGreater[i] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[i] > nums2[deque.peek()]) {
                nextGreater[deque.pop()] = nums2[i];
            }
            deque.push(i);
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
        assertArrayEquals(result,expected);
    }
    //https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 /* @Test
    public void testNaryPreOrderTraversal(){
        class Solution {
            public List<Integer> preorder(Node root) {
                List<Integer> result = new ArrayList<>();
                if (root != null) {
                    preorderHelper(root, result);
                }
                return result;
            }
            private void preorderHelper(Node node, List<Integer> result) {
                result.add(node.val);
                for (Node child : node.children) {
                    preorderHelper(child, result);
                }
            }
        }
    }*/
    //https://leetcode.com/problems/baseball-game/
    @Test
    public void testBasketballGame(){
        String[] operations = {"5", "2", "C", "D", "+"};
        int expected=30;
        Deque<Integer> deque = new LinkedList<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int top = deque.pollLast();
                int newTop = top + deque.peekLast();
                deque.offerLast(top);
                deque.offerLast(newTop);
            } else if (op.equals("D")) {
                deque.offerLast(2 * deque.peekLast());
            } else if (op.equals("C")) {
                deque.pollLast();
            } else {
                deque.offerLast(Integer.parseInt(op)); // parseInt to convert string to int
            }
        }
        int sum = 0;
        for (int score : deque) {
            sum=sum+score;
        }
        assertEquals(sum,expected);
    }
    //https://leetcode.com/problems/backspace-string-compare/
    @Test
    public void testBackspaceStringCompare(){
        
        String str = "ab#c";
        String expected="ac";
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                deque.offerLast(c);
            } else if (!deque.isEmpty()) {
                deque.pollLast();
            }
        }
        StringBuilder finalString = new StringBuilder();
        while (!deque.isEmpty()) {
            finalString.append(deque.pollFirst());
        }
        assertEquals(finalString.toString(),expected);
    }
/*  //https://leetcode.com/problems/increasing-order-search-tree/
    @Test
    public void testIncreasingOrderSearchTree(){
        class Solution {
            TreeNode prev;
            TreeNode newRoot;
            public TreeNode increasingBST(TreeNode root) {
                prev = null;
                newRoot = null;
                inOrderTraversal(root);
                return newRoot;
            }
            private void inOrderTraversal(TreeNode node) {
                if (node == null) {
                    return;
                }
                inOrderTraversal(node.left);
                if (prev == null) {
                    newRoot = node;
                } else {
                    prev.left = null;
                    prev.right = node;
                }
                prev = node;
                inOrderTraversal(node.right);
            }
        }
    }*/
    //https://leetcode.com/problems/remove-outermost-parentheses/description/
    @Test
    public void testRemoveParanthesis(){
        StringBuilder result = new StringBuilder();
        int balance = 0;
        String str="(()())(())(()(()))";
        String expected="()()()()(())";
        for (char c : str.toCharArray()) {
            if (c == '(') {                         //idea : all left ( = right )
                balance++;          // open pe +
                if (balance > 1) {
                    result.append(c);
                }
            } else {
                balance--;          //closed pe -
                if (balance != 0) {
                    result.append(c);
                }
            }
        }
        assertEquals(result.toString(),expected);
    }
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/1211044920/
    @Test
    public void testRemoveDuplicated(){
        String str="abbaca";
        String expected="ca";
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == c) {
                deque.pollLast();
            } else {
                deque.offerLast(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }
        assertEquals(result.toString(), expected);
    }
}

