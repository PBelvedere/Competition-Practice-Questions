/**
 * Created by Peter on 2016-10-03.
 * Question for reference can be found at: https://open.kattis.com/problems/countingstars
 */
import java.util.*;

public class stars {

    public static void main(String[]args)
    {
        String s;
        char[] d;
        int count = 0;
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        input.nextLine();

        char[][] c = new char[m][n];

        for(int i = 0; i<m; i++)
        {
            s = input.nextLine();
            d = s.toCharArray();
            for(int j = 0; j<n; j++)
            {
                c[i][j] = d[j];
            }
        }

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(c[i][j] == '-')
                {
                    checkAdjacent(i, j, c);
                    //increase count after leaving the recursive call
                    count++;
                }

            }
        }

        System.out.println(count);




    }

    public static void checkAdjacent(int i, int j, char[][]c)
    {
        //change current index to a # to prevent double counting
        c[i][j] = '#';
        //check up one
        if((i-1)>=0)
        {
            if(c[i-1][j]=='-')checkAdjacent(i-1, j, c);
        }
        //check down one
        if((i+1)<c.length)
        {
            if(c[i+1][j]=='-')
            {
                checkAdjacent(i+1, j, c);
            }
        }

        //check left one
        if((j-1)>=0)
        {
            if(c[i][j-1]=='-')checkAdjacent(i, j-1, c);
        }
        //check right one
        if((j+1)<c[i].length) {
            if (c[i][j + 1] == '-') {
                checkAdjacent(i, j + 1, c);
            }
        }
    }
}
