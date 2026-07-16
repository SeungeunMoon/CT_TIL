import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());


        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            int num=Integer.parseInt(br.readLine());
            int result=upper(num)-lower(num);
            System.out.println(result);
        }

    }
    private static int lower(int target){
        int left=0;
        int right=n-1;
        int minIndex=n;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>=target){
                right=mid-1;
                minIndex=Math.min(minIndex,mid);
            }else{
                left=mid+1;
            }
        }
        return minIndex;
    }
    private static int upper(int target){
        int left=0;
        int right=n-1;
        int minIndex=n;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>target){
                right=mid-1;
                minIndex=Math.min(minIndex,mid);
            }else{
                left=mid+1;
            }
        }
        return minIndex;
    }
}