public class methods 
{
/*

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
*/

static void charat() 
{
    String myStr = "Hello";
    char result = myStr.charAt(0); //f() jo char ki posi deta hai
    System.out.println(result);
    //test class left
}
static void codePointAt() 
{
    String myStr = "Hello";
    int result = myStr.codePointAt(1); //f() jo char ka unicode deta hai
    System.out.println(result);
    //test class left
}
static void codePointBefore()
{
    String myStr = "Hello";
    int result = myStr.codePointBefore(3); //f() jo char ke piche wale ka unicode deta hai
    System.out.println(result);
    //test class left
}
static void codePointCount()
{
    String myStr = "Hqwedqwe";
    int result = myStr.codePointCount(0, 5);    //f() jo 2 index ke beech mein kitne unicode hai vo batata hai
    System.out.println(result);
    //test class left
}
static void compareTo()
{
    String myStr1 = "Hell";
    String myStr2 = "Hello";
    System.out.println(myStr1.compareTo(myStr2)); // 0 for equal , -ve if str1<str2, +ve if str1>str2
    //test class left
}
static void compareToIgnoreCase()
{
    String myStr1 = "Hell";
    String myStr2 = "Hello";
    System.out.println(myStr1.compareToIgnoreCase(myStr2)); // ignore upper and lower case, 0 for equal , -ve if str1<str2, +ve if str1>str2
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
    String myStr = "Hello";
    System.out.println(myStr.contains("Hel"));   // true
    System.out.println(myStr.contains("e"));     // true
    System.out.println(myStr.contains("Hi"));    // false // check kart hai ki string mein ye hai ki nahi
    //test class left
}
static void contentEquals()
{
    String myStr = "Hello";
    System.out.println(myStr.contentEquals("Hello"));  // true
    System.out.println(myStr.contentEquals("e"));      // false
    System.out.println(myStr.contentEquals("Hi"));     // false // search exact same sequence in string
    //test class left
}
@SuppressWarnings("static-access")
static void copyValueOf()
{
    char[] myStr1 = {'H', 'e', 'l', 'l', 'o'};
    String myStr2 = "";
    myStr2 = myStr2.copyValueOf(myStr1, 0, 5);
    System.out.println("Returned String: " + myStr2); // str2 mein str1 ki value daal di hai 0-5 index ka
    //test class left
}
static void startsWith()
{
    String myStr = "Hello";
    System.out.println(myStr.startsWith("Hel"));   // true
    System.out.println(myStr.startsWith("llo"));   // false
    System.out.println(myStr.startsWith("o"));     // false 
    //test class left
}
static void endsWith()
{
    String myStr = "Hello";
    System.out.println(myStr.endsWith("Hel"));   // false
    System.out.println(myStr.endsWith("llo"));   // true
    System.out.println(myStr.endsWith("o"));     // true // string ending with the specified pattern
    //test class left
}
static void equals()
{
    String myStr1 = "Hello";
    String myStr2 = "Hello";
    String myStr3 = "Another String";
    System.out.println(myStr1.equals(myStr2)); // Returns true because they are equal
    System.out.println(myStr1.equals(myStr3)); // false // compares 2 strings case sensitive
    //test class left
}
static void equalsIgnoreCase()
{
    String myStr1 = "Hello";
    String myStr2 = "HELLO";
    String myStr3 = "Another String";
    System.out.println(myStr1.equalsIgnoreCase(myStr2)); // true
    System.out.println(myStr1.equalsIgnoreCase(myStr3)); // false // compares 2 strings not case sensitive
    //test class left
}
static void format()
{
    String str = "HELLO";
 
    // Concatenation of two strings
    String s
        = String.format("My Company name is %s", str);

    // Output is given upto 8 decimal places
    String str2
        = String.format("My answer is %.8f", 47.65734);

    // Here answer is supposed to be %15.8f" and
    // "47.65734000" there are 15 spaces
    String str3 = String.format("My answer is %15.8f",47.65734);

    // Print and display strings
    System.out.println(s);
    System.out.println(str2);
    System.out.println(str3);
    //test class left
}
static void getBytes()
{
        // Declaring and initializing a string
        String str = "HELLOW";
 
        // Displaying string values before conversion
        System.out.println(
            "The String before conversion is : ");
        System.out.println(str);
 
        // Converting the string into byte
        // using getBytes() method
        byte[] b = str.getBytes();
 
        // Display message only
        System.out.println(
            "The String after conversion is : ");
 
        // Printing converted string after conversion
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
    //test class left
}
static void getChars()
{
    String str = "HELLOW !!! NO";
 
    char[] destArray = new char[20];
    try {
        str.getChars(0, 12, destArray, 0);
        System.out.println(destArray);
    }
    catch (Exception ex) {
        System.out.println(ex);
    }
    //test class left
}
static void indexOf()
{
    String myStr = "Hello Bellow bye TIE";
    System.out.println(myStr.indexOf("bye")); // char ki pehli occurence batata hai
    //test class left
}
static void isEmpty()
{
    String myStr1 = "Hello";
    String myStr2 = "";
    System.out.println(myStr1.isEmpty());
    System.out.println(myStr2.isEmpty()); // string empty or not
    //test class left
}
static void length()
{
    String txt = "ABCDEFGHIJKLMNO";
    System.out.println(txt.length()); //length of string
    //test class left
}
static void replace()
{
    String myStr = "HeLLo";
    System.out.println(myStr.replace('L', 'p')); // char ko replace karta hai string mein
    //test class left
}
static void replaceFirst()
{
    String myStr = "Hello Hellow HI HI";
    String myStr2 = "CHANGE";
    System.out.println(myStr.replaceFirst("HI", myStr2)); // string mein first occuerence ko change karta hai dusre se
    //test class left
}
static void replaceAll()
{
    String myStr = "Hello Hellow HI HI HI";
    String myStr2 = "CHANGE";
    System.out.println(myStr.replaceAll("HI", myStr2)); // string mein first occuerence ko change karta hai dusre se
    //test class left
}
static void split()
{
    String str = "HELLOW@bye@hi@hello";
    String[] arrOfStr = str.split("@", 3);

    for (String a : arrOfStr)
        System.out.println(a); // string ko substring mein todhta hai '@' pe todega and '3' string mein aur in dono ki jagaj "samplestring" pe bhi tod sakte ho
    //test class left
}
static void subSequence()
{
    String Str = "Welcomeqwe to HELLOW"; 
  
    // prints the subsequence from 0-7, exclusive 7th index 
    System.out.print("Returns: "); 
    System.out.println(Str.subSequence(0, 7)); // ye 0 se n-1 tak jata hai inke beech ke chars print karega
    //test class left
}
static void substring()
{
  // Initializing String
  String Str = new String("HELLOW HI BYE");
 
  // using substring() to extract substring
  // returns (whiteSpace) for HELLOW

  System.out.print("The extracted substring is : ");
  System.out.println(Str.substring(0));  // 0 se lekar end tak ke substrings and 0,6 bhi kar sakte hai
    //test class left
}
static void toCharArray()
{
    String s = "HELLOW";
    char[] str = s.toCharArray();
 
    System.out.println(str);  // string ko char [] banata
    //test class left
}
static void toLowerCase()
{
    String txt = "Hello World";
    System.out.println(txt.toLowerCase());  // string ko lowercase
    //test class left
}
static void toUpperCase()
{
    String txt = "Hello World";
    System.out.println(txt.toUpperCase());  // string ko uppercase
    //test class left
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

    }
}
