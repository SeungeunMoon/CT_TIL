import java.util.*;
import java.io.*;

public class Main {
    static int k,n,flag;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        picked = new int[n];

        combi(0);
        System.out.print(sb);
    }

    static public void combi(int depth) {

        if(depth == n) {
            for(int i =0; i<n; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(depth >= 2 && i == picked[depth-1] && i == picked[depth-2]) continue;
            picked[depth] = i;
            combi(depth+1);
        }
    }
}