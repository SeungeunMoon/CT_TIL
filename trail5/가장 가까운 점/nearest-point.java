import java.io.*;
import java.util.*;
public class Main {
    static class Pair implements Comparable<Pair>{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair o){
            if((this.x+this.y)!=(o.x+o.y)){
            return (this.x+this.y)-(o.x+o.y);
            }else if(this.x!=o.x){
                    return this.x-o.x;
            }else{
                return this.y-o.y;
            }
            
        }
    }
    private static PriorityQueue<Pair> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n,m;

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            pq.add(new Pair(x,y));
        }

        for(int i=0;i<m;i++){
            Pair curr=pq.poll();
            int nx=curr.x+2;
            int ny=curr.y+2;
            pq.add(new Pair(nx,ny));

        }

        Pair result=pq.peek();
        System.out.println(result.x+" "+result.y);
        
    }
}