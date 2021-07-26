import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        System.out.println(lps(str));
    }

    public static int lps(String str){
        int[][] dp=new int[str.length()][str.length()];
        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<str.length();j++,i++){
                if(gap==0){
                    dp[i][j]=1;
                    continue;
                }
                else if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            } 
        }
        // for(int[] arr:dp){
        //     for(int ele:arr){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][str.length()-1];
    }

}