import java.util.*;
import java.io.*;

public class Main {
    private static int n,m;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        StringBuilder sb=new StringBuilder();


        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            int num = solve(x);

            if(num>=0){
                sb.append(num+1);
            }else{
                sb.append(-1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static int solve(int target){
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target) return mid;

            if(arr[mid]>target) right=mid-1;
            else left =mid+1;

        }
        return -1;
        
    }
}