import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }


        int result=0;

        while(pq.size()>=2){
            int a=pq.poll();
            int b=pq.poll();
            int sum=a+b;
            result+=sum;
            pq.add(sum);

        }

        System.out.println(result);
    }
}