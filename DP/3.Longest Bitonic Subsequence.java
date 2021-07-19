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
        int[]dp_left=new int[n];
        int[]dp_right=new int[n];

        Arrays.fill(dp_left,1);
        Arrays.fill(dp_right,1);

        int maxLeftCount=0;
        int maxRightCount=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp_left[j]+1>dp_left[i]){
                        dp_left[i]=dp_left[j]+1;
                    }
                }
            }
            maxLeftCount=Math.max(maxLeftCount,dp_left[i]);
        }

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    if(dp_right[j]+1>dp_right[i]){
                        dp_right[i]=dp_right[j]+1;
                    }
                }
            }
            maxLeftCount=Math.max(maxLeftCount,dp_right[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dp_left[i]+dp_right[i]-1);
        }

        System.out.println(ans);
    }

}