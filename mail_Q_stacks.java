import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.Test;
// Q -1 -> not able to sort out problem of anagrams 
/* 
 *stacks Operation

    Deque<type> name=new arraydeque/linkedlist <>();
    name.push()
    name.pop()
    name.isEmpty()
    name.peek()
    insertion working -> push ->1,2,3,4
    on output -> 4,3,2,1
    on pop -> 4->3->2->1
    first and last F()
    addfirst/last() -> add element in first or last index       (throws exception if full)
    offerfirst/last() -> add element in first or last index     (different from above gives boolean value -> false if full)
    getfirst/last() -> get first and last element               (throws exception if empty)
    peekfirst/last() -> get first and last element              (gives NULL if empty)
    removefirst/last() -> removes element                        (exception if empty)
    pollfirst/last() ->removes element                          (NULL if empty)

 */
public class mail_Q_stacks 
{
    @Test
    public void testing()
    {   //foreach loop version  (doubt : has to add more test cases if array gets big )
        int[] ar = {1, 2, 3, 4};
        List<Integer> arrList = new ArrayList<>();
        boolean pN = false;
        for (int num : ar) 
        {
            if (pN) 
            {
                arrList.add(num);
                pN = false; 
            } 
            else 
            {
                pN = true; 
            }
        }
        assertEquals((int)arrList.get(0),ar[1]);
        assertEquals((int)arrList.get(1),ar[3]);
        arrList.clear();
        //normal forloop
        for (int i = 1; i < ar.length; i=i+2) 
        {
            arrList.add(ar[i]);
        }
        assertEquals((int)arrList.get(0),ar[1]);
        assertEquals((int)arrList.get(1),ar[3]);
        arrList.clear();
        //array in reverse order (not possible with foreach loop bcz we dont access index directly in foreach loop)
        for (int i = ar.length; i >= 0; i--) 
        {
            arrList.add(i);
        }
        assertEquals((int)arrList.get(0),ar[3]);
        assertEquals((int)arrList.get(1),ar[2]);
        assertEquals((int)arrList.get(2),ar[1]);
        assertEquals((int)arrList.get(3),ar[0]);
        arrList.clear();
        //every even element of the array
        for (int i = ar.length-1; i >= 0; i--) 
        {
            if(ar[i]%2==0)
            {
                arrList.add(ar[i]);
            }
            
        }
        assertEquals((int)arrList.get(0),ar[3]);
        assertEquals((int)arrList.get(1),ar[1]);
        arrList.clear();
        //sum of all odd numbers of array
        int sum=0;
        for (int num : ar) 
        {
            if (num % 2 != 0) 
            {
                sum=sum+num; 
            }
        }
        assertEquals(sum,ar[0]+ar[2]);
        arrList.clear();
        //character array mein vowels konse hai 
        char[] charr = {'A', 'b', 'c', 'D', 'e', 'f', 'G', 'h', 'I', 'j'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < charr.length; i++) 
        {
            char ch = Character.toLowerCase(charr[i]);
            for (char vowel : vowels) 
            {
                if (ch == vowel) 
                {
                    arrList.add(i);
                    break; 
                }
            }
        }
        assertEquals((int)arrList.get(0),0);
        assertEquals((int)arrList.get(1),4);
        assertEquals((int)arrList.get(2),8);
        arrList.clear();
        //in a String array, find strings that are of length 3
        String[] str1 = {"apple", "banana", "cat", "dog", "elephant", "fox"};
        StringBuilder str2 = new StringBuilder();
        for (String str : str1) 
        {
            if (str.length() == 3) 
            {
                str2.append(str);
            }
        }
        assertEquals(str2.substring(0,3),"cat");
        assertEquals(str2.substring(3,6),"dog");
        assertEquals(str2.substring(6,9),"fox");
        arrList.clear();
        //stacks basic questions
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        numbers.push(4);
        assertEquals("[4, 3, 2, 1]", numbers.toString());
        assertFalse(numbers.isEmpty());
        assertEquals(Integer.valueOf(4), numbers.removeFirst());
        assertEquals(Integer.valueOf(1), numbers.removeLast());
        assertEquals("[3, 2]", numbers.toString());
        while (!numbers.isEmpty()) 
        {
            numbers.pop();
        }
         assertTrue(numbers.isEmpty());
    }

}
