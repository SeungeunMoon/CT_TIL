import java.util.*;
import java.io.*;
public class Main {
    private static PriorityQueue<Integer> pq=new PriorityQueue<>();
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        while(n>0){
            st=new StringTokenizer(br.readLine());
            String tmp=st.nextToken();
            if(tmp.equals("push")){
                int num=Integer.parseInt(st.nextToken());
                doPush(num);
            }else if(tmp.equals("size")){
                doSize();
            }else if(tmp.equals("pop")){
                doPoll();
            }else if(tmp.equals("empty")){
                doEmpty();
            }else{
                doPeek();
            }
            n--;
        }
        System.out.print(sb);

        // Please write your code here.
    }
    private static void doPush(int num){
        pq.add(-num);
    }
    private static void doPoll(){
        int num=-pq.poll();
        sb.append(num).append('\n');
    }
    private static void doSize(){
        int num=pq.size();
        sb.append(num).append('\n');
    }
    private static void doEmpty(){
        if(pq.isEmpty()){
            sb.append(1).append('\n');
        }else{
            sb.append(0).append('\n');
        }
    }
    private static void doPeek(){
        int num=-pq.peek();
        sb.append(num).append('\n');
    }
}