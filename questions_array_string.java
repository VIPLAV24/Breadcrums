import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//multiple errors are bcz of no parameter value I'll be adding testcases so it will be removed!!
public class questions_array_string 
{
static void Java_Strings_Introduction(String A, String B)
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
        System.out.println(Character.toUpperCase(A.charAt(0))+A.substring(1)+" "+Character.toUpperCase(B.charAt(0))+B.substring(1));
}

static void Java_Substring(String S,int start,int end)
{
    System.out.print(S.subSequence(start,end));
}

static void getSmallestAndLargestsubstring(String s,int k)
{
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 1; i <= s.length() - k; i++) 
        {
            String curSubstring = s.substring(i, i + k);
            if (curSubstring.compareTo(smallest) < 0) 
            {
                smallest = curSubstring;
            }
            if (curSubstring.compareTo(largest) > 0) 
            {
                largest = curSubstring;
            }
        }    
        System.out.print(smallest + "\n" + largest);
}
static void Java_String_Reverse(String str)
{
    StringBuilder str1=new StringBuilder(str);
        str1.reverse();
        if (str.equals(str1.toString())) 
        {
            System.out.println("palindrome");
        } else 
        {
            System.out.println("Not palindrome");
        }
}
static void Java_Anagrams(String a,String b)
{
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] A = a.toCharArray();
        Arrays.sort(A);
        char[] B = b.toCharArray();
        Arrays.sort(B);
        System.out.print(Arrays.equals(A,B));
}
static void Java_String_Tokens(String str)
{
    String[] arrOfStr = str.split("[, ?'.@!_]+");
 
        for (String a : arrOfStr)
            System.out.println(a);
}
static void java_subarray(int n,int a[])
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
            System.out.println(count);
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
public static void main(String[] args) 
{
    Java_Strings_Introduction(A,B);
    Java_Substring(start,end);
    getSmallestAndLargestsubstring(S,K);
    Java_String_Reverse(S);
    Java_Anagrams(A,B);
    Java_String_Tokens(S);
    java_subarray(n,a[]);
    java_list();
}

}
