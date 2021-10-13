import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        int ans=countPalindromicSubstring(str);
        System.out.println(ans);
    }

    public static int countPalindromicSubstring(String str){
        int n=str.length();
        // System.out.println(n);
        int[][] arr=new int[n][n];
        int count=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n ;i++,j++){
                if(gap==0){
                    arr[i][j]=1;
                    count++;
                    // System.out.println(count);
                    continue;
                }
                if(gap==1 && str.charAt(i)==str.charAt(j)){
                    arr[i][j]=1;
                    count++;
                }
                else if(str.charAt(i)==str.charAt(j)){
                    if(arr[i+1][j-1]==1){
                        arr[i][j]=1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}