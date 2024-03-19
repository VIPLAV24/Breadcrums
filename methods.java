import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//errors wait resolving till night
public class methods 
{
/*
* String operations

charAt() 	            char deta hai kis position pe hai 	
codePointAt() 	        unicode deta hai index pe jo char hai	
codePointBefore() 	    char ke piche wale ka unicode deta hai
codePointCount() 	    Returns the number of Unicode values found in a string. 
compareTo() 	        // 0 for equal , -ve if str1<str2, +ve if str1>str2 (lexicographically)(unicode based) 	
compareToIgnoreCase() 	Compares two strings lexicographically, ignoring case differences 
concat() 	            Appends a string to the end of another string 
contains() 	            Checks whether a string contains a sequence of characters 
contentEquals() 	    Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer 
copyValueOf() 	        Returns a String that represents the characters of the character array 	
endsWith() 	            Checks whether a string ends with the specified character(s) 	
equals() 	            Compares two strings. Returns true if the strings are equal, and false if not
equalsIgnoreCase() 	    Compares two strings, ignoring case considerations 
format() 	            Returns a formatted string using the specified locale, format string, and arguments 
getBytes() 	            Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array 	
getChars() 	            Copies characters from a string to an array of chars
hashCode() 	            Returns the hash code of a string 
indexOf() 	            Returns the position of the first found occurrence of specified characters in a string 
intern() 	            Returns the canonical representation for the string object 
isEmpty() 	            Checks whether a string is empty or not
lastIndexOf() 	        Returns the position of the last found occurrence of specified characters in a string 
length() 	            Returns the length of a specified string
matches() 	            Searches a string for a match against a regular expression, and returns the matches 
offsetByCodePoints() 	Returns the index within this String that is offset from the given index by codePointOffset code points
regionMatches() 	    Tests if two string regions are equal 
replace() 	            Searches a string for a specified value, and returns a new string where the specified values are replaced 
replaceFirst() 	        Replaces the first occurrence of a substring that matches the given regular expression with the given replacement 
replaceAll() 	        Replaces each substring of this string that matches the given regular expression with the given replacement
split() 	            Splits a string into an array of substrings 
startsWith() 	        Checks whether a string starts with specified characters 
subSequence() 	        Returns a new character sequence that is a subsequence of this sequence 
substring() 	        Returns a new string which is the substring of a specified string 	
toCharArray() 	        Converts this string to a new character array 	
toLowerCase() 	        Converts a string to lower case letters 
toString() 	            Returns the value of a String object 	
toUpperCase() 	        Converts a string to upper case letters 
trim() 	                Removes whitespace from both ends of a string 
valueOf() 	            Returns the string representation of the specified value

* Integer operations
   * -- Integer.toString(int) -- returns String
   * -- Integer.toBinaryString(int) -- returns binary String
   * -- Integer.toHexString(int) -- returns hexadecimal String
   * -- parseInt returns int whereas valueOf returns Integer
   * -- Integer.parseInt(String) -- returns int value
   * -- Integer.parseInt(String, base) -- will parse value based on the base

*/


static char charAt() 
{
    String strp = "Hello";
    return strp.charAt(0); //returns char at index
}
static int codePointAt(String str, int index) 
{
    return str.codePointAt(index);//f() jo char ka unicode deta hai
} 
static int codePointBefore(String str, int index) 
{
    return str.codePointBefore(index);  //f() jo char pe pahucha uske piche wale ka unicode deta hai
}
static void codePointCount()
{
    String strp = "Hqwedqwe";
    int result = strp.codePointCount(0, 5);    //f() jo 2 index ke beech mein kitne unicode hai vo batata hai
    System.out.println(result);
    //test class left
}
static void compareTo()
{
    String strp1 = "Hell";
    String strp2 = "Hello";
    System.out.println(strp1.compareTo(strp2)); // 0 for equal , -ve if str1<str2, +ve if str1>str2
    //test class left
}
static void compareToIgnoreCase()
{
    String strp1 = "Hell";
    String strp2 = "Hello";
    System.out.println(strp1.compareToIgnoreCase(strp2)); // ignore upper and lower case, 0 for equal , -ve if str1<str2, +ve if str1>str2
    //test class left
}
static void concat()
{
    String str1 = "VIP ";
    String str2 = "lav";
    System.out.println(str1.concat(str2)); //join 2 strings
    //test class left
}
static void contains()
{
    String strp = "Hello";
    System.out.println(strp.contains("Hel"));   // true
    System.out.println(strp.contains("e"));     // true
    System.out.println(strp.contains("Hi"));    // false // check kart hai ki string mein ye hai ki nahi
    //test class left
}
static void contentEquals()
{
    String strp = "Hello";
    System.out.println(strp.contentEquals("Hello"));  // true
    System.out.println(strp.contentEquals("e"));      // false
    System.out.println(strp.contentEquals("Hi"));     // false // search exact same sequence in string
    //test class left
}
@SuppressWarnings("static-access")
static void copyValueOf()
{
    char[] strp1 = {'H', 'e', 'l', 'l', 'o'};
    String strp2 = "";
    strp2 = strp2.copyValueOf(strp1, 0, 5);
    System.out.println("Returned String: " + strp2); // str2 mein str1 ki value daal di hai 0-5 index ka
    //test class left
}
static void startsWith()
{
    String strp = "Hello";
    System.out.println(strp.startsWith("Hel"));   // true
    System.out.println(strp.startsWith("llo"));   // false
    System.out.println(strp.startsWith("o"));     // false 
    //test class left
}
static void endsWith()
{
    String strp = "Hello";
    System.out.println(strp.endsWith("Hel"));   // false
    System.out.println(strp.endsWith("llo"));   // true
    System.out.println(strp.endsWith("o"));     // true // string ending with the specified pattern
    //test class left
}
static void equals()
{
    String strp1 = "Hello";
    String strp2 = "Hello";
    String strp3 = "Another String";
    System.out.println(strp1.equals(strp2)); // Returns true because they are equal
    System.out.println(strp1.equals(strp3)); // false // compares 2 strings case sensitive
    //test class left
}
static boolean equalsIgnoreCase(String str1, String str2) 
{
    return str1.equalsIgnoreCase(str2); // compares 2 strings not case sensitive
}
static String format(String str) 
{
    return str;
}
static byte[] getBytes(String str) 
{
    return str.getBytes();
}
static char[] getChars(String str, int srcBegin, int srcEnd, char[] dest, int destBegin) 
{
    try {
        str.getChars(srcBegin, srcEnd, dest, destBegin);
        return dest;
    } catch (Exception ex) {
        System.out.println(ex);
        return new char[0];
    }
}
static int indexOf(String str, String searchStr) 
{
    return str.indexOf(searchStr);      // char ki pehli occurence batata hai
}
static boolean isEmpty(String strp) 
{
    return strp.isEmpty();         // string empty or not
}
static int length(String txt) 
{
    return txt.length();    //length of string
}
static String replace(String strp, char oldChar, char newChar) 
{
    return strp.replace(oldChar, newChar);             // char ko replace karta hai string mein
}
static String replaceFirst(String strp, String regex, String replacement) 
{
    return strp.replaceFirst(regex, replacement);  // string mein first occuerence ko change karta hai dusre se
}
static String replaceAll(String strp, String regex, String replacement) 
{
    return strp.replaceAll(regex, replacement);        // string mein first occuerence ko change karta hai dusre se
}
static String[] split(String str, String regex, int limit) 
{
    return str.split(regex, limit); // string ko substring mein todhta hai '@' pe todega and '3' string mein aur in dono ki jagaj "samplestring" pe bhi tod sakte ho
}
static String subSequence(String Str, int start, int end) 
{
    return Str.subSequence(start, end).toString();          // ye 0 se n-1 tak jata hai inke beech ke chars print karega
}
static String substring(String Str, int startIndex) 
{
    return Str.substring(startIndex);           // 0 se lekar end tak ke substrings and 0,6 bhi kar sakte hai
}
static char[] toCharArray(String s) 
{
    return s.toCharArray();      // string ko char [] banata
}
static String toLowerCase(String txt) 
{
    return txt.toLowerCase();  // string ko lowercase
}
static String toUpperCase(String txt) 
{
    return txt.toUpperCase();  // string ko uppercase
}
static String isPalindrome(String str) 
{
    StringBuilder str1 = new StringBuilder(str);
    str1.reverse();                                       //checks pallindrome by reversing and putting it equals to given string
    if (str.equals(str1.toString())) {
        return "palindrome";
    } else {
        return "Not palindrome";
    }
}

public class testing
{
    @Test
    public void testCharAt() 
    {
        String s = "Hello";
        char expectedOutput = 'H'; // Expected character at pos 0
        assertEquals(expectedOutput, charAt());
    }
    public void testCodePointAt() 
    {
        String strp1 = "Hello";
        int expectedOutput1 = 101; // Expected Unicode value of 'e'(acc to google)
        assertEquals(expectedOutput1, codePointAt(strp1, 1));
        String strp2 = "World";
        int expectedOutput2 = 111; // Expected Unicode value of 'o' (acc to google)
        assertEquals(expectedOutput2, codePointAt(strp2, 2));
    }
    public void testCodePointBefore() 
    {
        String strp1 = "Hello";
        int expectedOutput1 = 108; // Expected Unicode value of 'l'
        assertEquals(expectedOutput1, codePointBefore(strp1, 3));
        String strp2 = "World";
        int expectedOutput2 = 108; // Expected Unicode value of 'l'
        assertEquals(expectedOutput2, codePointBefore(strp2, 4));
    }
    public void testStringBuilder() 
    {
        String str1 = "MADAM";
        String expectedOutput1 = "palindrome";
        assertEquals(expectedOutput1, isPalindrome(str1));
        String str2 = "HELLO";
        String expectedOutput2 = "Not palindrome";
        assertEquals(expectedOutput2, isPalindrome(str2));
    }
    public void testToUpperCase() 
    {
        String txt1 = "Hello World";
        String expectedOutput1 = "HELLO WORLD";
        assertEquals(expectedOutput1, toUpperCase(txt1));
        String txt2 = "hello";
        String expectedOutput2 = "HELLO";
        assertEquals(expectedOutput2, toUpperCase(txt2));
    }
    public void testToLowerCase() 
    {
        String txt1 = "HELLO WORLD";
        String expectedOutput1 = "hello world";
        assertEquals(expectedOutput1, toLowerCase(txt1));
        String txt2 = "HELLO";
        String expectedOutput2 = "hello";
        assertEquals(expectedOutput2, toLowerCase(txt2));
    }
    public void testToCharArray() 
    {
        String s1 = "HELLOW";
        char[] expectedOutput1 = {'H', 'E', 'L', 'L', 'O', 'W'};
        assertArrayEquals(expectedOutput1, toCharArray(s1));
        String s2 = "world";
        char[] expectedOutput2 = {'w', 'o', 'r', 'l', 'd'};
        assertArrayEquals(expectedOutput2, toCharArray(s2));
    }
    public void testSubstring() 
    {
        String Str1 = "HELLOW HI BYE";
        String expectedOutput1 = "HELLOW HI BYE";
        assertEquals(expectedOutput1, substring(Str1, 0));
        String Str2 = "Programming is fun";
        String expectedOutput2 = "gramming is fun";
        assertEquals(expectedOutput2, substring(Str2, 3));
    }
    public void testSubSequence() 
    {
        String Str1 = "Welcomeqwe to HELLOW";
        String expectedOutput1 = "Welcome";
        assertEquals(expectedOutput1, subSequence(Str1, 0, 7));
        String Str2 = "Hello World";
        String expectedOutput2 = "Hello";
        assertEquals(expectedOutput2, subSequence(Str2, 0, 5));
    }
    public void testSplit() 
    {
        String str1 = "HELLOW@bye@hi@hello";
        String[] expectedOutput1 = {"HELLOW", "bye", "hi@hello"};
        assertArrayEquals(expectedOutput1, split(str1, "@", 3));
        String str2 = "Java@Programming@Language";
        String[] expectedOutput2 = {"Java", "Programming", "Language"};
        assertArrayEquals(expectedOutput2, split(str2, "@", 5));
    }
    public void testReplaceAll() 
    {
        String strp1 = "Hello Hellow HI HI HI";
        String strp2 = "CHANGE";
        String expectedOutput1 = "Hello Hellow CHANGE CHANGE CHANGE";
        assertEquals(expectedOutput1, replaceAll(strp1, "HI", strp2));
        String strp3 = "The cat and the hat";
        String strp4 = "dog";
        String expectedOutput2 = "The cat and the hat";
        assertEquals(expectedOutput2, replaceAll(strp3, "dog", strp4));
    }
    public void testReplaceFirst() 
    {
        String strp1 = "Hello Hellow HI HI";
        String strp2 = "CHANGE";
        String expectedOutput1 = "Hello Hellow CHANGE HI";
        assertEquals(expectedOutput1, replaceFirst(strp1, "HI", strp2));
        String strp3 = "The cat and the cat";
        String strp4 = "dog";
        String expectedOutput2 = "The cat and the dog";
        assertEquals(expectedOutput2, replaceFirst(strp3, "cat", strp4));
    }
    public void testReplace() 
    {
        String strp1 = "HeLLo";
        String expectedOutput1 = "Heppo";
        assertEquals(expectedOutput1, replace(strp1, 'L', 'p'));
        String strp2 = "Programming is fun";
        String expectedOutput2 = "Programming is fun";
        assertEquals(expectedOutput2, replace(strp2, 'x', 'y'));
    }
    public void testLength() 
    {
        String txt1 = "ABCDEFGHIJKLMNO";
        int expectedOutput1 = 15;
        assertEquals(expectedOutput1, length(txt1));
        String txt2 = "";
        int expectedOutput2 = 0;
        assertEquals(expectedOutput2, length(txt2));
    }
    public void testIsEmpty() 
    {
        String myStr1 = "Hello";
        boolean expectedOutput1 = false;
        assertEquals(expectedOutput1, isEmpty(myStr1));
        String myStr2 = "";
        boolean expectedOutput2 = true;
        assertEquals(expectedOutput2, isEmpty(myStr2));
    }
    public void testFormat() 
    {
        String str1 = "HELLO";
        String expectedOutput1 = "My Company name is HELLO";
        assertEquals(expectedOutput1, format(str1));   // Concatenation of two strings
        String str2 = String.format("My answer is %.8f", 47.65734);
        String expectedOutput2 = "My answer is 47.65734000";    // Output is given upto 8 decimal places
        assertEquals(expectedOutput2, format(str2));
        String str3 = String.format("My answer is %15.8f", 47.65734);  // Here answer is supposed to be %15.8f" and "47.65734000" there are 15 spaces
        String expectedOutput3 = "My answer is      47.65734000";
        assertEquals(expectedOutput3, format(str3));
    }
    public void testGetChars() 
    {
        String str1 = "HELLOW !!! NO";
        char[] destArray1 = new char[20];
        char[] expectedOutput1 = {'H', 'E', 'L', 'L', 'O', 'W', ' ', '!', '!', ' ', 'N', 'O'};
        assertArrayEquals(expectedOutput1, getChars(str1, 0, 12, destArray1, 0));
        String str2 = "Hello World";
        char[] destArray2 = new char[20];
        char[] expectedOutput2 = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        assertArrayEquals(expectedOutput2, getChars(str2, 0, 11, destArray2, 0));
    }
    public void testIndexOf() 
    {
        String str1 = "Hello Bellow bye TIE";
        int expectedOutput1 = 14; // Expected index of "bye" in the string 
        assertEquals(expectedOutput1, indexOf(str1, "bye"));
        String str2 = "Programming is fun";
        int expectedOutput2 = -1; // "dog" not present in the string ()
        assertEquals(expectedOutput2, indexOf(str2, "dog"));
    }
    public void testGetBytes() 
    {
        String str1 = "HELLOW";
        byte[] expectedOutput1 = {72, 69, 76, 76, 79, 87}; // ASCII values of the characters in "HELLOW"
        assertArrayEquals(expectedOutput1, getBytes(str1));
        String str2 = "Java is fun";
        byte[] expectedOutput2 = {74, 97, 118, 97, 32, 105, 115, 32, 102, 117, 110}; // ASCII values of the characters in "Java is fun"
        assertArrayEquals(expectedOutput2, getBytes(str2));
    }
    public void testEqualsIgnoreCase() 
    {

        String str1 = "Hello";
        String str2 = "HELLO";
        boolean expectedOutput1 = true;
        assertEquals(expectedOutput1, equalsIgnoreCase(str1, str2));
        String str3 = "Another String";
        boolean expectedOutput2 = false;
        assertEquals(expectedOutput2, equalsIgnoreCase(str1, str3));
    }


}

public static void main(String[] args) 
    {
        charat();
        codePointAt();
        codePointBefore();
        codePointCount();
        compareTo();
        compareToIgnoreCase();
        concat();
        contains();
        contentEquals();
        copyValueOf();
        endsWith();
        equals();
        equalsIgnoreCase();
        format();
        getBytes();
        getChars();
        indexOf();
        isEmpty();
        length();
        replace();
        replaceFirst();
        replaceAll();
        split();
        startsWith();
        subSequence();
        substring();
        toCharArray();
        toLowerCase();
        toUpperCase();
        StringBuilder();
    }
}
