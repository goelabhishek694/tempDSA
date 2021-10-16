import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        int ans=lpss(str);        
        System.out.println(ans);
    }

    public static int lpss(String str){
        int n=str.length();
        int[][] arr=new int[n][n];
        int longestSubString=1; 
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n && j<n;i++,j++){
                if(gap==0){
                    arr[i][j]=1;
                    continue;
                }
                if(gap==1 && str.charAt(i)==str.charAt(j)){
                    arr[i][j]=1;
                    longestSubString=2;
                }
                else if(str.charAt(i)==str.charAt(j) && arr[i+1][j-1]==1){
                    arr[i][j]=1;
                    if(longestSubString<j-i+1){
                        longestSubString=j-i+1;
                    }
                }
            }
        }
        return longestSubString;
    }

}