import java.io.*;
import java.util.*;
public class Main {
    private static int n,m;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            int first= lower(num);

            if(first!=-1){
                sb.append(first);
            }else{
                sb.append(-1);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
    private static int lower(int target){
        int left=0;
        int right=n-1;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>=target){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }

        if (ans != -1 && arr[ans] == target) {
            return ans + 1; // 1-based index 반환
        } else {
            return -1;
        }
    }
}