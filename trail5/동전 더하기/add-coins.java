import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        int[] money=new int[n];


     
        for(int i=0;i<n;i++){
            money[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(money);


        int cnt=0;

        for(int i=n-1;i>=0;i--){
            cnt+=k/money[i];
            k=k%money[i];
            if(k==0) break;

        }
        System.out.println(cnt);

    }
}