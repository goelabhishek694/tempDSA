import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		//write your code here
        int root=(int)Math.floor(Math.pow(n,0.5));
        //System.out.println(root);
        int count=0;
		int[] dp=new int[root];
		for(int i=0;i<root;i++){
			dp[i]=(i+1)*(i+1);
		}
		for(int i=root-1;i>=0;i--){
			if(n-dp[i]>=0){
			    n=n-dp[i];
				count++;
				i++;
			}
			if(n==0) return count;
		}
		return n;
	}
    

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

    

	
}