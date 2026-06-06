import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] ns;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ns = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< n;i++) {
            ns[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(upper_bound(num)-lower_bound(num));
        }

    }

    public static int lower_bound(int target) {

        int left = 0;
        int right = ns.length;

        while(left < right) {
            int mid = (left+ right) / 2;

            if(ns[mid] >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static int upper_bound(int target) {

        int left = 0;
        int right = ns.length;

        while(left < right) {
            int mid = (left+ right) / 2;

            if(ns[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}