package Code_files;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
 * java.math.BigInterger lib
 * BigInterger is class helps with addition of binaries and other types
 * BigInteger num1 = new BigInteger(string, base);  base is binary - 2, hexadecimal - 16 basically what we use to convert them and it depend on string ki uske andar kya hai
 * make child and perform actions -> BitInteger sum=num1.add(num2)  (num2 is also string with bin/hexa or more);
 * XOR gate 
 */
public class stringspractice {
    // https://leetcode.com/problems/longest-common-prefix/description/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }

    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
    public static int FirstOccurenceString(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        for (int i = 0; i <= hLength - nLength; i++) {
            int j;
            for (j = 0; j < nLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLength) {
                return i;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/length-of-last-word/
    public static int lengthOfLastWord(String s) {
        s.trim(); // trim all trailing and front spaces //Question was for space removal I wrote
                  // code for all characters
        int LastLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))) {
                LastLength++;
            } else if (LastLength > 0) {
                return LastLength;
            }
        }
        return LastLength;
    }

    // https://leetcode.com/problems/add-binary/
    public static String AddBinaryorOthers(String a, String b, int c) { // description on top
        BigInteger string1 = new BigInteger(a, c);
        BigInteger string2 = new BigInteger(b, c);
        BigInteger sum = string1.add(string2);
        return sum.toString(c);
    }

    // https://leetcode.com/problems/valid-palindrome/description/
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // keeps the only specified [] characters and digits (^)
                                                            // iske baad ke keep
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    // https://leetcode.com/problems/excel-sheet-column-title/description/
    public static String convertToExcelTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            ans.append((char) ((columnNumber) % 26 + 'A')); // eg- 10%26=10+65=J
            columnNumber = (columnNumber) / 26; // 10/26=0 loop end as coloumnumber!>0
        }
        return ans.reverse().toString();
    }

    // https://leetcode.com/problems/word-pattern/description/
    public static boolean wordPattern(String pattern, String s) { // 2 map them map se pattern to word link and then
                                                                  // checked ki vo word hai agar hai toh theek hai else
                                                                  // false

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (reverseMap.containsKey(word))
                    return false;
                map.put(c, word);
                reverseMap.put(word, c);
            }
        }
        return true;
    }

    // https://leetcode.com/problems/reverse-string/description/
    public static String reverseString(char[] s) {
        return new StringBuilder(String.valueOf(s)).reverse().toString();
        /*
         * int lo = 0;
         * int hi = s.length - 1;
         * while(lo < hi){
         * char temp = s[lo];
         * s[lo] = s[hi];
         * s[hi] = temp;
         * lo++;
         * hi--;
         * }
         */
    }

    // https://leetcode.com/problems/reverse-vowels-of-a-string/description/
    public static String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        String vowel = "aeiouAEIOU";
        int i = 0, j = ch.length - 1;
        while (i < j) {
            while (i < j && !(vowel.indexOf(ch[i]) != -1))
                i++;
            while (i < j && !(vowel.indexOf(ch[i]) != -1))
                j--;
            if (i < j) {
                char temp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = temp;
            }
        }
        return new String(ch);
    }

    // https://leetcode.com/problems/ransom-note/description/
    public static boolean ConstructStringwithAnother(String ransomNote, String magazine) {
        HashMap<Character, Integer> magfreq = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magfreq.put(c, magfreq.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!magfreq.containsKey(c) || magfreq.get(c) == 0) {
                return false;
            }
            magfreq.put(c, magfreq.get(c) - 1);
        }
        return true;
    }

    // https://leetcode.com/problems/first-unique-character-in-a-string/description/
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFreq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/find-the-difference/description/
    public static char findAddedCharacter(String s, String t) { // XOR simillar to C++ gives true if and only if 1 input
                                                                // is true 0x0=0 ,0x1or1x0=1 and 1x1=0
        int xor = 0;
        for (char c : s.toCharArray()) // so jo char hai dono mein vo same ascii value ke hai toh 1x1 =0 toh jo bachega
                                       // vo added hai java XOR representation = ^
            xor ^= c;
        for (char c : t.toCharArray())
            xor ^= c;
        return (char) xor;
        /*
         * my code
         * HashMap<Character, Integer> charFreq = new HashMap<>();
         * for (char c : s.toCharArray()) {
         * charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
         * }
         * for (char c : t.toCharArray()) {
         * charFreq.put(c, charFreq.getOrDefault(c, 0) - 1);
         * }
         * for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
         * if (entry.getValue() < 0) {
         * return entry.getKey();
         * }
         * }
         */
    }
}
