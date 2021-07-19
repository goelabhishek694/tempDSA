import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        int[]dp =new int[n];
        Arrays.fill(dp,1);
        int maxCount=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            maxCount=Math.max(maxCount,dp[i]);
        }
        
        System.out.println(maxCount);
        
    }

}