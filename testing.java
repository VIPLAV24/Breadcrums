import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testing 
{
/*
*TESTS----------------
assertEquals(expected,actual);                      (checks 2 values are same or not)
assertArrayEquals(expected array,actual array)      (checks each item in the arrays are equal in the right position)
assertIterableEquals(expected array,actual array)   (verifies each item in the iterable are equal in the corrosponding position)
assertEquals(expected,actual," ");                  (in " " u can put msg if test case fails what should be displayed)
fail()                                              (used to force fail the test)
@EnabledOnOs(OS.LINUX)                              (to run test case on specific OS like linux)
@Disabled (to disable a test)
assertALL ( to combine multiple assert statements) (sab check karega ek bhi fail hoga toh whole test fail (and condition))
@Nested (group karta hai ek class ke tests ko main class test ke niche eg -> class test{ @Nested class test2 { @test ---}})
@Tag  (tag a test or nested test to call them from tags (run configuration and add include tags))
@DisplayName  (to display the name of the test)
https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html (more on this)

*StringBuilder vs String----------------
STRINGS IN JAVA -> NON-MUTTABLE(cannot be modified). (but if we concat another string with it will get appended but catch is its gives reference to the previous string and create a new string)
stringbuilder is mutable and can performs actions on it.

Enchanced forloop is the read-only loop object(jispe array chal raha hai) cannnot be modified (eg -> for(int num:array){num=num*2;}) isme keval num ki value *2 hogi array ki nahi.
does not keep track of index.

Q- how can we declare forloop in actual of assert by method ??
Q- line 46 how to test that only num is changing otherthan using the systemoutprintln. as num scope gets destroyed after completion of for loop
*/  

@Test
//@Tag("Assert Tests")
public void test()
{   
    
    int ar[]={1,2,3,4};
    int sum=0,last=0,first=0;
    assertEquals("LOWO","HELLOWORLD".substring(3,7));
    assertArrayEquals(new int[] {2,4,6},new int[]{2,4,6});
    assertEquals("HELLO","HEL".concat("LO"));
    for(int i:ar){sum=sum+i;}
    assertEquals(10,sum);
   // for(int num:ar){num=num*2;System.out.println(num);}
   // assertEquals(8,num);
   
   //printing last digit of array using foreach
   for(int i:ar)
        last=i;
   assertEquals(ar[ar.length-1],last);
   //printing first digit of array using foreach
   for(int i:ar)
   {
      first=i;
      break;
   }
   assertEquals(ar[0],first);
}














}
