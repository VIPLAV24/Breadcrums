package test_files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import Code_files.stringspractice;

public class tests_string_prac {
    @Test
    public void testlongestCommonPrefix() {
        String[] strings = { "flower", "flow", "flight" };
        assertEquals("fl", stringspractice.longestCommonPrefix(strings));
    }

    @Test
    public void testFirstOccurenceString() {
        assertEquals(3, stringspractice.FirstOccurenceString("butsadbutsad", "sad"));
        assertEquals(0, stringspractice.FirstOccurenceString("sadbutsad", ""));
        assertEquals(-1, stringspractice.FirstOccurenceString("sadbutsad", "sada"));
    }

    @Test
    public void testlengthOfLastWord() {
        assertEquals(5, stringspractice.lengthOfLastWord("Hello World"));
        assertEquals(5, stringspractice.lengthOfLastWord("         Hello World           "));
        assertEquals(1, stringspractice.lengthOfLastWord("a "));
    }

    @Test
    public void testAddBinaryorOthers() {
        assertEquals("100", stringspractice.AddBinaryorOthers("11", "1", 2)); // binary
        assertEquals("45", stringspractice.AddBinaryorOthers("1A", "2B", 16)); // hexadecimal
        assertEquals("35", stringspractice.AddBinaryorOthers("17", "16", 8)); // octal
    }

    @Test
    public void testisPallindrome() {
        assertTrue(stringspractice.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(stringspractice.isPalindrome("race a car"));
        assertTrue(stringspractice.isPalindrome(" "));
    }

    @Test
    public void testconvertToExcelTitle() {
        assertEquals("J", stringspractice.convertToExcelTitle(10));
        assertEquals("ZY", stringspractice.convertToExcelTitle(701));
    }

    @Test
    public void testwordPattern() {
        assertTrue(stringspractice.wordPattern("abba", "dog cat cat dog"));
        assertFalse(stringspractice.wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    public void testReverseString() {
        char[] input = { 'h', 'e', 'l', 'l', 'o' };
        assertEquals("olleh", stringspractice.reverseString(input));
    }

    @Test
    public void testReverseVowelinString() {
        assertEquals("holle", stringspractice.reverseVowels("hello"));
    }

    @Test
    public void testConstructStringwithAnother() {
        assertTrue(stringspractice.ConstructStringwithAnother("aa", "aab"));
        assertFalse(stringspractice.ConstructStringwithAnother("aa", "am"));
    }

    @Test
    public void testfirstUniqChar() {
        assertEquals(0, stringspractice.firstUniqChar("leetcode"));
        assertEquals(2, stringspractice.firstUniqChar("loveleetcode"));
        assertEquals(-1, stringspractice.firstUniqChar("aabb"));
    }
    @Test
    public void testfindAddedCharacter(){
        assertEquals('e',stringspractice.findAddedCharacter("abcd", "abcde"));
        assertEquals('y',stringspractice.findAddedCharacter("", "y"));
    }
}
