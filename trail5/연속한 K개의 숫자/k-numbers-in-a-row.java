import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n,k,b;

        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        int[] sum=new int[n+1];
        sum[0]=0;
        int[] arr=new int[n+1];

        for(int i=0;i<b;i++){
            int num=Integer.parseInt(br.readLine());
            arr[num]=1;
        }
        
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        int min=100_000;

        for(int i=k;i<=n;i++){
            int diff= sum[i]-sum[i-k];
            min=Math.min(diff,min);
        }
        System.out.println(min);
    }
}