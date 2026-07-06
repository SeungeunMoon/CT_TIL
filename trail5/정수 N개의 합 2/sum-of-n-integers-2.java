import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n,k;
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        int[] arr=new int[n+1];
        int[] sum=new int[n+1];
        sum[0]=0;
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());
            sum[i]=num+sum[i-1];
        }

        int max=0;
        for(int i=k; i<n+1;i++){
            int diff=sum[i]-sum[i-k];
            max=Math.max(max,diff);
        }
        System.out.println(max);
    }
}