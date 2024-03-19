import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//updated file with test cases but has some doubt in Main section of code
public class questions_array_string 
{
static String Java_Strings_Introduction(String A,String B)
{
    int sum_ab=A.length()+B.length();
        System.out.println(sum_ab);
        int result=A.compareTo(B);
        if(result>0)
        {
            System.out.println("Yes");
        }
        else 
        {
            System.out.println("No");
        }
        return (Character.toUpperCase(A.charAt(0))+A.substring(1)+" "+Character.toUpperCase(B.charAt(0))+B.substring(1));
}

static String Java_Substring(String S, int start, int end) 
{
    return S.substring(start, end);
}

static String[] getSmallestAndLargestsubstring(String s, int k) 
{
    String smallest = s.substring(0, k);
    String largest = s.substring(0, k);

    for (int i = 1; i <= s.length() - k; i++) {
        String curSubstring = s.substring(i, i + k);
        if (curSubstring.compareTo(smallest) < 0) {
            smallest = curSubstring;
        }
        if (curSubstring.compareTo(largest) > 0) {
            largest = curSubstring;
        }
    }

    return new String[]{smallest, largest};
}
static String Java_String_Reverse(String str) 
{
    StringBuilder str1 = new StringBuilder(str);
    str1.reverse();
    if (str.equals(str1.toString())) {
        return "palindrome";
    } else {
        return "Not palindrome";
    }
}
static boolean Java_Anagrams(String a, String b) 
{
    a = a.toLowerCase();
    b = b.toLowerCase();
    char[] A = a.toCharArray();
    Arrays.sort(A);
    char[] B = b.toCharArray();
    Arrays.sort(B);
    return Arrays.equals(A, B);
}
static String[] Java_String_Tokens(String str) 
{
    return str.split("[, ?'.@!_]+");
}
static int java_subarray(int n,int a[])
{   
    int count=0;
    for(int i=0;i<n;i++)                        //n->total elements,a->array
            {
                int sum = 0;
                for(int j=i;j<n;j++)
                {
                    sum = a[j] + sum;
                    if(sum<0){
                        count++;
                    }
                }
            }
            return (count);
}
static void java_list()
{
    List<Integer> arrList = new ArrayList<>();   //iska raw  -> List<typeoflist> name=new Arraylist<>();
    arrList.add(1);
    arrList.add(2);
    arrList.add(3);
    arrList.add(4);
    arrList.add(2,11);
    arrList.remove(0);
}
public class testing {

    @Test
    public void testJavaStringsIntroduction()
    {
        // Test Case 1
        String A1 = "hello";
        String B1 = "world";
        String expectedOutput1 = "Hello World";
        assertEquals(expectedOutput1, questions_array_string.Java_Strings_Introduction(A1, B1));

        // Test Case 2
        String A2 = "apple";
        String B2 = "banana";
        String expectedOutput2 = "Apple Banana";
        assertEquals(expectedOutput2, questions_array_string.Java_Strings_Introduction(A2, B2));
    }
    public void testListOpe() 
    {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(2, 11);
        arrList.remove(0);
        assertEquals(4, arrList.size()); 
        assertEquals(Integer.valueOf(2), arrList.get(0)); 
        assertEquals(Integer.valueOf(11), arrList.get(1)); 
        assertEquals(Integer.valueOf(3), arrList.get(2)); 
        assertEquals(Integer.valueOf(4), arrList.get(3)); 
    }
    public void testJavaSubarray() 
    {
        int[] arr1 = {1, -2, 3, -4, 5};
        int n1 = arr1.length;
        int expectedCount1 = 9; 
        assertEquals(expectedCount1, java_subarray(n1, arr1));
        int[] arr2 = {-1, -2, -3, -4, -5};
        int n2 = arr2.length;
        int expectedCount2 = 15; 
        assertEquals(expectedCount2, java_subarray(n2, arr2));
    }
    public void testJavaSubstring() 
    {
        String S1 = "Hello World";
        int start1 = 3;
        int end1 = 7;
        String expectedSubstring1 = "lo W";
        assertEquals(expectedSubstring1, Java_Substring(S1, start1, end1));
        String S2 = "Java Programming";
        int start2 = 5;
        int end2 = 12;
        String expectedSubstring2 = "Program";
        assertEquals(expectedSubstring2, Java_Substring(S2, start2, end2));
    }
    public void testJavaStringTokens() 
    {
        String str1 = "Hello World! This is a test string.";
        String[] expectedTokens1 = {"Hello", "World", "This", "is", "a", "test", "string"};
        assertArrayEquals(expectedTokens1, Java_String_Tokens(str1));
        String str2 = "Java, Programming, is, fun!";
        String[] expectedTokens2 = {"Java", "Programming", "is", "fun"};
        assertArrayEquals(expectedTokens2, Java_String_Tokens(str2));
    }
    public void testJavaAnagrams() 
    {
        String a1 = "listen";
        String b1 = "silent";
        boolean expectedAnagram1 = true;
        assertEquals(expectedAnagram1, Java_Anagrams(a1, b1));
        String a2 = "hello";
        String b2 = "world";
        boolean expectedAnagram2 = false;
        assertEquals(expectedAnagram2, Java_Anagrams(a2, b2));
    }
    public void testJavaStringReverse() 
    {
        String str1 = "madam";
        String expectedOutput1 = "palindrome";
        assertEquals(expectedOutput1, Java_String_Reverse(str1));
        String str2 = "hello";
        String expectedOutput2 = "Not palindrome";
        assertEquals(expectedOutput2, Java_String_Reverse(str2));
    }
    public void testGetSmallestAndLargestSubstring() 
    {
        String s1 = "welcometojava";
        int k1 = 3;
        String[] expectedOutput1 = {"ava", "wel"};
        assertArrayEquals(expectedOutput1, getSmallestAndLargestsubstring(s1, k1));
        String s2 = "abcdefgh";
        int k2 = 2;
        String[] expectedOutput2 = {"ab", "gh"};
        assertArrayEquals(expectedOutput2, getSmallestAndLargestsubstring(s2, k2));
    }
}

public static void main(String[] args) 
{
    String A =" ";
    String B = " ";
    int start=0,end=0;
    int a[]={};
    Java_Strings_Introduction(A,B);
    Java_Substring(A,start,end);
    getSmallestAndLargestsubstring(A,start);
    Java_String_Reverse(A);
    Java_Anagrams(A,B);
    Java_String_Tokens(A);
    java_subarray(start,a);
    java_list();
}
}
