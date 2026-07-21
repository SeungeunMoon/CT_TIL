import java.util.*;
import java.io.*;
//(3^10=60000) * (20*20)

public class Main {

    static int n,k, maxTotal = 0;
    static int[][] grid, testGrid;
    static int[] combi;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        testGrid = new int[n][n];

       
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) k++;
            }
        }

        combi = new int[k+1];
        backTracking(1);

        System.out.print(maxTotal);

    }

    static int totalSum() {
        int total = 0;
               
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(testGrid[i][j] == 2){
                    total++;
                }
            }
        }

        return total;
    }

    // 중복 순열 
    static void backTracking(int depth) {

        if( depth == k+1 ) {
            for(int i=0; i<n;i++){
                for(int j=0;j<n;j++){
                    testGrid[i][j] = grid[i][j];
                }
            }

            int idx = 1;
            for(int i =0; i< n; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == 1){
                        testGrid[i][j] = 2;
                        bomb(combi[idx++], i, j);
                    }
                }
            }

            maxTotal = Math.max(totalSum(),maxTotal);

            return;
        }

        for (int i = 1; i < 4; i++) {
            combi[depth] = i;
            backTracking(depth+1);
        }

    }

    static boolean inRange(int r,  int c) {
        return (r >= 0 && c >= 0 && r < n && c < n);
    }

    static void bomb(int tp, int r, int c) {
        int[] dr = new int[4];
        int[] dc = new int[4];

        switch(tp) {
            case 1:
                dr = new int[]{-1,-2,1,2}; dc = new int[]{0,0,0,0};
                break;
            case 2:
                dr = new int[]{-1, 0, 1, 0}; dc = new int[]{0, -1, 0, 1};
                break;
            case 3:
                dr = new int[]{-1,-1,1,1}; dc = new int[]{-1,1,-1,1};
                break;
            }

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(inRange(nr,nc)) {
                testGrid[nr][nc] = 2;
            }
        }

    }
}