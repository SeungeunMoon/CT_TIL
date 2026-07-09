import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int to,cost;
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }

    static class Pair implements Comparable<Pair>{
        int to,cost;
        public Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair o){
            return this.cost-o.cost;
        }
    }
    private static int n,m,k;
    private static PriorityQueue<Pair> pq=new PriorityQueue<>();
    private static List<Node>[] graph; 
    private static int[] dist;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        k=Integer.parseInt(br.readLine());

        graph=new ArrayList[n+1];
        dist=new int[n+1];

        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }

        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[k]=0;
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr= pq.poll();

            if(curr.cost!=dist[curr.to]) continue;

            for(int j=0; j<graph[curr.to].size();j++){
                int index=graph[curr.to].get(j).to;
                int cost=graph[curr.to].get(j).cost;

                int newCost=dist[curr.to]+cost;
                if(dist[index]>newCost){
                    dist[index]=newCost;
                    pq.add(new Pair(index,newCost));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(dist[i]);
            }
        }


    }
}