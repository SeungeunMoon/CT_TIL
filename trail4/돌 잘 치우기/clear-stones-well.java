import java.util.*;
import java.io.*;

public class Main {
    static int n,m,k,maxCnt;
    static int[][] graph, curGraph;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static ArrayList<Point> rocks;
    static Point[] starts;
    static int[] picked;

    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 

        graph = new int[n][n];
        curGraph = new int[n][n];
        rocks = new ArrayList();
        starts = new Point[k];
        picked = new int[m];

        for(int i=0; i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    rocks.add(new Point(i,j));
                }
            }
        }

        for(int i=0; i< k; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i] = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }
 
        combi(0,0);

        System.out.print(maxCnt);

    }

    static void combi(int cur, int depth) {

        if(depth == m) {
            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n;j++) {
                    curGraph[i][j] = graph[i][j];
                }
            }

            for(int i=0; i<picked.length; i++) {
                Point p = rocks.get(picked[i]);
                curGraph[p.r][p.c] = 0;
            }
            BFS();
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n;j++) {
                    if(visited[i][j]) {
                        cnt++;
                    }
                }
            }
            maxCnt = Integer.max(cnt,maxCnt);
            return;
        }

        for(int i=cur; i<rocks.size(); i++) {
            picked[depth] = i;
            combi(i+1, depth+1);
        }

    }

    static void BFS() {
        Queue<Point> q = new ArrayDeque();

        for(Point p: starts) {
            q.add(p);
            visited[p.r][p.c] = true;
        }

        while(!q.isEmpty()) {

            Point cur = q.poll();

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<n) {
                    if(!visited[nr][nc] && curGraph[nr][nc]==0) {
                        visited[nr][nc] =true;
                        q.add(new Point(nr,nc));
                    }
                }
            }

        }

    }
}