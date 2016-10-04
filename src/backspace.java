/**
 * Created by Peter on 2016-10-03.
 * Question for reference can be found at: https://open.kattis.com/problems/backspace
 */

import java.util.*;
public class backspace {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String a = input.nextLine();
        char[] b;

        b = a.toCharArray();

        //make an arraylist out of b
        ArrayList <Character> c = new ArrayList<Character>();
        for(char c1 : b) c.add(c1);

        //run through for arraylist
        for(int i = 0; i<c.size(); i++)
        {
            //if a < is found, remove it and the letter before, and reduce the counter back as to not skip anything
            if(c.get(i) == '<')
            {
                c.remove(i);
                c.remove(i-1);
                i-=2;
            }
        }
        String s = "";
        for(char a1: c) s+= a1;

        System.out.println(s);
    }
}
