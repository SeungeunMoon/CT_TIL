import java.util.*;
import java.io.*;

public class Main {

    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] grid;
    static List<Integer> result;
    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] || grid[i][j] == 0) continue;
                cnt = 1;
                visited[i][j] = true;
                dfs(i, j);
                result.add(cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for(int c: result){
            sb.append(c).append("\n");
        }

        System.out.print(sb);
                
    }
    public static void dfs(int r, int c) {
        for(int k=0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < n && nc < n && nr >= 0 && nc >= 0 ) {
                if(!visited[nr][nc] && grid[nr][nc]==1) {
                    visited[nr][nc] = true;
                    cnt++;
                    dfs(nr, nc);
                }
            }
        }
    }
}