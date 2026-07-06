import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n,k;

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        int[][] sum=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int num=Integer.parseInt(st.nextToken());
                   sum[i][j]= sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+num;
            }
        }

        int max=0;
     
for (int i = k; i <= n; i++) {
    for (int j = k; j <= n; j++) {

        int diff = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
        
        max = Math.max(diff, max);
    }
}
        System.out.println(max);

    }
}