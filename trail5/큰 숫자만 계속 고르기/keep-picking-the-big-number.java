import java.io.*;
import java.util.*;


public class Main {
    private static PriorityQueue<Integer> pq=new PriorityQueue<>();
    private static int n,m;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            pq.add(-num);
        }
        for(int i=0;i<m;i++){
            int num=pq.poll();
            num=-num;
            num-=1;
            pq.add(-num);
        }
        int num=pq.peek();
        System.out.println(-num);


    }
}