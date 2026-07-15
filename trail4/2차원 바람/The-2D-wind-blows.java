import java.util.*;
import java.io.*;

public class Main {

    static int n,m,q;
    static int[][] graph;
    static int[][] nextGraph;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;

            nextGraph = new int[n][m];
            for (int r = 0; r < n; r++) {
                nextGraph[r] = graph[r].clone();
            }

            //회전
            int dir = 0;
            int totalStep = (r2-r1 + c2-c1) *2;
            int pre = graph[r1][c1];
            int sr = r1, sc = c1;
            

            for(int j = 0; j < totalStep; j++) {

                int nr = sr + dx[dir];
                int nc = sc + dy[dir];

                if(!((r1<=nr && r2>=nr) && (c1<=nc && c2>=nc))) {
                    dir = (dir + 1) % 4;
                    nr = sr + dx[dir];
                    nc = sc + dy[dir];
                }

                sr = nr;
                sc = nc;
                int temp = graph[sr][sc];
                graph[sr][sc] = pre;
                nextGraph[sr][sc] = pre;
                pre = temp;

            }
            //평균
            for(int r=r1; r<=r2; r++){
                for(int c=c1; c<=c2; c++){

                    int total = graph[r][c];
                    int cnt = 1;

                    for(int k=0; k<4; k++) {
                        int nr = r + dx[k];
                        int nc = c + dy[k];

                        if(nr<n && nc <m && nr >=0 && nc >=0) {
                            total += graph[nr][nc];
                            cnt++;
                        }
                    }
                    nextGraph[r][c] = (total/cnt);
                }
            }

            graph = nextGraph;

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}