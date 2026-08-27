import java.util.*;
import java.io.*;

public class Main {
    private static int[][] map;
    private static int n,cnt;
    private static List<Integer> list=new ArrayList<>();
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited=new boolean[n][n];

        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&map[i][j]==1){
                    cnt=0;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);

        sb.append(list.size()).append('\n');
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);

        
    }
    private static void dfs(int x,int y){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};

       visited[x][y]=true;
       cnt++;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if (visited[nx][ny]) continue;
        if (map[nx][ny] == 0) continue;

        dfs(nx, ny);
    }
    }
}