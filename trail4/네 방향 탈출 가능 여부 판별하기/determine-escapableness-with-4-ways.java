import java.util.*;
import java.io.*;


public class Main {

    public static int n,m;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dr= {-1,1,0,0}, dc = {0,0,-1,1};

    public static class Point{
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
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(BFS()) System.out.print(1);
        else System.out.print(0);

        
    }

    public static boolean BFS() {
        Queue<Point> q = new ArrayDeque();

        q.add(new Point(0,0));
        visited[0][0] = true;

        while(!q.isEmpty()) {

            Point cur = q.poll();

            if(cur.r == n-1 && cur.c == m-1 && graph[cur.r][cur.c] == 1) {
                return true;
            }

            for(int i=0; i<4; i++) {

                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr>=0 && nc >=0 && nr < n && nc < m) {
                    if(!visited[nr][nc] && graph[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr,nc));
                    }
                }
            }
        }

        return false;
    }
}