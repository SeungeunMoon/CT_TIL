import java.util.*;
import java.io.*;

public class Main {
    private static PriorityQueue<Integer> pq =new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    int min=pq.poll();
                    sb.append(min).append('\n');
                }
            }else{
                pq.add(num);
                //sb.append(num);
            }
        }
        System.out.println(sb);

    }
}