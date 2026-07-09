import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static class Node{
        int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    private static int n, m, a, b;
    private static List<Node>[] graph;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // [수정 포인트 1] 문제의 요구사항에 맞춰 그래프의 인접 리스트를 미리 정렬합니다.
        // 역추적 시 '번호가 가장 작은 정점'을 먼저 선택하게 만들기 위함입니다.
        for(int i = 1; i <= n; i++) {
            graph[i].sort((o1, o2) -> o1.to - o2.to);
        }
        
        // [수정 포인트 2] 답안 코드처럼 b를 시작점으로 설정하여 다익스트라를 돌립니다.
        // 이렇게 하면 a에서부터 바로 역추적을 시작해 reverse 없이 출력할 수 있습니다.
        int[] dist = dij(b); 
        System.out.println(dist[a]);

        // [수정 포인트 3] 역추적 루프 개선
        List<Integer> path = new ArrayList<>();
        int curr = a; // 도착지 a에서 시작해서
        path.add(a);

        while(curr != b){ // 시작점 b를 만날 때까지
            boolean moved = false;
            for(Node next : graph[curr]){
                // 인접 리스트가 정렬되어 있으므로, 이 조건을 만족하는 '가장 작은 번호의 노드'가 바로 선택됩니다.
                if(dist[next.to] + next.cost == dist[curr]){
                    path.add(next.to);
                    curr = next.to;
                    moved = true;
                    break;
                }
            }
            // 만약 경로를 찾지 못하는 예외 상황(예: 끊어진 그래프)이 발생하면 무한 루프를 방지하고 탈출합니다.
            if(!moved) break; 
        }

        // 출력 (a부터 b까지 순서대로 바로 출력 가능)
        for(int node : path){
            System.out.print(node + " ");
        }
    }

    // [수정 포인트 2 반영] 시작점을 매개변수(start)로 받도록 유연하게 수정
    private static int[] dij(int start){
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int d = curr.cost;
            int now = curr.to;

            if(d > dist[now]) continue;

            for(Node next: graph[now]){
                if(dist[next.to] > dist[now] + next.cost){
                    dist[next.to] = dist[now] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}