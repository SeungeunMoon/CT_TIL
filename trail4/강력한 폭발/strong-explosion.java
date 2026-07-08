import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int n, max = 0;
    private static List<Pair> bomb = new ArrayList<>();
    private static int[] type;
    private static boolean[][] visited;

    // [수정 ①] 정답 코드의 기준에 맞춘 5칸짜리 폭탄 형태 (인덱스 1, 2, 3 사용)
    private static Pair[][] dir = {
        {}, 
        {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
        {new Pair(-1, 0), new Pair(1, 0), new Pair(0, 0), new Pair(0, -1), new Pair(0, 1)},
        {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) bomb.add(new Pair(i, j));
            }
        }

        type = new int[bomb.size()];
        choose(0);
        System.out.println(max);
    }

    // 터트린후 갯수 세기
    private static void cnt(){
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) sum++;
            }
        }
        max = Math.max(sum, max);
    }

    // 초기화
    private static void reset(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }

    // 폭탄 골라주기
    private static void choose(int index){
        if(index == bomb.size()){
            calc();
            return;
        }
     
        for(int i = 1; i <= 3; i++){
            type[index] = i;
            choose(index + 1);
        }
    }

    private static void calc(){
        reset();

        for(int i = 0; i < bomb.size(); i++){
            Pair[] curr = dir[type[i]];
            Pair coordinate = bomb.get(i);
            
        
            for(int j = 0; j < 5; j++){
                int nx = coordinate.x + curr[j].x;
                int ny = coordinate.y + curr[j].y;
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    visited[nx][ny] = true;
                }
            }
        }
        cnt();
    }
}