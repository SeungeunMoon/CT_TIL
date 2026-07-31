import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] dr = {0,1,0,-1}, dc = {1,0,-1,0};
        int dir = 0;
        int idx = 1;
        int r = 0, c = 0;
        visited[r][c] = true;
        graph[r][c] = idx++;


        for(int i = 0; i < n*m -1; i++) {

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(!(nr>=0 && nc>= 0 && nr<n && nc<m) || visited[nr][nc]) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            } 

            visited[nr][nc] = true;
            graph[nr][nc] = idx++;
            r = nr;
            c = nc;
            
        }

        for(int i =0; i< n;i++) {
            for(int j =0; j< m; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}