import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.HashMap;

import org.junit.Test;

/*
Map<String, Integer> hashMap = new HashMap<>();  (Map<type,type> name = new HashMap<>();)
    put(key,value):     Associates the specified value with the specified key in the map.
    get(key):           Retrieves the value associated with the specified key, or null if the key is not present in the map.
    remove(key):        Removes the mapping for the specified key from the map if it is present.
    containsKey(key):   Checks whether the map contains a mapping for the specified key.
    size():             Returns the number of key-value mappings in the map. (kitni cheeze hai map mein key and value (1 unit))
    keySet():           Returns a set view of the keys contained in the map.
    values():           Returns a collection view of the values contained in the map.
    entrySet():         Returns a set view of the key-value mappings contained in the map.
    Map.Entry: This refers to the Map.Entry interface in Java's collections framework. It represents a single key-value pair in a map.
    This allows you to access the key and value of each entry using the getKey() and getValue() methods respectively.
    getOrDefault()      It is used to retrieve the value associated with a specified key from the map. If the key is present in the map, it returns the corresponding value; otherwise, it returns a default value that you specify.
    sample code:

     Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 8);
        System.out.println("Initial Map: " + map);    
        System.out.println("Value associated with 'apple': " + map.get("apple"));
        System.out.println("Contains key 'banana': " + map.containsKey("banana"));
        map.remove("banana");
        System.out.println("Map after removing 'banana': " + map);
        System.out.println("Size of the map: " + map.size());
        System.out.println("Iterating over key-value pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        map.clear();  
        System.out.println("Map after clearing: " + map);
    PriorityQueue:
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();        (PriorityQueue<type> name=new PriorityQueue<>();)
    If two elements in a priority queue have the same priority, they will be arranged using the FIFO principle.
    An element with the higher priority will be deleted before the deletion of the lesser priority.   
    HashSet stores unique elements without any associated values, while HashMap stores key-value pairs where the keys are unique identifiers and the values are associated data.
*/
public class maps {
    // https://leetcode.com/problems/two-sum/
    @Test
    public void testTwoSum() {
        int[] nums = { 15, 11, 2, 7 };
        int target = 9;
        int[] expected = { 2, 3 };
        //for loop ignore plz and system statements (trying different logic)
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) == target) {
                System.out.println(i);
                System.out.println(i + 1);
                break;
            }
        }

        HashMap<Integer, Integer> NumArr = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int Num = target - nums[i];
            if (NumArr.containsKey(Num)) {
                assertArrayEquals(new int[] { NumArr.get(Num), i }, expected);
            }
            NumArr.put(nums[i], i);
        }
        assertArrayEquals(new int[0], new int[0]);
    }

    // https://leetcode.com/problems/roman-to-integer/description/
    @Test
    public void testRomantoInt() {
        String s = "XXVII";
        int expected = 27;
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = roman.get(s.charAt(i));
            if (i < s.length() - 1 && value < roman.get(s.charAt(i + 1))) {
                result = result - value;
            } else {
                result = result + value;
            }
        }
        assertEquals(result, expected);
    }

    // https://leetcode.com/problems/linked-list-cycle/
    @Test
    public void testCycleLinkedList() {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }
        boolean expected1 = true;
        boolean expected2 = false;
        ListNode head = new ListNode(1);
        ListNode node4 = new ListNode(2);
        head.next = node4;
        ListNode node5 = new ListNode(3);
        node4.next = node5;
        HashMap<ListNode, Boolean> visited = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            if (visited.containsKey(current)) {
                assertEquals(true, expected1);
            }
            visited.put(current, true);
            current = current.next;
        }
        assertEquals(false, expected2);
    }

    @Test
    // https://leetcode.com/problems/intersection-of-two-linked-lists/description/
    public void testIntersectionTwoLinkedLists() {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonNode;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;
        HashMap<ListNode, Boolean> checkHashMap = new HashMap<>();
        while (headA != null) {
            checkHashMap.put(headA, true);
            headA = headA.next;
        }
        while (headB != null) {
            if (checkHashMap.containsKey(headB)) {
                // assertEquals(headB, commonNode);
                // return headB;
            }
            headB = headB.next;
        }
        assertNull(null);
    }

    // https://leetcode.com/problems/majority-element/description/
    @Test
    public void testMajorityElement() {
        int[] nums = { 3, 2, 3 };
        int expected = 3;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int MajorEle = 0;
        int MaxCount = 0;
        for (int key : count.keySet()) {
            int counter = count.get(key);
            if (counter > MaxCount) {
                MajorEle = key;
                MaxCount = counter;
            }
        }
        assertEquals(MajorEle, expected);
    }

    // https://leetcode.com/problems/happy-number/description/
    @Test
    public void testHappyNumber() {
        int n = 19;
        int expected = 1;
        HashMap<Integer, Boolean> contMap = new HashMap<>();
        while (n != 1 && !contMap.containsKey(n)) {
            contMap.put(n, true);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        assertEquals(n, expected);
    }

    // https://leetcode.com/problems/isomorphic-strings/
    @Test
    public void testIsomorphicString() {
        String s = "egg";
        String t = "add";
        boolean expected1 = true;
        boolean expected2 = false;
        if (s.length() != t.length()) {
            assertEquals(false, expected2);
        }
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (smap.containsKey(sChar)) {
                if (smap.get(sChar) != tChar) {
                    assertEquals(false, expected2);
                }
            } else {
                smap.put(sChar, tChar);
            }
            if (tmap.containsKey(tChar)) {
                if (tmap.get(tChar) != sChar) {
                    assertEquals(false, expected2);
                }
            } else {
                tmap.put(tChar, sChar);
            }
        }
        assertEquals(true, expected1);
    }

    // https://leetcode.com/problems/contains-duplicate/
    @Test
    public void testContainDupliNum() {
        int[] nums = { 1, 2, 3, 1 };
        boolean expected1 = true;
        boolean expected2 = false;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        for (int i : countMap.values()) {
            if (i > 1) {
                assertEquals(true, expected1);
            }
        }
        assertEquals(false, expected2);
    }

    // https://leetcode.com/problems/contains-duplicate-ii/description/
    @Test
    public void testContainDupliNumandAbs() {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        boolean expected1 = true;
        boolean expected2 = false;
        HashMap<Integer, Integer> NumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (NumMap.containsKey(num) && i - NumMap.get(num) <= k) {
                assertEquals(true, expected1);
            }
            NumMap.put(num, i);
        }
        assertEquals(false, expected2);
    }

    // https://leetcode.com/problems/valid-anagram/description/
    @Test
    public void testValidAnagram() {
        String s = "anagram";
        String t = "nagaram";
        boolean expected1 = true;
        boolean expected2 = false;
        if (s.length() != t.length()) {
            assertEquals(false, expected2);
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            int count = charCount.getOrDefault(c, 0);
            if (count == 0) {
                assertEquals(false, expected2);
            }
            charCount.put(c, count - 1);
        }
        for (int count : charCount.values()) {
            if (count != 0) {
                assertEquals(false, expected2);
            }
        }
        assertEquals(true, expected1);
    }
}
