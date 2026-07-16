import java.util.*;
import java.io.*;

public class Main {
    
    static int N,answer;
    static int[][] lines;
    static boolean[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lines = new int[N][2];
        graph = new boolean[1001];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,0);
        System.out.print(answer);
    }

    static void backTracking(int depth, int cnt) {

        if(depth == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        boolean flag = false;

        for(int j=lines[depth][0]; j<=lines[depth][1]; j++) {
            if(graph[j]) {
                flag = true;
                break;
            }
        }  

        if(!flag)  {
            for(int j=lines[depth][0]; j<=lines[depth][1]; j++) {
                graph[j] = true;
            }
            backTracking(depth+1, cnt+1);

            for(int j=lines[depth][0]; j<=lines[depth][1]; j++) {
                graph[j] = false;
            }
        }
        backTracking(depth+1, cnt);

    }
}
