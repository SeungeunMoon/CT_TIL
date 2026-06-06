import java.util.*;
import java.io.*;

public class Main {
    static int n, start, end, mid;
    static int[][] graph;
    static class Point{
        int r,c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        start = 0;
        end = 1000001;
        
        while(start < end) {
            mid = (start+end) / 2;
            
            if(parametric(mid)){
                end = mid;
            } else {
                start = mid+1;
            }            
        }

        System.out.print(start);



    }
    
    public static boolean parametric(int mid) {
        boolean[][] visited = new boolean[n][n];

        for(int i = 0; i< n; i++) {
            for(int j=0; j<n;j++) {
                if(visited[i][j]) continue;
                if(check(i,j,mid,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(int r, int c, int d, boolean[][] visited) {
        int[] dr={-1,1,0,0}, dc={0,0,-1,1};
        int cnt = 0;
        Queue<Point> q = new ArrayDeque();
        q.add(new Point(r,c));
        cnt++;
        visited[r][c]=true;

        while(!q.isEmpty()) {

            if(cnt * 2 >= n*n) return true;
            Point cur = q.poll();

            for(int i=0; i < 4; i++) {
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<n && !visited[nr][nc] &&
                    (Math.abs(graph[nr][nc] - graph[cur.r][cur.c]) <= d)) {
                    visited[nr][nc] = true;
                    cnt++;
                    q.add(new Point(nr,nc));
                }
            }
        }


        return false;

    }
}