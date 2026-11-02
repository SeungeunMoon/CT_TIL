import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(binarySearch(arr, x)).append("\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int k) {

        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left+right)/2;

            if(arr[mid] == k) return mid+1;

            if( k < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}