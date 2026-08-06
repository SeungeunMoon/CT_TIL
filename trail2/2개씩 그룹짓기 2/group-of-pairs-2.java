import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());


        int[] arr=new int[n*2];

        for(int i=0;i<2*n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            
        }

        Arrays.sort(arr);
        int diff =Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int num=arr[i+n]-arr[i];
            diff=Math.min(num,diff);
        }
        System.out.print(diff);
    }
}
