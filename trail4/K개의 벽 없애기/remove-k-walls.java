import java.util.*;
import java.io.*;

public class Main {

    static int N,K,sr,sc,er,ec;
    static int minDis = Integer.MAX_VALUE;
    static int[][] graph,curGraph;
    static int[] picked;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static List<Point> walls;

    static class Point {
        int r,c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        walls = new ArrayList<>();


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    walls.add(new Point(i,j,0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken())-1;
        ec = Integer.parseInt(st.nextToken())-1;
        
        picked = new int[K];
        combi(0, 0);
        if(minDis != Integer.MAX_VALUE) System.out.print(minDis);
        else System.out.print(-1);

    }

    public static void combi(int cur, int depth ) {

        if(depth == K) {
            visited = new boolean[N][N];
            curGraph = new int [N][N];

            for(int i=0; i<N;i++) {
                for(int j=0; j<N; j++) {
                    curGraph[i][j] = graph[i][j];
                }
            }

            for(int i=0; i<picked.length; i++) {

                curGraph[walls.get(picked[i]).r][walls.get(picked[i]).c] = 0;

            }
            
            int result = BFS();
            if(result != 0) {
                minDis = Integer.min(minDis, result);
            }

            return;
        }

        for(int i = cur; i < walls.size(); i++) {

            picked[depth] = i;
            combi(i+1, depth + 1);
        }

    }

    public static int BFS() {

        Queue<Point> q = new ArrayDeque();
        visited[sr][sc] = true;
        q.add(new Point(sr,sc,0));
        int cnt = 0;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;

            if(cur.r == er && cur.c == ec) return cur.cnt;

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<N) {
                    if(!visited[nr][nc] && curGraph[nr][nc] == 0) {
                        visited[nr][nc]=true;
                        q.add(new Point(nr,nc,cur.cnt+1));
                    }
                }
            }
        }

        return 0;

    }


}