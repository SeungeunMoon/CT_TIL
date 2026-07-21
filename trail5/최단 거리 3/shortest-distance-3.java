import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    private static List<Edge>[] list;
    private static int[] dist;
    static class Edge implements Comparable<Edge>{
        int to,dis;

        public Edge(int to,int dis){
         
            this.to=to;
            this.dis=dis;
        }

        @Override
        public int compareTo(Edge o){
            return this.dis-o.dis;
        }
    }
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }


        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dis=Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to,dis));
            list[to].add(new Edge(from,dis));

        }
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        dist= new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dij(start);

        System.out.println(dist[end]);
    }

    private static void dij(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            int u=curr.to;
            int d=curr.dis;

            if(dist[u]<d) continue;
            for(Edge next: list[u]){
                if(dist[next.to]>dist[u]+next.dis){
                    dist[next.to]=dist[u]+next.dis;
                    pq.add(new Edge(next.to,dist[next.to]));
                }
            }
        }
    }
}