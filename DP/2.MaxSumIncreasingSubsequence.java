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
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
        }
        int maxSumIncreasingSub=0;
        

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]){
                    if(dp[j]+arr[i]>dp[i]){
                        dp[i]=dp[j]+arr[i];
                        
                    }
                }
            }
            maxSumIncreasingSub=Math.max(maxSumIncreasingSub,dp[i]);
            System.out.println(maxSumIncreasingSub);
        }

        System.out.println(maxSumIncreasingSub);
    }

}
