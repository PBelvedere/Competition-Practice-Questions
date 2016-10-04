/**
 * Created by Peter on 2016-10-03.
 * Question for reference can be found here: https://open.kattis.com/problems/8queens
 */
import java.util.*;

public class queens {

    public static void main(String[]args)
    {
        //eight by eight array as stated in the question
        char[][] c = new char[8][8];
        char[] c1;
        boolean check = true;
        Scanner input = new Scanner(System.in);
        String s;
        for(int i =0; i< 8; i++)
        {
            s = input.nextLine();
            c1 = s.toCharArray();
            for(int j = 0; j<8; j++)
            {
                c[i][j] = c1[j];
            }
        }

        for(int i =0; i< 8; i++) {
            for (int j = 0; j < 8; j++) {
                //Begin checking - all up cases are removed and all horizontal left cases removed for efficiency
                //always check if break is false to reduce number of iterations (negligible effect on runtime,
                //useful while debugging
                if(c[i][j]=='*')
                {
                    //Check to the right
                    for(int k = j+1; k<8; k++){
                        if(!check)break;
                        if(c[i][k]=='*')check = false;
                    }
                    //Check down
                    for(int k = i+1; k<8; k++){
                        if(!check)break;
                        if(c[k][j]=='*')check = false;
                    }
                    //check down and to the left
                    for(int k = 1; k+i<8&&j-k>=0; k++){
                        if(!check)break;
                        if(c[i+k][j-k]=='*')check = false;
                    }
                    //check down and to the right
                    for(int k = 1; i+k<8&&k+j<8; k++){
                        if(!check)break;
                        if(c[i+k][k+j]=='*')check = false;
                    }
                    if(!check)break;
                }
                //IDE states always false, however this is incorrect
                if(!check)break;

            }
            if(!check)break;
        }
        if(check)System.out.println("valid");
        else System.out.println("Invalid");
    }
}
