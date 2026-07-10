import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        
        int max=num[0];
        int sum=num[0];
        
        for(int i=1;i<n;i++){
            sum=Math.max(sum+num[i],num[i]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
        // Please write your code here.
    }
}

// 최대값 유지할 때 까지계속 합산 근데 줄어든다면 초기화 하고 구간 다시 시작